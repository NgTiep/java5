package com.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Account {
    String username;
    String password;
    String fullname;
    String email;
    Boolean activated;
    Boolean admin;

    public boolean isAdmin(){
        return admin != null && admin;
    }
}
