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
    private JTextField placaField;
    private JLabel placaLabel;
    private JButton confirmar;
    private JTextField corField;
    private JTextField renavamField;
    private JTextField marcaField;
    private JLabel corLabel;
    private JLabel renavamLabel;
    private JLabel marcaLabel;
    private JTextField categoriaField;
    private JLabel categoriaLabel;
    private JTextField anoField;
    private JLabel anoLabel;
    private JTextField kmField;
    private JLabel kmLabel;

    public MyPanel() {
        //construct components
        titulo = new JLabel ("Adicionar Carro");
        placaField = new JTextField (5);
        placaLabel = new JLabel ("Placa");
        confirmar = new JButton ("Confirmar");
        corField = new JTextField (5);
        renavamField = new JTextField (5);
        marcaField = new JTextField (5);
        corLabel = new JLabel ("Cor");
        renavamLabel = new JLabel ("RENAVAM");
        marcaLabel = new JLabel ("Marca");
        categoriaField = new JTextField (5);
        categoriaLabel = new JLabel ("Categoria");
        anoField = new JTextField (5);
        anoLabel = new JLabel ("Ano");
        kmField = new JTextField (5);
        kmLabel = new JLabel ("Quilometragem");

        //adjust size and set layout
        setPreferredSize (new Dimension (240, 375));
        setLayout (null);

        //add components
        add (titulo);
        add (placaField);
        add (placaLabel);
        add (confirmar);
        add (corField);
        add (renavamField);
        add (marcaField);
        add (corLabel);
        add (renavamLabel);
        add (marcaLabel);
        add (categoriaField);
        add (categoriaLabel);
        add (anoField);
        add (anoLabel);
        add (kmField);
        add (kmLabel);

        //set component bounds (only needed by Absolute Positioning)
        titulo.setBounds (75, 0, 100, 25);
        placaField.setBounds (0, 65, 100, 25);
        placaLabel.setBounds (0, 40, 100, 25);
        confirmar.setBounds (70, 345, 100, 25);
        corField.setBounds (0, 125, 100, 25);
        renavamField.setBounds (0, 185, 100, 25);
        marcaField.setBounds (140, 65, 100, 25);
        corLabel.setBounds (0, 100, 100, 25);
        renavamLabel.setBounds (0, 160, 100, 25);
        marcaLabel.setBounds (140, 40, 100, 25);
        categoriaField.setBounds (140, 125, 100, 25);
        categoriaLabel.setBounds (140, 100, 100, 25);
        anoField.setBounds (0, 245, 100, 25);
        anoLabel.setBounds (0, 220, 100, 25);
        kmField.setBounds (0, 305, 100, 25);
        kmLabel.setBounds (0, 280, 100, 25);
    }
}