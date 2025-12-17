package hotelManagement;

public class Step3Test {
    public static void main(String[] args) {
        System.out.println("--- STEP 3 TEST START ---");

        // 1. Create a Standard Room
        StandardRoom room101 = new StandardRoom("101");

        // 2. Check details
        System.out.println("Room Number: " + room101.getRoomNumber());
        System.out.println("Price: RM " + room101.calculateCost());
        System.out.println("Available? " + room101.isAvailable());

        // 3. Test changing availability (e.g., after booking)
        room101.setAvailable(false);
        System.out.println("Updated Availability? " + room101.isAvailable());

        System.out.println("--- STEP 3 TEST END ---");
    }
}