
package petshelter;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CostmrLogin extends JFrame {
    JPanel panel1 = new JPanel();
    JButton costmrLoginButt = new JButton("Log In");
    JButton createAccountButt = new JButton("Create Account");  
    JLabel userName = new JLabel("Username: ");
    JTextField userNameFiled = new JTextField();
    JLabel passWordLabel = new JLabel("Password: ");
    JPasswordField costmrPasswordFiled = new JPasswordField();

    public CostmrLogin() {
        setTitle("Customer Login");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        panel1.setLayout(new GridLayout(2, 2));
        panel1.add(userName);
        panel1.add(userNameFiled);
        panel1.add(passWordLabel);
        panel1.add(costmrPasswordFiled);
        add(panel1);
        add(costmrLoginButt);
        add(createAccountButt);  // Add the "Create Account" button
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
            String user = userNameFiled.getText();
            String password = new String(costmrPasswordFiled.getPassword()); // Get password as a String
            if (user.equals("admin") && password.equals("ADMIN")) {
                Addoption costmrlogin = new Addoption();
                costmrlogin.setVisible(true);
            } else {
            JOptionPane.showMessageDialog(null, "Login Failed!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CostmrLogin login = new CostmrLogin();
            login.setVisible(true);
        });
    }
}

class RegistrationForm extends JFrame {
    JLabel createAccountLabel = new JLabel("Create Your Account");
    JLabel newUsernameLabel = new JLabel("Username: ");
    JTextField newUsernameField = new JTextField();
    JLabel newPasswordLabel = new JLabel("Password: ");
    JPasswordField newPasswordField = new JPasswordField();
    JButton registerButton = new JButton("Register");
    JPanel panelForImageAndText= new JPanel();
    JPanel otherPanel = new JPanel();

    public RegistrationForm() {
        setTitle("WELCOME");
        setLayout(new FlowLayout());
        setSize(420, 420);
        setLocationRelativeTo(null);
        add(createAccountLabel);
       otherPanel.setLayout(new GridLayout(3,2));
        otherPanel.add(newUsernameLabel);
        otherPanel.add(newUsernameField);
       otherPanel. add(newPasswordLabel);
       otherPanel.add(newPasswordField);
   otherPanel.add(registerButton);
       add(otherPanel);


    }
}
