/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automovel;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Alberto Duarte
 */
public class ModeloTest {
    
    public ModeloTest() {
    }
    
    @Before
    public void setUpBefore() throws Exception {	
    }

    @After
    public void tearDownAfter() throws Exception {
    }

    /**
     * Teste do método getNome, da classe Modelo.
     */
    @Test
    public void testGetNome() {
        System.out.println("@Test: getNome");
        
        String nome = "Shazam";
        Modelo modelo = new Modelo(nome, "gasolina", 4);
        
        String resultado_esperado = nome.toLowerCase();
        String resultado = modelo.getNome();
        
        assertEquals(resultado_esperado, resultado);
    }

    /**
     * Teste do método getMarca, da classe Modelo.
     */
    @Test
    public void testGetMarca() {
        System.out.println("@Test: getMarca");
        
        Marca marca = new Marca("audiO");
        Modelo modelo = new Modelo("Shazam", "gasolina", 4);
        modelo.setMarca(marca);
        
        Marca resultado_esperado = marca;
        Marca resultado = modelo.getMarca();
        
        assertEquals(resultado_esperado, resultado);
    }

    /**
     * Teste do método setMarca, da classe Modelo.
     */
    @Test
    public void testSetMarca() {
        System.out.println("@Test: setMarca");
        
        Marca marca = new Marca("audiO");
        Modelo modelo = new Modelo("Shazam", "gasolina", 4);
        modelo.setMarca(marca);
        
        Marca resultado_esperado = marca;
        Marca resultado = modelo.getMarca();
        
        assertEquals(resultado_esperado, resultado);
    }

    /**
     * Teste do método getCombustivel, da classe Modelo.
     */
    @Test
    public void testGetCombustivel() {
        System.out.println("@Test: getNome");
        
        String combustivel = "Gasolina";
        Modelo modelo = new Modelo("ShazaM", combustivel, 4);
        
        String resultado_esperado = combustivel.toLowerCase();
        String resultado = modelo.getCombustivel();
        
        assertEquals(resultado_esperado, resultado);
    }

    /**
     * Teste do método getNPortas, da classe Modelo.
     */
    @Test
    public void testGetNPortas() {
        System.out.println("@Test: getNPortas");
        
        int n_portas = 4;
        Modelo modelo = new Modelo("ShazaM", "gasolina", n_portas);
        
        int resultado_esperado = n_portas;
        int resultado = modelo.getNPortas();
        
        assertEquals(resultado_esperado, resultado);
    }

    /**
     * Teste do método setNome, da classe Modelo.
     */
    @Test
    public void testSetNome() {
        System.out.println("@Test: setNome");
        
        String nome = "Shazam";
        String novo_nome = "mOd2";
        Modelo modelo = new Modelo(nome, "gasolina", 4);
        modelo.setNome(novo_nome);
        
        String resultado_esperado = novo_nome.toLowerCase();
        String resultado = modelo.getNome();
        
        assertEquals(resultado_esperado, resultado);
    }

    /**
     * Teste do método setCombustivel, da classe Modelo.
     */
    @Test
    public void testSetCombustivel() {
        System.out.println("@Test: setCombustivel");
        
        String combustivel = "Gasolina";
        String novo_combustivel = "Diesel";
        Modelo modelo = new Modelo("ShazaM", combustivel, 4);
        modelo.setCombustivel(novo_combustivel);
        
        String resultado_esperado = novo_combustivel.toLowerCase();
        String resultado = modelo.getCombustivel();
        
        assertEquals(resultado_esperado, resultado);
    }

    /**
     * Teste do método setNPortas, da classe Modelo.
     */
    @Test
    public void testSetNPortas() {
        System.out.println("@Test: getNPortas");
        
        int n_portas = 4;
        int novo_n_portas = 2;
        Modelo modelo = new Modelo("ShazaM", "gasolina", n_portas);
        modelo.setNPortas(novo_n_portas);
        
        int resultado_esperado = novo_n_portas;
        int resultado = modelo.getNPortas();
        
        assertEquals(resultado_esperado, resultado);
    }

    /**
     * Teste do método setAdicionarCarro, da classe Modelo.
     */
    @Test
    public void testAdicionarCarro() {
        System.out.println("@Test: adicionarCarro");
        
        Carro carro = new Carro("ABC123", "123456", "azul", 2012, 0);
        Modelo modelo = new Modelo("mOd1", "Gasolina", 4);
        modelo.adicionarCarro(carro);
       
        Carro resultado_esperado = carro;
        Carro resultado = modelo.getCarros().get(0);
        
        assertEquals(resultado_esperado, resultado);
    }

    /**
     * Teste do método setNome, da classe Modelo.
     */
    @Test
    public void testRemoverCarro() {
        System.out.println("@Test: removerCarro");
        
        Carro carro = new Carro("ABC123", "123456", "azul", 2012, 0);
        Modelo modelo = new Modelo("mOd1", "Gasolina", 4);
        modelo.adicionarCarro(carro);
        modelo.removerCarro(carro);
       
        int resultado_esperado = 0;
        int resultado = modelo.getCarros().size();
        
        assertEquals(resultado_esperado, resultado);
    }

    /**
     * Test of getCarros method, of class Modelo.
     */
//    @Test
//    public void testGetCarros() {
//        System.out.println("getCarros");
//        Modelo instance = null;
//        List<Carro> expResult = null;
//        List<Carro> result = instance.getCarros();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of toString method, of class Modelo.
     */
//    @Test
//    public void testToString() {
//        System.out.println("toString");
//        Modelo instance = null;
//        String expResult = "";
//        String result = instance.toString();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Teste do método getCarros method, da classe Modelo.
     */
//    @Test
//    public void testGetCarros() {
//        System.out.println("acessa_carros");
//        Modelo instance = null;
//        Carro expResult = null;
//        Carro result = instance.getCarros();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Teste do método toString, da classe Modelo.
     */
//    @Test
//    public void testToString() {
//        System.out.println("toString");
//        Modelo instance = null;
//        String expResult = "";
//        String result = instance.toString();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Teste do método mostraCompleto, da classe Modelo.
     */
//    @Test
//    public void testMostraCompleto() {
//        System.out.println("mostraCompleto");
//        Modelo instance = null;
//        instance.mostraCompleto();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Teste do método mostraResumo, da classe Modelo.
     */
//    @Test
//    public void testMostraResumo() {
//        System.out.println("mostraResumo");
//        Modelo instance = null;
//        instance.mostraResumo();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Teste do método getId, da classe Modelo.
     */
//    @Test
//    public void testGetId() {
//        System.out.println("getId");
//        Modelo instance = null;
//        int expResult = 0;
//        int result = instance.getId();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
}
