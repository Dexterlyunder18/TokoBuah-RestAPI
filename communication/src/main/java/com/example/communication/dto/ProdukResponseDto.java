package com.example.communication.dto;


import lombok.Data;
import java.math.BigDecimal;

@Data 
public class ProdukResponseDto {
    private String nama;
    private String satuan;
    private Long harga;
    private BigDecimal stok;
    private Long kategoriId;
    private String namaKategori;
}
