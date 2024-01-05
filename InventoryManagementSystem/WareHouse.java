package InventoryManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class WareHouse {

    public WareHouse(String name) {
        this.name = name;
    }

    private String name;

    public static List<Product> products= new ArrayList<>();

    public static boolean isBreak=false;

    public static boolean isProduct=false;

    public String getName() {
        return name;
    }

    public  void addProduct(Product product) {
        if (products.size()!=0){
            for (Product product1 : products) {
                if (product.getName().equals(product1.getName())) {
                    product1.setQuantity(product1.getQuantity() + product.getQuantity());
                    System.out.println("Product added successfully");
                    isBreak = true;
                }
            }
            if(!isBreak){
                products.add(product);
                System.out.println("Product added successfully");
            }
    }
        else{
            products.add(product);
            System.out.println("Product added successfully");
        }
    }
    public void checkProducts(){
        for(Product product:products){
            System.out.println(products.indexOf(product)+1+" "+product.getName());
        }
    }

    public void removeProduct(String name,int quantity){
        if(products.size()==0){
            System.out.println("There are no products yet");
        }
        else{
            for(Product product1:products){
                if(name.equals(product1.getName())){
                    if(product1.getQuantity()<quantity){
                        System.out.println("Out of stock");
                    }
                    else{
                        product1.setQuantity(product1.getQuantity()-quantity);
                        System.out.println("The product will be delivered with in 5 days");
                    }
                }
            }
        }
    }

    public void checkStockLevels(){
      for(Product product:products){
          System.out.println("The product "+product.getName()+" is of quantity "+product.getQuantity());
      }
    }


}
