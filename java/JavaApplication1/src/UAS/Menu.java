/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UAS;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class Menu {
    private static final Map<Integer, Map<Integer, MenuItem>> MENU_OPTIONS = new HashMap<>();

    static {
        // Role 1: Mengerjakan quiz
        Map<Integer, MenuItem> role1Menu = new HashMap<>();
        role1Menu.put(1, new MenuItem("Lihat Quiz", Menu::lihatQuiz));
        role1Menu.put(2, new MenuItem("Tambah Quiz", Menu::tambahQuiz));
        role1Menu.put(3, new MenuItem("Hapus Quiz", Menu::hapusQuiz));
        MENU_OPTIONS.put(1, role1Menu);

        // Role 2: Mengerjakan quiz, melihat semua user
        Map<Integer, MenuItem> role2Menu = new HashMap<>();
        role2Menu.put(1, new MenuItem("Lihat User", Menu::lihatUser));
        role2Menu.put(2, new MenuItem("Lihat Quiz", Menu::lihatQuiz));
        role2Menu.put(3, new MenuItem("Tambah Quiz", Menu::tambahQuiz));
        role2Menu.put(4, new MenuItem("Hapus Quiz", Menu::hapusQuiz));
        MENU_OPTIONS.put(2, role2Menu);

        // Role 3: Mengerjakan quiz, melihat semua user, edit user, hapus user
        Map<Integer, MenuItem> role3Menu = new HashMap<>();
        role3Menu.put(1, new MenuItem("Lihat User", Menu::lihatUser));
        role3Menu.put(2, new MenuItem("Tambah User", Menu::tambahUser));
        role3Menu.put(3, new MenuItem("Hapus User", Menu::hapusUser));
        role3Menu.put(4, new MenuItem("Ubah User", Menu::editUser));
        role3Menu.put(5, new MenuItem("Lihat Matkul", Menu::lihatMatkul));
        role3Menu.put(6, new MenuItem("Tambah Matkul", Menu::tambahMatkul));
        role3Menu.put(7, new MenuItem("Ubah Matkul", Menu::ubahMatkul));
        role3Menu.put(8, new MenuItem("Hapus Matkul", Menu::hapusMatkul));
        MENU_OPTIONS.put(3, role3Menu);
    }
    private static class MenuItem {
        private String name;
        private Runnable action;

        public MenuItem(String name, Runnable action) {
            this.name = name;
            this.action = action;
        }

        public String getName() {
            return name;
        }

        public Runnable getAction() {
            return action;
        }
    }

    public static void displayMenu(UserModel user) {
        String role = user.getRole();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Pilih menu:");

            if (!MENU_OPTIONS.containsKey(Integer.parseInt(role))) {
                System.out.println("Role tidak dikenali. Keluar dari menu.");
                return;
            }

            Map<Integer, MenuItem> roleMenu = MENU_OPTIONS.get(Integer.parseInt(role));
            for (Map.Entry<Integer, MenuItem> entry : roleMenu.entrySet()) {
                int choice = entry.getKey();
                MenuItem menuItem = entry.getValue();
                System.out.println(choice + ". " + menuItem.getName());
            }

            System.out.println("0. Keluar");
            
            System.out.print("Masukkan pilihan: ");
            scanner.nextLine(); // Mengkonsumsi karakter newline (\n)
            int choice = scanner.nextInt();

            if (choice == 0) {
                return;
            }

            if (!roleMenu.containsKey(choice)) {
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            } else {
                MenuItem selectedMenuItem = roleMenu.get(choice);
                selectedMenuItem.getAction().run();
            }
        }
    }

    public static void lihatUser() {
        
        System.out.println("Menu Lihat User");
        UserModel user = new UserModel();
        List<Map<String, Object>> data = user.executeQuery();
        
        System.out.println("===============================================");
        System.out.println("| ID | Nama   | Username | Password | Alamat | Role |");
        System.out.println("===============================================");

        for (Map<String, Object> row : data) {
            String id = String.valueOf(row.get("ID"));
            String nama = (String) row.get("nama");
            String username = (String) row.get("username");
            String password = (String) row.get("password");
            String alamat = (String) row.get("alamat");
            String role = (String) row.get("role");

            System.out.printf("| %-2s | %-6s | %-8s | %-8s | %-6s | %-4s |\n", id, nama, username, password, alamat, role);
        }

        System.out.println("===============================================");

    }

    public static void tambahUser() {
        UserModel user = new UserModel();

        // Mengatur nilai kolom pada UserModel
        user.setColumn("nama", "rere");
        user.setColumn("username", "rere");
        user.setColumn("password", "rere");
        user.setColumn("alamat", "rere");
        user.setColumn("role", "3");

        // Melakukan operasi tambah ke database menggunakan UserModel
        user.create();

        System.out.println("Menu Tambah User");
    }

    public static void editUser(){
        System.out.println("Menu Edit User");
        Scanner scanner = new Scanner(System.in);
        UserModel user = new UserModel();
        System.out.print("Masukkan ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Mengkonsumsi karakter newline (\n)

        System.out.print("Masukkan nama: ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();

        System.out.print("Masukkan alamat: ");
        String alamat = scanner.nextLine();

        System.out.print("Masukkan role: ");
        String role = scanner.nextLine();
        
        user.setColumn("ID", id);
        user.setColumn("nama", nama);
        user.setColumn("password", password);
        user.setColumn("alamat", alamat);
        user.setColumn("role", role);
        user.update();
    }
    
    public static void hapusUser() {
        System.out.println("Menu Hapus User");
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Masukkan ID: ");
        int id = scanner.nextInt();
        
        UserModel user = new UserModel();
        user.destroy(id);
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

        System.out.println("Menu Tambah Quiz");
    }

    public static void hapusQuiz() {
        System.out.println("Menu Hapus Quiz");
    }

    public static void lihatMatkul() {
        System.out.println("Menu Lihat Matkul");
        
        System.out.println("Menu Lihat User");
        MatkulModel matkul = new MatkulModel();
        List<Map<String, Object>> data = matkul.executeQuery();
        
        System.out.println("===============================================");
        System.out.println("| ID | Nama   | Singkatan |");
        System.out.println("===============================================");

        for (Map<String, Object> row : data) {
            String id = String.valueOf(row.get("ID"));
            String nama = (String) row.get("nama");
            String singkatan = (String) row.get("singkatan");

            System.out.printf("| %-2s | %-6s | %-8s |\n", id, nama, singkatan);
        }

        System.out.println("===============================================");
    }
    public static void tambahMatkul() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu Tambah Matkul");
        
        MatkulModel matkul = new MatkulModel();
        System.out.print("Masukkan nama: ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan singkatan: ");
        String singkatan = scanner.nextLine();

        // Mengatur nilai kolom pada UserModel
        matkul.setColumn("nama", nama);
        matkul.setColumn("singkatan", singkatan);

        // Melakukan operasi tambah ke database menggunakan UserModel
        matkul.create();
    }
    public static void ubahMatkul() {
        System.out.println("Menu Ubah Matkul");
        
        Scanner scanner = new Scanner(System.in);
        MatkulModel matkul = new MatkulModel();
        
        System.out.print("Masukkan ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Masukkan nama: ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan singkatan: ");
        String singkatan = scanner.nextLine();
        
        matkul.setColumn("ID", id);
        matkul.setColumn("nama", nama);
        matkul.setColumn("singkatan", singkatan);
        matkul.update();
    }
    public static void hapusMatkul() {
        System.out.println("Menu Hapus Matkul");
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Masukkan ID: ");
        int id = scanner.nextInt();
        
        MatkulModel matkul = new MatkulModel();
        matkul.destroy(id);
    }
}
