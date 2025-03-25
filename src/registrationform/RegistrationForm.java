/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package registrationform;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**^
 *
 * @author HP
 */
public class RegistrationForm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
                
   
        // Create the frame
     JFrame frame = new JFrame("Button Example"); 
frame.setSize(300, 200);
frame.setLayout(null);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   JButton button = new JButton("Click Me");
        button.setBounds(100, 50, 100, 30);
        frame.add(button);
        
    button.setBackground(Color.CYAN);
     button.setForeground(Color.BLACK);


JLabel label = new JLabel();
label.setBounds(100, 100, 200, 30); 
frame.add(label);
 button.addActionListener((ActionEvent e) -> {
     label.setText("Button Clicked!");
     JOptionPane.showMessageDialog(frame, "Button Clicked!");
     });
 frame.setVisible(true);

    }

}

        

    

 
    
        

    
    

