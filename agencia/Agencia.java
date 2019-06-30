package agencia;
import fluxos.Fluxo;

import colecoes.Colecao;
import colecoes.Colecionavel;
import automovel.Carro;
import automovel.ObjetoId;
import java.util.ArrayList;
import java.util.List;

public class Agencia extends ObjetoId{
    private String CEP;
    private List<Carro> carros;
    private List<Fluxo> fluxos;
    
    
    public Agencia(String CEP){
        this.CEP = CEP.toLowerCase();
        this.carros = new ArrayList<>();
        this.fluxos = new ArrayList<>();
    }
    
    public String getCEP() {
        return this.CEP;
    }
    
    public void mostraResumo() {System.out.printf("CEP: %s",CEP);}
    
    public void mostraCompleto() {
        System.out.println("Id: " + this.getId());
        System.out.println("CEP: " + CEP);
        System.out.println("Carros nesta agência: ");
        //carros.mostra();
    }
    
    public void adicionarCarro(Carro carro) {
    	carros.add(carro);       
    }
    
    public void removerCarro(Carro carro) {        
        if(this.carros.remove(carro.getId()) != null)
            System.out.println("Carro removido com sucesso");
        else
            System.out.println("Carro não encontrado");
    }
    
    public void adicionaFluxo(Fluxo fluxo) {
        fluxos.add(fluxo);
    }
    
//    public void mostraHistorico(){
//        fluxos.navega(false);
//    }
}
