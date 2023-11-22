package petshelter;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Addoption extends JFrame {
    static Image backgroundImage;

    private JPanel petPanel = new JPanel(); 
    private JPanel petPanel2 = new JPanel();
    JLabel label1 = new JLabel("Pets available for adoption: ");
    JLabel label2 = new JLabel("You selected: ");
    private JScrollPane scrollPane;
    private JTextField selectedPet;

    JButton policyButton = new JButton("Our Policy");


    // To hold components
    private String[] pets = { "cat", "dog", "hamster", "bird" };
    private JList petList = new JList(pets);

    public Addoption() {
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

        label2.setForeground(new Color(103, 49, 71));
        selectedPet = new JTextField(10);
        selectedPet.setEditable(false);

        Color darkerButtonColor = label1.getForeground().darker();
        policyButton.setForeground(darkerButtonColor);
        policyButton.addActionListener(new PolicyAction(
                "applicant must be at least 18 years old, have the ability to provide proper care and stable life."
        ));

        petPanel.setBackground(new Color(255, 255, 255, 0));
        petPanel.setLayout(new GridLayout(2, 2));

        petPanel.add(label1);
        petPanel.add(new JLabel());
        petPanel.add(scrollPane);
        petPanel.add(new JLabel());

        petPanel2.setBackground(new Color(255, 255, 255, 0));
        petPanel2.setLayout(new GridLayout(5, 3));

        petPanel2.add(label2);
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
      
    }

    private class ListListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            String selection = (String) petList.getSelectedValue();
            selectedPet.setText(selection);

            int confirmation = JOptionPane.showConfirmDialog(
                    Addoption.this,
                    "Are you sure?",
                    "Adoption Confirmation",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirmation == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(Addoption.this, "We will contact you soon", "Adoption Confirmation", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private class PolicyAction extends AbstractAction {
        private String policyContent;

        public PolicyAction(String policyContent) {
            this.policyContent = policyContent;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // Display the policy content in a JOptionPane
            JOptionPane.showMessageDialog(
                    Addoption.this,
                    policyContent,
                    "Our Policy",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    static class BackgroundImagePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public static void main(String[] args) {
    {
            Addoption addoption = new Addoption();
            addoption.setVisible(true);
        }
    }
}
