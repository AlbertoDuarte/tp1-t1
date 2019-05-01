package locacoes;

import cliente.cliente;
import undefined_test.agencia;
import undefined_test.automovel;

public abstract class locacao extends fluxo{
	// Métodos
	protected locacao(agencia agencia,cliente cliente, automovel automovel){
		super(agencia,cliente,automovel);
	} 
	public void mostra_dados(){super.mostra_dados();}
	abstract double calcula_custo(float valor_diaria);
}
