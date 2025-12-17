package hotelManagement;

import java.awt.*;
import javax.swing.*;

public class MainMenuFrame extends JFrame {

    public MainMenuFrame() {
        // 1. Setup the Window
        setTitle("Hotel Management System - Dashboard");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 1, 10, 10)); // 6 rows, 1 column

        // 2. Add Header
        JLabel welcomeLabel = new JLabel("Wild Wild West Hotel", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(welcomeLabel);

        // 3. Create Buttons
        JButton btnAddGuest = new JButton("Add New Guest");
        JButton btnSearchGuest = new JButton("Search Guest");
        JButton btnEditGuest = new JButton("Edit Guest Details");
        JButton btnBooking = new JButton("New Booking");
        JButton btnDeleteGuest = new JButton("Delete Guest");
        JButton btnExit = new JButton("Exit");

        // 4. Add Buttons to the Window
        add(btnAddGuest);
        add(btnSearchGuest);
        add(btnEditGuest);
        add(btnBooking);
        add(btnDeleteGuest);
        add(btnExit);

        // 5. Add Logic (Using simple arrows '->' to prevent syntax errors)
        
        // Open Add Guest Window
        btnAddGuest.addActionListener(e -> new AddGuestFrame().setVisible(true));

        // Open Search Guest Window
        btnSearchGuest.addActionListener(e -> new SearchGuestFrame().setVisible(true));

        // Open Edit Guest Window
        btnEditGuest.addActionListener(e -> new EditGuestFrame().setVisible(true));

        // Open Delete Guest Window
        btnDeleteGuest.addActionListener(e -> new DeleteGuestFrame().setVisible(true));

        btnBooking.addActionListener(e -> new BookingFrame().setVisible(true));

        // Close Application
        btnExit.addActionListener(e -> System.exit(0));
    }

    // Main method to launch the dashboard
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainMenuFrame().setVisible(true);
        });
    }
}