/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhow;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author root
 */
public class Marca extends ObjetoId {
    private static int countId = 1;
    private ArrayList<Modelo> modelos;
    
    private String nome;

    Marca(String nome) {
        super(Marca.countId);
        Marca.countId++;
        this.modelos = new ArrayList<>();
        
        this.nome = nome.toLowerCase();
    }
    
    public String getNome() {
        return this.nome;
    }

    public void adicionarModelo(Modelo modelo) {
        for (Modelo i : this.modelos) {
            if(modelo.getId() == i.getId()) {
                System.out.println("Modelo ja esta na marca!");
                return;
            }
        }
        this.modelos.add(modelo);
        modelo.modificarMarca(this);
    }
    
    public void removerModelo(Modelo modelo) {
        boolean s;
        s = this.modelos.remove(modelo);
        if(s) {
            System.out.println("Modelo removido com sucesso");
        }
        else {
            System.out.println("Modelo nao encontrado");
        }
    }
    
    public ArrayList<Modelo> getModelos() {
        return this.modelos;
    }

    @Override
    public String toString() { 
      return "Marca id " + this.getId() + ", Nome: " + this.getNome() + "";
    } 
}
