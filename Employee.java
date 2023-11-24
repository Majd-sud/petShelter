package petshelter;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
public class Employee extends JFrame   {
           static Image backgroundImage;
           
            FileWriter fw;
            FileReader fr;
            BufferedWriter bw;
            PrintWriter out;
            Addoption addoption=new Addoption();
             ArrayList<String> pets = addoption.pets;
                DefaultListModel<String> model =addoption.model;
                JList<String> petList = addoption.petList;
                   private JTextField selectedPet;


    public Employee() {
        
        setTitle("Employee Page");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    backgroundImage = new ImageIcon(PetShelter.class.getResource("13.png")).getImage();
        setContentPane(new BackgroundImagePanel());
        setSize(400, 430);
        setLocationRelativeTo(null);

        JPanel panel1 = new JPanel();
        JButton addNewPet = new JButton("Add New Pet");
        JButton viewPets = new JButton("View Available Pets");
        JButton viewRequests = new JButton("Show Adoption Requests");
        JLabel label = new JLabel("Welcome, our dear employee");
        label.setFont(new Font("Serif", Font.CENTER_BASELINE,20));

        addNewPet.setForeground(new Color(103, 49, 71)); 
      viewPets.setForeground(new Color(103, 49, 71)); 
        viewRequests.setForeground(new Color(103, 49, 71)); 
        label.setForeground(new Color(103, 49, 71)); 
        panel1.setBackground(new Color(255, 255, 255, 0));

        panel1.setLayout(new GridLayout(7, 1));
                       panel1.add(new JLabel());

        panel1.add(new JLabel());

        panel1.add(label);
        panel1.add(new JLabel());
        panel1.add(addNewPet);
        panel1.add(viewPets);
        panel1.add(viewRequests);

        //add(label);
        add(panel1);

        addNewPet.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame addNewPetWindow = new JFrame("Add New Pet");
                setSize(400, 430);
                addNewPetWindow.setLocationRelativeTo(null);
             // Create components for the addNewPetWindow
        JLabel nameLabel = new JLabel("Pet Name:");
        JTextField nameField = new JTextField(20);
        JButton saveButton = new JButton("Save");
      
        // Add components to the addNewPetWindow
        JPanel panel = new JPanel();
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(saveButton);
        addNewPetWindow.add(panel);
        addNewPetWindow.setSize(400, 430);
        addNewPetWindow.setLocationRelativeTo(null);
         addNewPetWindow.setVisible(true);
          saveButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                
                 try{
                
                String petName = nameField. getText(); 
                fw=new FileWriter("pets.txt",true);
                bw=new BufferedWriter(fw);
                out=new PrintWriter(bw);
               // fw.write(petName);
               out.println(petName);
                //fw.write("\n");
                }catch (IOException exception){
                   System.err.println("Save oops");  
                }finally {
                     if(fw != null)
                         try{
                             fw.close();
                         } catch(IOException exception) {
          System.err.println("Error closing writer");
          exception.printStackTrace();
                 }
                 }
                 
                 

                  
                    }});
                    
            } });
     viewPets.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame viewPetsWindow = new JFrame("View Available Pets");
        JScrollPane scrollPane;

        viewPetsWindow.setSize(400, 430);
        viewPetsWindow.setLocationRelativeTo(null);
        viewPetsWindow.setVisible(true);

        Addoption addoption = new Addoption();
        addoption.loadDataFromFile("pets.txt"); // Load data from file
        ArrayList<String> pets = addoption.pets;
        DefaultListModel<String> model = addoption.model;
        JList<String> petList = addoption.petList;

        petList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        petList.addListSelectionListener(new Employee.ListListener());

        // Update the model to reflect the changes in the 'pets' list
        addoption.updateModel();

        petList.setVisibleRowCount(3);
        scrollPane = new JScrollPane(petList);
        scrollPane.setForeground(new Color(103, 49, 71));

        add(scrollPane); // Add the scrollPane instead of petList

        // Append the new pet name to the file
        try (FileWriter fw = new FileWriter("pets.txt", true)) {
            for (String pet : pets) {
                fw.write(pet);
                fw.write(System.lineSeparator()); // Use system line separator
            }
        } catch (IOException exception) {
            System.err.println("Error appending to file");
            exception.printStackTrace();
        }
    }
});




    }
    static class BackgroundImagePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
      private class ListListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            // Get the selected pet
            String selection = (String) petList.getSelectedValue();

            //Put the selected pet in the text field.
            selectedPet.setText(selection);

            // Show a confirmation dialog
           // int confirmation = JOptionPane.showConfirmDialog(
                   // Addoption.this,
                  //  "are you sure?",
                 //   "Adoption Confirmation",
                    //JOptionPane.YES_NO_OPTION
        }
      }
}