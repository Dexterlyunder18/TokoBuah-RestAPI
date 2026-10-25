package com.example.communication.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import com.example.communication.dto.ProdukDto;
import java.util.*;

@Repository 
public class ProdukRepository{
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public ProdukRepository(NamedParameterJdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ProdukDto> findAllWithKategori(){
        String sql = "SELECT p.id, p.nama, p.harga, p.satuan, p.stok, p.kategori_id, k.nama AS nama_kategori FROM produk p LEFT JOIN kategori k ON k.id = p.kategori_id";
        return jdbcTemplate.query(sql, Collections.emptyMap(), (rs, rowNum)->{
                ProdukDto dto = new ProdukDto();
                dto.setId(rs.getLong("id"));
                dto.setNama(rs.getString("nama"));
                dto.setHarga(rs.getLong("harga"));
                dto.setSatuan(rs.getString("satuan"));
                dto.setStok(rs.getBigDecimal("stok"));
                dto.setKategoriId(rs.getLong("kategori_id"));
                dto.setNamaKategori(rs.getString("nama_kategori"));
                return dto;
        });
    }

}
