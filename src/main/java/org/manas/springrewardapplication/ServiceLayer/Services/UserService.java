package org.manas.springrewardapplication.ServiceLayer.Services;

import org.manas.springrewardapplication.DTO.UserDTO;
import org.manas.springrewardapplication.DTO.UserResponseDTO;
import org.manas.springrewardapplication.DaoLayer.UserDao;
import org.manas.springrewardapplication.Model.User;
import org.manas.springrewardapplication.ServiceLayer.Interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service

public class UserService implements IUserService {

    private User user;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public UserResponseDTO addUser(UserDTO user) {
        Optional<User> checkuser = userDao.findByEmail(user.getEmail());
        if (checkuser.isPresent()) {
            throw new RuntimeException("User already exists");
        }
        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        String HashedPassword = passwordEncoder.encode(user.getPassword());
        newUser.setPassword(HashedPassword);
        newUser.setRewardPoints(0);
        User retrunuser = userDao.save(newUser);
        return new UserResponseDTO(retrunuser.getUserId(), retrunuser.getName(), retrunuser.getEmail(), retrunuser.getRewardPoints(), retrunuser.getRedemptions(), retrunuser.getTransactions());
    }

    @Override
    @Transactional
    public UserResponseDTO loginUser(UserDTO user) {
        Optional<User> checkuser = userDao.findByEmail(user.getEmail());
        if (checkuser.isPresent()) {
            if (passwordEncoder.matches(user.getPassword(), checkuser.get().getPassword())) {
                this.user = checkuser.get();
                return new UserResponseDTO(
                        this.user.getUserId(),
                        this.user.getName(),
                        this.user.getEmail(),
                        this.user.getRewardPoints(),
                        this.user.getRedemptions(),
                        this.user.getTransactions());
            } else {
                throw new RuntimeException("Invalid Password");
            }
        } else {
            throw new RuntimeException("User not found");
        }

    }

    @Override
    public UserResponseDTO signOut() {
        if (this.user != null) {
            User loggedOutUser = this.user;
            this.user = null;
            return new UserResponseDTO(
                    loggedOutUser.getUserId(),
                    loggedOutUser.getName(),
                    loggedOutUser.getEmail(),
                    loggedOutUser.getRewardPoints(),
                    loggedOutUser.getRedemptions(),
                    loggedOutUser.getTransactions()
            );
        } else {
            throw new RuntimeException("No user logged in");
        }
    }

    @Override
    public UserResponseDTO getUser() {
        if(this.user==null){
            throw new RuntimeException("No user logged in");
        }
        this.user = userDao.findById(this.user.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        return new UserResponseDTO(
                this.user.getUserId(),
                this.user.getName(),
                this.user.getEmail(),
                this.user.getRewardPoints(),
                this.user.getRedemptions(),
                this.user.getTransactions()
        );
    }

    public User getLoginUser(){
        return this.user;
    }

    @Override
    public UserResponseDTO updateUser(User user) {
        if(this.user==null){
            throw new RuntimeException("No user logged in");
        }
        this.user = userDao.findByEmail(user.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));
         this.user.setName(user.getName());
         this.user.setEmail(user.getEmail());
         this.user.setRewardPoints(user.getRewardPoints());
         this.user.setRedemptions(user.getRedemptions());
         this.user.setTransactions(user.getTransactions());
         User updatedUser = userDao.save(this.user);
            return new UserResponseDTO(
                    updatedUser.getUserId(),
                    updatedUser.getName(),
                    updatedUser.getEmail(),
                    updatedUser.getRewardPoints(),
                    updatedUser.getRedemptions(),
                    updatedUser.getTransactions()
            );


    }
}
