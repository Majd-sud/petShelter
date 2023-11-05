/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshelter;

/**
 *
 * @author 96656
 */
import java.awt.*; // Needed for BorderLayout class
import java.awt.event.*;
import javax.swing.*;  // Needed for Swing classes
public class Employee extends JFrame {
    JPanel panel1= new JPanel();
   JButton addNwPet= new JButton("add new pet");
   JButton viewPets= new JButton("view avilabele pets");
   JButton viewReq= new JButton("Show addoption requset");
   JLabel label=new JLabel("welcom our deer employee ");
    public Employee(){
    setTitle("Employee Page");
    setLayout( new FlowLayout());
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setSize(300, 200);
    setLocationRelativeTo(null);
    panel1.setLayout(new GridLayout(3,3));
    panel1.add(addNwPet);
    panel1.add(viewPets);
    panel1.add(viewReq);
    add(label);
    add(panel1);
    }
    
}
