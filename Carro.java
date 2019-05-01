/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhow;

/**
 *
 * @author root
 */
public class Carro extends ObjetoId {
    private static int countId = 1;
    
    private Modelo modelo;
    
    private String placa;
    private String cor;
    private int ano;
    private int RENAVAM;
    private int quilometragem;
    
    Carro(Modelo modelo, String placa, String cor, int ano, int RENAVAM, int quilometragem) {
        super(Carro.countId);
        Carro.countId++;
        
        this.placa = placa.toLowerCase();
        this.cor = cor.toLowerCase();
        this.ano = ano;
        this.RENAVAM = RENAVAM;
        this.quilometragem = quilometragem;

        this.modelo = modelo;
        modelo.adicionarCarro((this));
    }
    
    public Modelo getModelo() {
        return this.modelo;
    }
    
    public void modificarModelo(Modelo modelo) {
        this.modelo = modelo;
    }
   
    @Override
    public String toString() { 
      return "Carro nº " + this.getId()+ ", Placa: " + this.placa + ", Modelo " + this.modelo.getNome() + ", Marca: " + this.modelo.getMarca().getNome() + "";
    } 
}
