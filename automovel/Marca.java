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
 * @author AlbertoDuarte
 */
public class Marca extends ObjetoId {
    private List<Modelo> modelos;
    private String nome;

    public Marca(String nome) {
        this.modelos = new ArrayList<>();
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
     *  Método para definir nome da marca.
     * 
     * @param nome - Objeto da classe String
     */
    public void setNome(String nome) {
        this.nome = nome.toLowerCase();
    }

    /**
     * Método para adicionar modelo na marca.
     * Caso já esteja adicionado, não modifica nada.
     * 
     * @param modelo - objeto da classe Modelo.
     */
    public void adicionarModelo(Modelo modelo) {
        this.modelos.add(modelo);
    }
    
    /**
     * Método para remover modelo da marca.
     * Caso não esteja na marca, não modifica nada.
     * 
     * @param modelo - objeto da classe Modelo.
     */
    public void removerModelo(Modelo modelo) {
        if(this.modelos.remove(modelo.getId())!=null)
            System.out.println("Modelo removido com sucesso");
        else
            System.out.println("Modelo nao encontrado");
    }
    
    /**
     * Método para retorno da lista de modelos pertencentes a essa marca.
     * 
     * @return List - lista de modelos
     */
    public List<Modelo> getModelos() {
        return this.modelos;
    }

    /**
     *  Método que converte as informacoes da marca em String.
     * 
     * @return String - informacoes da marca.
     */
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
