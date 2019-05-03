/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhow;
import Colecoes.Colecao;

/**
 *
 * @author root
 */
public class Marca extends ObjetoId {
    private static int countId = 1;
    private Colecao modelos;
    
    private String nome;

    Marca(String nome) {
        super(Marca.countId);
        Marca.countId++;
        
        this.nome = nome.toLowerCase();
    }
    
    public String getNome() {
        return this.nome;
    }

    public void adicionarModelo(Modelo modelo) {
        if(!modelos.adiciona(modelo)) {
            System.out.println("Modelo ja esta na marca!");
            return;
        }
        modelo.modificarMarca(this);
    }
    
    public void removerModelo(Modelo modelo) {
        if(modelos.remove(modelo.get_id())!=null)
            System.out.println("Modelo removido com sucesso");
        else
            System.out.println("Modelo nao encontrado");
    }
    
    public Modelo acessa_Modelos() {
        return (Modelo) modelos.navega(true);
    }

    @Override
    public String toString() { 
    	return "Marca id " + this.get_id() + ", Nome: " + this.getNome() + "";
    }

	@Override
	public void mostra_resumo() {System.out.printf("Nome: %s", getNome());}

	@Override
	public void mostra_completo() { mostra_resumo(); System.out.println();} 
}
