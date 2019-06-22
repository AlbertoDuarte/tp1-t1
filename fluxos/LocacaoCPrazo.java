package fluxos;
import agencia.Agencia;
import automovel.Carro;
import java.util.Date;
import cliente.Cliente;

public class LocacaoCPrazo extends Locacao{
	// Static final
	private static final long dia = 86400000;
	
	// Atributos
	boolean violacao; // Indica se o cliente extrapolou o prazo
	private long prazo; // Em dias
	
	// M�todos
	public LocacaoCPrazo(Agencia agencia,Cliente cliente, Carro automovel,long prazo) {
		// Construir superclasse
		super(agencia,cliente,automovel);
		// Construir o resto
		this.prazo=prazo;
		this.violacao=false;
	}
	@Override
	public void mostraCompleto() {
		// Mostra super + o que resta
		super.mostraCompleto();
		System.out.println("Prazo: " + this.prazo + " dias; " + "Prazo violado: " + this.violacao);
	}
        @Override
	public void mostraResumo() {
		// Mostra super + o que resta
		super.mostraResumo();
		System.out.printf("c/ Prazo; ");
	}
	@Override
	public double calculaCusto(float valor_diaria) {
		// Obter data atual
		Date data = new Date();
		
		// Obter quantidade de dias no intervalo para verificar se passou do prazo 
		double dias_passados= (data.getTime()-super.tempo.getTime())/dia; // Converter de milisegundos para dias
	
		// Notificar viola��o do prazo se preciso
		if(dias_passados > prazo){
			this.violacao=true;
			return dias_passados*valor_diaria;
		}
		//else {
			return prazo*valor_diaria; // Caso o cliente tenha entregue antes, vai pagar tudo do mesmo modo >:)
	    //}
	}
	@Override
	public void geraId() {super.geraId();}
	@Override
	public int getId() {return id;}
}