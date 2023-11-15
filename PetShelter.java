/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.petshelter;

/**
 *
 * @author 96656
 * 
 */
import java.awt.*; // Needed for BorderLayout class
import java.awt.event.*;
import javax.swing.*;  // Needed for Swing classes
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
//import java.awt.Dimension;
import java.awt.Graphics;
public class PetShelter extends JFrame  {
    static Image backgroundImage;
   JPanel panel1= new JPanel();
   JButton emp= new JButton("employee");
    JButton costmr=new JButton("costomer");
    JLabel label1=new JLabel("what are you?!");
    JPanel panel2= new JPanel();
    public PetShelter(){
    setTitle("Pet Shelter");
    
	      // Specify an action for the close button.
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              //setLayout(new  BorderLayout());
              
              setSize(1000,1000);
	      // Add a BorderLayout manager to the content pane.
              
	      setLayout(new BorderLayout());
              
              setContentPane(new BackgroundImagePanel());
            
             
              panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
              panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
              emp.addActionListener (new ActionListenerExample());
              costmr.addActionListener (new ActionListenerExample());
               setVisible(true);
              panel1.add(emp);
              panel1.add(costmr);
              panel2.add(label1);
                backgroundImage = new ImageIcon("background.png").getImage();
             
              add(panel2,BorderLayout.NORTH);
             add(panel1,BorderLayout.CENTER);
                
            
    
    }
     static class BackgroundImagePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            //Draw the background image at (0,0);
            g.drawImage(backgroundImage, 400, 400, this);
        }
    }
    
       public class ActionListenerExample implements ActionListener{
    public void actionPerformed(ActionEvent e){ 
        if (e.getSource() == emp){
         EmpLogin emplogin = new EmpLogin();
                emplogin.setVisible(true);
        }else if (e.getSource() == costmr){
        CostmrLogin costmrrLogin = new CostmrLogin();
            costmrrLogin.setVisible(true);
        }
    }
        
    
       }

    public static void main(String[] args) {
        new  PetShelter();
    }
   
}
