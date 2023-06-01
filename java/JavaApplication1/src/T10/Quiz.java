/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package T10;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class Quiz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();

        System.out.println("Nama yang dimasukkan: " + nama);

        ModelHakAkses modelHakAkses = new ModelHakAkses();
        HakAkses hakAkses = modelHakAkses.findByName(nama);

        if (hakAkses != null) {
            System.out.println("Hak Akses ditemukan:");
            System.out.println("Username: " + hakAkses.getNama() + ", Level: " + hakAkses.getLevel());
            
            Menu menu = new Menu(hakAkses);
            
            System.out.println("Menu yang tersedia:");
            menu.displayMenu();

            System.out.print("Pilih menu: ");
            int menuChoice = scanner.nextInt();

            menu.processMenu(menuChoice);
        } else {
            System.out.println("Hak Akses tidak ditemukan.");
        }
    }
}
