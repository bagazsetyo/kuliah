public class Customer extends Model {
    private String name;
    private String email;

    public Customer() {
        this.tableName = "customers"; // Nama tabel di database
    }

    // Metode getter dan setter untuk atribut name dan email
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    // Implementasi metode createModelFromResultSet() untuk mengubah ResultSet menjadi objek Customer
    protected Model createModelFromResultSet(ResultSet resultSet) throws SQLException {
        Customer customer = new Customer();
        customer.setName(resultSet.getString("name"));
        customer.setEmail(resultSet.getString("email"));
        return customer;
    }
}
