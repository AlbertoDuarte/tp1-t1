/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automovel;

import colecoes.Colecao;

/**
 *
 * @author AlbertoDUarte
 */
public class Modelo extends ObjetoId {
    private static int countId = 1;
    private Colecao carros;
    
    private Marca marca;
    private String nome;
    private String combustivel;
    private int n_portas;
    
    Modelo(Marca marca, String nome, String combustivel, int n_portas) {
        super(Modelo.countId);
        Modelo.countId++;
        
        this.nome = nome.toLowerCase();
        this.combustivel = combustivel.toLowerCase();
        this.n_portas = n_portas;        
        
        this.carros = new Colecao(10);
        this.marca = marca;
        marca.adicionarModelo((this));
    }
    
    /**
     * Método para retorno do nome do modelo.
     * 
     * @return String - nome do modelo.
     */
    public String getNome() {
        return this.nome;
    }
    
    /**
     * Método para retorno da marca do modelo.
     * 
     * @return Marca - marca do modelo.
     */
    public Marca getMarca() {
       return this.marca; 
    }

    /**
     * Método para definir marca do modelo.
     * 
     * @param marca - Objeto da classe Marca
     */
    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    
    /**
     * Método para adicionar carro ao modelo.
     * Caso já esteja adicionado, não modifica nada.
     * 
     * @param carro - Objeto da classe Carro.
     */
    public void adicionarCarro(Carro carro) {
        if(carros.adiciona(carro)) {
            System.out.println("Carro ja esta no modelo!");
            return;
        }
        carro.setModelo(this);
    }
    
    /**
     * Método para remover carro do modelo.
     * Caso não esteja no modelo, não modifica nada.
     * 
     * @param carro - Objeto da classe Carro.
     */
    public void removerCarro(Carro carro) {
        if(carros.remove(carro.getId())!=null)
            System.out.println("Carro removido com sucesso");
        else
            System.out.println("Carro nao encontrado");
    }
    
    /**
     * TODO:
     * 
     * @return
     */
    public Carro getCarros() {
        return (Carro)carros.navega(true);
    }

    @Override
    public String toString() { 
      return "Modelo id " + this.getId() + ", Nome: " + this.getNome() + ", Marca: " + this.getMarca().getNome() + "";
    }

    /**
     * TODO:
     */
    @Override
    public void mostraCompleto() {
	System.out.println(toString());
	System.out.println("Combustivel: " + combustivel);
	System.out.println("Portas: " + n_portas);
    }

    /**
     * TODO:
     * 
     */
    @Override
    public void mostraResumo() {
        System.out.printf("Nome: %s; Marca: %s", getNome(),getMarca());
    }
}
