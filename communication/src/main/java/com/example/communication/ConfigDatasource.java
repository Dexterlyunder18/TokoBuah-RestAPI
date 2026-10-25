package com.example.communication;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration 
public class ConfigDatasource {
    
    @Bean 
    @ConfigurationProperties (prefix="spring.datasource")
    public static DataSource source(){
        //konfigurasi driver dimana datasource builder harus di create dahulu baru di build;
        return DataSourceBuilder.create().build();
    }
}
