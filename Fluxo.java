package Fluxos;
import java.util.Date;

import Colecoes.Colecionavel;
import cliente.Cliente;
import trabalhow.Agencia;
import trabalhow.Carro;

public abstract class Fluxo implements Colecionavel{
	// Atributos
	protected static int global_id=0;
	protected int id;
	
	protected Agencia agencia;
	protected Cliente cliente;
	protected Carro automovel;
	protected Date tempo;
	
	// Métodos
	protected Fluxo(Agencia agencia,Cliente cliente, Carro automovel) {
		// Gravar atributos
		this.tempo=new Date();
		this.agencia=agencia;
		this.cliente=cliente;
		this.automovel=automovel;
		gera_id();
	};
	public void mostra_completo() {
		System.out.println("Data: " + this.tempo.toString());
		System.out.println("AGENCIA:");
		this.agencia.mostra_resumo();
		System.out.println("CLIENTE:");
		this.cliente.mostra_resumo();
		System.out.println("AUTOMOVEL:");
		this.automovel.mostra_resumo();
	}
	public void mostra_resumo() {
		System.out.printf("Data: %s; ", this.tempo.toString());
	}
	public void gera_id() {
		id = global_id;
		global_id++;
	}
	@Override
	public int get_id() {return id;}
}
