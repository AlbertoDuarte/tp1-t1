package colecoes;

import java.util.ArrayList;
import java.util.Scanner;

public class Colecao{
	// Atributos 
	ArrayList<Colecionavel> vetor;
	int selecao;
	int tamanho_da_pagina;
	
	// Métodos
	public Colecao(int tamanho_da_pagina){
		this.tamanho_da_pagina=tamanho_da_pagina;
		this.vetor = new ArrayList<Colecionavel>();
	}
	public boolean adiciona(Colecionavel objeto) {
		// Inserir ordenado
		int r = this.vetor.size(); // Inclui a posição vaga
		int l=0,i=r/2;
		
		// Busca binária, até l = r = i
		while(l<r)
		{
			if(objeto.getId() == this.vetor.get(i).getId())
				return false;
			
			if(objeto.getId() < this.vetor.get(i).getId())
				r=i;	// Descartar após índice i
			else // c.c
				l=i+1;	// Descartar antes e no índice i

			i=(l+r)/2;
		}
		
		this.vetor.add(i,objeto);
		return true;
	}
	public Colecionavel procura(int id) {
		int r = this.vetor.size() - 1;
		int l=0,i;
		Colecionavel atual;
		// Busca binária, até um intervalo [l,r] inexistente
		while(l<=r)
		{
			i=(l+r)/2;
			
			atual = this.vetor.get(i);
			if(id == atual.getId())
				return atual;
			else
			if(id < atual.getId())
				r=i-1;	// Descartar após e no índice i
			else // c.c
				l=i+1;	// Descartar antes e no índice i
		}
		// Não existe
		return null;
	}
	public Colecionavel remove(int id) {
		int r = this.vetor.size() - 1;
		int l=0,i;
		Colecionavel atual;
		// Busca binária, até um intervalo [l,r] inexistente
		while(l<=r)
		{
			i=(l+r)/2;
			
			atual = this.vetor.get(i);
			if(id == atual.getId())
				return this.vetor.remove(i);
			else
			if(id < atual.getId())
				r=i-1;	// Descartar após e no índice i
			else // c.c
				l=i+1;	// Descartar antes e no índice i
		}
		// Não existe
		return null;
	}
	public void mostra() {
		for(Colecionavel i: this.vetor) {
			System.out.printf(" |ID: %d | Dados:", i.getId());
			i.mostraResumo();
		}
	}
	@SuppressWarnings("resource")
	public Colecionavel navega(boolean select) {
		int primeiro_da_pagina;
		Scanner input = new Scanner(System.in);
		String escolha;
		do {						
			// VOU COLOCAR LINHAS MSM :V
			for(int k=0;k<40;k++)
				System.out.printf("\n");
			
			System.out.println("#######################");
			System.out.println("Use 'w' e 's' para escolher.");
			System.out.println("Use 'a' e 'd' para mudar de pagina.");
			if(select)
			{
				System.out.println("Use 'ENTER' para selecionar");
				System.out.println("Use 'r' para cancelar.");
			}
			else
				System.out.println("Use 'r' para sair.");
			System.out.println("#######################");
			// Mostra lista
			primeiro_da_pagina = (selecao)-(selecao)%(tamanho_da_pagina);
			for(int i = primeiro_da_pagina; i < primeiro_da_pagina + tamanho_da_pagina; i++)
			{
				if(0<=i && i<vetor.size())
				{	
					// Seleção
					if(i == selecao)
						System.out.printf(">> ");
					else
						System.out.printf("   ");
					// Conteudo
					System.out.printf("| ID %015d | => ", vetor.get(i).getId());
					vetor.get(i).mostraResumo();
				}
				else
					System.out.printf("\n");
			}
			System.out.printf("\n");
			System.out.println("Pagina " + primeiro_da_pagina/tamanho_da_pagina + " de " + vetor.size()/tamanho_da_pagina);
			
			escolha = new String(input.nextLine());
			System.out.println(escolha);
			
			if (escolha.length()==0)
			{				
				do {
					// VOU COLOCAR LINHAS MSM :V
					for(int k=0;k<40;k++)
						System.out.printf("\n");
					
					System.out.println("#######################");
					if(select) {
						System.out.println("Use 'ENTER' para confirmar");
						System.out.println("Use 'r' para cancelar.");
					}
					else
						System.out.println("Use 'r' para voltar.");
					System.out.println("#######################");
					System.out.printf( "|ID: %015d|\n",this.vetor.get(selecao).getId());
					this.vetor.get(selecao).mostraCompleto();
					
					escolha = new String(input.nextLine());
					if(select && escolha.length()==0)
					{
						input.close();
						return this.vetor.get(selecao);
					}
				}
				while(escolha.length()==0 || escolha.charAt(0)!='r');
				escolha = new String("k");
			}
			else
			{
				switch (escolha.charAt(0)) {
					// Escolher
					case 'w': if(selecao > 0) selecao--; break;
					case 's': if(selecao + 1 < vetor.size()) selecao++; break;
					// Mudar página
					case 'a': if(primeiro_da_pagina >= tamanho_da_pagina)  selecao= primeiro_da_pagina - tamanho_da_pagina; break;
					case 'd': {
						if(primeiro_da_pagina + tamanho_da_pagina < vetor.size()) 
							selecao = primeiro_da_pagina + tamanho_da_pagina;
					}
				}
			}
		}
		while(escolha.charAt(0) != 'r');
		
		// Cancelar
		return null;
	}
	public void reset(){this.selecao=0;}
}
