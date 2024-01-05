package HotelManagementSystem;

class Guest {
    private int guestId;
    private String name;
    private String email;

    public Guest(int guestId, String name, String email) {
        this.guestId = guestId;
        this.name = name;
        this.email = email;
    }

    public int getGuestId() {
        return guestId;
    }

    // Other getter and setter methods for name, email, etc.
}
