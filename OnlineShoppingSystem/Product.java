package OnlineShoppingSystem;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // private static ArrayList<Product> products;
    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}