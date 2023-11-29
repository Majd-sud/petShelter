
package petshelter;



import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class CostmrLogin extends JFrame {
    static Image backgroundImage;
    JPanel panel1 = new JPanel();
    JButton costmrLoginButt = new JButton("Log In");
    JButton createAccountButt = new JButton("Create Account");
    JLabel userName = new JLabel("Username: ");
    JLabel noaccount = new JLabel("don't have an account? ");
    JTextField userNameField = new JTextField();
    JLabel passWordLabel = new JLabel("Password: ");
    JPasswordField costmrPasswordField = new JPasswordField();
   
    

    public CostmrLogin() throws IOException {
        
        setTitle("Customer Login");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                 backgroundImage = new ImageIcon(PetShelter.class.getResource("11.png")).getImage();
        setContentPane(new BackgroundImagePanel());
        noaccount.setForeground(new Color(103, 49, 71)); 
        passWordLabel.setForeground(new Color(103, 49, 71)); 
        userName.setForeground(new Color(103, 49, 71)); 
                userName.setFont(new Font("Serif", Font.CENTER_BASELINE,18));
        passWordLabel.setFont(new Font("Serif", Font.CENTER_BASELINE,18));
        noaccount.setFont(new Font("Serif", Font.CENTER_BASELINE,15));

                 Color darkerButtonColor = userName.getForeground().darker();
costmrLoginButt.setForeground(darkerButtonColor);
createAccountButt.setForeground(darkerButtonColor);
        setSize(400, 430);
        setLocationRelativeTo(null);
        Dimension buttonSize = new Dimension(100, 30);
        costmrLoginButt.setMinimumSize(buttonSize);
        createAccountButt.setMinimumSize(buttonSize);
panel1.setBackground(new Color(255, 255, 255, 0));//make panel backgrond transparent

        panel1.setLayout(new GridLayout(8, 1));
        panel1.add(new JLabel());
        panel1.add(userName);
        panel1.add(userNameField);
        panel1.add(passWordLabel);
        panel1.add(costmrPasswordField);
      
        panel1.add(costmrLoginButt);
        panel1.add(noaccount);
         panel1.add(createAccountButt);
        add(panel1, BorderLayout.NORTH);


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

   public class ActionListenerExample implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        try {
            String user = userNameField.getText();
            String password = new String(costmrPasswordField.getPassword());

            if (verifyAccount(user, password)) {
                Addoption costmrlogin = new Addoption();
                costmrlogin.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Login Failed!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException ex) {
            Logger.getLogger(CostmrLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean verifyAccount(String username, String password) throws IOException {
        String filePath = "C:\\NetBeansProjects\\PetShelter\\CostmrLogin.txt";

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

class RegistrationForm extends JFrame {
    static Image backgroundImage;
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
    JPanel otherPanel = new JPanel();
    JLabel createAccountLabel = new JLabel(" Create your own account");
    
     FileWriter fileWriter;
    BufferedWriter bufferedWriter;
    PrintWriter out;
    
    public RegistrationForm() throws IOException {
       
        setTitle("WELCOME");
        setLayout(new FlowLayout());
        otherPanel.setBackground(new Color(255, 255, 255, 0));
                nameLabel.setFont(new Font("Serif", Font.CENTER_BASELINE,15));
                emailLabel.setFont(new Font("Serif", Font.CENTER_BASELINE,15));
                phoneLabel.setFont(new Font("Serif", Font.CENTER_BASELINE,15));
                newUsernameLabel.setFont(new Font("Serif", Font.CENTER_BASELINE,15));
                newPasswordLabel.setFont(new Font("Serif", Font.CENTER_BASELINE,15));
                createAccountLabel.setFont(new Font("Serif", Font.CENTER_BASELINE,15));

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

        Color darkerButtonColor = nameLabel.getForeground().darker();
        registerButton.setForeground(darkerButtonColor);

        // Set layout and add components to otherPanel
        otherPanel.setLayout(new GridLayout(7, 2));
otherPanel.add(new JLabel());
otherPanel.add(new JLabel());

        otherPanel.add(nameLabel);
        otherPanel.add(nameField);
        otherPanel.add(emailLabel);
        otherPanel.add(emailField);
        otherPanel.add(phoneLabel);
        otherPanel.add(phoneField);
        otherPanel.add(newUsernameLabel);
        otherPanel.add(newUsernameField);
        otherPanel.add(newPasswordLabel);
        otherPanel.add(newPasswordField);
         fileWriter=new FileWriter( "C:\\NetBeansProjects\\PetShelter\\CostmrLogin.txt",true);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                
                   try {

                      bufferedWriter= new BufferedWriter(fileWriter);
                            out = new PrintWriter(bufferedWriter);
                           out.println(nameField.getText());
                           out.println(emailField.getText());
                           out.println(phoneField.getText());
                            out.print(newUsernameField.getText()+",");
                            out.print(newPasswordField.getText()+",");
                            bufferedWriter.newLine();
                            bufferedWriter.close();
                            
                        } catch (IOException ex) {
                            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
                        }
                   JOptionPane.showMessageDialog(null,"Registration Successful!");
            }
                
       }
        );
        otherPanel.add(registerButton);

        add(otherPanel, BorderLayout.CENTER);
    }
    static class BackgroundImagePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

   
}