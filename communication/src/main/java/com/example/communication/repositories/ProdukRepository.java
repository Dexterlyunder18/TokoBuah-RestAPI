package com.example.communication.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.communication.entity.Produk;

@Repository 
public interface ProdukRepository extends CrudRepository<Produk, Long>{
    
}
