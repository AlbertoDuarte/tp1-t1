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

public class adicionar_marca extends JPanel {
    private JLabel titulo;
    private JTextField nomeField;
    private JLabel nomeLabel;
    private JButton confirmar;

    public adicionar_marca() {
        //construct components
        titulo = new JLabel ("Adicionar Marca");
        nomeField = new JTextField (5);
        nomeLabel = new JLabel ("Nome");
        confirmar = new JButton ("Confirmar");

        //adjust size and set layout
        setPreferredSize (new Dimension (258, 124));
        setLayout (null);

        //add components
        add (titulo);
        add (nomeField);
        add (nomeLabel);
        add (confirmar);

        //set component bounds (only needed by Absolute Positioning)
        titulo.setBounds (75, 0, 100, 25);
        nomeField.setBounds (0, 65, 100, 25);
        nomeLabel.setBounds (0, 40, 100, 25);
        confirmar.setBounds (70, 95, 100, 25);
    }
    
    confirmar.addActionListener(new ActionListener(){
        String nova_marca = confirmar.getText();
    });
}
