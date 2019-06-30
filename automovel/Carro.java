/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automovel;

import agencia.Agencia;

/**
 *
 * @author AlbertoDuarte
 */
public class Carro extends ObjetoId{    
    private Categoria categoria;
    private Modelo modelo;
    private Agencia agencia;
    
    private String placa;
    private String cor;
    private String RENAVAM;
    private int ano;
    private double quilometragem;
    
    public Carro(String placa, String RENAVAM, String cor, int ano, double quilometragem) {
        this.categoria = null;
        this.agencia = null;
        
        this.placa = placa.toLowerCase();
        this.cor = cor.toLowerCase();
        this.ano = ano;
        this.RENAVAM = RENAVAM;
        this.quilometragem = quilometragem;
    }
    
    /**
     * Método para retorno da categoria do carro.
     * 
     * @return Categoria - categoria do carro
     */
    public Categoria getCategoria() {
        return this.categoria;
    }
    
    /**
     *  Método para retorno do modelo do carro.
     * 
     * @return Modelo - modelo do carro
     */
    public Modelo getModelo() {
        return this.modelo;
    }
    
    public Agencia getAgencia() {
        return this.agencia;
    }
    
    public String getPlaca() {
        return this.placa;
    }
    
    public String getRenavam() {
        return this.RENAVAM;
    }
    
    public String getCor() {
        return this.cor;
    }
    
    public int getAno() {
        return this.ano;
    }
    
    public double getQuilometragem() {
        return this.quilometragem;
    }
    
    /**
     *  Método para definir categoria do carro.
     * 
     * @param categoria - Objeto da classe Categoria
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    /**
     * Método para definir modelo do carro.
     * 
     * @param modelo - Objeto da classe Modelo
     */
    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }
    
    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }
    
    @Override
    public String toString() { 
      return "Carro n. " + this.getId()+ ", Placa " + this.placa + ", Cor " + this.cor + ", Modelo " + this.modelo.getNome() + ", Marca " + this.modelo.getMarca().getNome() + "";
    }

    /**
     * TODO:
     */
    @Override
    public void mostraResumo() {
        System.out.printf("%s", this.toString());
    }
	
    /**
     * TODO:
     */
    @Override
    public void mostraCompleto() {
	System.out.println("RENAVAM: " + this.RENAVAM);
	System.out.println("Placa: " + this.placa);
	System.out.println("Cor: " + this.cor);
	System.out.println("Ano: " + this.ano);
	System.out.println("Quilometragem: " + this.quilometragem);
	System.out.printf("MARCA: "); 
	System.out.printf("MODELO: "); modelo.mostraResumo();
	System.out.printf("CATEGORIA: "); categoria.mostraResumo();
    }
}
