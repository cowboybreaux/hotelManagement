package hotelManagement;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class RoomSetup {
    public static void main(String[] args) {
        // We will pre-fill the hotel with some rooms
        // Format: RoomNumber,Type,BasePrice,IsAvailable
        String[] initialRooms = {
            "101,Standard,100.00,true",
            "102,Standard,100.00,true",
            "201,Deluxe,200.00,true",
            "202,Deluxe,200.00,true",
            "301,Suite,500.00,true"
        };

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("rooms.txt"))) {
            for (String room : initialRooms) {
                bw.write(room);
                bw.newLine();
            }
            System.out.println("Success! 'rooms.txt' has been created.");
        } catch (IOException e) {
            System.out.println("Error creating room file: " + e.getMessage());
        }
    }
}