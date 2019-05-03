package cliente;

import Fluxos.Locacao;
import Colecoes.Colecao;
import Fluxos.Devolucao;
import Colecoes.Colecionavel;

public class Cliente implements Colecionavel{
	// Atributos
	static int global_id=0;
	int id;
	private String nome,sobrenome,CPF,email;
	double divida;
	private Colecao locacoes;
	// Métodos
	public Cliente (String nome, String sobrenome, String CPF,String email)
	{
		locacoes = new Colecao(5);
		gera_id();
		
		this.nome=nome;
		this.sobrenome=sobrenome;
		this.CPF=CPF;
		this.email=email;
		divida=0;
	}
	@ Override
	public void mostra_completo() {
		System.out.println("Nome: " + nome);
		System.out.println("Sobreome: " + sobrenome);
		System.out.println("CPF: " + CPF);
		System.out.println("Email: " + email);
	}
	@ Override
	public void mostra_resumo()	{
		System.out.println("Nome completo: " + this.nome + " " + this.sobrenome);
	}
	public void gera_id() {
		id = global_id;
		global_id++;
	}
	@Override
	public int get_id() {
		return id;
	}
	public void adiciona_locacao(Locacao locacao){
		locacoes.adiciona(locacao);
	}
	public Locacao acessa_locacoes() {
		return (Locacao) this.locacoes.navega(true);
	}
	public Devolucao devolve(Locacao locacao,float valor_diaria) {
		locacoes.remove(locacao.get_id());
		return new Devolucao(locacao,locacao.calcula_custo(valor_diaria));
	}
	public Devolucao devolve(int id,float valor_diaria) {
		Locacao locacao=(Locacao) locacoes.remove(id);
		return new Devolucao(locacao,locacao.calcula_custo(valor_diaria));
	}
}
