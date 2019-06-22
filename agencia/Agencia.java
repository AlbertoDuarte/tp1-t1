package agencia;
import fluxos.Fluxo;

import colecoes.Colecao;
import colecoes.Colecionavel;
import automovel.Carro;

public class Agencia implements Colecionavel{
    private static int countId = 1;
    private int id;
    private String CEP;
    private Colecao carros;
    private Colecao fluxos;
    
    
    Agencia(String CEP){
        this.id = Agencia.countId;
        Agencia.countId++;
        this.CEP = CEP.toLowerCase();
        this.carros = new Colecao(5);
        this.fluxos = new Colecao(5);
    }
    
    @Override
    public int getId(){
        return this.id;
    }
    public void mostraResumo() {System.out.printf("CEP: %s",CEP);}
    
    public void mostraCompleto(){
        System.out.println("Id: " + id);
        System.out.println("CEP: " + CEP);
        System.out.println("Carros nesta agência: ");
        carros.mostra();
    }
    
    public void adicionarCarro(Carro carro){
    	if(!carros.adiciona(carro))
    		System.out.println("Carro ja esta adicionado na agencia!");         
    }
    
    public void removerCarro(Carro carro){        
        if(this.carros.remove(carro.get_id()) != null)
            System.out.println("Carro removido com sucesso");
        else
            System.out.println("Carro não encontrado");
    }
    
    public void adicionaFluxo(Fluxo fluxo){
        fluxos.adiciona((Colecionavel) fluxo);
    }
    
    public void mostraHistorico(){
        fluxos.navega(false);
    }
}
