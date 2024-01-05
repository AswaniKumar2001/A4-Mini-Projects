package OnlineShoppingSystem;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private ArrayList<Product> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public List addItem(Product product) {
        items.add(product);
        return items;
    }

    public List removeItem(Product product) {
        items.remove(product);
        return items;
    }

    public List showItems() {
        return items;
    }

    public double calculateTotal() {
        double total = 0;
        for (Product item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public String checkout() {
        double total = calculateTotal();
        // Perform order processing here
        return "Order placed! Total amount: " + total + ". Will be delivered within 5 days";
    }
}
