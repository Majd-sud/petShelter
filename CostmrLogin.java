package petshelter;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

// Customer login class
public class CostmrLogin extends JFrame {

    // Background image for the login window
    static Image backgroundImage;
    
     // Components for the customer login window
    JPanel customerLogPanel = new JPanel();
    JButton costmrLoginButt = new JButton("Log In");
    JButton createAccountButt = new JButton("Create Account");
    JLabel userNameLabel = new JLabel("Username: ");
    JLabel noAccLabel = new JLabel("don't have an account? ");
    JTextField userNameTfield = new JTextField();
    JLabel passwordLabel = new JLabel("Password: ");
    JPasswordField costmrPasswordTfield = new JPasswordField();

    // Constructor for CostmrLogin class
    public CostmrLogin() throws IOException {

        // JFrame setup
        setTitle("Customer Login");
        setLayout(new FlowLayout());
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       
        // Set the background image
        backgroundImage = new ImageIcon(PetShelter.class.getResource("16o.png")).getImage();
        setContentPane(new BackgroundImagePanel());
        
        // Set label and button style
        noAccLabel.setForeground(new Color(103, 49, 71));
        passwordLabel.setForeground(new Color(103, 49, 71));
        userNameLabel.setForeground(new Color(103, 49, 71));
        userNameLabel.setFont(new Font("Serif", Font.CENTER_BASELINE, 18));
        passwordLabel.setFont(new Font("Serif", Font.CENTER_BASELINE, 18));
        noAccLabel.setFont(new Font("Serif", Font.CENTER_BASELINE, 15));

        costmrLoginButt.setForeground(new Color(103, 49, 71));
        createAccountButt.setForeground(new Color(103, 49, 71));
        setSize(400, 430);
        setLocationRelativeTo(null);
        
        //make panel background transparent
        customerLogPanel.setBackground(new Color(255, 255, 255, 0));
        
        // Layout setup
        customerLogPanel.setLayout(new GridLayout(10, 1));
        customerLogPanel.add(new JLabel());
        customerLogPanel.add(new JLabel());
        customerLogPanel.add(new JLabel());
        customerLogPanel.add(userNameLabel);
        customerLogPanel.add(userNameTfield);
        customerLogPanel.add(passwordLabel);
        customerLogPanel.add(costmrPasswordTfield);
        customerLogPanel.add(costmrLoginButt);
        customerLogPanel.add(noAccLabel);
        customerLogPanel.add(createAccountButt);
        add(customerLogPanel, BorderLayout.NORTH);

        // Action listeners for buttons
        costmrLoginButt.addActionListener(new ActionListenerExample());

        createAccountButt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RegistrationForm registrationForm;
                try {
                    registrationForm = new RegistrationForm();
                    registrationForm.setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(CostmrLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Action listener class for handling "Log In" button click
    public class ActionListenerExample implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                String user = userNameTfield.getText();
                String password = new String(costmrPasswordTfield.getPassword());

                // Verify customer account
                if (verifyAccount(user, password)) {
                    Addoption costmrlogin = new Addoption();
                    costmrlogin.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Login Failed!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (FileIOException ex) {
                Logger.getLogger(CostmrLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        // Method to verify customer account
        private boolean verifyAccount(String username, String password) throws FileIOException {
            String filePath = "CostmrLogin.txt";

            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(","); // or use the correct delimiter

                    if (parts.length == 2) {
                        String storedUsername = parts[0];
                        String storedPassword = parts[1];

                        if (storedUsername.equals(username) && storedPassword.equals(password)) {
                            return true; // Account found
                        }
                    } else {
                        // Handle the case where the line does not have the expected format
                        System.out.println("Skipping line with unexpected format: " + line);
                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(CostmrLogin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                // Catch any other IOException and throw your custom exception
                throw new FileIOException("Error reading data from file: " + filePath, ex);
            }

            return false; // Account not found
        }
    }

    // BackgroundImagePanel class for setting the background image
    static class BackgroundImagePanel extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}

// RegistrationForm class for customer registration
class RegistrationForm extends JFrame {

   // Background image for the registration form
  static Image backgroundImage;
  
    // Components for the registration form
    JLabel nameLabel = new JLabel("Name: ");
    JTextField nameField = new JTextField();
    JLabel emailLabel = new JLabel("Email: ");
    JTextField emailField = new JTextField();
    JLabel phoneLabel = new JLabel("Phone Number: ");
    JTextField phoneField = new JTextField();
    JLabel newUsernameLabel = new JLabel("Username: ");
    JTextField newUsernameField = new JTextField();
    JLabel newPasswordLabel = new JLabel("Password: ");
    JTextField newPasswordField = new JTextField();
    JButton registerButton = new JButton("Register");
    JPanel newCustomerPanel = new JPanel();
    JLabel createAccountLabel = new JLabel(" Create your own account");
     
    // File writer for customer registration data
    FileWriter fileWriter;
    BufferedWriter bufferedWriter;
    PrintWriter out;

    // Constructor for RegistrationForm class
    public RegistrationForm() throws IOException {

        // JFrame setup
        setTitle("WELCOME");
        setLayout(new FlowLayout());
        newCustomerPanel.setBackground(new Color(255, 255, 255, 0));
        nameLabel.setFont(new Font("Serif", Font.CENTER_BASELINE, 15));
        emailLabel.setFont(new Font("Serif", Font.CENTER_BASELINE, 15));
        phoneLabel.setFont(new Font("Serif", Font.CENTER_BASELINE, 15));
        newUsernameLabel.setFont(new Font("Serif", Font.CENTER_BASELINE, 15));
        newPasswordLabel.setFont(new Font("Serif", Font.CENTER_BASELINE, 15));
        createAccountLabel.setFont(new Font("Serif", Font.CENTER_BASELINE, 15));

        // Set the content pane to a BackgroundImagePanel
        setContentPane(new BackgroundImagePanel());
        backgroundImage = new ImageIcon(PetShelter.class.getResource("12.png")).getImage();

        setSize(400, 430);
        setLocationRelativeTo(null);

        // Set foreground colors
        createAccountLabel.setForeground(new Color(103, 49, 71));
        nameLabel.setForeground(new Color(103, 49, 71));
        emailLabel.setForeground(new Color(103, 49, 71));
        phoneLabel.setForeground(new Color(103, 49, 71));
        newUsernameLabel.setForeground(new Color(103, 49, 71));
        newPasswordLabel.setForeground(new Color(103, 49, 71));
        registerButton.setForeground(new Color(103, 49, 71));

        // Set layout and add components to otherPanel
        newCustomerPanel.setLayout(new GridLayout(7, 2));
        newCustomerPanel.add(new JLabel());
        newCustomerPanel.add(new JLabel());
        newCustomerPanel.add(nameLabel);
        newCustomerPanel.add(nameField);
        newCustomerPanel.add(emailLabel);
        newCustomerPanel.add(emailField);
        newCustomerPanel.add(phoneLabel);
        newCustomerPanel.add(phoneField);
        newCustomerPanel.add(newUsernameLabel);
        newCustomerPanel.add(newUsernameField);
        newCustomerPanel.add(newPasswordLabel);
        newCustomerPanel.add(newPasswordField);

        // Setup file writer for customer registration data
        fileWriter = new FileWriter("CostmrLogin.txt", true);

        // Action listener for registerButton
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    // Write customer registration data to file
                    bufferedWriter = new BufferedWriter(fileWriter);
                    out = new PrintWriter(bufferedWriter);
                    out.println(nameField.getText());
                    out.println(emailField.getText());
                    out.println(phoneField.getText());
                    out.print(newUsernameField.getText() + ",");
                    out.print(newPasswordField.getText() + ",");
                    bufferedWriter.newLine();
                    bufferedWriter.close();

                } catch (IOException ex) {
                    Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(null, "Registration Successful!");
            }
        });

        newCustomerPanel.add(registerButton);

        add(newCustomerPanel, BorderLayout.CENTER);
    }

    // BackgroundImagePanel class for setting the background image
    static class BackgroundImagePanel extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
             //call paintComponet method from JPanel class
            super.paintComponent(g);
            //rendering the image onto the panel, scaling it to fill the entire panel.
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}