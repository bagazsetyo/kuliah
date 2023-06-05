import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
    private static final String DATABASE_PATH = "path_ke_database.accdb"; // Ganti dengan path ke file database Anda

    public static Connection getConnection() {
        try {
            // Registrasi driver JDBC untuk UCANACCESS
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            
            // Mendapatkan koneksi ke database
            String url = "jdbc:ucanaccess://" + DATABASE_PATH;
            return DriverManager.getConnection(url);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
