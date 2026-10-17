package com.example.communication;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.*;


@RestController 
public class HelloController {
    
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
}
