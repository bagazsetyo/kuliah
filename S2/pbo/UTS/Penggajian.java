package UTS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Penggajian {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Karyawan> karyawanList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("==================================");
        System.out.println("Penggajian Karyawan");
        System.out.println("==================================");
        
        while (true){
            System.out.print("Masukkan Nama: ");
            String nama = scanner.nextLine();
            System.out.print("Masukkan Golongan: ");
            String golongan = scanner.nextLine();
            
            String intensif = "0";
            String kehadiran = "0";

            if (golongan.equals("0")) {
                System.out.print("Masukkan Kehadiran: ");
                kehadiran = scanner.nextLine();
            } else if (golongan.equals("1")) {
                System.out.print("Masukkan Intensif: ");
                intensif = scanner.nextLine();
            } else {
                System.out.println("Golongan tidak valid");
                continue;
            }

            Karyawan karyawan = new Karyawan(nama, golongan, intensif, kehadiran);

            karyawanList.add(karyawan);
            
            // decimal format
            System.out.print("Input mahasiswa lagi? (Y/T): ");
            String input = scanner.nextLine();
            if (input.equals("T") || input.equals("t")){
                break;
            }

        }

        // print karyawanlist 
        System.out.println("==================================");
        
        int nameWidth = 10;
        int golonganWidth = 10;
        int insentifWidth = 10;
        int kehadiranWidth = 10;
        int gajiWidth = 10;
        System.out.println("| " + String.format("%-" + nameWidth + "s", "Name") + 
            " |" + String.format("%-" + golonganWidth + "s", "Golongan") + 
            " |" + String.format("%-" + insentifWidth + "s", "Intensif") + 
            " |" + String.format("%-" + kehadiranWidth + "s", "Kehadiran") + 
            " |" + String.format("%-" + gajiWidth + "s", "Gaji") + " |");
        System.out.println(
            "|" + new String(new char[nameWidth + 2]).replace("\0", "-") + 
            "|" + new String(new char[golonganWidth + 2]).replace("\0", "-") + 
            "|" + new String(new char[insentifWidth + 2]).replace("\0", "-") + 
            "|" + new String(new char[kehadiranWidth + 2]).replace("\0", "-") + 
            "|" + new String(new char[gajiWidth + 2]).replace("\0", "-") + "|");
        System.out.println("| " );
        for (Karyawan karyawan : karyawanList ){
            karyawan.getKaryawan();
        }
    }
}

class Karyawan extends Gaji {

    private String nama;
    private String golongan;
    private Gaji gaji = new Gaji();
    
    private Map<String, String> golonganPegawai = new HashMap<String, String>() {{
        put("0", "Honorer");
        put("1", "Tetap");
    }};


    public Karyawan(String nama, String golongan, String intensif, String kehadiran) {
        this.nama = nama;
        this.golongan = this.getGolongan(golongan);

        gaji.setBebanKerja(Integer.parseInt(intensif));
        gaji.setKehadiranKaryawan(Integer.parseInt(kehadiran));
    }

    public boolean setGolongan(String golongan) {
        if (golonganPegawai.containsKey(golongan)) {
            this.golongan = golongan;
            return true;
        }
        return false;
    } 

    public String getGolongan(String golongan) {
        return golonganPegawai.get(golongan);
    }

    public void getKaryawan() {
        int nameWidth = 10;
        int golonganWidth = 10;
        int insentifWidth = 10;
        int kehadiranWidth = 10;
        int gajiWidth = 10;

        int gaji = this.gaji.hitungGaji() + this.gaji.getInsentif() + this.gaji.getKehadiran();
        System.out.println("| " + String.format("%-" + nameWidth + "s", this.nama) + " |" + 
            String.format("%-" + golonganWidth + "s", this.golongan) + " |" + 
            String.format("%-" + insentifWidth + "s", this.gaji.getInsentif()) + " |" + 
            String.format("%-" + kehadiranWidth + "s", this.gaji.getKehadiran()) + " |" + 
            String.format("%-" + gajiWidth + "s",  + gaji) + " |");
    }
}

class Gaji {
    private int gaji = 2500000;
    private int insentif = 800000;
    private int kehadiran = 150000;

    private int bebanKerja;
    private int kehadiranKaryawan;

    public void setBebanKerja(int bebanKerja) {
        if (bebanKerja < 1 || bebanKerja > 5) {
            bebanKerja = 0;
        }
        this.bebanKerja = (bebanKerja * insentif);
    }

    public void setKehadiranKaryawan(int kehadiranKaryawan) {
        if (kehadiranKaryawan < 1 || kehadiranKaryawan > 20) {
            kehadiranKaryawan = 0;
        }
        this.kehadiranKaryawan = (kehadiranKaryawan * kehadiran);
    }

    public int getInsentif() {
        return bebanKerja;
    }

    public int getKehadiran() {
        return kehadiranKaryawan;
    }

    public int hitungGaji() {
        return gaji + (bebanKerja * kehadiranKaryawan);
    }
}