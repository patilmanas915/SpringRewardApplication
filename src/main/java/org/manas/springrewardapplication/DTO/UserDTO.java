package org.manas.springrewardapplication.DTO;

import lombok.Data;

@Data
public class UserDTO {
    private String name;
    private String email;
    private String password;

    public UserDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }
}

