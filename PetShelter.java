package petshelter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class PetShelter extends JFrame {

    // Static variable for background image
    static Image backgroundImage;

    // Components
    JPanel panel1 = new JPanel();
    JButton emp = new JButton("Employee?");
    JButton costmr = new JButton("Customer?");
    JLabel label1 = new JLabel("Welcome");

    // Constructor for the PetShelter class
    public PetShelter() {
        // Set frame properties
        setTitle("Pet Shelter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setJMenuBar(createMenuBar());
        setLayout(new BorderLayout());
        setContentPane(new BackgroundImagePanel());

        // Add action listeners to buttons
        emp.addActionListener(new ActionListenerExample());
        costmr.addActionListener(new ActionListenerExample());

        // Set label and button colors
        label1.setFont(new Font("Serif", Font.CENTER_BASELINE, 30));
        label1.setForeground(new Color(103, 49, 71)); // Brown color using RGB values
        emp.setForeground(new Color(103, 49, 71));
        costmr.setForeground(new Color(103, 49, 71));

        // Set panel layout and background
        panel1.setLayout(new GridLayout(5, 1));
        panel1.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel1.setBackground(new Color(255, 255, 255, 0));
        panel1.add(new JLabel());
        panel1.add(new JLabel());
        panel1.add(label1);
        panel1.add(emp);
        panel1.add(costmr);

        // Add panel to the frame
        add(panel1, BorderLayout.CENTER);

        // Set background image
        backgroundImage = new ImageIcon(PetShelter.class.getResource("18.png")).getImage();

        // Set frame size, center it, disable resizing, and make it visible
        setSize(400, 430);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    // Inner class for a background image panel
    static class BackgroundImagePanel extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    // Inner class for action listener handling button clicks
    public class ActionListenerExample implements ActionListener {

        @Override
       // Action event handler for buttons
public void actionPerformed(ActionEvent e) {
    // Check if the event is associated with the Employee button
    if (e.getSource() == emp) {
        // Open Employee Login window
        EmpLogin emplogin = new EmpLogin();
        emplogin.setVisible(true);
    } 
    // Check if the event is associated with the Customer button
    else if (e.getSource() == costmr) {
        try {
            // Open Customer Login window
            CostmrLogin costmrrLogin = new CostmrLogin();
            costmrrLogin.setVisible(true);
        } 
        // Handle IOException if there is an issue opening the Customer Login window
        catch (IOException ex) {
            // Log the exception for debugging purposes
            Logger.getLogger(PetShelter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

    }

    // Method to create the menu bar
    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        // Create the "File" menu
        JMenu fileMenu = new JMenu("File");

        // Create the "Exit" menu item
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        fileMenu.add(exitMenuItem);

        // Create the "Help" menu
        JMenu helpMenu = new JMenu("Help");

        // Create the "Contact us" menu item
        JMenuItem helpMenuItem = new JMenuItem("Contact us");
        helpMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display contact information using a JOptionPane
                JOptionPane.showMessageDialog(null,
                        """
                        Contact us via:
                        
                        -Email: petShelterORG60@gmail.com
                        - Phone Number: 0544378198.
                        -Address:123 Palm Street, Al Rawdah District, Jeddah.
                        
                        """
                        + JOptionPane.INFORMATION_MESSAGE);
                      // used INFORMATION_MESSAGE to reduce confusion:


            }
        });

        helpMenu.add(helpMenuItem);

        // Add menus to the menu bar
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);

        return menuBar;
    }

    // Main method to run the application
    public static void main(String[] args) {
        new PetShelter();
    }
}
