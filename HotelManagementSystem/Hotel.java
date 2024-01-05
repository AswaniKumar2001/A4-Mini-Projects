package HotelManagementSystem;

import java.util.*;

class Hotel {
    private List<Room> rooms;
    private Map<Integer, Guest> guests;
    private List<Reservation> reservations;
    private int nextReservationId;

    public Hotel() {
        rooms = new ArrayList<>();
        guests = new HashMap<>();
        reservations = new ArrayList<>();
        nextReservationId = 1;
        initializeRooms(); // Initialize rooms in the hotel
    }

    private void initializeRooms() {
        // Create and add rooms to the hotel
        rooms.add(new Room(101, 100)); // Room number 101 with price 100
        // Add more rooms as needed
    }

    public Room findAvailableRoom() {
        // Find and return the first available room
        for (Room room : rooms) {
            if (!room.isBooked()) {
                return room;
            }
        }
        return null; // No available rooms
    }

    public boolean bookRoom(Guest guest, Room room, Date checkInDate, Date checkOutDate) {
        if (room.isBooked()) {
            return false; // Room is already booked
        }

        room.bookRoom();
        Reservation reservation = new Reservation(nextReservationId++, guest, room, checkInDate, checkOutDate);
        reservations.add(reservation);
        guests.put(guest.getGuestId(), guest);
        return true;
    }

    public double checkOut(int reservationId,int days) {
        for (Reservation reservation : reservations) {
            if (reservation.getReservationId() == reservationId) {
                reservation.getRoom().releaseRoom();
                return reservation.calculateTotalBill(days);
            }
        }
        return -1; // Reservation not found
    }
}
