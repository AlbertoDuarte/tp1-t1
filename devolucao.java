package Fluxos;

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
	public void mostra_completo() {
		super.mostra_completo();
		System.out.println("Preco:" + preco);
		System.out.println("Locacao associada:");
		locacao.mostra_resumo();
	}
	public void mostra_resumo() {
		super.mostra_resumo();
		System.out.printf("Preco: %f; ", preco);
	}
	@Override
	public void gera_id() { super.gera_id();}
	@Override
	public int get_id() {return id;}
}
