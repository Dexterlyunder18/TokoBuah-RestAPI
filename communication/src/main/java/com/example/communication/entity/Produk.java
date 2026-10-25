package com.example.communication.entity;

import org.springframework.data.annotation.Id;

import lombok.Data;
import java.math.BigDecimal;

@Data 
public class Produk {
    @Id 
    private Long id;
    private String nama;
    private Long harga;
    private String satuan;
    private BigDecimal stok;
    private Long kategori_id;
}