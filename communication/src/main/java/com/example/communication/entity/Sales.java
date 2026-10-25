package com.example.communication.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import lombok.Data;


@Data 
public class Sales {
    @Id 
    private Long id;
    private LocalDateTime tanggal_penjualan;
}
