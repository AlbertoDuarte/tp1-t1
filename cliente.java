package cliente;

import Fluxos.devolucao;
import Fluxos.locacao;
import Colecoes.colecao;
import Colecoes.colecionavel;

public class cliente implements colecionavel{
	// Atributos
	static int global_id=0;
	int id;
	private String nome,sobrenome,CPF,email;
	double divida;
	private colecao locacoes;
	// Métodos
	public cliente (String nome, String sobrenome, String CPF,String email)
	{
		locacoes = new colecao(5);
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
	@Override
	public void gera_id() {
		id = global_id;
		global_id++;
	}
	@Override
	public int get_id() {
		return id;
	}
	public void adiciona_locacao(locacao locacao){
		locacoes.adiciona(locacao);
	}
	public locacao acessa_locacoes() {
		return (locacao) locacoes.navega();
	}
	public devolucao devolve(locacao locacao,float valor_diaria) {
		locacoes.remove(locacao.get_id());
		return new devolucao(locacao,locacao.calcula_custo(valor_diaria));
	}
	public devolucao devolve(int id,float valor_diaria) {
		locacao locacao=(locacao) locacoes.remove(id);
		return new devolucao(locacao,locacao.calcula_custo(valor_diaria));
	}
}
