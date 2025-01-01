/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UAS;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Microvac
 */
public class UserModel extends Model {
    
    private int ID;
    private String username;
    private String password;
    private String nama;    
    private String alamat;
    private String role;
    
    public UserModel() {
        super("user");
    }

    // Metode getter dan setter untuk atribut id, nama, email, password, dan role
    public int getId() {
        return ID;
    }

    public void setId(int ID) {
        this.ID = ID;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
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
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
        
    // jika user ditemukan, return sebagai user model, agar bisa digunakan di semua tempat 
    public UserModel checkCredentials(String username, String password) {
        String hashedPassword = PasswordEncoder.encode(password);

        List<Map<String, Object>> result = this
                .where("nama = '" + username + "'")
                .andWhere("password = '" + password + "'")
                .limit(1)
                .executeQuery();

        if (!result.isEmpty()) {
            // Data ditemukan, mengisi objek UserModel dengan nilai-nilai yang sesuai
            Map<String, Object> userData = result.get(0);

            // Membuat objek UserModel dan mengisi nilainya
            UserModel user = new UserModel();

            // Mengisi nilai-nilai objek UserModel
            user.setId(((Integer) userData.get("ID")).intValue());
            user.setAlamat((String) userData.get("alamat"));
            user.setUsername((String) userData.get("username"));
            user.setNama((String) userData.get("nama"));
            user.setRole((String) userData.get("role"));
            
            // buatkan setter dan getter untuk set menu, dimana role 1 = [mengerjakan quiz], 2 = [mengerjakan quiz, melihat semua user], 3, [mengerjakan quiz, melohat semua user, edit user, hapus user]

            return user; // Mengembalikan objek UserModel yang diisi
        } else {
            return null; // Contoh pengembalian nilai null jika data tidak ditemukan
        }
    }
    
    public void create() {
        // Mengisi nilai-nilai objek UserModel berdasarkan data yang telah ditentukan
        setNama((String) getColumn("name"));
        setUsername((String) getColumn("username"));
        setPassword((String) getColumn("password"));
        setAlamat((String) getColumn("alamat"));
        setRole((String) getColumn("role"));

        // Melakukan operasi tambah ke database menggunakan metode bawaan Model (seperti yang telah Anda implementasikan sebelumnya)
        insert();
    }
}
