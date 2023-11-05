/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshelter;

/**
 *
 * @author 96656
 */
import java.awt.*; // Needed for BorderLayout class
import java.awt.event.*;
import javax.swing.*;  // Needed for Swing classes
public class CostmrLogin extends JFrame {
       JPanel panel1= new JPanel();
   JButton costmrLoginButt= new JButton("Log In");
    JLabel userName=new JLabel("Usernam: ");
    JTextField userNameFiled=new JTextField();
    JLabel passWordLabel=new JLabel("Password: ");
    JPasswordField costmrPasswordFiled=new JPasswordField();
 public  CostmrLogin(){
   setTitle("employee login");
        setLayout( new FlowLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        panel1.setLayout(new GridLayout(2,2));
        panel1.add(userName);
        panel1.add(userNameFiled);
        panel1.add(passWordLabel);
        panel1.add(costmrPasswordFiled);
        add(panel1);
        add(costmrLoginButt);
        costmrLoginButt.addActionListener (new ActionListenerExample());
        
 
 
 }  
  public class ActionListenerExample implements ActionListener{
    public void actionPerformed(ActionEvent e){ 
         String user=userNameFiled.getText();
         String password=costmrPasswordFiled.getText();
         if(user.equals("admin")&&password.equals("ADMIN")){
             Addoption costmrlogin = new Addoption();
                costmrlogin.setVisible(true); 
         }
         else{
         System.out.print("Fialed!!!");
         }
    }
   
}
}