package fluxos;

import colecoes.Colecionavel;
import cliente.Cliente;
import agencia.Agencia;
import automovel.Carro;

public abstract class Locacao extends Fluxo implements Colecionavel{
	// M�todos
	protected Locacao(Agencia agencia,Cliente cliente, Carro automovel){
		super(agencia,cliente,automovel);
	} 
        @Override
	public void mostraCompleto(){super.mostraCompleto();}
        @Override
	public void mostraResumo() {super.mostraResumo();}
        @Override
	public void geraId() { super.geraId();}
	abstract public double calculaCusto(float valor_diaria);
}
