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
        //situasi ketika isi buah null
        if(buahRepository.count() == 0){
            throw new IllegalArgumentException("Tidak ada buah");
        }
        //situasi ketika 
        return buahRepository.findAll();
    }
    public Buah dapatkanBuah(String nama){
        return  buahRepository.findById(nama).orElse(null);
    }
    public boolean apakahBuahSudahAda(String nama){
        return buahRepository.existsById(nama);
    }

    public void tambahBuah(Buah buah){
        //situasi ketika buah.getHarga() < 0 (Minus)
        if(buah.getHarga() < 0){
            throw new IllegalArgumentException("Gagal menambah buah! Harga buah tidak boleh minus.");
        }
        //situasi ketika buah.getNama() == null
        if(buah.getNama() == null || buah.getNama().trim().isEmpty()){
            throw new IllegalArgumentException("Gagal menambah buah! Harga buah tidak boleh kosong.");
        }
        //situasi ketika buah.getNama() ada di database
        if(buahRepository.existsById(buah.getNama())){
            throw new IllegalArgumentException("Gagal menambah buah! Buah dengan nama " + buah.getNama() + " sudah ada.");
        }
        buahRepository.save(buah);
    }

    public long dapatkanPanjangDaftarBuah(){
        return buahRepository.count();
    }

    public boolean removeBuah(String nama){
        Buah buahLama = buahRepository.findById(nama).orElse(null);
        //situasi ketika nilai buah null
        if(buahLama == null){
            throw new IllegalArgumentException("Gagal menghapus buah, karena tidak ditemukan buah yang ingin dihapus");
        }
        buahRepository.deleteById(nama);
        return true;
        
    }

    public void updateBuah(String namaBuahYangMauDiedit, Buah dataBaru){
        Buah buahLama = dataBaru;
        //situasi ketika databaru.getHarga() < 0 dan == 0
        if(buahLama.getHarga() < 0 || buahLama.getHarga() == 0){
            throw new IllegalArgumentException("Gagal mengupdate buah, harga tidak boleh minus atau gratis");
        }
        //situasi ketika harga isMuda itu bukan boolean
        if(!String.valueOf(buahLama.getIsMuda()).equalsIgnoreCase("false") || !String.valueOf(buahLama.getIsMuda()).equalsIgnoreCase("true")){
            throw new IllegalArgumentException("Gagal mengupdate buah, tidak terdefinisikan apakah buah itu matanga atau tidak");
        }
        //Situasi jika nama == null
        if(buahLama.getNama() == null || buahLama.getNama().trim().isEmpty()){
            throw new IllegalArgumentException("Gagal mengupdate buah, nama buah tidak ada");
        }
        
        buahLama.setHarga(dataBaru.getHarga());
        buahLama.setIsMuda(dataBaru.getIsMuda());
        
        buahRepository.save(buahLama); 
        
    }
}
