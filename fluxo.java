package locacoes;
import java.util.Date;
import cliente.cliente;
import undefined_test.agencia;
import undefined_test.automovel;

public abstract class fluxo {
	// Atributos
	protected agencia agencia;
	protected cliente cliente;
	protected automovel automovel;
	protected Date tempo;
	
	// Métodos
	protected fluxo(agencia agencia,cliente cliente, automovel automovel) {
		// Gravar atributos
		this.tempo=new Date();
		this.agencia=agencia;
		this.cliente=cliente;
		this.automovel=automovel;
	};
	public void mostra_dados() {
		System.out.println("Data: " + this.tempo.toString());
		System.out.println("AGENCIA:");
		this.agencia.mostra_dados();
		System.out.println("CLIENTE:");
		this.cliente.mostra_dados();
		System.out.println("AUTOMOVEL:");
		this.automovel.mostra_dados();
	}
	public void mostra_resumo() {
		System.out.println("Data: " + this.tempo.toString());
	}
}
