package hotelManagement;

public class Step1Test {
    public static void main(String[] args) {
        System.out.println("--- STEP 1 TEST START ---");

        // 1. Create an Employee object
        // Name: Ali, Pass: 12345, ID: E001
        Employee emp = new Employee("Ali", "12345", "E001");

        // 2. Print details to verify it works
        System.out.println("Success! Created Employee:");
        System.out.println("Name: " + emp.getName());
        System.out.println("ID:   " + emp.getEmployeeID());
        
        // 3. Check the abstract method
        emp.displayRole();

        System.out.println("--- STEP 1 TEST END ---");
    }
}