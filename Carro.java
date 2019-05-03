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
        
        this.placa = placa.toLowerCase();
        this.cor = cor.toLowerCase();
        this.ano = ano;
        this.RENAVAM = RENAVAM;
        this.quilometragem = quilometragem;

        this.modelo = modelo;
        modelo.adicionarCarro((this));
    }
    
    public Categoria getCategoria() {return this.categoria;}
    
    public Modelo getModelo() {return this.modelo;}
    
    public void setCategoria(Categoria categoria) {this.categoria = categoria;}
    
    public void modificarModelo(Modelo modelo) {this.modelo = modelo;}
    
    @Override
    public String toString() { 
      return "Carro nº " + this.get_id()+ ", Placa: " + this.placa + ", Modelo " + this.modelo.getNome() + ", Marca: " + this.modelo.getMarca().getNome() + "";
    }

	@Override
	public void mostra_resumo() {System.out.printf("%s", this.toString());}
	
	@Override
	public void mostra_completo() {
		System.out.println("RENAVAM: " + this.RENAVAM);
		System.out.println("Placa: " + this.placa);
		System.out.println("Cor: " + this.cor);
		System.out.println("Ano: " + this.ano);
		System.out.println("Quilometragem: " + this.quilometragem);
		System.out.printf("MARCA: "); 
		System.out.printf("MODELO: "); modelo.mostra_resumo();
		System.out.printf("CATEGORIA: "); categoria.mostra_resumo();
	}
 
}
