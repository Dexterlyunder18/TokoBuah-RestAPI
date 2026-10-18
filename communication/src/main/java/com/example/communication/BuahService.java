package com.example.communication;
import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class BuahService {
    private final BuahRepository buahRepository;
    public BuahService(BuahRepository buahRepository){
        this.buahRepository = buahRepository;
    }
    public List<Buah> dapatkanSemuaBuah(){
        return buahRepository.findAll();
    }
    public Buah dapatkanBuah(String nama){
        return  buahRepository.findById(nama).orElse(null);
    }
    public boolean apakahBuahSudahAda(String nama){
        return buahRepository.existsById(nama);
    }

    public void tambahBuah(Buah buah){
        buahRepository.save(buah);
    }

    public long dapatkanPanjangDaftarBuah(){
        return buahRepository.count();
    }

    public boolean removeBuah(String nama){
        Buah buahLama = buahRepository.findById(nama).orElse(null);
        if(buahLama != null){
            buahRepository.deleteById(nama);
            return true;
        }
        return false;
    }

    public void updateBuah(String namaBuahYangMauDiedit, Buah dataBaru){
        Buah buahLama = dataBaru;
        if (buahLama != null) {
            buahLama.setHarga(dataBaru.getHarga());
            buahLama.setIsMuda(dataBaru.getIsMuda());
            
            buahRepository.save(buahLama); 
        }
    }
}
