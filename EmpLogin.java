/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshelter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class EmpLogin extends JFrame {
    static Image backgroundImage;
    JPanel panel1 = new JPanel();
    JButton empLoginButt = new JButton("Log In");
    JLabel userName = new JLabel("Username: ");
    JTextField userNameField = new JTextField();
    JLabel passwordLabel = new JLabel("Password: ");
    JPasswordField empPasswordField = new JPasswordField();

    public EmpLogin() {
        setTitle("Employee login");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
          // backgroundImage = new ImageIcon(PetShelter.class.getResource("/backg.png")).getImage();

        setSize(300, 200);
        setLocationRelativeTo(null);

        // Set the content pane to a BackgroundImagePanel
        setContentPane(new BackgroundImagePanel());

        panel1.setLayout(new GridLayout(2, 2));
        panel1.add(userName);
        panel1.add(userNameField);
        panel1.add(passwordLabel);
        panel1.add(empPasswordField);

        add(panel1, BorderLayout.CENTER);
        add(empLoginButt, BorderLayout.SOUTH);

        empLoginButt.addActionListener(new ActionListenerExample());
    }

    public class ActionListenerExample implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String user = userNameField.getText();
            String password = new String(empPasswordField.getPassword());
            if (user.equals("a") && password.equals("A")) {
                Employee emplogin = new Employee();
                emplogin.setVisible(true);
                dispose(); // Close the current login window
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
}