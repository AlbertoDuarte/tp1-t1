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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MyPanel extends JPanel {
    private JLabel marcaLabel;
    private JComboBox marcaField;
    private JLabel modeloLabel;
    private JComboBox modeloField;
    private JLabel combustivelLabel;
    private JComboBox combustivelField;
    private JLabel categoriaLabel;
    private JComboBox categoriaField;
    private JLabel agenciaLabel;
    private JComboBox agenciaField;
    private JList listaField;
    private JLabel corLabel;
    private JLabel anoLabel;
    private JLabel n_portasLabel;
    private JTextField corField;
    private JTextField anoField;
    private JTextField n_portasField;
    private JButton pesquisar;
    private JButton alugar_com;
    private JButton alugar_sem;
    
    private JButton adicionar_marca;
    private JButton adicionar_modelo;
    private JButton adicionar_categoria;
    private JButton adicionar_carro;
    private JButton adicionar_agencia;
            
    public MyPanel() {  
        
	JTabbedPane tabbedPane = new JTabbedPane();
        
        String[] marcaFieldItems = {"Todos"}; 
        String[] modeloFieldItems = {"Todos"}; 
        String[] combustivelFieldItems = {"Todos"}; 
        String[] categoriaFieldItems = {"Todos"}; 
        String[] agenciaFieldItems = {"Todos"}; 
        String[] listaFieldItems = {"Carro 1", "Carro 2", "Carro 3"}; 
        //adjust size and set layout
        setPreferredSize (new Dimension (1000, 1000));
        
        // Primeiro Painel: Locações
        // Component panel1 = makeTextPanel("Teste1.1");
        
        JPanel locacoes = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.anchor = GridBagConstraints.LINE_START;
        c.fill = GridBagConstraints.HORIZONTAL;
        marcaLabel = new JLabel("Marca");
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.gridheight = 1;
        locacoes.add(marcaLabel, c);
        
        c.gridy = 1;
        marcaField = new JComboBox(marcaFieldItems);
        locacoes.add(marcaField, c);
        
        c.gridx = 2;
        c.gridy = 0;
        modeloLabel = new JLabel("Modelo");
        locacoes.add(modeloLabel, c);
        
        c.gridy = 1;
        modeloField = new JComboBox(modeloFieldItems);
        locacoes.add(modeloField, c);
        
        c.gridx = 4;
        c.gridy = 0;
        combustivelLabel = new JLabel("Combustível");
        locacoes.add(combustivelLabel, c);
        
        c.gridy = 1;
        combustivelField = new JComboBox(combustivelFieldItems);
        locacoes.add(combustivelField, c);
        
        c.gridx = 6;
        c.gridy = 0;
        categoriaLabel = new JLabel("Categoria");
        locacoes.add(categoriaLabel, c);
        
        c.gridy = 1;
        categoriaField = new JComboBox(categoriaFieldItems);
        locacoes.add(categoriaField, c);
        
        c.gridx = 8;
        c.gridy = 0;
        agenciaLabel = new JLabel("Agência");
        locacoes.add(agenciaLabel, c);
        
        c.gridy = 1;
        agenciaField = new JComboBox(agenciaFieldItems);
        locacoes.add(agenciaField, c);
        
        c.gridy = 3;
        c.gridx = 0;
        corLabel = new JLabel("Cor");
        locacoes.add(corLabel, c);
        
        c.gridy = 4;
        corField = new JTextField (5);
        locacoes.add(corField, c);
        
        c.gridy = 3;
        c.gridx = 2;
        anoLabel = new JLabel("Ano");
        locacoes.add(anoLabel, c);
        
        c.gridy = 4;
        anoField = new JTextField (5);
        locacoes.add(anoField, c);
        
        c.gridy = 3;
        c.gridx = 4;
        n_portasLabel = new JLabel("Nº Portas");
        locacoes.add(n_portasLabel, c);
        
        c.gridy = 4;
        n_portasField = new JTextField (5);
        locacoes.add(n_portasField, c);
        
        c.gridx = 8;
        pesquisar = new JButton("Pesquisar");
        locacoes.add(pesquisar, c);
        

        pesquisar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String marca = (String) marcaField.getSelectedItem();
                String modelo = (String) modeloField.getSelectedItem();
                String combustivel = (String) combustivelField.getSelectedItem();
                String categoria = (String) categoriaField.getSelectedItem();
                String agencia = (String) agenciaField.getSelectedItem();
                String cor = corField.getText();
                String ano = anoField.getText();
                String n_portas = n_portasField.getText();
                //locacoes.remove(listaField);
            }   
        });
        
        c.gridx = 0;
        c.gridy = 8;
        c.gridwidth = 11;
        c.gridheight = 10;
        listaField = new JList(listaFieldItems);
        locacoes.add(listaField, c);
        
        c.gridwidth = 3;
        c.gridx = 7;
        c.gridy = 18;
        alugar_com = new JButton("Alugar Com Prazo");
        alugar_sem = new JButton("Alugar Sem Prazo");
        locacoes.add(alugar_com, c);
        c.gridx = 3;
        locacoes.add(alugar_sem, c);
        
        alugar_com.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                    JFrame frame = new JFrame ("Aluguel Com Prazo");
                    frame.getContentPane().add (new aluguel_com_prazo());
                    frame.pack();
                    frame.setVisible (true);
            }
        });
        alugar_sem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                    JFrame frame = new JFrame ("Aluguel Sem Prazo");
                    frame.getContentPane().add (new aluguel_sem_prazo());
                    frame.pack();
                    frame.setVisible (true);
            }
        });
        setLayout(new GridBagLayout());
        tabbedPane.addTab("Locações", null, locacoes, "Realizar locações");
        tabbedPane.setSelectedIndex(0);
        
        Component panel2 = makeTextPanel("Não disponível");
        tabbedPane.addTab("Devoluções", null, panel2, "Realizar devoluções");
        
        Component panel3 = makeTextPanel("Não disponível");
        tabbedPane.addTab("Histórico", null, panel3, "Histórico das transações");
        
        JPanel dados = new JPanel(new GridBagLayout());
        c.gridx = 0;
        c.gridy = 0;
        adicionar_marca = new JButton("Adicionar Marca");
        
        c.gridy = 2;
        adicionar_modelo = new JButton("Adicionar Modelo");
        
        c.gridy = 4;
        adicionar_categoria = new JButton("Adicionar Categoria");
        
        c.gridy = 6;
        adicionar_carro = new JButton("Adicionar Carro");
        
        c.gridy = 8;
        adicionar_agencia = new JButton("Adicionar Agência");
        
        adicionar_marca.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame ("Adicionar Marca");
                frame.getContentPane().add (new adicionar_marca());
                frame.pack();
                frame.setVisible (true);
            }            
        });
        
        adicionar_modelo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame ("Adicionar Modelo");
                frame.getContentPane().add (new adicionar_modelo());
                frame.pack();
                frame.setVisible (true);
            }            
        });
        
        adicionar_categoria.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame ("Adicionar carro");
                frame.getContentPane().add (new adicionar_carro());
                frame.pack();
                frame.setVisible (true);
            }            
        });
        
        adicionar_carro.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

            }            
        });
        
        adicionar_agencia.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

            }            
        });
        
        tabbedPane.addTab("Banco de Dados", null, dados, "Alterar o banco de dados");
        
        add(tabbedPane);
        
    }
  
    protected Component makeTextPanel(String text) {
	JPanel panel = new JPanel();
	JLabel filler = new JLabel(text);
	filler.setHorizontalAlignment(JLabel.CENTER);
	panel.setLayout(new GridLayout(1, 0));
	panel.add(filler);
	return panel;
    }

    public static void main (String[] args) {
        JFrame frame = new JFrame ("MyPanel");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new MyPanel());
        frame.pack();
        frame.setVisible (true);
    }
}
