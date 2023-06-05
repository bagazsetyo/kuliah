import java.util.Scanner;

public class Menu {

    ...
    
    private static void menuUser2(User loggedInUser) {
        System.out.println("Selamat datang, " + loggedInUser.getNama() + " (Role: " + loggedInUser.getRole() + ")");

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. List User");
            System.out.println("2. Tambah User");
            System.out.println("3. Ubah User");
            System.out.println("4. Hapus User");
            System.out.println("0. Keluar");

            int menuChoice = getMenuChoice();

            switch (menuChoice) {
                case 1:
                    System.out.println("Menu List User dipilih");
                    userService.index();
                    break;
                case 2:
                    System.out.println("Menu Tambah User dipilih");
                    userService.create();
                    break;
                case 3:
                    System.out.println("Menu Ubah User dipilih");
                    userService.edit();
                    break;
                case 4:
                    System.out.println("Menu Hapus User dipilih");
                    userService.delete();
                    break;
                case 0:
                    System.out.println("Keluar dari program");
                    return;
                default:
                    System.out.println("Pilihan menu tidak valid");
            }
        }
    }

    public static void menu(User loggedInUser) {
        boolean exit = false;

        // Menampilkan menu berdasarkan role
        if (loggedInUser.getRole().equals("1")) {
            menuUser1(loggedInUser);
        } else if (loggedInUser.getRole().equals("2")) {
            menuUser2(loggedInUser);
        } else {
            System.out.println("Role tidak valid");
        }
    }

    private static void menuUser1(User loggedInUser) {
        System.out.println("Selamat datang, " + loggedInUser.getNama() + " (Role: " + loggedInUser.getRole() + ")");

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. List User");
            System.out.println("0. Keluar");

            int menuChoice = getMenuChoice();

            switch (menuChoice) {
                case 1:
                    System.out.println("Menu List User dipilih");
                    break;
                case 0:
                    System.out.println("Keluar dari program");
                    return;
                default:
                    System.out.println("Pilihan menu tidak valid");
            }
        }
    }

    private static void menuUser2(User loggedInUser) {
        System.out.println("Selamat datang, " + loggedInUser.getNama() + " (Role: " + loggedInUser.getRole() + ")");

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Soal");
            System.out.println("2. List User");
            System.out.println("3. Ubah Soal");
            System.out.println("4. Hapus Soal");
            System.out.println("0. Keluar");

            int menuChoice = getMenuChoice();

            switch (menuChoice) {
                case 1:
                    System.out.println("Menu Soal dipilih");
                    break;
                case 2:
                    System.out.println("Menu List User dipilih");
                    break;
                case 3:
                    System.out.println("Menu Ubah Soal dipilih");
                    break;
                case 4:
                    System.out.println("Menu Hapus Soal dipilih");
                    break;
                case 0:
                    System.out.println("Keluar dari program");
                    return;
                default:
                    System.out.println("Pilihan menu tidak valid");
            }
        }
    }

    private static int getMenuChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Pilih menu: ");
        return scanner.nextInt();
    }
}
