/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import automovel.Marca;
import java.sql.SQLException;

/**
 *
 * @author root
 */
public class main  {
    
    public static void main(String args[]) throws SQLException {    
    String nome = "alberto";

    Marca marca = new Marca(nome);
    }
}
