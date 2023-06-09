/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UAS;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Microvac
 */

public class Menu {
    private static final Map<Integer, Runnable> MENU_OPTIONS = new HashMap<>();

    static {
        MENU_OPTIONS.put(1, Menu::lihatUser);
        MENU_OPTIONS.put(2, Menu::tambahUser);
        MENU_OPTIONS.put(3, Menu::hapusUser);
        MENU_OPTIONS.put(4, Menu::lihatQuiz);
        MENU_OPTIONS.put(5, Menu::tambahQuiz);
        MENU_OPTIONS.put(6, Menu::hapusQuiz);
    }

    public static void displayMenu(UserModel user) {
        String role = user.getRole();

        while (true) {
            System.out.println("Pilih menu:");

            if (role.equals("1")) { // Role 1: Mengerjakan quiz
                System.out.println("1. Lihat Quiz");
                System.out.println("2. Tambah Quiz");
                System.out.println("3. Hapus Quiz");
            } else if (role.equals("2")) { // Role 2: Mengerjakan quiz, melihat semua user
                System.out.println("1. Lihat User");
                System.out.println("2. Lihat Quiz");
                System.out.println("3. Tambah Quiz");
                System.out.println("4. Hapus Quiz");
            } else if (role.equals("3")) { // Role 3: Mengerjakan quiz, melihat semua user, edit user, hapus user
                System.out.println("1. Lihat User");
                System.out.println("2. Tambah User");
                System.out.println("3. Hapus User");
                System.out.println("4. Lihat Quiz");
                System.out.println("5. Tambah Quiz");
                System.out.println("6. Hapus Quiz");
            } else {
                System.out.println("Role tidak dikenali. Keluar dari menu.");
                return;
            }

            System.out.println("0. Keluar");
            System.out.print("Masukkan pilihan: ");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            if (choice == 0) {
                return;
            }

            if (role.equals("1") && (choice < 1 || choice > 3)) {
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            } else if (role.equals("2") && (choice < 1 || choice > 4)) {
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            } else if (role.equals("3") && (choice < 1 || choice > 6)) {
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            } else {
                if (MENU_OPTIONS.containsKey(choice)) {
                    MENU_OPTIONS.get(choice).run();
                } else {
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                }
            }
        }
    }

    public static void lihatUser() {
        System.out.println("Menu Lihat User");
    }

    public static void tambahUser() {
        UserModel user = new UserModel();

        // Mengatur nilai kolom pada UserModel
        user.setColumn("nama", "bagas");
        user.setColumn("username", "bag");
        user.setColumn("password", "abc");
        user.setColumn("alamat", "asd");
        user.setColumn("role", "3");

        // Melakukan operasi tambah ke database menggunakan UserModel
        user.create();

        System.out.println("Menu Tambah Quizazzzz");
    }

    public static void hapusUser() {
        System.out.println("Menu Hapus User");
    }

    public static void lihatQuiz() {
        System.out.println("Menu Lihat Quiz");
    }

    public static void tambahQuiz() {
        UserModel user = new UserModel();

        // Mengatur nilai kolom pada UserModel
        user.setColumn("name", "bagas");
        user.setColumn("username", "bag");
        user.setColumn("password", "abc");
        user.setColumn("alamat", "asd");
        user.setColumn("role", "3");

        // Melakukan operasi tambah ke database menggunakan UserModel
        user.create();

        System.out.println("Menu Tambah Quizazzzz");
    }

    public static void hapusQuiz() {
        System.out.println("Menu Hapus Quiz");
    }
}
