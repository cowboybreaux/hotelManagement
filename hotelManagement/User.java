// 1. Package name must be one word (no spaces)
package hotelManagement;

// Abstract class: You cannot create a "User" object directly
public abstract class User {
    // Encapsulation: Private attributes
    private String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    // Abstract method: Must be implemented by children (Employee/Admin)
    public abstract void displayRole();

    // Getters and Setters (Encapsulation)
    public String getName() { 
        return name; 
    }
    
    public String getPassword() { 
        return password; 
    }
}