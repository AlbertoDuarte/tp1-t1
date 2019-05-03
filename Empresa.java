package trabalhow;
import java.util.ArrayList;
import java.util.Iterator;

public class Empresa {
    private String nome;
    private ArrayList<Agencia> agencias;
    private ArrayList<Cliente> clientes;
    private ArrayList<Categoria> categorias;
    private ArrayList<Marca> marcas;
    
    Empresa(String nome){
        this.nome = nome;
        this.agencias = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.categorias = new ArrayList<>();
        this.marcas = new ArrayList<>();
    }
    
    public void mostra_atributos(){
        System.out.println("Nome da Empresa: " + nome);
        for(Agencia i : this.agencias){
            System.out.println("ID: " + i.id + " | CEP: " + i.CEP);
        }
    }
    public void adiciona_agencia(Agencia agencia){
        for(Agencia i : this.agencias){
            if(i.getId() == agencia.getId()){
                System.out.println("Esta agência já está adicionada.");
                return;
            }
        }
        this.agencias.add(agencia);
    }
    
    public Agencia acessa_agencia(int id){
        for(Agencia i : this.agencias){
            if(i.getId() == id){
                return i;
            }
        }
        System.out.println("Agência não encontrada.");
    }
    
    public void adiciona_cliente(Cliente cliente){
        for(Cliente i : this.clientes){
            if(cliente.getId() == i.getId()){
                System.out.println("Este cliente já está adicionado.");
                return;
            }
        }
        this.clientes.add(cliente);
    }
    
    public Cliente acessa_cliente(int id){
        for(Cliente i : this.clientes){
            if(id == i.getId()){
                return i;
            }
        }
        System.out.println("Cliente não encontrado.");
    }
    
    public void adiciona_categoria(Categoria categoria){
        for(Categoria i : this.categorias){
            if(categoria.getletra() == i.getletra()){
                System.out.println("Esta categoria já está adicionada.");
                return;
            }
        }
        this.categorias.add(categoria);
    }
    public Categoria acessa_categoria(char letra){
        for(Categoria i : this.categorias){
            if(i.getletra() == letra){
                return i;
        }
        System.out.println("Categoria não encontrada.");
    }
    
    public void adiciona_marca(Marca marca){
        for(Marca i : this.marcas){
            if(i.getId() == marca.getId()){
                System.out.println("Esta marca já está adicionada.");
            }
        }
        this.marcas.add(marca);
    }
    public void remove_marca(Marca marca){
        boolean s;
        s = this.marcas.remove(marca);
        if(s){
            System.out.println("Marca removida com sucesso.");
        }
        else{
            System.out.println("Marca não encontrada.");
        }
    }
}
