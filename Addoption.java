package petshelter;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Addoption extends JFrame {
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
            // Get the selected season
            String selection = (String) petList.getSelectedValue();

            // Put the selected season in the text field.
            selectedPet.setText(selection);
        }
    }

    // Action class for the Policy button
    private class PolicyAction extends AbstractAction {
     
        @Override
        public void actionPerformed(ActionEvent e) {
            // Open a new window or dialog to display the policy information
            JFrame policyWindow = new JFrame("Our Policy");
        
            policyWindow.setSize(400, 300);
            policyWindow.setLocationRelativeTo(null);
            policyWindow.setVisible(true);
        }
    }
}
