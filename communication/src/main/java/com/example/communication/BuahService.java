package com.example.communication;
import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class BuahService {
    private List<BuahRequest> listKeranjangBuah = new ArrayList<>();
    //Saat program di jalankan BuahService() akan otomatis memiliki default buah bawaan.
    public BuahService(){
        listKeranjangBuah.add(new BuahRequest("apel", 7000, true));        
        listKeranjangBuah.add(new BuahRequest("mangga", 10000, false));        
        listKeranjangBuah.add(new BuahRequest("durian", 12000, false));        
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
                buah.setNama(listKeranjangBuah.get(i).getNama().toLowerCase());
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

    public int buatIdBuah(String nama){
        for(int i = 0; i < listKeranjangBuah.size(); i++){
            if(nama.equalsIgnoreCase(listKeranjangBuah.get(i).getNama())){
                return i;
            }
        }
        return -1;
    }

    public void updateBuah(int id, String nama, int harga, boolean isMuda){
        BuahRequest buah = listKeranjangBuah.get(id);
        buah.setNama(nama.toLowerCase());
        buah.setHarga(harga);
        buah.setIsMuda(isMuda);
    }

    public void removeBuah(int id){
        listKeranjangBuah.remove(id);
    }
}
