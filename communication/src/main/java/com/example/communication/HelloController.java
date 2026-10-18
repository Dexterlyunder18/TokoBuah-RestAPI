package com.example.communication;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



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
        try{
            if (nama == null || nama.trim().isEmpty()) {
                return buahService.dapatkanSemuaBuah();
            }
        
            // Jika parameter nama diisi, cari buah spesifik
            Buah buah = buahService.dapatkanBuah(nama);
            if (buah == null) {
                throw new IllegalArgumentException("Buah dengan nama " + nama + " tidak ditemukan.");
            }
            return buah;
        }catch(IllegalArgumentException e){
            Map<String, String> response = new HashMap<>();
            response.put("status", "Bad Response");
            response.put("pesan", e.getMessage());
            return response;
        }
    }
    
    @PostMapping("/api/buah")
    //kenapa kok pakai RequestBody? karena kalau secara arsitektur client isi form terus kirim form -> berarti kirim request ke ->server
    //Request dari Client {"nama": "x", "harga": x, "isMuda": true}
    public Object handleBuatBuahBaru(@RequestBody Buah request){
        try{
            buahService.tambahBuah(request);
            return buahService.dapatkanSemuaBuah();
        }catch(IllegalArgumentException e){
            Map<String, String> response = new HashMap<>();
            response.put("status", "Bad Response");
            response.put("pesan", e.getMessage());
            return  response;
        }
        
    }
    @PutMapping("/api/buah/{nama}")
    public Object handlePengupdateanBuah(@PathVariable String nama, @RequestBody Buah request){
        try{
            buahService.updateBuah(nama, request);
            return buahService.dapatkanSemuaBuah();
        }catch(IllegalArgumentException e){
            Map<String, String> response = new HashMap<>();
            response.put("status", "Bad Response");
            response.put("pesan", e.getMessage());
            return response;
        }
    }
    @DeleteMapping ("/api/buah/{nama}")
    public Object handlePenghapusanBuah(@PathVariable String nama){
        try{
            buahService.removeBuah(nama);
            return buahService.dapatkanSemuaBuah();
        }catch(IllegalArgumentException e){
            Map<String, String> response = new HashMap<>();
            response.put("status", "Bad Response");
            response.put("pesan", e.getMessage());
            return response;
        }
    }
    
    //End API (api/Buah)

}
