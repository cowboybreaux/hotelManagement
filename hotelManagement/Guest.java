package hotelManagement;

public class Guest {
    // Encapsulation: All attributes are private
    private String guestID;
    private String name;
    private String address;
    private String contactNumber;

    // Constructor
    public Guest(String guestID, String name, String address, String contactNumber) {
        this.guestID = guestID;
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
    }

    // Getters (to access the data safely)
    public String getGuestID() { return guestID; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getContactNumber() { return contactNumber; }

    // Setters (if you need to update info later)
    public void setAddress(String address) {
        this.address = address;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    
    // Helper method to display guest info easily
    public void displayGuestInfo() {
        System.out.println("Guest ID: " + guestID);
        System.out.println("Name:     " + name);
        System.out.println("Address:  " + address);
        System.out.println("Contact:  " + contactNumber);
    }
}