package hotelManagement;

public class Step2Test {
    public static void main(String[] args) {
        System.out.println("--- STEP 2 TEST START ---");

        // 1. Create a Guest object
        // ID: G101, Name: Sarah, Address: KL, Contact: 012-3456789
        Guest guest1 = new Guest("G101", "Sarah", "Kuala Lumpur", "012-3456789");

        // 2. Display the info
        System.out.println("Created Guest successfully:");
        guest1.displayGuestInfo();

        // 3. Test modifying data (Encapsulation check)
        System.out.println("\nUpdating Address...");
        guest1.setAddress("Selangor"); // Change address
        System.out.println("New Address: " + guest1.getAddress());

        System.out.println("--- STEP 2 TEST END ---");
    }
}