package trabalhow;
import java.util.ArrayList;
import java.util.Iterator;

public class Agencia {
    private static int countId = 1;
    private int id;
    private String CEP;
    private ArrayList<Carro> carros;
    private ArrayList<Fluxo> fluxos;
    
    
    Agencia(String CEP){
        this.id = Agencia.countId;
        Agencia.countId++;
        this.CEP = CEP.toLowerCase/();
        this.carros = new ArrayList<>();
    }
    
    public void getId(){
        return this.id;
    }
    
    public void mostrar_atributoss(){
        System.out.println("Id: " + id);
        System.out.println("CEP: " + CEP);
        System.out.println("ID dos carros nesta agência: ");
        for (Carro i : this.carros) {
            System.out.print(i.id + "\n");
        }
    }
    
    public void adicionarCarro(Carro carro){
        for (Carro i : this.carros) {
            if(carro.getId() == i.getId()) {
                System.out.println("Carro ja esta adicionado na agencia!");
                return;
            }
        }
        this.carros.add(carro);
    }
    
    public void removerCarro(Carro carro){
        boolean s;
        s = this.carros.remove(carro);
        if(s){
            System.out.println("Carro removido com sucesso");
        }
        else{
            System.out.println("Carro não encontrado");
        }
    }
    
    public void adiciona_fluxo(Fluxo fluxo){
        this.fluxos.add(fluxo);
    }
    
    public void mostra_historico(){
        for(Fluxo i : this.fluxos){
            System.out.println(i.date);
        }
    }
}
