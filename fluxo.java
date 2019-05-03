package Fluxos;
import java.util.Date;

import Colecoes.colecionavel;
import cliente.cliente;
import undefined_test.agencia;
import undefined_test.automovel;

public abstract class fluxo implements colecionavel{
	// Atributos
	protected static int global_id=0;
	protected int id;
	
	protected agencia agencia;
	protected cliente cliente;
	protected automovel automovel;
	protected Date tempo;
	
	// Métodos
	protected fluxo(agencia agencia,cliente cliente, automovel automovel) {
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
	@Override
	public void gera_id() {
		id = global_id;
		global_id++;
	}
	@Override
	public int get_id() {
		return id;
	}
}
