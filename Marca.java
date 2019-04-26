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
public class Marca {
    int id;
    private String nome;
    private ArrayList<Modelo> modelos;

    Marca(String nome) {
        this.nome = nome.toLowerCase();
        this.modelos = new ArrayList<>();

    }
    
    public String getNome() {
        return this.nome;
    }

    public void adicionarModelo(Modelo modelo) {
        for (Modelo i : this.modelos) {
            if(i.nome.equals(modelo.nome)) {
                System.out.println("Modelo ja esta na marca!");
                return;
            }
        }
        this.modelos.add(modelo);
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
}
