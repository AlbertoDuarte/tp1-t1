package Fluxos;
import trabalhow.Agencia;
import trabalhow.Carro;
import java.util.Date;
import cliente.Cliente;

public class Locacao_c_prazo extends Locacao{
	// Static final
	private static final long dia = 86400000;
	
	// Atributos
	boolean violacao; // Indica se o cliente extrapolou o prazo
	private long prazo; // Em dias
	
	// Métodos
	public Locacao_c_prazo(Agencia agencia,Cliente cliente, Carro automovel,long prazo) {
		// Construir superclasse
		super(agencia,cliente,automovel);
		// Construir o resto
		this.prazo=prazo;
		this.violacao=false;
	}
	@Override
	public void mostra_completo() {
		// Mostra super + o que resta
		super.mostra_completo();
		System.out.println("Prazo: " + this.prazo + " dias; " + "Prazo violado: " + this.violacao);
	}
	public void mostra_resumo() {
		// Mostra super + o que resta
		super.mostra_resumo();
		System.out.printf("c/ Prazo; ");
	}
	@Override
	public double calcula_custo(float valor_diaria) {
		// Obter data atual
		Date data = new Date();
		
		// Obter quantidade de dias no intervalo para verificar se passou do prazo 
		double dias_passados= (data.getTime()-super.tempo.getTime())/dia; // Converter de milisegundos para dias
	
		// Notificar violação do prazo se preciso
		if(dias_passados > prazo){
			this.violacao=true;
			return dias_passados*valor_diaria;
		}
		//else {
			return prazo*valor_diaria; // Caso o cliente tenha entregue antes, vai pagar tudo do mesmo modo >:)
	    //}
	}
	@Override
	public void gera_id() {super.gera_id();}
	@Override
	public int get_id() {return id;}
}