package com.example.communication.controllers;

import java.util.*;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.communication.entity.Produk;
import com.example.communication.services.ProdukService;


@RestController 
public class ProdukController {
    @GetMapping("/")
    public Object handleGreetings(){
        return "Hello";
    }
}
