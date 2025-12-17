package hotelManagement;

public class StandardRoom extends Room {
    
    public StandardRoom(String roomNumber) {
        // Standard room costs RM 100.00
        super(roomNumber, 100.00);
    }

    // Overriding the method (Polymorphism)
    @Override
    public double calculateCost() {
        return basePrice; // No extra fees for standard room
    }
}