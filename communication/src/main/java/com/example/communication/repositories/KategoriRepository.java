package com.example.communication.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.communication.entity.Kategori;

@Repository 
public interface KategoriRepository extends CrudRepository<Kategori, Long>{
    
}