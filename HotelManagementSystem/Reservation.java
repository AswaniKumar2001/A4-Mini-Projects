package HotelManagementSystem;

import java.util.Date;

class Reservation {
    private int reservationId;
    private Guest guest;
    private Room room;
    private Date checkInDate;
    private Date checkOutDate;

    public Reservation(int reservationId, Guest guest, Room room, Date checkInDate, Date checkOutDate) {
        this.reservationId = reservationId;
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public double calculateTotalBill(int days) {
        // Calculate the total bill based on room price and duration of stay
        // For simplicity, assuming the price is fixed per day for a room
//        long duration = checkOutDate.getTime() - checkInDate.getTime();
//        int days = (int) (duration / (1000 * 60 * 60 * 24)); // Milliseconds to days
        return room.getPrice() * days;
    }
    public int getReservationId(){
        return reservationId;
    }

    public Room getRoom(){
        return room;
    }
}
