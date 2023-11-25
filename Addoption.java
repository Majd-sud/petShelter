/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package addoption;



import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Addoption extends JFrame {
    static Image backgroundImage;

    private JPanel petPanel = new JPanel();
    private JPanel petPanel2 = new JPanel();

    JLabel label1 = new JLabel("Pets available for adoption: ");
    JLabel label = new JLabel("You selected: ");
    public JScrollPane scrollPane;
    private JTextField selectedPet;
    FileWriter filew;
    BufferedWriter bufferdw;
    PrintWriter out;
    JButton policyButton = new JButton("Our Policy");

    // To hold components
    public ArrayList<String> pets = new ArrayList<>();

    DefaultListModel<String> model = new DefaultListModel<>();
    JList<String> petList = new JList<>(model);

    public Addoption() throws IOException {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        backgroundImage = new ImageIcon(PetShelter.class.getResource("13.png")).getImage();
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
        policyButton.addActionListener(new PolicyAction());

        petPanel.setBackground(new Color(255, 255, 255, 0)); // make panel transparent
        petPanel.setLayout(new GridLayout(2, 2));

        petPanel.add(label1);
        petPanel.add(new JLabel());
        petPanel.add(scrollPane);
        petPanel.add(new JLabel());

        petPanel2.setBackground(new Color(255, 255, 255, 0)); // make panel transparent
        petPanel2.setLayout(new GridLayout(5, 3));

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
        filew=new FileWriter("\\C:\\Users\\96656\\OneDrive\\Documents\\NetBeansProjects\\Addoption\\requisites.txt",true);

        // Load pet data from file
        loadDataFromFile("\\C:\\Users\\96656\\OneDrive\\Documents\\NetBeansProjects\\Addoption\\pets.txt");
        // Update the model with the loaded data
        updateModel();
    }

    class ListListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            // Get the selected pet
            String selection = petList.getSelectedValue();

            // Put the selected pet in the text field.
            selectedPet.setText(selection);

            // Show a confirmation dialog
            int confirmation = JOptionPane.showConfirmDialog(
                    Addoption.this,
                    "Are you sure?",
                    "Adoption Confirmation",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirmation == JOptionPane.YES_OPTION) {
                String petName = selectedPet.getText();
                    try {

                     bufferdw = new BufferedWriter(filew);
                            out = new PrintWriter(bufferdw);
                            out.println(petName);
                            bufferdw.newLine();
                            bufferdw.close();
                            
                        } catch (IOException ex) {
                            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
                        } 
                    }
                // User confirmed, show the adoption confirmation message
                JOptionPane.showMessageDialog(Addoption.this, "We will contact you soon", "Adoption Confirmation", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    

    // Action class for the Policy button
    private class PolicyAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Display the policy information in a JOptionPane
            JOptionPane.showMessageDialog(Addoption.this,
                    "Our Adoption Policy:\n\n" +
                            "1. Complete the adoption application.\n" +
                            "2. Wait for our staff to review your application.\n" +
                            "3. Once approved, visit the shelter to finalize the adoption process.\n\n" +
                            "Thank you for considering adoption!",
                    "Adoption Policy",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    static class BackgroundImagePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public void loadDataFromFile(String filename) {
        // Implement code to read data from the file and populate the 'pets' list.
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                pets.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateModel() {
        model.clear(); // Clear the existing items in the model
        for (String pet : pets) {
            model.addElement(pet); // Add each pet to the model
        }
    }

   /* public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Addoption adoption = new Addoption();
            adoption.setVisible(true);
        });
    }*/
    
}


