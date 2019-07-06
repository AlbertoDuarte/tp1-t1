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
        
        this.placa = placa.toUpperCase();
        this.cor = cor.toUpperCase();
        this.ano = ano;
        this.RENAVAM = RENAVAM.toUpperCase();
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
    
    /**
     *  Método para retorno da agencia do carro.
     * 
     * @return Agencia - agencia do carro
     */
    public Agencia getAgencia() {
        return this.agencia;
    }
    
    /**
     *  Método para retorno da placa do carro.
     * 
     * @return String - placa do carro
     */
    public String getPlaca() {
        return this.placa;
    }
    
    /**
     *  Método para retorno do RENAVAM do carro.
     * 
     * @return String - RENAVAM do carro
     */
    public String getRenavam() {
        return this.RENAVAM;
    }
    
    public String getCor() {
        return this.cor;
    }
 
    /**
     *  Método para retorno do ano do carro.
     * 
     * @return int - ano do carro
     */
    public int getAno() {
        return this.ano;
    }
    
    /**
     *  Método para retorno da quilometragem do carro.
     * 
     * @return double - quilometragem do carro
     */
    public double getQuilometragem() {
        return this.quilometragem;
    }
    
    /**
     *  Método para definir categoria do carro.
     * 
     * @param categoria - objeto da classe Categoria
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    /**
     * Método para definir modelo do carro.
     * 
     * @param modelo - objeto da classe Modelo
     */
    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }
    
    /**
     *  Método para definir agencia do carro.
     * 
     * @param agencia - objeto da classe Agencia
     */
    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }
    
    /**
     *  Método para definir cor do carro.
     * 
     * @param cor - objeto da classe String
     */
    public void setCor(String cor) {
        this.cor = cor.toUpperCase();
    }
    
    /**
     *  Método para definir quilometragem do carro.
     * 
     * @param quilometragem - objeto do tipo double
     */
    public void setQuilometragem(double quilometragem) {
        this.quilometragem = quilometragem;
    }
    
    /**
     *  Método que converte as informacoes do carro em String.
     * 
     * @return String - informacoes do carro.
     */
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
