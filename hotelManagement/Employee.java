package HotelManagement;

// INHERITANCE: Employee "is a" User
public class Employee extends User {
    
    private final String employeeID; // Specific attribute for Employee only

    public Employee(String name, String password, String employeeID) {
        super(name, password); // Pass name/pass to the parent User class
        this.employeeID = employeeID;
    }

    // IMPLEMENTING the abstract method from the parent
    public boolean login(String inputName, String inputPassword) {
        // Simple check: name and password must match
        return this.getName().equals(inputName) && this.getPassword().equals(inputPassword);
    }
    
    private Object getName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getName'");
    }

    private Object getPassword() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPassword'");
    }

    public String getEmployeeID() {
        return employeeID;
    }
}