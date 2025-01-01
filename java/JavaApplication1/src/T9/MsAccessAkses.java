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
            String location = "jdbc:ucanaccess://D:\\databagas\\db_access\\dbwisata.accdb";
            Connection con = DriverManager.getConnection(location);
            String kueri = "Select * from wisata ORDER BY CONVERT(id_wisata, INTEGER) ASC";
            PreparedStatement ps = con.prepareStatement(kueri);

            ResultSet rs = ps.executeQuery();

            System.out.println("-----------------------------------------------------------------------------------------------------------------------");
            System.out.println(
                    "| ID         |"
                    + " Nama Lokasi                              |"
                    + " Alamat               |"
                    + " Rangking             |"
            );
            System.out.println("-----------------------------------------------------------------------------------------------------------------------");
            while (rs.next()) {
                String id_lokasi = rs.getString("Id_wisata");
                String nama_lokasi = rs.getString("Nama_lokasi");
                String alamat = rs.getString("Alamat_lokasi");
                String rangking = rs.getString("Rangking");
                System.out.format(
                        "| %-10s | %-40s | %-20s | %-20s |\n",
                        id_lokasi,
                        nama_lokasi,
                        alamat,
                        rangking
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
