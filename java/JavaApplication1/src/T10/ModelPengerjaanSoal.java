/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package T10;

import java.sql.*;
/**
 *
 * @author user
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ModelPengerjaanSoal {
    public void findById(int id_pengguna) {
        Connection connection = DbConnection.getConnection();
        if (connection != null) {
            try {
                String query = "SELECT * FROM pengerjaan_soal "
                        + "join hak_akses on pengerjaan_soal.pengguna = hak_akses.id_pengguna "
                        + "WHERE pengguna = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, id_pengguna);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int skor = resultSet.getInt("skor");
                    String tanggal_pengerjaan = resultSet.getString("tanggal_pengerjaan");
                    String jam_pengerjaan = resultSet.getString("jam_pengerjaan");
                    String nama = resultSet.getString("nama");
                    
                    System.out.println("Skor : " + skor);
                    System.out.println("Tanggal Pengerjaan : " + tanggal_pengerjaan);
                    System.out.println("Jam Pengerjaan : " + jam_pengerjaan);
                    System.out.println("========================================");
                }

                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void findAll() {
        List<PengerjaanSoal> pengerjaanSoalList = new ArrayList<>();

        Connection connection = DbConnection.getConnection();
        if (connection != null) {
            try {
                String query = "SELECT * FROM pengerjaan_soal join hak_akses on pengerjaan_soal.pengguna = hak_akses.id_pengguna";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();
                
                System.out.println("-----------------------------------------------------------------------");
                System.out.println(
                        "| ID    |"
                        + " Nama  |"
                        + " Skor  |"
                        + " Tanggal Pengerjaan   |"
                        + " Jam Pengerjaan       |"
                );
                System.out.println("-----------------------------------------------------------------------");
                while (resultSet.next()) {
                    int id_pengerjaan = resultSet.getInt("id_pengerjaan");
                    int skor = resultSet.getInt("skor");
                    String tanggal_pengerjaan = resultSet.getString("tanggal_pengerjaan");
                    String jam_pengerjaan = resultSet.getString("jam_pengerjaan");
                    String nama = resultSet.getString("nama");
                    
                    System.out.format(
                  "| %-5s | %-5s | %-5s | %-20s | %-20s |\n",
                        id_pengerjaan, 
                        nama, 
                        skor, 
                        tanggal_pengerjaan, 
                        jam_pengerjaan 
                    );
                }

                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void insert(PengerjaanSoal pengerjaanSoal) {
        // Ambil koneksi dari koneksi file DbConnection
        Connection connection = DbConnection.getConnection();
        if (connection != null) {
            try {
                // Query insert ke database 
                String query = "INSERT INTO pengerjaan_soal (pengguna, skor, tanggal_pengerjaan, jam_pengerjaan) VALUES (?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                // Mapping data 
                preparedStatement.setInt(1, pengerjaanSoal.getIdPengerjaan());
                preparedStatement.setInt(2, pengerjaanSoal.getSkor());
                preparedStatement.setString(3, getCurrentDate());
                preparedStatement.setString(4, getCurrentTime());
                // Eksekusi query
                preparedStatement.executeUpdate();
                System.out.println("Data Pengerjaan Soal berhasil disimpan.");

                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void updateSkor(int idPengerjaan, int newSkor) {
        // Ambil koneksi dari koneksi file DbConnection
        Connection connection = DbConnection.getConnection();
        if (connection != null) {
            try {
                // query update ke database
                String query = "UPDATE pengerjaan_soal SET skor = ? WHERE id_pengerjaan = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                // mapping data
                preparedStatement.setInt(1, newSkor);
                preparedStatement.setInt(2, idPengerjaan);
                // eksekusi query
                preparedStatement.executeUpdate();
                System.out.println("Data skor berhasil diperbarui.");

                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteById(int idPengerjaan) {
        // ambil koneksi dari koneksi file DbConnection
        Connection connection = DbConnection.getConnection();
        if (connection != null) {
            try {
                // query ke database
                String query = "DELETE FROM pengerjaan_soal WHERE id_pengerjaan = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, idPengerjaan);
                // eksekusi kode program
                preparedStatement.executeUpdate();
                System.out.println("Data berhasil dihapus.");

                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static String getCurrentDate() {
        // Implementasi untuk mendapatkan tanggal saat ini
        // Misalnya menggunakan library java.time.LocalDateTime
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd MMMM yyyy"));
    }

    public static String getCurrentTime() {
        // Implementasi untuk mendapatkan waktu saat ini
        // Misalnya menggunakan library java.time.LocalDateTime
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }
}
