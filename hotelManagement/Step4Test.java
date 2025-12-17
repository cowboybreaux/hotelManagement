package hotelManagement;

public class Step4Test {
    public static void main(String[] args) {
        System.out.println("--- STEP 4 TEST START ---");

        // 1. We need a Guest first
        Guest myGuest = new Guest("G200", "John Doe", "Penang", "019-8888888");

        // 2. We need a Room
        StandardRoom myRoom = new StandardRoom("305");

        // 3. Now we create the Booking linking them together
        Booking newBooking = new Booking("B555", myGuest, myRoom, "2025-12-20", "2025-12-22");

        // 4. Verify the link worked
        newBooking.showBookingDetails();

        // 5. Test: Once booked, the room should not be available
        myRoom.setAvailable(false);
        System.out.println("Room " + myRoom.getRoomNumber() + " available? " + myRoom.isAvailable());

        System.out.println("--- STEP 4 TEST END ---");
    }
}