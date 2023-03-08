/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package T4;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class Deret {
    
    private final int nilaiAwal, beda, jumlahKemunculan;
    
    public Deret(int nilaiAwal, int beda, int jumlahKemunculan)
    {
        this.nilaiAwal = nilaiAwal;
        this.beda = beda;
        this.jumlahKemunculan = jumlahKemunculan;
    }
    
    public void generateDeret()
    {
        // inisialisasi array
        int deret[] = new int[jumlahKemunculan];
        deret[0] = nilaiAwal;
        
        // membuat deret
        for (int i = 1; i < jumlahKemunculan; i++) {
            deret[i] = deret[i-1] + beda;
        }
        
        // menampilkan deret
        System.out.print("Deret : ");
        for (int i = 0; i < jumlahKemunculan; i++) {
            System.out.print(deret[i] + " ");
        }
        System.out.println();
        
        // mencari nilai rata rata
        double rataan = 0;
        for (int i = 0; i < jumlahKemunculan; i++) {
            rataan += deret[i];
        }
        rataan /= jumlahKemunculan;
        System.out.println("Nilai rata-rata deret adalah : " + rataan);
    }
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan nilai awal : ");
        int a = input.nextInt();
        System.out.print("Masukkan beda : ");
        int b = input.nextInt();
        System.out.print("Masukkan jumlah kemunculan deret : ");
        int n = input.nextInt();
        
        Deret deret = new Deret(a, b, n);
        deret.generateDeret();
        
    }
    
}
