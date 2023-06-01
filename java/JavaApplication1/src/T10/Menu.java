/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package T10;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class Menu {
    private final HakAkses hakakses;
    private final ModelPengerjaanSoal modelPengerjaanSoal;
    
    // Membuat constructor menu, berdasarkan HakAkses dan PengerjaanSoal
    public Menu(HakAkses hakakses) {
        this.hakakses = hakakses;
        this.modelPengerjaanSoal = new ModelPengerjaanSoal();
    }
    
    // menampilkan menu berdasarkan HakAkses User
    public void displayMenu() {
        int level = this.hakakses.getLevel();
        System.out.println("Menu:");
        
        switch (level) {
            case 1:
                System.out.println("1. Kerjakan Soal");
                System.out.println("2. Lihat Hasil Sendiri");
                System.out.println("3. Lihat Progress Teman-Teman");
                System.out.println("4. Ubah Data");
                System.out.println("5. Hapus Data");
                break;
            case 2:
                System.out.println("1. Kerjakan Soal");
                System.out.println("2. Lihat Hasil Sendiri");
                break;
            default:
                System.out.println("Level tidak valid.");
                break;
        }
    }

    // Menampilkan menu berdasarkan yang di input user
    public void processMenu(int menuChoice) {
        Scanner scanner = new Scanner(System.in);
        boolean repeatMenu = true;

        do {
            // Menampilkan list menu berdasarkan inputan
            switch (menuChoice) {
                case 1:
                    kerjakanSoal();
                    break;
                case 2:
                    lihatHasilSendiri();
                    break;
                case 3:
                    lihatProgressTeman();
                    break;
                case 4:
                    ubahData();
                    break;
                case 5:
                    hapusData();
                    break;
                default:
                    System.out.println("Pilihan menu tidak valid.");
            }

            // Tampilkan menu lagi atau selesai?
            System.out.print("Apakah Anda ingin melanjutkan? (y/n): ");
            String continueChoice = scanner.nextLine();

            if (continueChoice.equalsIgnoreCase("y")) {
                System.out.println("Menu yang tersedia:");
                displayMenu();
                System.out.print("Pilih menu: ");
                menuChoice = scanner.nextInt();
                scanner.nextLine(); // Membaca karakter baru setelah angka
            } else {
                repeatMenu = false;
            }
        } while (repeatMenu);
    }

    private void kerjakanSoal() {
        int numberOfQuestions = 10;
        int score = 0;

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i <= numberOfQuestions; i++) {
            int number1 = random.nextInt(10) + 1;
            int number2 = random.nextInt(10) + 1;
            int operator = random.nextInt(4);
            int correctAnswer = 0;
            String operatorSymbol = "";

            switch (operator) {
                case 0:
                    correctAnswer = number1 + number2;
                    operatorSymbol = "+";
                    break;
                case 1:
                    correctAnswer = number1 - number2;
                    operatorSymbol = "-";
                    break;
                case 2:
                    correctAnswer = number1 * number2;
                    operatorSymbol = "*";
                    break;
                case 3:
                    // Menghasilkan angka untuk pembagian (hasil dari pembagian)
                    int dividend = random.nextInt(10) + 1;
                    // Mencari pembagi terbesar yang menghasilkan hasil bagi tanpa desimal
                    int divisor = random.nextInt(number1) + 1;
                    // Menghitung jawaban yang benar berdasarkan pembagian yang dihasilkan dan pembagi
                    number1 = dividend * divisor;
                    number2 = divisor;
                    correctAnswer = dividend;
                    operatorSymbol = "/";
                    break;
            }

            System.out.print("Question " + i + ": ");
            System.out.print(number1 + " " + operatorSymbol + " " + number2 + " = ");

            int userAnswer = scanner.nextInt();
            if (userAnswer == correctAnswer) {
                score++;
            } 
        }
        
        score = score * 10;

        System.out.println("Quiz completed!");
        System.out.println("Your score: " + score + "/" + numberOfQuestions);
        
        PengerjaanSoal pengerjaanSoal = new PengerjaanSoal(
                this.hakakses.getIdPengguna(), 
                score , 
                null, 
                null
        );
        ModelPengerjaanSoal modelPengerjaanSoal = new ModelPengerjaanSoal();
        modelPengerjaanSoal.insert(pengerjaanSoal);
    }

    private void lihatProgressTeman() {
        System.out.println("Menu Lihat Progress Teman-Teman dipilih.");
        modelPengerjaanSoal.findAll();
    }

    private void lihatHasilSendiri() {
        System.out.println("--------------------------------------------");
        System.out.println("Lihat Hasil dari : " + this.hakakses.getNama());
        System.out.println("");
        modelPengerjaanSoal.findById(this.hakakses.getIdPengguna());
    }

    private void ubahData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu Ubah Data Skor dipilih.");

        System.out.print("Masukkan ID Pengerjaan: ");
        int idPengerjaan = scanner.nextInt();

        System.out.print("Masukkan Skor Baru: ");
        int newSkor = scanner.nextInt();
    
        modelPengerjaanSoal.updateSkor(idPengerjaan, newSkor);
    }

    private void hapusData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu Hapus Data dipilih.");
        
        System.out.print("Masukkan ID Pengerjaan: ");
        int idPengerjaan = scanner.nextInt();

        modelPengerjaanSoal.deleteById(idPengerjaan);
    }
}