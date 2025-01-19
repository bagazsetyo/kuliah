package com.example.belajar_android_sturio;

public class Obat {
    private long id;
    private String nama;
    private double harga;

    public Obat(long id, String nama, double harga) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
    }

    public long getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }
}
