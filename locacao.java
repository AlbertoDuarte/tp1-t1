package Fluxos;

import Colecoes.colecionavel;
import cliente.cliente;
import undefined_test.agencia;
import undefined_test.automovel;

public abstract class locacao extends fluxo implements colecionavel{
	// Métodos
	protected locacao(agencia agencia,cliente cliente, automovel automovel){
		super(agencia,cliente,automovel);
	} 
	public void mostra_completo(){super.mostra_completo();}
	public void mostra_resumo() {super.mostra_resumo();}
	@Override
	public void gera_id() { super.gera_id();}
	abstract public double calcula_custo(float valor_diaria);
}
