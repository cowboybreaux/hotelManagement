package hotelManagement;

public class Booking {
    private String bookingID;
    private Guest guest;  // Association: Booking "has a" Guest
    private Room room;    // Association: Booking "has a" Room
    private String checkInDate;
    private String checkOutDate;

    public Booking(String bookingID, Guest guest, Room room, String checkInDate, String checkOutDate) {
        this.bookingID = bookingID;
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    // Getters
    public String getBookingID() { return bookingID; }
    public Guest getGuest() { return guest; }
    public Room getRoom() { return room; }
    public String getCheckInDate() { return checkInDate; }

    // Helper method to print booking details clearly
    public void showBookingDetails() {
        System.out.println("----- BOOKING DETAILS -----");
        System.out.println("Booking ID:   " + bookingID);
        System.out.println("Guest Name:   " + guest.getName()); // Accessing Guest object
        System.out.println("Room Number:  " + room.getRoomNumber()); // Accessing Room object
        System.out.println("Check-In:     " + checkInDate);
        System.out.println("Check-Out:    " + checkOutDate);
        System.out.println("Total Cost:   RM " + room.calculateCost());
        System.out.println("---------------------------");
    }
}