package fluxos;
import java.util.Date;

import colecoes.Colecionavel;
import cliente.Cliente;
import agencia.Agencia;
import automovel.Carro;

public abstract class Fluxo implements Colecionavel{
	// Atributos
	protected static int global_id=0;
	protected int id;
	
	protected Agencia agencia;
	protected Cliente cliente;
	protected Carro automovel;
	protected Date tempo;
	
	// M�todos
	protected Fluxo(Agencia agencia,Cliente cliente, Carro automovel) {
		// Gravar atributos
		this.tempo=new Date();
		this.agencia=agencia;
		this.cliente=cliente;
		this.automovel=automovel;
		geraId();
	};
	public void mostraCompleto() {
		System.out.println("Data: " + this.tempo.toString());
		System.out.println("AGENCIA:");
		this.agencia.mostraResumo();
		System.out.println("CLIENTE:");
		this.cliente.mostraResumo();
		System.out.println("AUTOMOVEL:");
		this.automovel.mostraResumo();
	}
	public void mostraResumo() {
		System.out.printf("Data: %s; ", this.tempo.toString());
	}
	public void geraId() {
		id = global_id;
		global_id++;
	}
	@Override
	public int getId() {return id;}
}
