/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.test;

/**
 *
 * @author Felipe
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class MyPanel extends JPanel {
    private JLabel titulo;
    private JTextField nomeField;
    private JLabel nomeLabel;
    private JButton confirmar;
    private JTextField combustivelField;
    private JTextField n_portasField;
    private JTextField marcaField;
    private JLabel combustivelLabel;
    private JLabel n_portasLabel;
    private JLabel marcaLabel;

    public MyPanel() {
        //construct components
        titulo = new JLabel ("Adicionar Modelo");
        nomeField = new JTextField (5);
        nomeLabel = new JLabel ("Nome");
        confirmar = new JButton ("Confirmar");
        combustivelField = new JTextField (5);
        n_portasField = new JTextField (5);
        marcaField = new JTextField (5);
        combustivelLabel = new JLabel ("Combustível");
        n_portasLabel = new JLabel ("Nº Portas");
        marcaLabel = new JLabel ("Marca");

        //adjust size and set layout
        setPreferredSize (new Dimension (240, 257));
        setLayout (null);

        //add components
        add (titulo);
        add (nomeField);
        add (nomeLabel);
        add (confirmar);
        add (combustivelField);
        add (n_portasField);
        add (marcaField);
        add (combustivelLabel);
        add (n_portasLabel);
        add (marcaLabel);

        //set component bounds (only needed by Absolute Positioning)
        titulo.setBounds (75, 0, 100, 25);
        nomeField.setBounds (0, 65, 100, 25);
        nomeLabel.setBounds (0, 40, 100, 25);
        confirmar.setBounds (70, 230, 100, 25);
        combustivelField.setBounds (0, 125, 100, 25);
        n_portasField.setBounds (0, 185, 100, 25);
        marcaField.setBounds (140, 65, 100, 25);
        combustivelLabel.setBounds (0, 100, 100, 25);
        n_portasLabel.setBounds (0, 160, 100, 25);
        marcaLabel.setBounds (140, 40, 100, 25);
      
        confirmar.addActionListener(new ActionListener(){
            
            
        });
    }
}
