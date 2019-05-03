package Fluxos;

import Colecoes.Colecionavel;
import cliente.Cliente;
import trabalhow.Agencia;
import trabalhow.Carro;

public abstract class Locacao extends Fluxo implements Colecionavel{
	// Métodos
	protected Locacao(Agencia agencia,Cliente cliente, Carro automovel){
		super(agencia,cliente,automovel);
	} 
	public void mostra_completo(){super.mostra_completo();}
	public void mostra_resumo() {super.mostra_resumo();}
	public void gera_id() { super.gera_id();}
	abstract public double calcula_custo(float valor_diaria);
}
