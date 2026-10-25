package com.example.communication.entity;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data 
public class Produk {
    @Id 
    private Long id;
    private String nama;
    private Long harga;
    private String satuan;
    private Long kategori_id;
}
