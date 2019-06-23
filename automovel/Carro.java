/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automovel;

/**
 *
 * @author AlbertoDuarte
 */
public class Carro extends ObjetoId{
    private static int countId = 1;
    
    private Categoria categoria;
    private Modelo modelo;
    
    private String placa;
    private String cor;
    private int ano;
    private int RENAVAM;
    private int quilometragem;
    
    Carro(Modelo modelo, String placa, String cor, int ano, int RENAVAM, int quilometragem) {
        super(Carro.countId);
        Carro.countId++;
        
        this.categoria = null;
        this.placa = placa.toLowerCase();
        this.cor = cor.toLowerCase();
        this.ano = ano;
        this.RENAVAM = RENAVAM;
        this.quilometragem = quilometragem;

        this.modelo = modelo;
        modelo.adicionarCarro((this));
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
