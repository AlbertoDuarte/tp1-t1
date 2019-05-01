package locacoes;

import java.util.Date;
import cliente.cliente;
import undefined_test.agencia;
import undefined_test.automovel;


public class locacao_s_prazo extends locacao{
	// Static final
	private static final long dia = 86400000;
	
	// Atributos
	private double desconto; // De 0% a 100% = 0,00 a 1,00
	
	// Métodos
	public locacao_s_prazo(agencia agencia,cliente cliente, automovel automovel,double desconto) {
		// Construir superclasse
		super(agencia,cliente,automovel);
		// Construir o resto
		this.desconto=desconto;
	}
	@Override
	public void mostra_dados() {
		super.mostra_dados();
		System.out.println("Desconto:" + desconto);
	}
	public double calcula_custo(float valor_diaria) {
		Date data = new Date();
		
		// Obter quantidade de dias no intervalo para multiplicar pela diária, e aplicar o desconto.
		return valor_diaria*((data.getTime()-super.tempo.getTime())/dia)*(1-desconto);
	}
}