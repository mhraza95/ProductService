package com.example.productservice.security.dtos;

import java.util.List;

public class User {

    private String name;
    private String hashedPassword;
    private String email;
    private List<Role> roles;
    private boolean isEmailVerified;
}
