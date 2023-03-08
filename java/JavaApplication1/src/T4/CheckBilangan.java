package T4;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
public class CheckBilangan {
     
    private int angka;
    
    public CheckBilangan(int angka){
        this.angka = angka;
    }
    
    public boolean isPositiveGenap(){
        return angka > 0 && angka %2 == 0;
    }
    
    public boolean isPositiveGanjil(){
        return angka > 0 && angka %2 == 1;
    }
    
    public boolean isNegativeGenap(){
        return angka < 0 && angka %2 == 0;
    }
    
    public boolean isNegativeGanjil(){
        return angka < 0 && angka %2 == -1;
    }
}
