package com.example.communication;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.*;


@RestController 
public class HelloController {

    
    private final CommunicationApplication communicationApplication;
    HelloController(CommunicationApplication communicationApplication) {
        this.communicationApplication = communicationApplication;
    }
    //apa yang terjadi? client melakukan request untuk mengakses /Hello terus responnya apa dari server? server memberikan respon "Halo Welcome to my /Hello API Happy Learning!"
    private List<String> getListBuah(){
        return Arrays.asList("apel", "pisang", "semangka", "mangga");
    }
    @GetMapping("/api/buah")
    // /api/buah?nama= ini parameter @RequestParam
    public Object handleRequestBuah(@RequestParam(value="nama", required = false) String nama) {
        if(nama == null || nama.isEmpty()){
            return getListBuah();
        }
        Map<String, String> response = new HashMap<>();
        List<String> getListBuah = getListBuah();
        Integer indeksBuah = null;
        for(int i = 0; i < getListBuah.size();i++){
            if(getListBuah.get(i).equalsIgnoreCase(nama)){
                indeksBuah = i;
                break;
            }
        }
        if(indeksBuah == null){
            response.put("buah", "Tidak ada");
            response.put("status", "Bad Response");
            return response;
        }
        response.put("id", String.valueOf(indeksBuah));
        response.put("nama", getListBuah.get(indeksBuah));
        response.put("status", "Success");
        return response;
        
    }
    @PostMapping("/api/buah")
    //kenapa kok pakai RequestBody? karena kalau secara arsitektur client isi form terus kirim form -> berarti kirim request ke ->server
    //Request dari Client {"nama": "x", "harga": x, "isMuda": true}
    public Map<String, Object> buatBuahBaru(@RequestBody BuahRequest request){
        Map<String, Object> response = new HashMap<>();
        String mudaOrTua = null;
        if(request.getIsMuda() == false){
            mudaOrTua = "tua";
        }else{
            mudaOrTua = "muda";
        }
        //output respon saat diinput. . .
        response.put("status", "Success Terkirim");
        
        response.put("pesan", "Buah "+request.getNama()+" "+mudaOrTua+" Sukses ditambahkan kedalam keranjang");
        response.put("harga_per_kilo", "Rp. "+request.getHarga());
        response.put("harga_per_kuintal", "Rp. "+request.getHarga()*100);

        return response;
    }
    //End API (api/Buah)
}
