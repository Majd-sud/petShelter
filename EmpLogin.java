package petshelter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class EmpLogin extends JFrame {

    static Image backgroundImage;
     
// Components for Employee Login window
    JPanel empLogPanel = new JPanel();
    JButton empLoginButt = new JButton("Log In");
    JLabel userName = new JLabel("Username:        ");
    JTextField userNameTfield = new JTextField();
    JLabel passwordLabel = new JLabel("Password: ");
    JPasswordField empPasswordField = new JPasswordField();

    // Constructor for EmpLogin class
    public EmpLogin() {
        // Set frame properties
        setTitle("Employee login");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // Set the background image
        backgroundImage = new ImageIcon(PetShelter.class.getResource("17n.png")).getImage();
         // Set the content pane to a BackgroundImagePanel
        setContentPane(new BackgroundImagePanel());
        
        empLogPanel.setBackground(new Color(255, 255, 255, 0));
        userName.setForeground(new Color(103, 49, 71));
        passwordLabel.setForeground(new Color(103, 49, 71));
        empLoginButt.setForeground(new Color(103, 49, 71));
        setSize(400, 430);
        setLocationRelativeTo(null);
        userName.setFont(new Font("Serif", Font.CENTER_BASELINE, 18));
        passwordLabel.setFont(new Font("Serif", Font.CENTER_BASELINE, 18));

       
         // Layout setup
        empLogPanel.setLayout(new GridLayout(7, 1));
        empLogPanel.add(new JLabel());
        empLogPanel.add(new JLabel());
        empLogPanel.add(userName);
        empLogPanel.add(userNameTfield);
        empLogPanel.add(passwordLabel);
        empLogPanel.add(empPasswordField);
        empLogPanel.add(empLoginButt);
        add(empLogPanel, BorderLayout.CENTER);

        // ActionListener for the "Log In" button
        empLoginButt.addActionListener(new ActionListenerExample());
    }

    // ActionListenerExample class for handling button click events
    public class ActionListenerExample implements ActionListener {

        // Method invoked when the "Log In" button is clicked
        public void actionPerformed(ActionEvent e) {
            
            // Get entered username and password
            String user = userNameTfield.getText();
            String password = new String(empPasswordField.getPassword());

            // Check if the entered username and password are correct
            if (user.equals("a") && password.equals("A")) {
                // If correct, open the Employee window and close the current login window
                Employee emplogin = new Employee();
                emplogin.setVisible(true);
                dispose(); // Close the current login window
            } else {
                // If incorrect, show an error message
                JOptionPane.showMessageDialog(null, "Login Failed!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Custom BackgroundImagePanel class for setting the background image
    static class BackgroundImagePanel extends JPanel {

        // Method for painting the background image
        @Override
        protected void paintComponent(Graphics g) {
          //call paintComponet method from JPanel class
            super.paintComponent(g);
            //rendering the image onto the panel, scaling it to fill the entire panel.
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}