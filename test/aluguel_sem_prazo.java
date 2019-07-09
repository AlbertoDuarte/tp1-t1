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

public class aluguel_sem_prazo extends JPanel {
    private JLabel dados;
    private JTextField nome_clienteField;
    private JLabel nome_clienteLabel;
    private JTextField sobrenome_clienteField;
    private JLabel sobrenome_clienteLabel;
    private JTextField cpfField;
    private JLabel cpfLabel;
    private JTextField emailField;
    private JLabel emailLabel;
    private JButton confirmar;
    private JTextField prazoField;
    private JLabel prazoLabel;

    public aluguel_sem_prazo() {
        //construct components
        dados = new JLabel ("Dados");
        nome_clienteField = new JTextField (5);
        nome_clienteLabel = new JLabel ("Nome");
        sobrenome_clienteField = new JTextField (5);
        sobrenome_clienteLabel = new JLabel ("Sobrenome");
        cpfField = new JTextField (5);
        cpfLabel = new JLabel ("CPF");
        emailField = new JTextField (5);
        emailLabel = new JLabel ("E-mail");
        confirmar = new JButton ("Confirmar");
        prazoField = new JTextField (5);
        prazoLabel = new JLabel ("Prazo (em dias)");

        //set components properties
        dados.setToolTipText ("q");

        //adjust size and set layout
        setPreferredSize (new Dimension (213, 271));
        setLayout (null);

        //add components
        add (dados);
        add (nome_clienteField);
        add (nome_clienteLabel);
        add (sobrenome_clienteField);
        add (sobrenome_clienteLabel);
        add (cpfField);
        add (cpfLabel);
        add (emailField);
        add (emailLabel);
        add (confirmar);
        add (prazoField);
        add (prazoLabel);

        //set component bounds (only needed by Absolute Positioning)
        dados.setBounds (60, 0, 100, 25);
        nome_clienteField.setBounds (0, 70, 100, 25);
        nome_clienteLabel.setBounds (0, 45, 100, 25);
        sobrenome_clienteField.setBounds (120, 70, 100, 25);
        sobrenome_clienteLabel.setBounds (120, 45, 100, 25);
        cpfField.setBounds (0, 135, 100, 25);
        cpfLabel.setBounds (0, 110, 100, 25);
        emailField.setBounds (0, 200, 100, 25);
        emailLabel.setBounds (0, 175, 100, 25);
        confirmar.setBounds (60, 235, 100, 25);
        prazoField.setBounds (120, 200, 100, 25);
        prazoLabel.setBounds (120, 175, 100, 25);
    }
}
