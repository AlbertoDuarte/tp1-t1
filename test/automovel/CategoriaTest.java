/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automovel;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author AlbertoDuarte
 */
public class CategoriaTest {
    
    public CategoriaTest() {
    }
    
    @Before
    public void setUpBefore() throws Exception {	
    }

    @After
    public void tearDownAfter() throws Exception {
    }

    /**
     * Teste do método getLetra , da classe Categoria.
     */
    @Test
    public void testGetLetra() {
        System.out.println("@Test: getLetra");
        
        Categoria categoria = new Categoria("a", 250.99);
        
        String resultado_esperado = "A";
        String resultado = categoria.getLetra();
        
        assertEquals(resultado_esperado, resultado);

    }

    /**
     * Teste do método getValorDiaria, da classe Categoria.
     */
    @Test
    public void testGetValorDiaria() {
        System.out.println("@Test: getValorDiaria");
        
        Categoria categoria = new Categoria("a", 250);
        
        double resultado_esperado = 250;
        double resultado = categoria.getValorDiaria();
        
        assertEquals(resultado_esperado, resultado, 0.01);
    }

    /**
     * Teste do método setLetra, da classe Categoria.
     */
    @Test
    public void testSetLetra() {
        System.out.println("@Test: setLetra");
        
        Categoria categoria = new Categoria("a", 250.99);
        categoria.setLetra("b");
        
        String resultado_esperado = "B";
        String resultado = categoria.getLetra();
        
        assertEquals(resultado_esperado, resultado);
    }

    /**
     * Teste do método setValorDiaria, da classe Categoria.
     */
    @Test
    public void testSetValorDiaria() {
        System.out.println("@Test: setValorDiaria");
        
        Categoria categoria = new Categoria("a", 250.99);
        categoria.setValorDiaria(300.25);
        
        double resultado_esperado = 300.25;
        double resultado = categoria.getValorDiaria();
        
        assertEquals(resultado_esperado, resultado, 0.01);
    }

    /**
     * Teste do método adicionarCarro, da classe Categoria.
     */
    @Test
    public void testAdicionarCarro() {
        System.out.println("@Test: adicionarCarro");
        
        Carro carro = new Carro("ABC123", "123456", "azul", 2012, 0);
        Categoria categoria = new Categoria("A", 123.0);
        categoria.adicionarCarro(carro);
       
        Carro resultado_esperado = carro;
        Carro resultado = categoria.getCarros().get(0);
        
        assertEquals(resultado_esperado, resultado);
    }

    /**
     * Teste do método removerCarro, da classe Categoria.
     */
    @Test
    public void testRemoverCarro() {
        System.out.println("@Test: removerCarro");
        
        Carro carro = new Carro("ABC123", "123456", "azul", 2012, 0);
        Categoria categoria = new Categoria("A", 123.0);
        categoria.adicionarCarro(carro);
        categoria.removerCarro(carro);
       
        int resultado_esperado = 0;
        int resultado = categoria.getCarros().size();
        
        assertEquals(resultado_esperado, resultado);
    }

    /**
     * Teste do método getCarros method, da classe Categoria.
     */
//    @Test
//    public void testGetCarros() {
//        System.out.println("acessa_carros");
//        Categoria instance = null;
//        Carro expResult = null;
//        Carro result = instance.getCarros();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Teste do método toString, da classe Categoria.
     */
//    @Test
//    public void testToString() {
//        System.out.println("toString");
//        Categoria instance = null;
//        String expResult = "";
//        String result = instance.toString();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Teste do método getId, da classe Categoria.
     */
//    @Test
//    public void testGetId() {
//        System.out.println("getId");
//        Categoria instance = null;
//        int expResult = 0;
//        int result = instance.getId();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Teste do método mostraResumo, da classe Categoria.
     */
//    @Test
//    public void testMostraResumo() {
//        System.out.println("mostraResumo");
//        Categoria instance = null;
//        instance.mostraResumo();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Teste do método mostraCompleto, da classe Categoria.
     */
//    @Test
//    public void testMostraCompleto() {
//        System.out.println("mostraCompleto");
//        Categoria instance = null;
//        instance.mostraCompleto();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
}
