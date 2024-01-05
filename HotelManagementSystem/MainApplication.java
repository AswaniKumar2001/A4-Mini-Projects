package HotelManagementSystem;

import java.util.Date;
import java.util.Scanner;

public class MainApplication {
    public static String s;
    public static Room availableRoom;
    public static int days;

    public static double billAmount=0.0;
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Scanner scanner=new Scanner(System.in);
        availableRoom = hotel.findAvailableRoom();
        System.out.println("want a room to stay? choose Yes or No." + "Type Y or N");
        s=scanner.next();
        while (s.toLowerCase().equals("y")){
            while (availableRoom != null) {
                System.out.println("There are vacant rooms");
                System.out.println("-----------------------------------------");
                System.out.println("Please enter your name");
                String name=scanner.next();
                System.out.println("Please enter your email");
                String email=scanner.next();
                System.out.println("enter how many days you wanted to stay");
                days=scanner.nextInt();
                Date checkInDate = new Date();
                Date checkOutDate = new Date(checkInDate.getTime() + (1000 * 60 * 60 * 24 * days));
                Guest guest=new Guest(1,name,email);
                if (hotel.bookRoom(guest,availableRoom,checkInDate, checkOutDate)) {
                    System.out.println("Room booked for " + name);
                    System.out.println("---------------------------------------");
                    availableRoom = hotel.findAvailableRoom();
                    while(availableRoom ==null) {
                        System.out.println("After " + days + " days");
                        System.out.println("You have stayed " + days + " days.Do you want to :");
                        System.out.println("1.CheckOut");
                        System.out.println("2.Extend");
                        System.out.println("choose from above options");
                        int choice=scanner.nextInt();
                        if(choice==1){
                            billAmount = hotel.checkOut(1,days);
                            if (billAmount != -1) {
                                System.out.println("Check-out successful. Total amount to be paid: $" + billAmount);
                                break;
                            } else {
                                System.out.println("Invalid guest ID");
                            }
                        }
                        else{
//                            billAmount += hotel.checkOut(1);
                            System.out.println("How many days do you want to extend");
                            days+=scanner.nextInt();
                            System.out.println("Extended successfully");
                        }
                    }
                }
                availableRoom = hotel.findAvailableRoom();
            }

        }

    }
}
