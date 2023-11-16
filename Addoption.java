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

public class Addoption extends JFrame {
       static Image backgroundImage;

    private JPanel petPanel;         // To hold components
    private JPanel selectedPetPanel; // To hold components
    JLabel label1 = new JLabel("Pets available for adoption: ");
    JLabel label;
    private JList petList;           // The pets
    private JScrollPane scrollPane;
    private JTextField selectedPet;
    
  JButton policyButton = new JButton("our Policy");

    // To hold components
    private String[] pets = { "cat", "dog", "hamster", "bird" };

    public Addoption() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                       // backgroundImage = new ImageIcon(PetShelter.class.getResource("backg.png")).getImage();
        setContentPane(new BackgroundImagePanel());

        setSize(300, 200);
        setLocationRelativeTo(null);
        buildPetPanel();
        buildSelectedSeasonPanel();
        add(petPanel, BorderLayout.CENTER);
        add(selectedPetPanel, BorderLayout.SOUTH);
              policyButton.addActionListener (new PolicyAction());
        JPanel policyPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        policyPanel.add(policyButton);
        add(policyPanel, BorderLayout.WEST);
    }

    private void buildPetPanel() {
        // Create a panel to hold the list.
        petPanel = new JPanel();

        // Create the list.
        petList = new JList(pets);

        // Set the selection mode to single selection.
        petList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Register the list selection listener.
        petList.addListSelectionListener(new ListListener());

        // Set the number of visible rows to 3.
        petList.setVisibleRowCount(3);

        // Add the list to a scroll pane.
        scrollPane = new JScrollPane(petList);

        // Add the label and scroll pane to the panel.
        petPanel.add(label1);
        petPanel.add(scrollPane);
    }

    private void buildSelectedSeasonPanel() {
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
                          backgroundImage = new ImageIcon(PetShelter.class.getResource("backg.png")).getImage();
        setContentPane(new BackgroundImagePanel());

            policyWindow.setSize(400, 300);
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