/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshelter;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CostmrLogin extends JFrame {
    static Image backgroundImage;
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JButton costmrLoginButt = new JButton("Log In");
    JButton createAccountButt = new JButton("Create Account");
    JLabel userName = new JLabel("Username: ");
    JLabel noaccount = new JLabel("don't have an account? ");
    JTextField userNameField = new JTextField();
    JLabel passWordLabel = new JLabel("Password: ");
    JPasswordField costmrPasswordField = new JPasswordField();

    public CostmrLogin() {
        setTitle("Customer Login");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                 // backgroundImage = new ImageIcon(PetShelter.class.getResource("backg.png")).getImage();
        setContentPane(new BackgroundImagePanel());

        setSize(300, 400);
        setLocationRelativeTo(null);
        Dimension buttonSize = new Dimension(100, 30);
        costmrLoginButt.setMinimumSize(buttonSize);
        createAccountButt.setMinimumSize(buttonSize);

        // Set the content pane to a BackgroundImagePanel

        panel1.setLayout(new GridLayout(7, 1));
        panel1.add(userName);
        panel1.add(userNameField);
        panel1.add(passWordLabel);
        panel1.add(costmrPasswordField);
         //panel1.add(costmrLoginButt);
         //panel1.add();
       // panel2.setLayout(new GridLayout(2, 1));
        panel1.add(costmrLoginButt);
        panel1.add(noaccount);
         panel1.add(createAccountButt);
        add(panel1, BorderLayout.NORTH);
       // add(costmrLoginButt, BorderLayout.SOUTH);
       //add(createAccountButt, BorderLayout.SOUTH);  // Add the "Create Account" button

        costmrLoginButt.addActionListener(new ActionListenerExample());

        createAccountButt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open a registration window for creating a new account
                RegistrationForm registrationForm = new RegistrationForm();
                registrationForm.setVisible(true);
            }
        });
    }

    public class ActionListenerExample implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String user = userNameField.getText();
            String password = new String(costmrPasswordField.getPassword()); // Get password as a String
            if (user.equals("a") && password.equals("A")) {
                Addoption costmrlogin = new Addoption();
                costmrlogin.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Login Failed!", "Error", JOptionPane.ERROR_MESSAGE);
            }
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

    public static void main(String[] args) {
        {
            CostmrLogin login = new CostmrLogin();
            login.setVisible(true);
        }
    }
}

class RegistrationForm extends JFrame {
    static Image backgroundImage;
    JLabel createAccountLabel = new JLabel("Create Your Account");
    JLabel newUsernameLabel = new JLabel("Username: ");
    JTextField newUsernameField = new JTextField();
    JLabel newPasswordLabel = new JLabel("Password: ");
    JPasswordField newPasswordField = new JPasswordField();
    JButton registerButton = new JButton("Register");
    JPanel panelForImageAndText = new JPanel();
    JPanel otherPanel = new JPanel();

    public RegistrationForm() {
        setTitle("WELCOME");
        setLayout(new FlowLayout());

        // Set the content pane to a BackgroundImagePanel
        setContentPane(new BackgroundImagePanel());
           //backgroundImage = new ImageIcon(PetShelter.class.getResource("backg.png")).getImage();

        setSize(420, 420);
        setLocationRelativeTo(null);
        add(createAccountLabel);

        otherPanel.setLayout(new GridLayout(3, 2));
        otherPanel.add(newUsernameLabel);
        otherPanel.add(newUsernameField);
        otherPanel.add(newPasswordLabel);
        otherPanel.add(newPasswordField);
        otherPanel.add(registerButton);

        add(otherPanel, BorderLayout.CENTER);
    }

    // BackgroundImagePanel class for setting the background image
    static class BackgroundImagePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public static void main(String[] args) {
       {
            RegistrationForm registrationForm = new RegistrationForm();
            registrationForm.setVisible(true);
        }
    }
}