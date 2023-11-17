package petshelter;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Employee extends JFrame {
           static Image backgroundImage;

    public Employee() {
        
        setTitle("Employee Page");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
     backgroundImage = new ImageIcon(PetShelter.class.getResource("cus1.png")).getImage();
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

        panel1.setLayout(new GridLayout(6, 1));
                panel1.add(new JLabel());

        panel1.add(label);
        panel1.add(new JLabel());
        panel1.add(addNewPet);
        panel1.add(viewPets);
        panel1.add(viewRequests);

        //add(label);
        add(panel1);

        addNewPet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame addNewPetWindow = new JFrame("Add New Pet");
        setSize(400, 430);
                addNewPetWindow.setLocationRelativeTo(null);
                addNewPetWindow.setVisible(true);
                
            }
        });

        viewPets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame viewPetsWindow = new JFrame("View Available Pets");
        setSize(400, 430);
                viewPetsWindow.setLocationRelativeTo(null);
                viewPetsWindow.setVisible(true);
            }
        });

        viewRequests.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame viewRequestsWindow = new JFrame("Show Adoption Requests");
                viewRequestsWindow.setSize(400, 430);
                viewRequestsWindow.setLocationRelativeTo(null);
                viewRequestsWindow.setVisible(true);
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
}