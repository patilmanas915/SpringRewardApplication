package org.manas.springrewardapplication.ServiceLayer.Interfaces;

import org.manas.springrewardapplication.DTO.UserDTO;
import org.manas.springrewardapplication.DTO.UserResponseDTO;
import org.manas.springrewardapplication.Model.User;

public interface IUserService {

    public UserResponseDTO addUser(UserDTO user);
    public UserResponseDTO loginUser(UserDTO user);
    public UserResponseDTO  signOut();
    public UserResponseDTO  getUser();
    public User getLoginUser();
    public UserResponseDTO  updateUser(User user);
}
