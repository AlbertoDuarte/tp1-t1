/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automovel;

import colecoes.Colecao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AlbertoDUarte
 */
public class Modelo extends ObjetoId {
    private ArrayList<Carro> carros;
    private Marca marca;
    private String nome;
    private String combustivel;
    private int n_portas;
    

    
    public Modelo(String nome, String combustivel, int n_portas) {
        this.carros = new ArrayList<>();
        this.nome = nome.toLowerCase();
        this.combustivel = combustivel.toLowerCase();
        this.n_portas = n_portas;        
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
    
    public String getCombustivel() {
        return this.combustivel;
    }
    
    public int getNPortas() {
        return this.n_portas;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Método para definir marca do modelo.
     * 
     * @param marca - Objeto da classe Marca
     */
    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    
    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }
    
    public void setNPortas(int n_portas) {
        this.n_portas = n_portas;
    }
    
    /**
     * Método para adicionar carro ao modelo.
     * Caso já esteja adicionado, não modifica nada.
     * 
     * @param carro - Objeto da classe Carro.
     */
    public void adicionarCarro(Carro carro) {
        this.carros.add(carro);
    }
    
    /**
     * Método para remover carro do modelo.
     * Caso não esteja no modelo, não modifica nada.
     * 
     * @param carro - Objeto da classe Carro.
     */
    public void removerCarro(Carro carro) {
        if(this.carros.remove(carro.getId())!=null)
            System.out.println("Carro removido com sucesso");
        else
            System.out.println("Carro nao encontrado");
    }
    
    /**
     * TODO:
     * 
     * @return
     */
    public List<Carro> getCarros() {
        return this.carros;
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
