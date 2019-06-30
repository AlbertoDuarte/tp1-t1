/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automovel;

import colecoes.Colecao;
import colecoes.Colecionavel;
import java.util.List;

/**
 *
 * @author AlbertoDuarte
 */
public class Categoria extends ObjetoId{	
    private String letra;
    private double valor_diaria;
    private List<Carro> carros;


    public Categoria(String letra, double valor_diaria) {
        this.letra = letra.toUpperCase();
        this.valor_diaria = valor_diaria;
    }

    /**
     * Método para retorno da letra da categoria.
     * A letra funciona como id da categoria.
     * 
     * @return String - letra da categoria
     */
    public String getLetra() {
        return this.letra;
    }

    /**
     * Método para retorno do valor da diária dos carros da categoria.
     * 
     * @return Double - valor da diária
     */
    public double getValorDiaria() {
        return this.valor_diaria;
    }

    /**
     * Método para definir a letra da categoria.
     * A String da letra é sempre convertida para maiúsculo.
     * 
     * @param letra - objeto da classe String.
     */
    public void setLetra(String letra) {
        this.letra = letra.toUpperCase();
    }

    /**
     * Método para definir valor da diária da categoria.
     * 
     * @param valor_diaria - valor do tipo double.
     */
    public void setValorDiaria(double valor_diaria) {
        this.valor_diaria = valor_diaria;
    }

    /**
     * Método para adicionar carro à categoria.
     * Caso carro já esteja adicionado, nada é modificado.
     * 
     * @param carro - objeto da classe Carro
     */
    public void adicionarCarro(Carro carro) {
        this.carros.add(carro);
    }

    /**
     * Método para remover carro da categoria.
     * Caso carro não esteja na categoria, nada é modificado.
     * 
     * @param carro - objeto da classe Carro
     */
    public void removerCarro(Carro carro) {
        if(this.carros.remove(carro.getId()) != null) 
            System.out.println("Carro removido com sucesso");
        else
            System.out.println("Carro nao encontrado");
    }

    /**
     * Método para retorno dos carros da categoria.
     * 
     * @return TODO:
     */
    public List<Carro> getCarros() {
        return this.carros;
    }

    @Override
    public String toString() {
        return "Categoria " + this.letra;
    }

    /**
     * TODO:
     */
    @Override
    public void mostraResumo() {
        System.out.printf("Letra: %s; Valor de diaria: %f", letra,valor_diaria);
    } 
    
    /**
     * TODO:
     */
    @Override
    public void mostraCompleto() {
		System.out.printf("Letra: %s; Valor de diaria: %f", letra,valor_diaria);
		System.out.println("CARROS:");
		//carros.mostra();
    }
}