
package addoption;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class EmpLogin extends JFrame {
    static Image backgroundImage;
    JPanel panel1 = new JPanel();
    JButton empLoginButt = new JButton("Log In");
    JLabel userName = new JLabel("Username:        ");
    JTextField userNameField = new JTextField();
    JLabel passwordLabel = new JLabel("Password: ");
    JPasswordField empPasswordField = new JPasswordField();

    public EmpLogin() {
        setTitle("Employee login");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        backgroundImage = new ImageIcon(PetShelter.class.getResource("13.png")).getImage();
panel1.setBackground(new Color(255, 255, 255, 0));
        userName.setForeground(new Color(103, 49, 71)); 
        passwordLabel.setForeground(new Color(103, 49, 71)); 
empLoginButt.setForeground(new Color(103, 49, 71)); 
        setSize(400, 430);
        setLocationRelativeTo(null);
        userName.setFont(new Font("Serif", Font.CENTER_BASELINE,18));
        passwordLabel.setFont(new Font("Serif", Font.CENTER_BASELINE,18));

        // Set the content pane to a BackgroundImagePanel
        setContentPane(new BackgroundImagePanel());

        panel1.setLayout(new GridLayout(8, 1));
                panel1.add(new JLabel()); 
                panel1.add(new JLabel()); 
                panel1.add(new JLabel()); 

        panel1.add(userName);
        panel1.add(userNameField);
        panel1.add(passwordLabel);
        panel1.add(empPasswordField);
        panel1.add(empLoginButt);
        add(panel1, BorderLayout.CENTER);

        empLoginButt.addActionListener(new ActionListenerExample());
    }

    public class ActionListenerExample implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String user = userNameField.getText();
            String password = new String(empPasswordField.getPassword());
            if (user.equals("a") && password.equals("A")) {
                try {
                    Employee emplogin = new Employee();
                    emplogin.setVisible(true);
                    dispose(); // Close the current login window
                } catch (IOException ex) {
                    Logger.getLogger(EmpLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
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