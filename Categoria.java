/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhow;

import Colecoes.Colecao;
import Colecoes.Colecionavel;

/**
 *
 * @author root
 */
public class Categoria implements Colecionavel{
	static int global_id=0;
	int id;
	
    private String letra;
    private double valor_diaria;
    private Colecao carros;


    Categoria(String letra, double valor_diaria) {
    	id=global_id;
    	global_id++;
        this.letra = letra;
        this.valor_diaria = valor_diaria;
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
        if(!carros.adiciona(carro))
                System.out.println("Carro ja esta na categoria!");
    }

    public void removerCarro(Carro carro) {
        if(carros.remove(carro.get_id()) != null) 
            System.out.println("Carro removido com sucesso");
        else
            System.out.println("Carro nao encontrado");
    }

    public Carro acessa_carros() {return (Carro) carros.navega(true);}

    @Override
    public String toString() {return "Categoria " + this.letra;}

	@Override
	public int get_id() {return id;}

	@Override
	public void mostra_resumo() {System.out.printf("Letra: %s; Valor de diaria: %f", letra,valor_diaria);} 
    
	@Override
    public void mostra_completo() {
		System.out.printf("Letra: %s; Valor de diaria: %f", letra,valor_diaria);
		System.out.println("CARROS:");
		carros.mostra();
    }
}