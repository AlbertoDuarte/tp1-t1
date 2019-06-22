package fluxos;

import java.util.Date;
import cliente.Cliente;
import agencia.Agencia;
import automovel.Carro;


public class LocacaoSPrazo extends Locacao{
	// Static final
	private static final long dia = 86400000;
	
	// Atributos
	private double desconto; // De 0% a 100% = 0,00 a 1,00
	
	// M�todos
	public LocacaoSPrazo(Agencia agencia,Cliente cliente, Carro automovel,double desconto) {
		// Construir superclasse
		super(agencia,cliente,automovel);
		// Construir o resto
		this.desconto=desconto;
	}
	@Override
	public void mostraResumo() {
		super.mostraResumo();
		System.out.printf("s/ Prazo; ");
	}
	@Override
	public void mostraCompleto() {
		super.mostraCompleto();
		System.out.println("Desconto:" + desconto);
	}
        @Override
	public double calculaCusto(float valor_diaria) {
		Date data = new Date();
		
		// Obter quantidade de dias no intervalo para multiplicar pela di�ria, e aplicar o desconto.
		return valor_diaria*((data.getTime()-super.tempo.getTime())/dia)*(1-desconto);
	}
	@Override
	public void geraId() { super.geraId();}
	@Override
	public int getId() {return id;}
}