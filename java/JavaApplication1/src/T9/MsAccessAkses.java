/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package T9;

import java.sql.*;

/**
 *
 * @author user
 */
public class MsAccessAkses {

    public static void main(String[] args) {
        try {
            String alamat = "jdbc:ucanaccess://D:\\databagas\\db_access\\Mahasiswa.accdb";
            Connection con = DriverManager.getConnection(alamat);
            String kueri = "Select nim, nama, angkatan, kelas, jurusan, alamat, tanggal_lahir from Mahasiswa";
            PreparedStatement ps = con.prepareStatement(kueri);

            ResultSet rs = ps.executeQuery();

            System.out.println("-----------------------------------------------------------------------------------------------------------------------");
            System.out.println(
                    "| NIM        |"
                    + " Nama                      |"
                    + " Angkatan |"
                    + " Kelas      |"
                    + " Jurusan   |"
                    + " Alamat    |"
                    + " Tanggal Lahir              |"
            );
            System.out.println("-----------------------------------------------------------------------------------------------------------------------");
            while (rs.next()) {
                String nim = rs.getString(1);
                String nama = rs.getString(2);
                String angkatan = rs.getString(3);
                String kelas = rs.getString(4);
                String jurusan = rs.getString(5);
                String alamat_mhs = rs.getString(6);
                String tanggal_lahir = rs.getString(7);
                System.out.format(
                        "| %-5s | %-25s | %-8s | %-9s | %-9s | %-9s | %-9s |\n",
                        nim, 
                        nama, 
                        angkatan, 
                        kelas, 
                        jurusan, 
                        alamat_mhs, 
                        tanggal_lahir
                );
            }
            System.out.println("-----------------------------------------------------------------------------------------------------------------------");

            ps.close();
            con.close();

            System.out.println("Connected");
        } catch (SQLException e) {
            System.err.println("Exception");
            System.err.print(e);
        }
    }
}
