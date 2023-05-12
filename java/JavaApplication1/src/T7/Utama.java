/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package T7;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author user
 */
public class Utama {
    public static void main(String[] args)throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Masukkan bilangan pertama : ");
        double a = Double.parseDouble(br.readLine());
        System.out.println("Masukkan bilangan kedua : ");
        double b = Double.parseDouble(br.readLine());
        
        Kalkulator k = new Kalkulator(a, b);
        
        System.out.println("");
        
        System.out.println("Hasil Penjumlahan = ");
        k.Penjumlahan();
        System.out.println("Hasil Penjumlahan = ");
        k.Pengurangan();
        System.out.println("Hasil Penjumlahan = " + k.Perkalian());
        System.out.println("Hasil Penjumlahan = " + k.Pembagian());
    }
}
