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
public class Trabalhow {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Marca marca1 = new Marca("marca1");
        Modelo modelo1 = new Modelo(marca1, "modelo1", "gasolina", 4);
                
        Carro carro1, carro2;
        carro1 = new Carro(modelo1, "aaa123", "azul", 2018, 123456789, 2000);
        carro2 = new Carro(modelo1, "bbb321", "branco", 2018, 987654321, 2500);
        
        System.out.println(carro1.getId());
        System.out.println(carro2.getId());
        
        System.out.println(carro1.getModelo().getNome());
        System.out.println(carro2.getModelo().getNome());
        
        System.out.println(carro1.getModelo().getMarca().getNome());
        System.out.println(carro2.getModelo().getMarca().getNome());
        
        System.out.println(carro1.toString());
        System.out.println(carro2.toString());
        System.out.println(modelo1.toString());
        System.out.println(marca1.toString());
    }
    
}
