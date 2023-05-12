/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package T7;

/**
 *
 * @author user
 */
public class Kalkulator implements Operasi{

    private final double Bil1, Bil2;
    
    Kalkulator(double Bil1, double Bil2)
    {
        this.Bil1 = Bil1;
        this.Bil2 = Bil2;
    }
    
    public double getBil1()
    {
        return Bil1;
    }
    
    public double getBil2()
    {
        return Bil2;
    }
    
    // method 
    @Override
    public void Penjumlahan()
    {
        System.out.println(Bil1 + Bil2);
    }
    // method 
    @Override
    public void Pengurangan()
    {
        System.out.println(Bil1 - Bil2);
    }
    // method 
    @Override
    public double Perkalian()
    {
        return Bil1 * Bil2;
    }
    
    // method 
    @Override
    public double Pembagian()
    {
        return Bil1 / Bil2;
    }
    
}
