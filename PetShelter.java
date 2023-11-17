package petshelter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class PetShelter extends JFrame {
    static Image backgroundImage;
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();

    JButton emp = new JButton("Employee?");
    JButton costmr = new JButton("Customer?");
    JLabel label1 = new JLabel("welcome");

    public PetShelter() {
        setTitle("Pet Shelter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout()); // Use BorderLayout for the frame

        setContentPane(new BackgroundImagePanel());

        emp.addActionListener(new ActionListenerExample());
        costmr.addActionListener(new ActionListenerExample());

        label1.setFont(new Font("Serif", Font.CENTER_BASELINE,30));
        label1.setForeground(new Color(103, 49, 71)); // Brown color using RGB values
     
         Color darkerButtonColor = label1.getForeground().darker();
        emp.setForeground(darkerButtonColor);
        costmr.setForeground(darkerButtonColor);
        
        panel1.setLayout(new GridLayout(5, 1));
        panel1.setBorder(new EmptyBorder(10, 10, 10, 10));
        
                panel1.setBackground(new Color(255, 255, 255, 0));
        panel1.add(new JLabel());

        panel1.add(new JLabel());
        panel1.add(label1);
        
        panel1.add(emp);

        panel1.add(costmr);

      

      add(panel1, BorderLayout.CENTER);

        backgroundImage = new ImageIcon(PetShelter.class.getResource("11.png")).getImage();

        // Set a specific size for the window
        setSize(400, 430);

        // Center the window
        setLocationRelativeTo(null);

        // Disable window resizing
        setResizable(false);
        setVisible(true);

    }

    static class BackgroundImagePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public class ActionListenerExample implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == emp) {
                EmpLogin emplogin = new EmpLogin();
                emplogin.setVisible(true);
            } else if (e.getSource() == costmr) {
                CostmrLogin costmrrLogin = new CostmrLogin();
                costmrrLogin.setVisible(true);
            }
        }
    }

    public static void main(String[] args) {
        new PetShelter();
    }
}
