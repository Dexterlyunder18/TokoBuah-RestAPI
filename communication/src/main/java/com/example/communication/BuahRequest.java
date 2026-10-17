package com.example.communication;

public class BuahRequest {
    private String nama;
    private int harga;
    private boolean isMuda;

    public BuahRequest(){   
    }
    public BuahRequest(String nama, int harga, boolean isMuda){
        this.nama = nama;
        this.harga = harga;
        this.isMuda = isMuda;
    }

    public String getNama(){
        return this.nama;
    }
    public void setNama(String nama){
        this.nama = nama;
    }

    public int getHarga(){
        return this.harga;
    }
    public void setHarga(int harga){
        this.harga = harga;
    }

    public boolean getIsMuda(){
        return this.isMuda;
    }
    public void setIsMuda(boolean isMuda){
        this.isMuda = isMuda;
    }

}
