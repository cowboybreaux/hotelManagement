package hotelManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuFrame extends JFrame {

    public MainMenuFrame() {
        // 1. Setup the Window
        setTitle("Hotel Management System - Dashboard");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Closing this ends the app
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1, 10, 10)); // 4 rows, 1 column

        // 2. Add Header
        JLabel welcomeLabel = new JLabel("Welcome to Hotel System", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(welcomeLabel);

        // 3. Create Buttons
        JButton btnAddGuest = new JButton("Add New Guest");
        JButton btnSearchGuest = new JButton("Search Guest");
        JButton btnDeleteGuest = new JButton("Delete Guest");
        JButton btnExit = new JButton("Exit");

        // 4. Add Buttons to Window
        add(btnAddGuest);
        add(btnSearchGuest);
        add(btnDeleteGuest);
        add(btnExit);
        

        // 5. Add Functionality (Linking the frames)
        
        // Action: Open Add Guest Window
        btnAddGuest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create and show the AddGuestFrame
                AddGuestFrame addFrame = new AddGuestFrame();
                addFrame.setVisible(true);
            }
        });

        // Action: Open Search Guest Window
        btnSearchGuest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create and show the SearchGuestFrame
                SearchGuestFrame searchFrame = new SearchGuestFrame();
                searchFrame.setVisible(true);
            }
        });

        btnDeleteGuest.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        new DeleteGuestFrame().setVisible(true);
    }
});

        // Action: Close App
        btnExit.addActionListener(e -> System.exit(0));
    }

    // Main method to launch the whole app
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainMenuFrame().setVisible(true);
        });
    }
}