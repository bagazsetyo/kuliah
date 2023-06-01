/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package T10;

/**
 *
 * @author user
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModelHakAkses {
    public HakAkses findByName(String name) {
        Connection connection = DbConnection.getConnection();
        if (connection != null) {
            try {
                String query = "SELECT * FROM hak_akses WHERE nama = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, name);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    String nama = resultSet.getString("nama");
                    int level = resultSet.getInt("level");
                    int id_pengguna = resultSet.getInt("id_pengguna");

                    return new HakAkses(nama, level, id_pengguna);
                }

                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
