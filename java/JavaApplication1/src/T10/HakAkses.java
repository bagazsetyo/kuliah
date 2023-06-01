/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package T10;

/**
 *
 * @author user
 */
public class HakAkses {
    // Setiap objek HakAkses memiliki informasi nama pengguna, level, dan id pengguna
    private String nama;
    private int level;
    private final int id_pengguna;

    // Konstruktor untuk membuat objek HakAkses
    public HakAkses(String nama, int level, int id_pengguna) {
        this.nama = nama;
        this.level = level;
        this.id_pengguna = id_pengguna;
    }    
    
    // 
    public int getIdPengguna() {
        return id_pengguna;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}