/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package T4;

import java.util.Scanner;
import T4.CheckBilangan;

/**
 *
 * @author user
 */
public class Bilangan {
    
    public static void main(String[] args) {
        while(true){
            Scanner input = new Scanner(System.in);

            System.out.println("Masukkan angka : ");

            if (input.hasNextInt()) {
                int bilangan = input.nextInt();
                
                CheckBilangan checkBilangan = new CheckBilangan(bilangan);
                
                if(checkBilangan.isPositiveGenap()){
                    System.out.println("Bilangan Positif Genap ");
                }else if(checkBilangan.isPositiveGanjil()){
                    System.out.println("Bilangan Positif Ganjil ");
                }else if(checkBilangan.isNegativeGenap()){
                    System.out.println("Bilangan Negarif Genap ");
                }else if(checkBilangan.isNegativeGanjil()){
                    System.out.println("Bilangan Negatif Ganjil");
                }else {
                    System.out.println("Bilangan NOL");
                }
            } else {
                String notNumber = input.next();
                if("stop".equals(notNumber)){
                    break;
                }
                System.out.println("'" + notNumber + "' bukan angka");
            }
        }
    }
}
