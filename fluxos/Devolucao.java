package fluxos;

public class Devolucao extends Fluxo{
	// Atributos
	double preco;
	Locacao locacao;
	
	// M�todos
	public Devolucao(Locacao locacao,double preco_locacao)
	{
			super(locacao.agencia,locacao.cliente,locacao.automovel);
			this.locacao=locacao;
			this.preco=preco_locacao;
	}
	public void mostraCompleto() {
		super.mostraCompleto();
		System.out.println("Preco:" + preco);
		System.out.println("Locacao associada:");
		locacao.mostraResumo();
	}
	public void mostraResumo() {
		super.mostraResumo();
		System.out.printf("Preco: %f; ", preco);
	}
	@Override
	public void geraId() { super.geraId();}
	@Override
	public int getId() {return id;}
}
