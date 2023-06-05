import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Model {
    protected String tableName; // Nama tabel di database

    public Model select(String columns) {
        // Kode untuk mengatur kolom-kolom yang akan dipilih dalam kueri
        return this;
    }

    public Model where(String condition) {
        // Kode untuk menambahkan klausa WHERE dalam kueri
        return this;
    }

    public Model groupBy(String column) {
        // Kode untuk menambahkan klausa GROUP BY dalam kueri
        return this;
    }

    public Model orderBy(String column) {
        // Kode untuk menambahkan klausa ORDER BY dalam kueri
        return this;
    }

    public List<Customer> get() {
        List<Customer> customers = new ArrayList<>();

        Connection connection = Koneksi.getConnection();
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                String query = "SELECT * FROM " + tableName;
                // Kode untuk membangun kueri berdasarkan metode-metode sebelumnya (select, where, groupBy, orderBy)
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    Customer customer = createCustomerFromResultSet(resultSet);
                    customers.add(customer);
                }

                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Gagal melakukan koneksi ke database.");
        }

        return customers;
    }

    public Customer findBy(String column, Object value) {
        Customer customer = null;

        Connection connection = Koneksi.getConnection();
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                String query = "SELECT * FROM " + tableName + " WHERE " + column + " = '" + value + "'";
                ResultSet resultSet = statement.executeQuery(query);

                if (resultSet.next()) {
                    customer = createCustomerFromResultSet(resultSet);
                }

                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Gagal melakukan koneksi ke database.");
        }

        return customer;
    }

    public void create(String[] fields, Object[] values) {
        Connection connection = Koneksi.getConnection();
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                String columns = String.join(",", fields);
                String query = "INSERT INTO " + tableName + " (" + columns + ") VALUES (";
                for (Object value : values) {
                    query += "'" + value + "',";
                }
                query = query.substring(0, query.length() - 1) + ")";

                statement.executeUpdate(query);
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Gagal melakukan koneksi ke database.");
        }
    }

    public void update(String[] fields, Object[] values) {
        Connection connection = Koneksi.getConnection();
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                String query = "UPDATE " + tableName + " SET ";
                for (int i = 0; i < fields.length; i++) {
                    query += fields[i] + " = '" + values[i] + "',";
                }
                query = query.substring(0, query.length() - 1);

                statement.executeUpdate(query);
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Gagal melakukan koneksi ke database.");
        }
    }

    public void deleteBy(String column, Object value) {
        Connection connection = Koneksi.getConnection();
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                String query = "DELETE FROM " + tableName + " WHERE " + column + " = '" + value + "'";

                statement.executeUpdate(query);
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Gagal melakukan koneksi ke database.");
        }
    }

    protected Customer createCustomerFromResultSet(ResultSet resultSet) throws SQLException {
        Customer customer = new Customer();
        customer.setName(resultSet.getString("name"));
        customer.setEmail(resultSet.getString("email"));
        return customer;
    }
}
