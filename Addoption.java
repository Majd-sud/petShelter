package petshelter;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Addoption extends JFrame {
       static Image backgroundImage;

    private JPanel petPanel = new JPanel();
     

    JLabel label1 = new JLabel("Pets available for adoption: ");
    JLabel label = new JLabel("You selected: ");
    private JScrollPane scrollPane;
    private JTextField selectedPet;
    
  JButton policyButton = new JButton("our Policy");

    // To hold components
    private String[] pets = { "cat", "dog", "hamster", "bird" };
    private JList  petList = new JList(pets);
   
    public Addoption() {
        setLayout(new GridLayout(2, 1));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // backgroundImage = new ImageIcon(PetShelter.class.getResource("cus1.png")).getImage();
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
        selectedPet = new JTextField(5);

        // Make the text field uneditable.
        selectedPet.setEditable(false);
        
        
        Color darkerButtonColor = label1.getForeground().darker();
      policyButton.setForeground(darkerButtonColor);
        policyButton.addActionListener (new PolicyAction());

      
      petPanel.setBackground(new Color(255, 255, 255, 0));//make panel transparent
      petPanel.setLayout(new GridLayout(7,2 ));
   
       
       
        petPanel.add(label1);
        petPanel.add(new JLabel());

        petPanel.add(scrollPane);
        petPanel.add(new JLabel());

       
        petPanel.add(label);
        petPanel.add(new JLabel());

        petPanel.add(selectedPet);
        petPanel.add(new JLabel());      
        
        petPanel.add(new JLabel());
        petPanel.add(new JLabel());
        petPanel.add(new JLabel());
        petPanel.add(policyButton);
       
        add(petPanel);
       
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
                         // backgroundImage = new ImageIcon(PetShelter.class.getResource("bac3.png")).getImage();
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
          //  g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
