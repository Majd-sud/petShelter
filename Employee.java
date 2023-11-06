package petshelter;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Employee extends JFrame {
    public Employee() {
        setTitle("Employee Page");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel panel1 = new JPanel();
        JButton addNewPet = new JButton("Add New Pet");
        JButton viewPets = new JButton("View Available Pets");
        JButton viewRequests = new JButton("Show Adoption Requests");
        JLabel label = new JLabel("Welcome, our dear employee!");

        panel1.setLayout(new GridLayout(3, 1));
        panel1.add(addNewPet);
        panel1.add(viewPets);
        panel1.add(viewRequests);

        add(label);
        add(panel1);

        addNewPet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame addNewPetWindow = new JFrame("Add New Pet");
                addNewPetWindow.setSize(400, 300);
                addNewPetWindow.setLocationRelativeTo(null);
                addNewPetWindow.setVisible(true);
            }
        });

        viewPets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame viewPetsWindow = new JFrame("View Available Pets");
                viewPetsWindow.setSize(400, 300);
                viewPetsWindow.setLocationRelativeTo(null);
                viewPetsWindow.setVisible(true);
            }
        });

        viewRequests.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame viewRequestsWindow = new JFrame("Show Adoption Requests");
                viewRequestsWindow.setSize(400, 300);
                viewRequestsWindow.setLocationRelativeTo(null);
                viewRequestsWindow.setVisible(true);
            }
            });
    }
}
