/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UAS;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 *
 * @author Microvac
 */
public class PasswordEncoder {
     public static String encode(String password) {
        try {
            // Buat objek MessageDigest dengan algoritma MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            
            // Konversi password menjadi byte array
            byte[] passwordBytes = password.getBytes();
            
            // Hitung hash dari byte array password
            byte[] hashBytes = md.digest(passwordBytes);
            
            // Konversi hash menjadi format string hexadecimal
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            
            // Kembalikan hasil hash sebagai string
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        
        return null;
    }
}
