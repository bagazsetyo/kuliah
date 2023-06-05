import java.util.List;
import java.util.Scanner;

public class UserService {
    private User user;
    private Scanner scanner;

    public UserService() {
        this.user = new User();
        this.scanner = new Scanner(System.in);
    }

    public void index() {
        List<User> userList = user.get();

        if (userList.isEmpty()) {
            System.out.println("Tidak ada data user.");
        } else {
            System.out.println("Daftar User:");

            // Tampilkan header tabel
            System.out.println("--------------------------------------------");
            System.out.printf("%-5s %-15s %-5s%n", "ID", "Nama", "Usia");
            System.out.println("--------------------------------------------");

            // Tampilkan data user dalam tabel
            for (User u : userList) {
                System.out.printf("%-5d %-15s %-5d%n", u.getId(), u.getName(), u.getAge());
            }

            System.out.println("--------------------------------------------");
        }
    }

    public void create() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Membaca karakter newline setelah membaca angka

        String[] fields = {"name", "age"};
        Object[] values = {name, age};
        user.create(fields, values);
    }

    public void edit() {
        System.out.print("Enter user ID to edit: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // Membaca karakter newline setelah membaca angka

        System.out.print("Enter new name: ");
        String name = scanner.nextLine();

        System.out.print("Enter new age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Membaca karakter newline setelah membaca angka

        String[] fields = {"name", "age"};
        Object[] values = {name, age};
        user.update(userId, fields, values);
    }

    public void delete() {
        System.out.print("Enter user ID to delete: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // Membaca karakter newline setelah membaca angka

        user.deleteBy("id", userId);
    }
}
