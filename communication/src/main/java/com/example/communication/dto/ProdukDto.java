package com.example.communication.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data 
public class ProdukDto {
    private Long id;
    private String nama;
    private Long harga;
    private String satuan;
    private BigDecimal stok;
    private Long kategoriId;
    private String namaKategori;
}
