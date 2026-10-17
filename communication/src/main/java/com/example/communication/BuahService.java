package com.example.communication;
import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class BuahService {
    private List<BuahRequest> listKeranjangBuah = new ArrayList<>();
    //Saat program di jalankan BuahService() akan otomatis memiliki default buah bawaan.
    public BuahService(){
        listKeranjangBuah.add(new BuahRequest("Apel", 7000, true));        
        listKeranjangBuah.add(new BuahRequest("Mangga", 10000, false));        
        listKeranjangBuah.add(new BuahRequest("Durian", 12000, false));        
    }
    public List<BuahRequest> dapatkanSemuaBuah() {
        return this.listKeranjangBuah;
    }
    public BuahRequest dapatkanBuah(String nama){
        BuahRequest buah = new BuahRequest();
        for(int i = 0; i < listKeranjangBuah.size(); i++){
            //kalau mangga == mangga
            if(listKeranjangBuah.get(i).getNama().equalsIgnoreCase(nama)){
                //call buah dan isinya
                buah.setNama(listKeranjangBuah.get(i).getNama());
                buah.setHarga(listKeranjangBuah.get(i).getHarga());
                buah.setIsMuda(listKeranjangBuah.get(i).getIsMuda());
            }
        }
        return buah;
    }
    public void tambahBuah(BuahRequest buahBaru){
        listKeranjangBuah.add(buahBaru);
    }
    public int dapatkanPanjangDaftarBuah(){
        return this.listKeranjangBuah.size();
    }

    public boolean apakahBuahSudahAda(String nama){
        for(BuahRequest b :listKeranjangBuah){
            if(b.getNama().equalsIgnoreCase(nama)){
                return  true;
            }
        }
        return false;
    }
}
