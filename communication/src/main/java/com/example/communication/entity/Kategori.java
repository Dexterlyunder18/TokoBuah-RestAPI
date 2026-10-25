package com.example.communication.entity;


import org.springframework.data.annotation.Id;

import lombok.Data;

@Data 
public class Kategori {
    @Id 
    private Long id;
    private String nama;
}
