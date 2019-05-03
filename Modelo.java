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
        
        this.marca = marca;
        marca.adicionarModelo((this));
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public Marca getMarca() {
       return this.marca; 
    }

    public void modificarMarca(Marca marca) {
        this.marca = marca;
    }
    
    public void adicionarCarro(Carro carro) {
        if(carros.adiciona(carro)) {
            System.out.println("Carro ja esta no modelo!");
            return;
        }
        carro.modificarModelo(this);
    }
    
    public void removerCarro(Carro carro) {
        if(carros.remove(carro.get_id())!=null)
            System.out.println("Carro removido com sucesso");
        else
            System.out.println("Carro nao encontrado");
    }
    
    public Carro acessa_carros() {return (Carro)carros.navega(true);}

    @Override
    public String toString() { 
      return "Modelo id " + this.get_id() + ", Nome: " + this.getNome() + ", Marca: " + this.getMarca().getNome() + "";
    }

	@Override
	public void mostra_completo() {
		System.out.println(toString());
		System.out.println("Combustivel: " + combustivel);
		System.out.println("Portas: " + n_portas);
	}

	@Override
	public void mostra_resumo() {System.out.printf("Nome: %s; Marca: %s", getNome(),getMarca());}
}
