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
    public int buatIdBuah(String nama){
        Buah buah = new Buah();
        for(int i = 0; i < buahRepository.count();i++){
            if(buah.getNama().equalsIgnoreCase(nama)){
                return i;
            }
        }
        return -1;
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
        Buah buahLama = buahRepository.findById(namaBuahYangMauDiedit).orElse(null);
        if (buahLama != null) {
            buahLama.setHarga(dataBaru.getHarga());
            buahLama.setIsMuda(dataBaru.getIsMuda());
            
            buahRepository.save(buahLama); 
        }
    }
}
