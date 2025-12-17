package hotelManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class DeleteGuestFrame extends JFrame {
    
    private JTextField idField;
    private JButton deleteButton;

    public DeleteGuestFrame() {
        // 1. Setup Container
        setTitle("Hotel System - Delete Guest");
        setSize(400, 200);
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // 2. Add Components
        add(new JLabel("Enter Guest ID to DELETE:"));
        idField = new JTextField(15);
        add(idField);

        deleteButton = new JButton("Delete Guest");
        deleteButton.setBackground(Color.RED); // Make it red so they know it's dangerous!
        deleteButton.setForeground(Color.WHITE);
        add(deleteButton);

        // 3. Logic: Remove line from file
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idToDelete = idField.getText().trim();
                
                if (idToDelete.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter an ID!");
                    return;
                }

                // Confirm before deleting
                int confirm = JOptionPane.showConfirmDialog(null, 
                    "Are you sure you want to delete Guest " + idToDelete + "?", 
                    "Confirm Deletion", JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    deleteGuestFromFile(idToDelete);
                }
            }
        });
    }

    // Helper method to handle the file rewriting
    private void deleteGuestFromFile(String id) {
        ArrayList<String> tempData = new ArrayList<>();
        File file = new File("guests.txt");
        boolean found = false;

        try {
            // A. Read all lines into memory
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                // If the ID matches, we SKIP adding it to tempData (effectively deleting it)
                if (data[0].equals(id)) {
                    found = true; 
                } else {
                    tempData.add(line); // Keep this line
                }
            }
            br.close();

            // B. If found, write the remaining lines back to the file
            if (found) {
                BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                for (String s : tempData) {
                    bw.write(s);
                    bw.newLine();
                }
                bw.close();
                JOptionPane.showMessageDialog(null, "Success! Guest " + id + " was deleted.");
                idField.setText(""); // Clear field
            } else {
                JOptionPane.showMessageDialog(null, "Error: Guest ID not found.");
            }

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error processing file: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DeleteGuestFrame().setVisible(true);
        });
    }
}