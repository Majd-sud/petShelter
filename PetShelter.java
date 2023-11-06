package petshelter;

import java.awt.*; // Needed for BorderLayout class
import java.awt.event.*;
import javax.swing.*;  // Needed for Swing classes



public class PetShelter extends JFrame  {
   JPanel panel1= new JPanel();
   JButton emp= new JButton("employee");
   JButton costmr=new JButton("costomer");
   JLabel label1=new JLabel("what are you?!");
    
    public PetShelter(){
        
    setTitle("Pet Shelter");
    
	      // Specify an action for the close button.
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              //setLayout(new  BorderLayout());
              setVisible(true);
              setSize(600, 600);
	      // Add a BorderLayout manager to the content pane.
	      setLayout(new FlowLayout());
              panel1.setLayout( new GridLayout(2,1));
              emp.addActionListener (new ActionListenerExample());
              costmr.addActionListener (new ActionListenerExample());
              
              panel1.add(emp);
              panel1.add(costmr);
              add(label1, BorderLayout.SOUTH);
              add(panel1, BorderLayout.CENTER);
    
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
