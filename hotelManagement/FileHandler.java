package hotelManagement;

import java.io.*;

public class FileHandler {
    // The name of the text file where data will be stored 
    private static final String GUEST_FILE = "guests.txt";

    // Method to save a guest to the text file
    public static void saveGuestToFile(Guest guest) {
        // Use try-with-resources for automatic file closing (Exception Handling) [cite: 9, 22]
        try (FileWriter fw = new FileWriter(GUEST_FILE, true); 
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            
            // Format: ID, Name, Address, Contact [cite: 19]
            String data = guest.getGuestID() + "," + 
                          guest.getName() + "," + 
                          guest.getAddress() + "," + 
                          guest.getContactNumber();
            
            out.println(data);
            System.out.println("Data written to file successfully.");

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}