package addoption;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Employee extends JFrame {

    static Image backgroundImage;
    FileWriter fw;
    BufferedWriter bw;
    PrintWriter out;

    // Constructor for Employee class
    public Employee() {
        try {
            // JFrame setup
            setTitle("Employee Page");
            setLayout(new FlowLayout());
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            
            // Load background image
            backgroundImage = new ImageIcon(Employee.class.getResource("17n.png")).getImage();
            setContentPane(new BackgroundImagePanel());
            setSize(400, 430);
            setLocationRelativeTo(null);

            // Create main panel for employee options
            JPanel emplMainPanel = new JPanel();
            JButton addNewPet = new JButton("Add New Pet");
            JButton viewPets = new JButton("View Available Pets");
            JButton viewRequests = new JButton("Show Adoption Requests");
            JLabel label = new JLabel("Welcome, our dear employee");
            label.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));

            // Styling and layout adjustments
            addNewPet.setForeground(new Color(103, 49, 71));
            viewPets.setForeground(new Color(103, 49, 71));
            viewRequests.setForeground(new Color(103, 49, 71));
            label.setForeground(new Color(103, 49, 71));
            emplMainPanel.setBackground(new Color(255, 255, 255, 0));
            emplMainPanel.setLayout(new GridLayout(7, 1));
            emplMainPanel.add(new JLabel());
            emplMainPanel.add(new JLabel());
            emplMainPanel.add(label);
            emplMainPanel.add(new JLabel());
            emplMainPanel.add(addNewPet);
            emplMainPanel.add(viewPets);
            emplMainPanel.add(viewRequests);

            add(emplMainPanel);

            // Initializes a FileWriter to append to the "pets.txt" file.
            fw = new FileWriter("pets.txt", true);

            /* Opens viewRequests window showing adoption requests by reading the content
               of the "requisites.txt" file and displaying it in a JList. */
            viewRequests.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Create a JFrame for viewing adoption requests
                    JFrame viewRequestsWindow = new JFrame("View Requests");
                    viewRequestsWindow.setSize(400, 430);
                    viewRequestsWindow.setLocationRelativeTo(null);
                    viewRequestsWindow.setContentPane(new BackgroundImagePanel());

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

                    // Create panel for layout and styling adjustments
                    JPanel panel = new JPanel();
                    panel.setLayout(new GridLayout(7, 3));
                    panel.setBackground(new Color(255, 255, 255, 0)); // make panel transparent
                    JLabel label1 = new JLabel("Requested Pets");
                    label1.setForeground(new Color(103, 49, 71));
                    label1.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));

                    panel.add(new JLabel());
                    panel.add(label1);
                    panel.add(scrollPane);

                    viewRequestsWindow.add(panel);

                    viewRequestsWindow.setVisible(true);
                }
            });

            // ActionListener for the "Add New Pet" button
            addNewPet.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Create a JFrame for adding a new pet
                    JFrame addNewPetWindow = new JFrame("Add New Pet");
                    addNewPetWindow.setSize(400, 430);
                    addNewPetWindow.setLocationRelativeTo(null);
                    addNewPetWindow.setContentPane(new BackgroundImagePanel());
                    JLabel nameLabel = new JLabel("Pet Name:");
                    JTextField nameField = new JTextField(20);
                    JButton saveButton = new JButton("Save");
                    JButton done = new JButton("done");

                    // Styling adjustments
                    nameLabel.setForeground(new Color(103, 49, 71));
                    nameLabel.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));
                    done.setForeground(new Color(103, 49, 71));
                    saveButton.setForeground(new Color(103, 49, 71));

                    // Create panel for layout and styling adjustments
                    JPanel panel = new JPanel();
                    panel.setBackground(new Color(255, 255, 255, 0)); // make panel transparent
                    panel.setLayout(new GridLayout(7, 1));
                    panel.add(new JLabel());
                    panel.add(new JLabel());
                    panel.add(new JLabel());
                    panel.add(nameLabel);
                    panel.add(nameField);
                    panel.add(saveButton);
                    panel.add(done);

                    // Add components to the JFrame
                    addNewPetWindow.add(panel);
                    addNewPetWindow.setVisible(true);

                    // ActionListener for the "Save" button
                    saveButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String petName = nameField.getText();
                            //writing the name of the pet in the file
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

                    // ActionListener for the "Done" button
                    done.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            //closing the file
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

            // ActionListener for the "View Available Pets" button
            viewPets.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Create a JFrame for viewing available pets
                    JFrame viewPetsWindow = new JFrame("View Available Pets");
                    viewPetsWindow.setSize(400, 430);
                    viewPetsWindow.setLocationRelativeTo(null);
                    viewPetsWindow.setContentPane(new BackgroundImagePanel());
                    JLabel viewPetsLabel = new JLabel("the available pets");
                    viewPetsLabel.setForeground(new Color(103, 49, 71));
                    viewPetsLabel.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));

                    // Create panel for layout and styling adjustments
                    JPanel panel = new JPanel();
                    panel.setBackground(new Color(255, 255, 255, 0)); // make panel transparent

                    try {
                        // Create an instance of the Addoption class
                        Addoption addoption = new Addoption();
                        ArrayList<String> pets = addoption.pets;
                        DefaultListModel<String> model = addoption.model;
                        JList<String> petList = addoption.petList;

                        // Set selection mode to allow only a single selection
                        petList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

                        // Disable the list to make it unclickable
                        petList.setEnabled(false);

                        // Load pet data from the "pets.txt" file
                        addoption.loadDataFromFile("pets.txt");

                        // Create a JScrollPane for the JList
                        JScrollPane scrollPane = new JScrollPane(petList);
                        scrollPane.setForeground(new Color(103, 49, 71));
                        panel.setLayout(new GridLayout(5, 1));

                        // Add components to the panel
                        panel.add(new JLabel());
                        panel.add(viewPetsLabel);
                        panel.add(scrollPane);

                        // Add panel to the JFrame
                        viewPetsWindow.add(panel);

                        viewPetsWindow.setVisible(true);
                    } catch (FileIOException ex) {
                        ex.printStackTrace(); // handle the exception appropriately
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Custom JPanel class for displaying a background image
    static class BackgroundImagePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}

