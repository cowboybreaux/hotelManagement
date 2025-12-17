package hotelManagement;

// Abstract Class: Represents a generic room
public abstract class Room {
    private String roomNumber;
    private boolean isAvailable;
    protected double basePrice; // 'protected' so child classes can use it

    public Room(String roomNumber, double basePrice) {
        this.roomNumber = roomNumber;
        this.basePrice = basePrice;
        this.isAvailable = true; // Default is true (available)
    }

    // Abstract Method: Child classes MUST define how to calculate price
    // This demonstrates POLYMORPHISM
    public abstract double calculateCost();

    // Getters
    public String getRoomNumber() { return roomNumber; }
    public boolean isAvailable() { return isAvailable; }

    // Setters
    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}