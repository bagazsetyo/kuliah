/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UAS;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Model {
    protected String tableName; // Nama tabel di database
    protected Map<String, Object> conditions;
    protected String[] groupByColumns;
    protected String[] orderByColumns;
    protected String selectColumns;
    private final StringBuilder conditionBuilder;
    private int limitValue;
    private List<Model> records;
    protected Map<String, Object> columns; // Kolom-kolom dalam tabel

    public Model(String tableName) {
        this.tableName = tableName;
        conditions = new HashMap<>();
        groupByColumns = null;
        orderByColumns = null;
        selectColumns = "*"; // Memilih semua kolom secara default
        conditionBuilder = new StringBuilder();
        limitValue = -1;
        this.records = new ArrayList<>();
        this.columns = new HashMap<>();
    }
    
    public Model limit(int limit) {
        this.limitValue = limit;
        return this;
    }

    public Model select(String columns) {
        this.selectColumns = columns;
        return this;
    }

    public Model where(Map<String, Object> conditions) {
        this.conditions.putAll(conditions);
        return this;
    }
    
      public Model where(String condition) {
        if (conditionBuilder.length() > 0) {
            conditionBuilder.append(" AND ");
        }
        conditionBuilder.append("(").append(condition).append(")");
        return this;
    }

    public Model orWhere(String condition) {
        if (conditionBuilder.length() > 0) {
            conditionBuilder.append(" OR ");
        }
        conditionBuilder.append("(").append(condition).append(")");
        return this;
    }

    public Model andWhere(String condition) {
        return where(condition);
    }

    public Model groupBy(String[] columns) {
        this.groupByColumns = columns;
        return this;
    }

    public Model orderBy(String[] columns) {
        this.orderByColumns = columns;
        return this;
    }
    
    public List<Map<String, Object>> executeQuery() {
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    List<Map<String, Object>> resultList = new ArrayList<>();

    try {
        // Mendapatkan koneksi ke database
        connection = Koneksi.getConnection();

        // Membangun query
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("SELECT ").append(selectColumns).append(" FROM ").append(tableName);

        if (conditionBuilder.length() > 0) {
            queryBuilder.append(" WHERE ").append(conditionBuilder.toString());
        }
        
        if (limitValue >= 0) {
            queryBuilder.append(" LIMIT ").append(limitValue);
        }

        // Menyiapkan pernyataan SQL
        statement = connection.prepareStatement(queryBuilder.toString());

        // Mengeksekusi query
        resultSet = statement.executeQuery();

        // Mendapatkan hasil query
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        while (resultSet.next()) {
            Map<String, Object> row = new HashMap<>();
            for (int i = 1; i <= columnCount; i++) {
                String columnName = metaData.getColumnName(i);
                Object columnValue = resultSet.getObject(i);
                row.put(columnName, columnValue);
            }
            resultList.add(row);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Menutup sumber daya JDBC
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    return resultList;
}
    
    
    public void setColumn(String columnName, Object value) {
        columns.put(columnName, value);
    }

    public Object getColumn(String columnName) {
        return columns.get(columnName);
    }

    public void create() {
        // Melakukan operasi tambah ke database menggunakan kolom-kolom yang telah ditentukan
        this.insert();
    }
    
    public void destroy(int id) {
        this.delete(id);
    }
    
    public void edit() {
        this.update();
    }
    
    public void insert() {
        // Implementasi penyimpanan ke database menggunakan kolom-kolom yang telah ditentukan
        // Anda dapat menyesuaikan kode ini sesuai dengan kebutuhan Anda
        StringBuilder columnNames = new StringBuilder();
        StringBuilder columnValues = new StringBuilder();

        for (Map.Entry<String, Object> entry : columns.entrySet()) {
            String columnName = entry.getKey();
            Object columnValue = entry.getValue();

            columnNames.append(columnName).append(",");
            columnValues.append("'").append(columnValue).append("',");
        }

        // Hapus koma terakhir
        columnNames.deleteCharAt(columnNames.length() - 1);
        columnValues.deleteCharAt(columnValues.length() - 1);

        // Lakukan operasi penyimpanan ke database
        String query = "INSERT INTO " + tableName + "(" + columnNames + ") VALUES (" + columnValues + ")";
        System.out.println("Query: " + query);
        // Eksekusi query ke database
        Connection connection = Koneksi.getConnection();
        if (connection != null) {
            try {
                PreparedStatement statement = connection.prepareStatement(query);
                statement.executeUpdate();
                System.out.println("Data berhasil disimpan ke database");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Gagal mendapatkan koneksi ke database");
        }
    }
    
    public void delete(int id) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // Mendapatkan koneksi ke database
            connection = Koneksi.getConnection();

            // Membangun query DELETE
            String query = "DELETE FROM " + tableName + " WHERE id = ?";

            // Menyiapkan pernyataan SQL
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            // Mengeksekusi query DELETE
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data berhasil dihapus.");
            } else {
                System.out.println("Data dengan ID " + id + " tidak ditemukan.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Menutup sumber daya JDBC
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void update() {

        StringBuilder setClause = new StringBuilder();

        for (Map.Entry<String, Object> entry : columns.entrySet()) {
            String columnName = entry.getKey();
            Object columnValue = entry.getValue();

            // Skip ID column
            if (!columnName.equals("ID")) {
                setClause.append(columnName).append(" = '").append(columnValue).append("',");
            }
        }

        // Hapus koma terakhir
        setClause.deleteCharAt(setClause.length() - 1);

        // Lakukan operasi pembaruan data ke database
        String query = "UPDATE " + tableName + " SET " + setClause + " WHERE ID = " + columns.get("ID");
        System.out.println("Query: " + query);

        // Eksekusi query ke database
        Connection connection = Koneksi.getConnection();
        if (connection != null) {
            try {
                PreparedStatement statement = connection.prepareStatement(query);
                statement.executeUpdate();
                System.out.println("Data berhasil diperbarui di database");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Gagal mendapatkan koneksi ke database");
        }
    }

}
