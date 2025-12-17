package hotelManagement;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

public class EditGuestFrame extends JFrame {

    private JTextField searchIdField, nameField, addressField, contactField;
    private JButton searchButton, updateButton;
    // We need to remember which ID we are editing
    private String currentGuestID = ""; 

    public EditGuestFrame() {
        // 1. Setup Container
        setTitle("Hotel System - Edit Guest Details");
        setSize(400, 350);
        setLayout(new GridLayout(6, 2, 10, 10)); 
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // 2. Add Search Section (Top Row)
        add(new JLabel(" Search Guest ID:"));
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        searchIdField = new JTextField(10);
        searchButton = new JButton("Search");
        searchPanel.add(searchIdField);
        searchPanel.add(searchButton);
        add(searchPanel);

        // 3. Add Editable Fields
        add(new JLabel(" Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel(" Address:"));
        addressField = new JTextField();
        add(addressField);

        add(new JLabel(" Contact:"));
        contactField = new JTextField();
        add(contactField);

        add(new JLabel("")); // Empty placeholder
        updateButton = new JButton("Update Guest");
        updateButton.setEnabled(false); // Disabled until we find a guest
        add(updateButton);

        // 4. Logic: Search for the guest first
        searchButton.addActionListener(e -> {
            String id = searchIdField.getText().trim();
            if (id.isEmpty()) return;
            loadGuestInfo(id);
        });

        // 5. Logic: Save the changes
        updateButton.addActionListener(e -> {
            updateGuestInFile();
        });
    }

    private void loadGuestInfo(String id) {
        try (BufferedReader br = new BufferedReader(new FileReader("guests.txt"))) {
            String line;
            boolean found = false;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equals(id)) {
                    // Fill the boxes with current data
                    currentGuestID = data[0];
                    nameField.setText(data[1]);
                    addressField.setText(data[2]);
                    contactField.setText(data[3]);
                    
                    updateButton.setEnabled(true); // Now you can update
                    found = true;
                    break;
                }
            }
            if (!found) JOptionPane.showMessageDialog(null, "Guest ID not found!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

    private void updateGuestInFile() {
        ArrayList<String> tempData = new ArrayList<>();
        File file = new File("guests.txt");

        try {
            // Read all lines
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                // If this is the guest we are editing, use the NEW data from text boxes
                if (data[0].equals(currentGuestID)) {
                    String newLine = currentGuestID + "," + 
                                     nameField.getText() + "," + 
                                     addressField.getText() + "," + 
                                     contactField.getText();
                    tempData.add(newLine);
                } else {
                    tempData.add(line); // Keep old data for others
                }
            }
            br.close();

            // Write everything back
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for (String s : tempData) {
                bw.write(s);
                bw.newLine();
            }
            bw.close();
            
            JOptionPane.showMessageDialog(null, "Guest details updated successfully!");
            dispose(); // Close window

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error updating file: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EditGuestFrame().setVisible(true));
    }
}