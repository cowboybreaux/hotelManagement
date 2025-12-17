package hotelManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class BookingFrame extends JFrame {
    // GUI Components
    private JTextField guestIdField, roomNumField, nightsField;
    private JTextArea receiptArea;
    private JButton bookButton;

    public BookingFrame() {
        // 1. Setup Window
        setTitle("Hotel System - New Booking");
        setSize(500, 400);
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // 2. Add Input Fields
        add(new JLabel("Guest ID:"));
        guestIdField = new JTextField(10);
        add(guestIdField);

        add(new JLabel("Room Number:"));
        roomNumField = new JTextField(10);
        add(roomNumField);

        add(new JLabel("Number of Nights:"));
        nightsField = new JTextField(5);
        add(nightsField);

        bookButton = new JButton("Confirm Booking");
        add(bookButton);

        // 3. Receipt Area
        receiptArea = new JTextArea(10, 40);
        receiptArea.setEditable(false);
        receiptArea.setBorder(BorderFactory.createTitledBorder("Booking Receipt"));
        add(new JScrollPane(receiptArea));

        // 4. Logic: Process the booking
        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processBooking();
            }
        });
    }

    private void processBooking() {
        String guestID = guestIdField.getText();
        String roomNum = roomNumField.getText();
        String nightsStr = nightsField.getText();

        // A. Validation
        if (guestID.isEmpty() || roomNum.isEmpty() || nightsStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields!");
            return;
        }

        // B. Calculate Price (Simple version for demo)
        // In a real scenario, you'd check rooms.txt for the specific price.
        // Here we assume Standard Room = RM100 for simplicity.
        try {
            int nights = Integer.parseInt(nightsStr);
            double pricePerNight = 100.00; // Base price
            double totalCost = nights * pricePerNight;

            // C. Save to File
            saveBooking(guestID, roomNum, nights, totalCost);

            // D. Show Receipt
            receiptArea.setText("--- BOOKING SUCCESSFUL ---\n");
            receiptArea.append("Guest ID: " + guestID + "\n");
            receiptArea.append("Room Num: " + roomNum + "\n");
            receiptArea.append("Duration: " + nights + " nights\n");
            receiptArea.append("Total Cost: RM " + totalCost + "\n");
            receiptArea.append("--------------------------\n");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Nights must be a number!");
        }
    }

    private void saveBooking(String guest, String room, int nights, double cost) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("bookings.txt", true))) {
            // Format: GuestID,RoomNum,Nights,TotalCost
            bw.write(guest + "," + room + "," + nights + "," + cost);
            bw.newLine();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving booking: " + e.getMessage());
        }
    }
    
    // Main method for testing
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BookingFrame().setVisible(true));
    }
} 
// ^^^ ENSURE THIS LAST CURLY BRACE IS HERE! ^^^