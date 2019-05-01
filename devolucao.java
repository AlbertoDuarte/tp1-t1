package locacoes;

public class devolucao extends fluxo{
	// Atributos
	double preco;
	locacao locacao;
	
	// Métodos
	public devolucao(locacao locacao,double preco_locacao)
	{
			super(locacao.agencia,locacao.cliente,locacao.automovel);
			this.locacao=locacao;
			this.preco=preco_locacao;
	}
	public void mostra_dados() {
		super.mostra_dados();
		System.out.println("Preco:" + preco);
		System.out.println("Locacao associada:");
		locacao.mostra_dados();
	}
}
