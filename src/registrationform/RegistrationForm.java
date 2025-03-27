package registrationform;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrationForm {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("User Registration");
        frame.setSize(400, 250);
        frame.setLayout(new GridLayout(4, 2));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create form fields
        frame.add(new JLabel("Name:"));
        JTextField nameField = new JTextField();
        frame.add(nameField);

        frame.add(new JLabel("Email:"));
        JTextField emailField = new JTextField();
        frame.add(emailField);

        frame.add(new JLabel("Password:"));
        JPasswordField passwordField = new JPasswordField();
        frame.add(passwordField);

        // Submit button
        JButton submitButton = new JButton("Register");
        frame.add(submitButton);

        // Status label
        JLabel statusLabel = new JLabel("");
        frame.add(statusLabel);

        // Button click action
        submitButton.addActionListener((ActionEvent e) -> {
            String name = nameField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());

            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                statusLabel.setText("Please fill all fields!");
                statusLabel.setForeground(Color.RED);
            } else {
                if (registerUser(name, email, password)) {
                    statusLabel.setText("Registration Successful!");
                    statusLabel.setForeground(Color.GREEN);
                } else {
                    statusLabel.setText("Error! Try again.");
                    statusLabel.setForeground(Color.RED);
                }
            }
        });

        // Show frame
        frame.setVisible(true);
    }

    // Database connection and user registration
    public static boolean registerUser(String name, String email, String password) {
        String url = "jdbc:mysql://localhost:3306/registration"; // Change database name
        String user = "root"; // Change if needed
        String pass = ""; // Enter MySQL password if required

        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            String sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, password);

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0; // Returns true if data inserted successfully
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Returns false if insertion fails
        }
    }
}


    

 
    
        

    
    

