package OnlineShoppingSystem;

import java.util.ArrayList;
import java.util.List;

class ProductCatalog {
    private ArrayList<Product> products;

    public ProductCatalog() {
        this.products = new ArrayList<>();
        // Add some example products
        products.add(new Product("RealmeX212GB", 25999.0));
        products.add(new Product("Iphone14ProMAX", 99999.0));
        products.add(new Product("Redminote13pro", 23999.0));
        products.add(new Product("GooglePixel8", 109999.0));
        // Add more products as needed...
    }

    public void displayAllProducts() {
        System.out.println("Available Products:");
        for (Product product : products) {
            System.out.println(product.getName() + " - $" + product.getPrice());
        }
    }

    public List<Product> getProducts() {
        return products;
    }
}
