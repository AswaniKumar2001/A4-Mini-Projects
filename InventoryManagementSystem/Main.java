package InventoryManagementSystem;

import java.util.Scanner;

public class Main {
    public static int choice=0;

    public static void main(String [] args){
        InventoryManager inventoryManager=new InventoryManager();
        WareHouse wareHouse=new WareHouse("AswinWareHouse");
//        WareHouse wareHouse1=new WareHouse("HameedWareHouse");
        inventoryManager.addWareHouse(wareHouse);
        Scanner scanner=new Scanner(System.in);
        while(choice!=5){
            System.out.println("Choose from below menu");
            System.out.println("1.ADD PRODUCT");
            System.out.println("2.VIEW STOCK LEVELS");
            System.out.println("3.RECIEVE ORDER");
            System.out.println("4.CHECK PRODUCTS");
            choice=scanner.nextInt();
            if(choice==1){
                System.out.println("PLEASE ENTER PRODUCT DETAILS LIKE NAME,PRICE,QUANTITY");
                String name=scanner.next();
                double price= scanner.nextDouble();
                int quantity= scanner.nextInt();
                wareHouse.addProduct(new Product(name,price,quantity));
            }
            else if(choice==2){
                wareHouse.checkStockLevels();
            }
            else if(choice==3) {
                System.out.println("This will be shown to user");

                if (WareHouse.products.isEmpty()) {
                    System.out.println("No products found");
                } else {
                    System.out.println("choose from below products");
                    wareHouse.checkProducts();
                    int choose = scanner.nextInt();
                    System.out.println("enter the quantity you want to buy");
                    int quant = scanner.nextInt();
//                System.out.println(WareHouse.products.size());
                    wareHouse.removeProduct(WareHouse.products.get(choose - 1).getName(), quant);
                }
            }
            else if(choice==4) {
                if (WareHouse.products.isEmpty()) {
                    System.out.println("No products found");
                } else {
                    wareHouse.checkProducts();
                }
            }
        }
    }
}
