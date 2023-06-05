import java.util.Scanner;

public class Kampus {
    public static void main(String[] args) {
        // Membuat objek User
        User user = new User();

        // Menggunakan input untuk meminta username dan password
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan username: ");
        String username = scanner.nextLine();
        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();

        // Melakukan pengecekan kredensial
        User loggedInUser = user.checkCredentials(username, password);

        if (loggedInUser != null) {
            // Kredensial valid, lempar ke Menu.java
            System.out.println("Login berhasil");
            System.out.println("Selamat datang, " + loggedInUser.getNama() + "!");

            // Memanggil metode menu() dalam file Menu.java
            Menu.menu(loggedInUser);
        } else {
            // Kredensial tidak valid
            System.out.println("Login gagal");
            // Tampilkan pesan atau lakukan tindakan lain jika login gagal
        }
    }
}
