package Colecoes;

import java.util.ArrayList;
import java.util.Scanner;

public class colecao{
	// Atributos 
	ArrayList<colecionavel> vetor;
	int selecao;
	int tamanho_da_pagina;
	
	// Métodos
	public colecao(int tamanho_da_pagina){
		this.tamanho_da_pagina=tamanho_da_pagina;
		this.vetor = new ArrayList<colecionavel>();
	}
	public void adiciona(colecionavel objeto) {
		// Inserir ordenado
		int r = this.vetor.size() - 1;
		int l=0,i=0;
		
		// Busca binária, até l = r = i
		while(l<r)
		{
			i=(l+r)/2;
			
			if(objeto.get_id() < this.vetor.get(i).get_id())
				r=i;	// Descartar após índice i
			else // c.c
				l=i+1;	// Descartar antes e no índice i
		}
		this.vetor.add(i,objeto);
	}
	public colecionavel procura(int id) {
		int r = this.vetor.size() - 1;
		int l=0,i;
		colecionavel atual;
		// Busca binária, até um intervalo [l,r] inexistente
		while(l<=r)
		{
			i=(l+r)/2;
			
			atual = this.vetor.get(i);
			if(id == atual.get_id())
				return atual;
			else
			if(id < atual.get_id())
				r=i-1;	// Descartar após e no índice i
			else // c.c
				l=i+1;	// Descartar antes e no índice i
		}
		// Não existe
		return null;
	}
	public colecionavel remove(int id) {
		int r = this.vetor.size() - 1;
		int l=0,i;
		colecionavel atual;
		// Busca binária, até um intervalo [l,r] inexistente
		while(l<=r)
		{
			i=(l+r)/2;
			
			atual = this.vetor.get(i);
			if(id == atual.get_id())
				return this.vetor.remove(i);
			else
			if(id < atual.get_id())
				r=i-1;	// Descartar após e no índice i
			else // c.c
				l=i+1;	// Descartar antes e no índice i
		}
		// Não existe
		return null;
	}
	public void mostra() {
		for(colecionavel i: this.vetor) {
			System.out.printf(" |ID: %d | Dados:", i.get_id());
			i.mostra_resumo();
		}
	}
	public colecionavel navega() {
		Scanner input = new Scanner(System.in);
		
		int primeiro_da_pagina;
		char escolha;
		
		do
		{			
			// VOU COLOCAR LINHAS MSM :V
			for(int k=0;k<40;k++)
				System.out.printf("\n");
			
			// Mostra seleção
			System.out.println("#######################");
			System.out.printf( "|ID: %d|\n",this.vetor.get(selecao).get_id());
			this.vetor.get(selecao).mostra_completo();			
			System.out.println("#######################");
			System.out.println("Use 'w' e 's' para escolher.");
			System.out.println("Use 'a' e 'd' para mudar de pagina.");
			System.out.println("Use 'c' para selecionar");
			System.out.println("Use 'r' para cancelar.");
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
					System.out.printf("| ID %015d | => ", vetor.get(i).get_id());
					vetor.get(i).mostra_resumo();
				}
				else
					System.out.printf("\n");
			}
			System.out.printf("\n");
			System.out.println("Pagina " + primeiro_da_pagina/tamanho_da_pagina + " de " + vetor.size()/tamanho_da_pagina);
			
			escolha = input.nextLine().charAt(0); // NAO SEI COLETAR UM CHAR CONTANDO  COM O \n
			System.out.println(escolha);
			
			switch (escolha){
			 	// Cancelar
				case 'r': input.close(); return null;
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
		while(escolha != '\n');
		
		input.close();
		
		return this.vetor.get(selecao);
	}
	public void reset(){this.selecao=0;}
}
