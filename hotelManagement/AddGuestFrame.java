package hotelManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddGuestFrame extends JFrame {
    // GUI Components
    private JTextField idField, nameField, addressField, contactField;
    private JButton saveButton;

    public AddGuestFrame() {
        // 1. Setup Container
        setTitle("Hotel System - Add New Guest");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2, 10, 10)); // Layout Manager
        setLocationRelativeTo(null); // Center window on screen
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close this window, not the whole app

        // 2. Add Components to the window
        add(new JLabel(" Guest ID:"));
        idField = new JTextField();
        add(idField);

        add(new JLabel(" Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel(" Address:"));
        addressField = new JTextField();
        add(addressField);

        add(new JLabel(" Contact:"));
        contactField = new JTextField();
        add(contactField);

        saveButton = new JButton("Save Guest");
        add(saveButton);

        // 3. Logic with Exception Handling and File I/O
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // A. Get data from UI components
                    String id = idField.getText();
                    String name = nameField.getText();
                    String addr = addressField.getText();
                    String cont = contactField.getText();

                    // B. Exception Handling: Validate input
                    if (id.isEmpty() || name.isEmpty()) {
                        throw new Exception("ID and Name are required fields!");
                    }

                    // C. Create the Guest object (OOP)
                    Guest newGuest = new Guest(id, name, addr, cont);
                    
                    // D. File I/O: Save to text file
                    FileHandler.saveGuestToFile(newGuest);
                    
                    // E. Success Message
                    JOptionPane.showMessageDialog(null, "Guest " + newGuest.getName() + " saved successfully to guests.txt!");
                    
                    // F. Clear fields for next entry
                    idField.setText("");
                    nameField.setText("");
                    addressField.setText("");
                    contactField.setText("");

                } catch (Exception ex) {
                    // Catch runtime errors and show in UI
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    // --- IMPORTANT: This main method MUST be inside the class curly braces ---
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AddGuestFrame().setVisible(true);
        });
    }
}