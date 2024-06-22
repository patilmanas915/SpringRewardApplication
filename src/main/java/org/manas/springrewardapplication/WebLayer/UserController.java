package org.manas.springrewardapplication.WebLayer;

import org.manas.springrewardapplication.DTO.UserDTO;
import org.manas.springrewardapplication.DTO.UserResponseDTO;
import org.manas.springrewardapplication.Model.User;
import org.manas.springrewardapplication.ServiceLayer.Interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private IUserService userService;
    @Autowired
    public void setUserService(IUserService userService){
        this.userService = userService;
    }

    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO){
        UserResponseDTO userdetail = userService.addUser(userDTO);
        return new ResponseEntity<>(userdetail, HttpStatus.OK);
    }

    @PostMapping("/LoginUser")
    public ResponseEntity<?> loginUser(@RequestBody UserDTO userDTO){
        UserResponseDTO userdetail = userService.loginUser(userDTO);
        return new ResponseEntity<>(userdetail, HttpStatus.OK);
    }

    @PostMapping("/signOut")
    public ResponseEntity<?> signOut(){
        UserResponseDTO userdetail = userService.signOut();
        return new ResponseEntity<>(userdetail, HttpStatus.OK);
    }

}
