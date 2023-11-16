package petshelter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class PetShelter extends JFrame {
    static Image backgroundImage;
    JPanel panel1 = new JPanel();

    JButton emp = new JButton("Employee");
    JButton costmr = new JButton("Customer");
    JLabel label1 = new JLabel("What are you?!");

    public PetShelter() {
        setTitle("Pet Shelter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        setContentPane(new BackgroundImagePanel());

        // Use a layout manager for panel1
        panel1.setLayout(new GridBagLayout());

        // Add an EmptyBorder to create space between label and buttons
        panel1.setBorder(new EmptyBorder(10, 0, 0, 0));

        emp.addActionListener(new ActionListenerExample());
        costmr.addActionListener(new ActionListenerExample());

        label1.setFont(new Font("Arial", Font.BOLD, 24));
        label1.setForeground(Color.WHITE);

        panel1.add(emp);
        panel1.add(costmr);

        add(label1, BorderLayout.NORTH);
        add(panel1, BorderLayout.CENTER);

        backgroundImage = new ImageIcon(PetShelter.class.getResource("backg.png")).getImage();

        // Set a specific size for the window
        setSize(390, 520);

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
