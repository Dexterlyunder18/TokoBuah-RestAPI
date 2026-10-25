package com.example.communication.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data 
public class ProdukRequestDto{
    private String nama;
    private String satuan;
    private Long harga;
    private BigDecimal stok;
    private String namaKategori;

}    
