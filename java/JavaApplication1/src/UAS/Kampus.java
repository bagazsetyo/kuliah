/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UAS;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
/**
 *
 * @author Microvac
 */
public class Kampus {
    public static void main(String[] args) {
        // Menggunakan input untuk meminta username dan password
        Scanner scanner = new Scanner(System.in);
        UserModel authenticatedUser = new UserModel();

        while (true) {
            System.out.print("Masukkan username: ");
            String username = scanner.nextLine();
            System.out.print("Masukkan password: ");
            String password = scanner.nextLine();

            authenticatedUser = authenticatedUser.checkCredentials(username, password);

            if (authenticatedUser != null) {
                break;
            } else {
                System.out.println("Username atau password salah. Silakan coba lagi.");
            }
        }

        if (authenticatedUser != null) {
            Menu.displayMenu(authenticatedUser);
        } else {
            System.out.println("Gagal melakukan login.");
        }

        // Menutup scanner
        scanner.close();
    }
}
