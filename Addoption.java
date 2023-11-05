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
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.*;

public class Addoption extends JFrame {
     private JPanel petPanel;         // To hold components
   private JPanel selectedPetPanel; // To hold components
   JButton Policy= new JButton("Our policy");
    JLabel label1=new JLabel("Pets avilabel for addption: ");
    JLabel label;
    private JList petList;           // The pets
   private JScrollPane scrollPane; 
   private JTextField selectedPet;
   // To hold components
    private String[] pets={"cat","dog","hamester","berd"};
    
public  Addoption (){
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        buildPetPanel();
        buildSelectedSeasonPanel();
        add(petPanel, BorderLayout.CENTER);
      add(selectedPetPanel, BorderLayout.SOUTH);
}
        private void buildPetPanel()
   {
      // Create a panel to hold the list.
      petPanel = new JPanel();

      // Create the list.
      petList = new JList(pets);
      


      // Set the selection mode to single selection.
      petList.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION);

      // Register the list selection listener.
      petList.addListSelectionListener(
                                 new ListListener());

      // Set the number of visible rows to 3.
      petList.setVisibleRowCount(3);

      // Add the list to a scroll pane.
      scrollPane = new JScrollPane(petList);

      // Add the scroll pane to the panel.
      petPanel.add(scrollPane);
   } 
   private void buildSelectedSeasonPanel()
   {
      // Create a panel to hold the text field.
      selectedPetPanel = new JPanel();

      // Create the label.
      label = new JLabel("You selected: ");

      // Create the text field.
      selectedPet = new JTextField(10);

      // Make the text field uneditable.
      selectedPet.setEditable(false);

      // Add the label and text field to the panel.
      selectedPetPanel.add(label);
      selectedPetPanel.add(selectedPet);
   } 
  private class ListListener implements ListSelectionListener
   {
      @Override
      public void valueChanged(ListSelectionEvent e)
      {
         // Get the selected seasin
         String selection =
               (String) petList.getSelectedValue();
         
                       
         // Put the selected season in the text field.
         selectedPet.setText(selection);
      }
   }
}
