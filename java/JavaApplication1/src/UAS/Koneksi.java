/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UAS;
import java.sql.*;
/**
 *
 * @author Microvac
 */
public class Koneksi {
    private static final String DATABASE_PATH = "D:\\databagas\\db_access\\UAS.accdb";


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
