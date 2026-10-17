package com.example.communication;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.*;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController 
public class HelloController {

    
    private final BuahService buahService;
    HelloController(BuahService buahService) {
        this.buahService = buahService;
    }
    //apa yang terjadi? client melakukan request untuk mengakses /Hello terus responnya apa dari server? server memberikan respon "Halo Welcome to my /Hello API Happy Learning!"
    @GetMapping("/api/buah")
    // /api/buah?nama= ini parameter @RequestParam
    public Object handleRequestBuah(@RequestParam(value="nama",required = false) String nama) {
        Map<String, String> response = new HashMap<>();
        if(nama == null || nama.isEmpty()){
            return buahService.dapatkanSemuaBuah();
        }
        if(buahService.dapatkanBuah(nama).getNama() == null){
            response.put("status", "Bad Request");
            response.put("pesan", "tidak ada buah itu di list buah");
            return response;
        }
        return buahService.dapatkanBuah(nama);
    }
    
    @PostMapping("/api/buah")
    //kenapa kok pakai RequestBody? karena kalau secara arsitektur client isi form terus kirim form -> berarti kirim request ke ->server
    //Request dari Client {"nama": "x", "harga": x, "isMuda": true}
    public Object handleBuatBuahBaru(@RequestBody BuahRequest request){
        
        Map<String, String> response = new HashMap<>();
        String namaBuah = request.getNama();
        //kasus kalau misalnya namaBuah null
        if(buahService.apakahBuahSudahAda(namaBuah)){
            response.put("Status", "Bad Response");
            response.put("Pesan", "request gak berhasil ditambahkan");
            return response;
        }
        buahService.tambahBuah(request);
        return buahService.dapatkanSemuaBuah();
    }
    @PutMapping("/api/buah/{id}")
    public Object handlePengupdateanBuah(@PathVariable int id, @RequestBody BuahRequest request){
        //id harus dapetin index
        Map<String, String> response = new HashMap<>();
        if(id < 0 || id >= buahService.dapatkanPanjangDaftarBuah()){
            response.put("status", "Bad Request");
            response.put("pesan", "Gagal update! ID index " + id + " tidak ditemukan.");
            return response;
        }

        buahService.updateBuah(id, request.getNama(), request.getHarga(), request.getIsMuda());
        return buahService.dapatkanSemuaBuah();
    }
    @DeleteMapping ("/api/buah")
    public Object handlePenghapusanBuah(@RequestParam(value = "nama", required = false) String nama){
        int id = buahService.buatIdBuah(nama);
        if (id == -1) {
            Map<String, String> response = new HashMap<>();
            response.put("status", "Bad Request");
            response.put("pesan", "Gagal menghapus! Buah " + nama + " tidak ditemukan.");
            return response;
        }
        buahService.removeBuah(id);
        return buahService.dapatkanSemuaBuah();
    }
    
    //End API (api/Buah)

}
