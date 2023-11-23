/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshelter;



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.ArrayList; 

public class Addoption extends JFrame {
       static Image backgroundImage;

    private JPanel petPanel = new JPanel();
    private JPanel petPanel2 = new JPanel();

    JLabel label1 = new JLabel("Pets available for adoption: ");
    JLabel label = new JLabel("You selected: ");
    private JScrollPane scrollPane;
    private JTextField selectedPet;
    
  JButton policyButton = new JButton("Our Policy");

    // To hold components
    public ArrayList<String> pets =new ArrayList<>();
    
        DefaultListModel<String> model = new DefaultListModel<>();
         
        

        JList<String> petList = new JList<>(model);
    // public JList  petList = new JList(pets);
   
    public Addoption() {
        pets.add("t");
        pets.add("Cat");
        pets.add("Dog");
        pets.add("Bird");
        for (String pet : pets) {
            model.addElement(pet);
        }
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // backgroundImage = new ImageIcon(PetShelter.class.getResource("13.png")).getImage();
        setContentPane(new BackgroundImagePanel());
        label1.setForeground(new Color(103, 49, 71)); 
        setSize(400, 430);
        setLocationRelativeTo(null);
       
        petList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        petList.addListSelectionListener(new ListListener());
        petList.setVisibleRowCount(3);
        scrollPane = new JScrollPane(petList);
       scrollPane.setForeground(new Color(103, 49, 71)); 

   
label.setForeground(new Color(103, 49, 71)); 
        // Create the text field.
        selectedPet = new JTextField(10);

        // Make the text field uneditable.
        selectedPet.setEditable(false);
        
        
        Color darkerButtonColor = label1.getForeground().darker();
      policyButton.setForeground(darkerButtonColor);
        policyButton.addActionListener (new PolicyAction());

      
      petPanel.setBackground(new Color(255, 255, 255, 0));//make panel transparent
petPanel.setLayout(new GridLayout(2,2 ));
   
       
       
        petPanel.add(label1);
        petPanel.add(new JLabel());
        petPanel.add(scrollPane);
         petPanel.add(new JLabel());

        petPanel2.setBackground(new Color(255, 255, 255, 0));//make panel transparent
        petPanel2.setLayout(new GridLayout(5,3 ));
        petPanel2.add(label);
        petPanel2.add(new JLabel());
        petPanel2.add(new JLabel());
        petPanel2.add(selectedPet);
        petPanel2.add(new JLabel());      
        petPanel2.add(new JLabel());
        petPanel2.add(new JLabel());
        petPanel2.add(new JLabel());
        petPanel2.add(new JLabel());
        petPanel2.add(new JLabel());
        petPanel2.add(new JLabel());
        petPanel2.add(policyButton);


       

        
       
        add(petPanel);
                add(petPanel2);

       
    }

   
      

  

    private class ListListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            // Get the selected pet
            String selection = (String) petList.getSelectedValue();

            // Put the selected pet in the text field.
            selectedPet.setText(selection);

            // Show a confirmation dialog
            int confirmation = JOptionPane.showConfirmDialog(
                    Addoption.this,
                    "are you sure?",
                    "Adoption Confirmation",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirmation == JOptionPane.YES_OPTION) {
                // User confirmed, show the adoption confirmation message
                JOptionPane.showMessageDialog(Addoption.this, "We will contact you soon", "Adoption Confirmation", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    // Action class for the Policy button
    private class PolicyAction extends AbstractAction {
     
        @Override
        public void actionPerformed(ActionEvent e) {
            // Open a new window or dialog to display the policy information
            JFrame policyWindow = new JFrame("Our Policy");
                         // backgroundImage = new ImageIcon(PetShelter.class.getResource("13.png")).getImage();
        setContentPane(new BackgroundImagePanel());

        setSize(400, 430);
            policyWindow.setLocationRelativeTo(null);
            policyWindow.setVisible(true);
        }
    }
    
static class BackgroundImagePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}