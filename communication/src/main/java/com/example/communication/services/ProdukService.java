package com.example.communication.services;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.communication.dto.ProdukResponseDto;
import com.example.communication.entity.Produk;
import com.example.communication.repositories.ProdukRepository;
import com.example.communication.dto.ProdukDto;

@Service
public class ProdukService {
    private final ProdukRepository produkRepository;
    ProdukService(ProdukRepository produkRepository){
        this.produkRepository = produkRepository;
    }
    //get produk
    public List<ProdukResponseDto> tampilkanProduk(){
        List<ProdukDto> listDto = produkRepository.findAllWithKategori();
        return listDto.stream().map(
            dto->{
                ProdukResponseDto responseDto = new ProdukResponseDto();
                responseDto.setNama(dto.getNama());
                responseDto.setSatuan(dto.getSatuan());
                responseDto.setHarga(dto.getHarga());
                responseDto.setStok(dto.getStok());
                responseDto.setKategoriId(dto.getKategoriId());
                responseDto.setNamaKategori(dto.getNamaKategori());

                return responseDto;
            }
        ).collect(Collectors.toList());
        

    }
}
