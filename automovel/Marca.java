/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automovel;
import colecoes.Colecao;

/**
 *
 * @author AlbertoDuarte
 */
public class Marca extends ObjetoId {
    private static int countId = 1;
    private Colecao modelos;
    
    private String nome;

    Marca(String nome) {
        super(Marca.countId);
        Marca.countId++;
        
        this.modelos = new Colecao(10);
        this.nome = nome.toLowerCase();
        
    }
    
    /**
     * Método para retorno do nome da marca.
     * 
     * @return String - nome da marca.
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Método para adicionar modelo na marca.
     * Caso já esteja adicionado, não modifica nada.
     * 
     * @param modelo - objeto da classe Modelo.
     */
    public void adicionarModelo(Modelo modelo) {
        if(!modelos.adiciona(modelo)) {
            System.out.println("Modelo ja esta na marca!");
            return;
        }
        modelo.setMarca(this);
    }
    
    /**
     * Método para remover modelo da marca.
     * Caso não esteja na marca, não modifica nada.
     * 
     * @param modelo - objeto da classe Modelo.
     */
    public void removerModelo(Modelo modelo) {
        if(modelos.remove(modelo.getId())!=null)
            System.out.println("Modelo removido com sucesso");
        else
            System.out.println("Modelo nao encontrado");
    }
    
    /**
     * TODO:
     * 
     * @return
     */
    public Modelo getModelos() {
        return (Modelo) modelos.navega(true);
    }

    @Override
    public String toString() { 
    	return "Marca id " + this.getId() + ", Nome: " + this.getNome() + "";
    }

    /**
     * TODO:
     */
    @Override
    public void mostraResumo() {
        System.out.printf("Nome: %s", getNome());
    }

    /**
     * TODO:
     */
    @Override
    public void mostraCompleto() {
        mostraResumo(); System.out.println();
    } 
}
