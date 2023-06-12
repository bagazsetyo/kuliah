/**
 *
 * @author Microvac
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
        role3Menu.put(4, new MenuItem("Lihat Quiz", Menu::lihatQuiz));
        role3Menu.put(5, new MenuItem("Tambah Quiz", Menu::tambahQuiz));
        role3Menu.put(6, new MenuItem("Hapus Quiz", Menu::hapusQuiz));
        MENU_OPTIONS.put(3, role3Menu);
    }

    public static void displayMenu(UserModel user) {
        String role = user.getRole();

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

            Scanner scanner = new Scanner(System.in);
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

        System.out.println("Menu Tambah User");
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

        System.out.println("Menu Tambah Quiz");
    }

    public static void hapusQuiz() {
        System.out.println("Menu Hapus Quiz");
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
}
