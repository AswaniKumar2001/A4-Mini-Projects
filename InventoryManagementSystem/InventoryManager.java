package InventoryManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class InventoryManager {

    public static boolean isBreak=false;

    private WareHouse wareHouse;

    private Product product;

    public static List<WareHouse> wareHouses= new ArrayList<>();

    public void addWareHouse(WareHouse wareHouse){
        if(wareHouses.size()!=0) {
            for (WareHouse wareHouse1 : wareHouses) {
                if (wareHouse1.getName().equals(wareHouse.getName())) {
                    isBreak = true;
                }
            }
            if (!isBreak) {
                wareHouses.add(wareHouse);
            } else {
                System.out.println("There is already a warehouse with same name");
            }
        }
        else{
            wareHouses.add(wareHouse);
        }
    }

    public void showWarehouses(){
        for (WareHouse wareHouse1:wareHouses){
            System.out.println(wareHouses.indexOf(wareHouse1)+1+wareHouse1.getName());
        }
    }


}
