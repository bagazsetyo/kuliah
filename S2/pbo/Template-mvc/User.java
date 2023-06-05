public class User extends Model {
    private int id;
    private String nama;
    private String email;
    private String password;
    private String role;

    public User() {
        this.tableName = "users"; // Nama tabel di database
    }

    // Metode getter dan setter untuk atribut id, nama, email, password, dan role
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // Implementasi metode createModelFromResultSet() untuk mengubah ResultSet menjadi objek User
    protected Model createModelFromResultSet(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setNama(resultSet.getString("nama"));
        user.setEmail(resultSet.getString("email"));
        user.setPassword(resultSet.getString("password"));
        user.setRole(resultSet.getString("role"));
        return user;
    }

    public User checkCredentials(String username, String password) {
        Connection connection = Koneksi.getConnection();
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                String query = "SELECT * FROM " + tableName + " WHERE email = '" + username + "' AND password = '" + password + "'";
                ResultSet resultSet = statement.executeQuery(query);

                if (resultSet.next()) {
                    User user = createModelFromResultSet(resultSet);
                    resultSet.close();
                    statement.close();
                    connection.close();
                    return user;
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

        return null;
    }
}
