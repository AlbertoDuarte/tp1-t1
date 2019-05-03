package trabalhow;

import Colecoes.Colecao;
import cliente.Cliente;
import trabalhow.Agencia;
import trabalhow.Categoria;

public class Empresa {
    private String nome;
    private Colecao agencias;
    private Colecao clientes;
    private Colecao categorias;
    private Colecao marcas;
    
    Empresa(String nome){
        this.nome = nome;
    }
    
    public void mostra_atributos(){
        System.out.println("Nome da Empresa: " + nome);
        System.out.println("AGENCIAS:");
        agencias.mostra();
    }
    // AGENCIAS
    public void adiciona(Agencia agencia){
        if(!agencias.adiciona(agencia))
                System.out.println("Esta agência já está adicionada.");
    }
    
    public Agencia acessa_agencia(){
    	return (Agencia) agencias.navega(true);
    }
    // CLIENTES
    public void adiciona(Cliente cliente_novo){
        if(!clientes.adiciona(cliente_novo))
        	System.out.println("Este cliente já está adicionado.");
    }
    
    public Cliente acessa_clientes(){
        return (Cliente) clientes.navega(true);
    }
    
    // CATEGORIAS
    public void adiciona(Categoria categoria){
        if(!categorias.adiciona(categoria))
                System.out.println("Esta categoria já está adicionada.");
    }
    public Categoria acessa_categorias(){
    	return (Categoria) categorias.navega(true);
    }
    
    // MARCAS
    public void adiciona(Marca marca){
        if(!marcas.adiciona(marca))
                System.out.println("Esta marca já está adicionada.");
    }
    public void remove(Marca marca){
        if(marcas.remove(marca.get_id())!=null)
            System.out.println("Marca removida com sucesso.");
        else
            System.out.println("Marca não encontrada.");
    }
}
