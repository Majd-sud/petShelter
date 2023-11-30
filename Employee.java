
package addoption;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Employee extends JFrame {
    static Image backgroundImage;
    FileWriter fw;
    BufferedWriter bw;
    PrintWriter out;
     
   


            
    
      
   
    private JTextField selectedPet;

    public Employee() {
      
        try {
            
            
            setTitle("Employee Page");
            setLayout(new FlowLayout());
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            backgroundImage = new ImageIcon(Employee.class.getResource("13.png")).getImage();
            setContentPane(new BackgroundImagePanel());
            setSize(400, 430);
            setLocationRelativeTo(null);

            JPanel panel1 = new JPanel();
            JButton addNewPet = new JButton("Add New Pet");
            JButton viewPets = new JButton("View Available Pets");
            JButton viewRequests = new JButton("Show Adoption Requests");
            JLabel label = new JLabel("Welcome, our dear employee");
            label.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));

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

            add(panel1);

            fw = new FileWriter("pets.txt", true);

            viewRequests.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame viewRequestsWindow = new JFrame("View Requests");
                    viewRequestsWindow.setSize(400, 430);
                    viewRequestsWindow.setLocationRelativeTo(null);

                    // Create a DefaultListModel to store the file contents
                    DefaultListModel<String> listModel = new DefaultListModel<>();

                    try {
                        // Read the contents of the file
                        File file = new File("requisites.txt");
                        BufferedReader reader = new BufferedReader(new FileReader(file));
                        String line;
                        while ((line = reader.readLine()) != null) {
                            listModel.addElement(line);
                        }
                        reader.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    // Create a JList with the DefaultListModel
                    JList<String> list = new JList<>(listModel);
                     list.setVisibleRowCount(3);

                    // Add the JList to a JScrollPane
                    JScrollPane scrollPane = new JScrollPane(list);
                    JLabel label1=new JLabel("                                   ");
                    JPanel panel2 = new JPanel();
                    panel2.add(label);
                    panel2.add(label1);

                    panel2.add(scrollPane);
                    viewRequestsWindow.add(panel2);

                    viewRequestsWindow.setVisible(true);
                }
            });

            addNewPet.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame addNewPetWindow = new JFrame("Add New Pet");
                    addNewPetWindow.setSize(400, 430);
                    addNewPetWindow.setLocationRelativeTo(null);
                    addNewPetWindow.setContentPane(new BackgroundImagePanel());
                    JLabel nameLabel = new JLabel("Pet Name:");
                    JTextField nameField = new JTextField(20);
                    JButton saveButton = new JButton("Save");
                    JButton done = new JButton("done");

                    JPanel panel = new JPanel();
                    panel.add(nameLabel);
                    panel.add(nameField);
                    panel.add(saveButton);
                    panel.add(done);
                    addNewPetWindow.add(panel);
                    addNewPetWindow.setVisible(true);

                    saveButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String petName = nameField.getText();
                            try {
                                bw = new BufferedWriter(fw);
                                out = new PrintWriter(bw);
                                out.println(petName);
                                bw.newLine();
                            } catch (IOException ex) {
                                Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    });
                    done.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                if (bw != null) {
                                    bw.close();
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    });
                }
            });

            viewPets.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame viewPetsWindow = new JFrame("View Available Pets");
                    viewPetsWindow.setSize(400, 430);
                    viewPetsWindow.setLocationRelativeTo(null);
                    JLabel viewPetsLabel = new JLabel("the available pets");
                    JLabel label1 = new JLabel();
                    JLabel label2 = new JLabel("                                              ");
                    JLabel label3 = new JLabel("       ");
                    JLabel label4 = new JLabel("                                              ");
                    JPanel panel = new JPanel();
                    JPanel panel1 = new JPanel();
                    viewPetsWindow.setLayout(new GridLayout(2, 1));
                    panel.setLayout(new FlowLayout());
                    // Addoption addoption = new Addoption();
                    try {
                        // existing code
                        Addoption addoption = new Addoption();
                        ArrayList<String> pets = addoption.pets;
                        DefaultListModel<String> model = addoption.model;
                        JList<String> petList = addoption.petList;
                        addoption.loadDataFromFile("pets.txt");
                        
                        
                        // petList.setSelectionMode(ListSelectionModel.false);
                        JScrollPane scrollPane = new JScrollPane(petList);
                        scrollPane.setForeground(new Color(103, 49, 71));
                        panel.add(label3);
                        panel.add(viewPetsLabel);
                        panel.add(label4);
                         panel.add(label2);

                        panel.add(scrollPane);

                        viewPetsWindow.getContentPane().add(panel);
                        viewPetsWindow.getContentPane().add(panel1);
                        viewPetsWindow.setVisible(true);
                        
                        // other code
                    } catch (FileIOException ex) {
                        ex.printStackTrace(); // handle the exception appropriately
                    }
                    
                    
                    //JScrollPane scrollPane = new JScrollPane(petList);
                    // scrollPane.setForeground(new Color(103, 49, 71));
                    // Add the scroll pane to the content pane of viewPetsWindow
                    // viewPetsWindow.getContentPane().add(scrollPane);


                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
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
            if (!e.getValueIsAdjusting()) {
                JList<String> list = (JList<String>) e.getSource();
                list.clearSelection();
            }
        }
    }
}
