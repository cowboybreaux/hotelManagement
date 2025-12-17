package hotelManagement;

import java.util.Scanner; // Import tool to read user input

public class Step5InputTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- STEP 5: USER INPUT TEST ---");

        // 1. Ask user for Guest details
        System.out.print("Enter Guest ID (e.g., G101): ");
        String id = scanner.nextLine(); // Waits for you to type and press Enter

        System.out.print("Enter Guest Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        System.out.print("Enter Contact Number: ");
        String contact = scanner.nextLine();

        // 2. Create the Guest object using YOUR input
        Guest newGuest = new Guest(id, name, address, contact);

        // 3. Display it back to prove it worked
        System.out.println("\n--- Success! Guest Created ---");
        newGuest.displayGuestInfo();
        
        System.out.println("------------------------------");
        scanner.close();
    }
}