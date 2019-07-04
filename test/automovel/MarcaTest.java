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
public class MarcaTest {
    
    public MarcaTest() {
    }
    
    @Before
    public void setUpBefore() throws Exception {	
    }

    @After
    public void tearDownAfter() throws Exception {
    }

    /**
     * Teste do método getNome, da classe Marca.
     */
    @Test
    public void testGetNome() {
        System.out.println("@Test: getNome");
        
        String nome = "audiO";
        Marca marca = new Marca(nome);
        
        String resultado_esperado = nome.toLowerCase();
        String resultado = marca.getNome();
        
        assertEquals(resultado_esperado, resultado);
    }
    
    @Test
    public void testSetNome() {
        System.out.println("@Test: getNome");
        
        String nome = "audiO";
        String novo_nome = "ShazaM";
        Marca marca = new Marca(nome);
        marca.setNome(novo_nome);
        
        String resultado_esperado = novo_nome.toLowerCase();
        String resultado = marca.getNome();
        
        assertEquals(resultado_esperado, resultado);
    }

    /**
     * Teste do método adicionarModelo, da classe Marca.
     */
    @Test
    public void testAdicionarModelo() {
        System.out.println("@Test: adicionarModelo");
        
        Modelo modelo = new Modelo("marca", "gasolina", 4);
        Marca marca = new Marca("audiO");
        marca.adicionarModelo(modelo);
       
        Modelo resultado_esperado = modelo;
        Modelo resultado = marca.getModelos().get(0);
        
        assertEquals(resultado_esperado, resultado);
    }

    /**
     * Teste do método removerModelo, da classe Marca.
     */
    @Test
    public void testRemoverModelo() {
        System.out.println("@Test: removerModelo");
        
        Modelo modelo = new Modelo("marca", "gasolina", 4);
        Marca marca = new Marca("audiO");
        marca.adicionarModelo(modelo);
        marca.removerModelo(modelo);
       
        int resultado_esperado = 0;
        int resultado = marca.getModelos().size();
        
        assertEquals(resultado_esperado, resultado);
    }

    /**
     * Teste do método getModelos, da classe Marca.
     */
//    @Test
//    public void testGetModelos() {
//        System.out.println("acessa_Modelos");
//        Marca instance = null;
//        Modelo expResult = null;
//        Modelo result = instance.getModelos();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Teste do método toString, da classe Marca.
     */
//    @Test
//    public void testToString() {
//        System.out.println("toString");
//        Marca instance = null;
//        String expResult = "";
//        String result = instance.toString();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Teste do método of mostraResumo, da classe Marca.
     */
//    @Test
//    public void testMostraResumo() {
//        System.out.println("mostraResumo");
//        Marca instance = null;
//        instance.mostraResumo();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Teste do método mostraCompleto, da classe Marca.
     */
//    @Test
//    public void testMostraCompleto() {
//        System.out.println("mostraCompleto");
//        Marca instance = null;
//        instance.mostraCompleto();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Teste do método getId, da classe Marca.
     */
//    @Test
//    public void testGetId() {
//        System.out.println("getId");
//        Marca instance = null;
//        int expResult = 0;
//        int result = instance.getId();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
