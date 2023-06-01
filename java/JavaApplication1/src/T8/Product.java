/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package T8;

/**
 *
 * @author user
 */
public class Product {
    private final String name;
    private final String price;
    private final int stock;

    // Constructor
    public Product(String name, String price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public static void main(String[] args) {
        // Membuat objek Product dengan menggunakan constructor
        Product product1 = new Product("Keyboard", "1.000.000", 10);
        Product product2 = new Product("Mouse", "300.000", 15);

        // Mengakses data menggunakan getter methods
        System.out.println("Product 1:");
        System.out.println("Name: " + product1.getName());
        System.out.println("Price: Rp. " + product1.getPrice());
        System.out.println("Stock: " + product1.getStock());

        System.out.println("\nProduct 2:");
        System.out.println("Name: " + product2.getName());
        System.out.println("Price: Rp. " + product2.getPrice());
        System.out.println("Stock: " + product2.getStock());
    }
}
