package petshelter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class EmpLogin extends JFrame {

    static Image backgroundImage;
    JPanel empLogPanel = new JPanel();
    JButton empLoginButt = new JButton("Log In");
    JLabel userName = new JLabel("Username:        ");
    JTextField userNameTfield = new JTextField();
    JLabel passwordLabel = new JLabel("Password: ");
    JPasswordField empPasswordField = new JPasswordField();

    public EmpLogin() {
        setTitle("Employee login");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        backgroundImage = new ImageIcon(PetShelter.class.getResource("17n.png")).getImage();
        empLogPanel.setBackground(new Color(255, 255, 255, 0));
        userName.setForeground(new Color(103, 49, 71));
        passwordLabel.setForeground(new Color(103, 49, 71));
        empLoginButt.setForeground(new Color(103, 49, 71));
        setSize(400, 430);
        setLocationRelativeTo(null);
        userName.setFont(new Font("Serif", Font.CENTER_BASELINE, 18));
        passwordLabel.setFont(new Font("Serif", Font.CENTER_BASELINE, 18));

        // Set the content pane to a BackgroundImagePanel
        setContentPane(new BackgroundImagePanel());

        empLogPanel.setLayout(new GridLayout(7, 1));
        empLogPanel.add(new JLabel());
        empLogPanel.add(new JLabel());

        empLogPanel.add(userName);
        empLogPanel.add(userNameTfield);
        empLogPanel.add(passwordLabel);
        empLogPanel.add(empPasswordField);
        empLogPanel.add(empLoginButt);
        add(empLogPanel, BorderLayout.CENTER);

        empLoginButt.addActionListener(new ActionListenerExample());
    }

    public class ActionListenerExample implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String user = userNameTfield.getText();
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
