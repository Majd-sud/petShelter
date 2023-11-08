
package petshelter;

import java.awt.*; // Needed for BorderLayout class
import java.awt.event.*;
import javax.swing.*;  // Needed for Swing classes
public class EmpLogin extends JFrame {
      JPanel panel1= new JPanel();
   JButton empLoginButt= new JButton("Log In");

    JLabel userName=new JLabel("Usernam: ");
    JTextField userNameFiled=new JTextField();
    JLabel passWordLabel=new JLabel("Password: ");
    JPasswordField empPasswordFiled=new JPasswordField();
     public EmpLogin() {
        setTitle("employee login");
        setLayout( new FlowLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        panel1.setLayout(new GridLayout(2,2));
        panel1.add(userName);
        panel1.add(userNameFiled);
        panel1.add(passWordLabel);
        panel1.add(empPasswordFiled);
        add(panel1);
        add(empLoginButt);
        empLoginButt.addActionListener (new ActionListenerExample());
        
    }
      public class ActionListenerExample implements ActionListener{
    public void actionPerformed(ActionEvent e){ 
         String user=userNameFiled.getText();
         String password=empPasswordFiled.getText();
         if(user.equals("admin")&&password.equals("ADMIN")){
             Employee emplogin = new Employee();
                emplogin.setVisible(true); 
         }
         else{
            JOptionPane.showMessageDialog(null, "Login Failed!", "Error", JOptionPane.ERROR_MESSAGE);
         }
    }
    
       }
}