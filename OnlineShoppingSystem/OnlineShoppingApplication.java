package OnlineShoppingSystem;

import java.util.Scanner;

public class OnlineShoppingApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductCatalog catalog = new ProductCatalog();
        System.out.println("WELCOME TO ONLINE SHOPPING APPLICATION");
        System.out.println("Please enter  email and password");
        // String name=scanner.next();
        String email = scanner.next();
        String pass = scanner.next();
        Customer customer = new Customer(1, email, pass);
        System.out.println("Login Successfull");
        ShoppingCart shoppingCart = new ShoppingCart();
        boolean continueShopping = true;
        while (continueShopping) {
            System.out.println("Select from Below menu");
            System.out.println("1.View All Products");
            System.out.println("2.Add Product to shopping cart");
            System.out.println("3.Remove Product from shopping cart");
            System.out.println("4.Proceed to checkout");
            System.out.println("5.exit");
            int choice = scanner.nextInt();
            if (choice == 5) {
                System.out.println("You have chosen to exit");
                continueShopping = false;
                break;
            } else if (choice == 1) {
                catalog.displayAllProducts();
            } else if (choice == 2) {
                System.out.println("Please enter the name of the product");
                String pName = scanner.next();
                boolean productFound = false;
                for (Product product : catalog.getProducts()) {
                    System.out.println(product.getName());
                    if (product.getName().toLowerCase().equals(pName.toLowerCase())) {
                        shoppingCart.addItem(product);
                        System.out.println(product.getName() + " added to cart.");
                        productFound = true;
                        break;
                    }
                    // break;
                }
                if (!productFound) {
                    System.out.println("Product not found. Please enter a valid product name.");
                }
                // break;
            } else if (choice == 3) {
                System.out.println("Please enter the name of the product to remove ");
                String pName = scanner.next();
                boolean productFound = false;
                for (Product product : catalog.getProducts()) {
                    System.out.println(product.getName());
                    if (product.getName().toLowerCase().equals(pName.toLowerCase())) {
                        shoppingCart.removeItem(product);
                        System.out.println(product.getName() + " removed from cart.");
                        productFound = true;
                        break;
                    }

                }
                if (!productFound) {
                    System.out.println("Product not found. Please enter a valid product name.");
                }
                // break;
            } else if (choice == 4) {
                System.out.println(shoppingCart.checkout());
            }
        }

    }
}
