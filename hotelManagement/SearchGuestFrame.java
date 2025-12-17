package hotelManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SearchGuestFrame extends JFrame {
    
    // GUI Components
    private JTextField searchField;
    private JTextArea resultArea; // A big text box to show the results
    private JButton searchButton;

    public SearchGuestFrame() {
        // 1. Setup Container
        setTitle("Hotel System - Search Guest");
        setSize(400, 300);
        setLayout(new FlowLayout()); // Simple layout
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window

        // 2. Add Components
        add(new JLabel("Enter Guest ID to Search:"));
        searchField = new JTextField(15); // Width of 15 columns
        add(searchField);

        searchButton = new JButton("Find Guest");
        add(searchButton);

        // Area to display the found info (Non-editable)
        resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false); // User can read but not type here
        resultArea.setBorder(BorderFactory.createTitledBorder("Search Results"));
        
        // Add scroll pane in case the text is long
        add(new JScrollPane(resultArea)); 

        // 3. Logic: Reading from File
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String targetID = searchField.getText().trim();
                
                // Exception Handling: Check if empty
                if (targetID.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter an ID!");
                    return;
                }

                // Call the helper method to search
                searchInFile(targetID);
            }
        });
    }

    // Helper method to read the text file
    private void searchInFile(String idToFind) {
        boolean found = false;
        resultArea.setText(""); // Clear previous results

        // File I/O: Try-with-resources to read 'guests.txt'
        try (BufferedReader br = new BufferedReader(new FileReader("guests.txt"))) {
            String line;
            
            // Loop through every line in the file
            while ((line = br.readLine()) != null) {
                // The file format is: ID,Name,Address,Contact
                String[] data = line.split(","); 
                
                // Check if the first part (ID) matches what we typed
                if (data[0].equals(idToFind)) {
                    resultArea.append("User Found!\n");
                    resultArea.append("-----------------\n");
                    resultArea.append("Name: " + data[1] + "\n");
                    resultArea.append("Address: " + data[2] + "\n");
                    resultArea.append("Contact: " + data[3] + "\n");
                    found = true;
                    break; // Stop searching once found
                }
            }

            // Exception Handling: Logic error if ID not found
            if (!found) {
                JOptionPane.showMessageDialog(null, "Guest ID " + idToFind + " not found.", "Search Result", JOptionPane.WARNING_MESSAGE);
            }

        } catch (IOException ex) {
            // Exception Handling: File not found or read error
            JOptionPane.showMessageDialog(null, "Error reading file: " + ex.getMessage());
        }
    }

    // Main method for testing this window alone
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SearchGuestFrame().setVisible(true);
        });
    }
}