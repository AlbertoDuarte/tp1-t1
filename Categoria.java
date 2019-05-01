/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhow;

import java.util.ArrayList;

/**
 *
 * @author root
 */
public class Categoria {
    private String letra;
    private double valor_diaria;

    private ArrayList<Carro> carros;


    Categoria(String letra, double valor_diaria) {
        this.letra = letra;
        this.valor_diaria = valor_diaria;

        this.carros = new ArrayList<>();       

    }

    public String getLetra() {
        return this.letra;
    }

    public double getValorDiaria() {
        return this.valor_diaria;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public void setValorDiaria(double valor_diaria) {
        this.valor_diaria = valor_diaria;
    }

    public void adicionarCarro(Carro carro) {
        for (Carro i : this.carros) {
            if(carro.getId() == i.getId()) {
                System.out.println("Carro ja esta na categoria!");
                return;
            }
        }
        this.carros.add(carro);
    }

    public void removerCarro(Carro carro) {
        boolean s;
        s = this.carros.remove(carro);
        if(s) {
            System.out.println("Carro removido com sucesso");
        }
        else {
            System.out.println("Carro nao encontrado");
        }
    }

    public ArrayList<Carro> getCarros() {
        return this.carros;
    }

    @Override
    public String toString() { 
      return "Categoria " + this.letra;
    } 
}