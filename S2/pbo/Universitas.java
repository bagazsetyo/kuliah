import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Universitas extends Mahasiswa {
    private ArrayList<Mahasiswa> mahasiswaList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private String universitas;

    public Universitas(String nim, String nama, String alamat, String jurusan) {
        super(nim, nama, alamat, jurusan);
    }

    public void inputMahasiswa() {
        char input = 'Y';
        
        System.out.print("Masukkan Universitas: ");
        universitas = scanner.nextLine();

        while (input != 'T' && input != 't') {
            System.out.print("Masukkan NIM: ");
            String nim = scanner.nextLine();
            System.out.print("Masukkan Nama: ");
            String nama = scanner.nextLine();
            System.out.print("Masukkan Alamat: ");
            String alamat = scanner.nextLine();
            System.out.print("Masukkan Jurusan: ");
            String jurusan = scanner.nextLine();

            Mahasiswa mahasiswa = new Mahasiswa(nim, nama, alamat, jurusan);

            if(!mahasiswa.setJurusan(jurusan)) {
                System.out.println("Jurusan tidak valid");
                continue;
            }

            mahasiswaList.add(mahasiswa);

            System.out.print("Input mahasiswa lagi? (Y/T): ");
            input = scanner.nextLine().charAt(0);
        }

        System.out.println("Universitas: " + universitas);
        for (Mahasiswa mahasiswa : mahasiswaList) {
            mahasiswa.getMahasiswa();
        }
    }

    public static void main(String[] args) {
        Universitas universitas = new Universitas("2113221069", "Bagas Setyo Nugroho", "Magelang", "65");
        universitas.inputMahasiswa();
    }
}

class Mahasiswa {
    private String nim;
    private String nama;
    private String alamat;
    private String jurusan;
    
    private Map<String, String> jurusanList = new HashMap<String, String>() {{
        put("61", "Matematika");
        put("62", "Biologi");
        put("63", "Kimia");
        put("64", "Fisika");
        put("65", "Teknik Informatika");
        put("66", "Teknik Arsitektur");
    }};

    public Mahasiswa(String nim, String nama, String alamat, String jurusan) {
        this.nim = nim;
        this.nama = nama;
        this.alamat = alamat;
        this.jurusan = jurusan;
    }

    public boolean setJurusan(String jurusan) {
        if (jurusanList.containsKey(jurusan)) {
            this.jurusan = jurusanList.get(jurusan);
            return true;
        }
        return false;
    }

    public void getMahasiswa() {
        System.out.println("===========================");
        System.out.println("NIM: " + nim);
        System.out.println("Nama: " + nama);
        System.out.println("Alamat: " + alamat);
        System.out.println("Jurusan: " + jurusan);
    }
}