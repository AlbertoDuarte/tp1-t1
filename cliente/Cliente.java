package cliente;

import fluxos.Locacao;
import colecoes.Colecao;
import fluxos.Devolucao;
import colecoes.Colecionavel;

public class Cliente implements Colecionavel{
	// Atributos
	static int global_id=0;
	int id;
	private String nome,sobrenome,CPF,email;
	double divida;
	private Colecao locacoes;
	// M�todos
	public Cliente (String nome, String sobrenome, String CPF,String email)
	{
		locacoes = new Colecao(5);
		geraId();
		
		this.nome=nome;
		this.sobrenome=sobrenome;
		this.CPF=CPF;
		this.email=email;
		divida=0;
	}
	@Override
	public void mostraCompleto() {
		System.out.println("Nome: " + nome);
		System.out.println("Sobreome: " + sobrenome);
		System.out.println("CPF: " + CPF);
		System.out.println("Email: " + email);
	}
	@ Override
	public void mostraResumo()	{
		System.out.println("Nome completo: " + this.nome + " " + this.sobrenome);
	}
	public void geraId() {
		id = global_id;
		global_id++;
	}
	@Override
	public int getId() {
		return id;
	}
	public void adicionaLocacao(Locacao locacao){
		locacoes.adiciona((Colecionavel) locacao);
	}
	public Locacao acessaLocacoes() {
		return (Locacao) this.locacoes.navega(true);
	}
	public Devolucao devolve(Locacao locacao,float valor_diaria) {
		locacoes.remove(locacao.getId());
		return new Devolucao(locacao,locacao.calculaCusto(valor_diaria));
	}
	public Devolucao devolve(int id,float valor_diaria) {
		Locacao locacao=(Locacao) locacoes.remove(id);
		return new Devolucao(locacao,locacao.calculaCusto(valor_diaria));
	}
}
