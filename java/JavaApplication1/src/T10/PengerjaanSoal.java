/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package T10;

/**
 *
 * @author user
 */
public class PengerjaanSoal {
    private int idPengerjaan;
    private int skor;
    private String jamPengerjaan;
    private String tanggalPengerjaan;

    public PengerjaanSoal(int idPengerjaan, int skor, String tanggalPengerjaan, String jamPengerjaan) {
        this.idPengerjaan = idPengerjaan;
        this.skor = skor;
        this.tanggalPengerjaan = tanggalPengerjaan;
        this.jamPengerjaan = jamPengerjaan;
    }

    public int getIdPengerjaan() {
        return idPengerjaan;
    }

    public void setIdPengerjaan(int idPengerjaan) {
        this.idPengerjaan = idPengerjaan;
    }

    public int getSkor() {
        return skor;
    }

    public void setJawaban(int skor) {
        this.skor = skor;
    }
    
    public String getJamPengerjaan() {
        return jamPengerjaan;
    }

    public void setJamPengerjaan(String jamPengerjaan) {
        this.jamPengerjaan = jamPengerjaan;
    }
    
    public String getTanggalPengerjaan() {
        return tanggalPengerjaan;
    }

    public void setTanggalPengerjaan(String tanggalPengerjaan) {
        this.tanggalPengerjaan = tanggalPengerjaan;
    }
}
