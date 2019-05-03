package Fluxos;

import java.util.Date;
import cliente.Cliente;
import trabalhow.Agencia;
import trabalhow.Carro;


public class Locacao_s_prazo extends Locacao{
	// Static final
	private static final long dia = 86400000;
	
	// Atributos
	private double desconto; // De 0% a 100% = 0,00 a 1,00
	
	// Métodos
	public Locacao_s_prazo(Agencia agencia,Cliente cliente, Carro automovel,double desconto) {
		// Construir superclasse
		super(agencia,cliente,automovel);
		// Construir o resto
		this.desconto=desconto;
	}
	@Override
	public void mostra_resumo() {
		super.mostra_resumo();
		System.out.printf("s/ Prazo; ");
	}
	@Override
	public void mostra_completo() {
		super.mostra_completo();
		System.out.println("Desconto:" + desconto);
	}
	public double calcula_custo(float valor_diaria) {
		Date data = new Date();
		
		// Obter quantidade de dias no intervalo para multiplicar pela diária, e aplicar o desconto.
		return valor_diaria*((data.getTime()-super.tempo.getTime())/dia)*(1-desconto);
	}
	@Override
	public void gera_id() { super.gera_id();}
	@Override
	public int get_id() {return id;}
}