import java.util.Scanner;

public class BeratBadanIdeal {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {

            System.out.println("Masukkan tinggi badan: ");
            String tinggiBadan = scanner.nextLine();
    
            if (!tinggiBadan.matches("[0-9]+")) {
                System.out.println("Tinggi badan harus berupa angka");
                continue;
            }

            BeratBadan beratBadanLakiLaki = new BeratBadanIdealLakiLaki(Double.parseDouble(tinggiBadan));
            BeratBadan beratBadanPerempuan = new BeratBadanIdealPerempuan(Double.parseDouble(tinggiBadan));
    
            System.out.println("Berat badan ideal laki-laki: " + beratBadanLakiLaki.hitungBeratBadanIdeal());
            System.out.println("Berat badan ideal perempuan: " + beratBadanPerempuan.hitungBeratBadanIdeal());

            System.out.print("Hitung lagi? (Y/T): ");
            String input = scanner.nextLine();
            if (input.equals("T") || input.equals("t")) {
                break;
            }
        }
    }
}

// make abstract class BeratBadan
abstract class BeratBadan {
    protected double tinggiBadan; 

    public BeratBadan(double tinggiBadan) {
        this.tinggiBadan = tinggiBadan;
    }

    // make abstract method
    abstract double hitungBeratBadanIdeal();
}

// make class BeratBadanIdealLakiLaki
class BeratBadanIdealLakiLaki extends BeratBadan {
    public BeratBadanIdealLakiLaki(double tinggiBadan) {
        super(tinggiBadan);
    }

    @Override
    double hitungBeratBadanIdeal() {
        return (tinggiBadan - 100) * 0.9;
    }
}

// make class BeratBadanIdealPerempuan
class BeratBadanIdealPerempuan extends BeratBadan {
    public BeratBadanIdealPerempuan(double tinggiBadan) {
        super(tinggiBadan);
    }

    @Override
    double hitungBeratBadanIdeal() {
        return (tinggiBadan - 100) * 0.8;
    }
}

