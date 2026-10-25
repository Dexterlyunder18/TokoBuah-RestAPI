package com.example.communication.entity;


import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Users{
    @Id 
    private Long id;
    private String username;
    private String password;
    private String role;
}