/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automovel;

import agencia.Agencia;
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
public class CarroTest {
    
    public CarroTest() {
    }
    
    @Before
    public void setUpBefore() throws Exception {	
    }

    @After
    public void tearDownAfter() throws Exception {
    }
    /**
     * Teste do método getCategoria, da classe Carro.
     */
    @Test
    public void testGetCategoria() {
        System.out.println("@Test: getCategoria");
        
        Categoria categoria = new Categoria("A", 4);
        Carro carro = new Carro("abc", "123456", "azul", 2019, 0);
        carro.setCategoria(categoria);
        
        Categoria resultado_esperado = categoria;
        Categoria resultado = carro.getCategoria();
        assertEquals(resultado_esperado, resultado);
    }

    /**
     * Teste do método getModelo, da classe Carro.
     */
    @Test
    public void testGetModelo() {
        System.out.println("@Test: getModelo");
        
        Modelo modelo = new Modelo("shazam", "gasolina", 4);
        Carro carro = new Carro("abc", "123456", "azul", 2019, 0);
        carro.setModelo(modelo);
        
        Modelo resultado = carro.getModelo();
        assertEquals(modelo, resultado);
    }

    /**
     * Teste do método setCategoria, da classe Carro.
     */
    @Test
    public void testSetCategoria() {
        System.out.println("@Test: getCategoria");
        
        Categoria categoria = new Categoria("A", 4);
        Carro carro = new Carro("abc", "123456", "azul", 2019, 0);
        carro.setCategoria(categoria);
        
        Categoria resultado_esperado = categoria;
        Categoria resultado = carro.getCategoria();
        assertEquals(resultado_esperado, resultado);
    }

    /**
     * Teste do método setModelo , da classe Carro.
     */
    @Test
    public void testSetModelo() {
        System.out.println("@Test: getModelo");
        
        Modelo modelo = new Modelo("shazam", "gasolina", 4);
        Carro carro = new Carro("abc", "123456", "azul", 2019, 0);
        carro.setModelo(modelo);
        
        Modelo resultado = carro.getModelo();
        assertEquals(modelo, resultado);
    }

    /**
     * Teste do método toString , da classe Carro.
     */
    @Test
    public void testToString() {
        System.out.println("@Test: toString");

        Marca marca = new Marca("audiO");
        Modelo modelo = new Modelo("Shazam", "gasolina", 4);
        modelo.setMarca(marca);
        
        Carro carro = new Carro("ABc123", "123456", "azul", 1999, 0);
        int id = carro.getId();
        
        carro.setModelo(modelo);
        
        String resultado_esperado = "Carro n. " + id + ", Placa ABC123, Cor AZUL, Modelo shazam, Marca audio";
        String resultado = carro.toString();
        
        assertEquals(resultado_esperado, resultado);
             
    }

    /**
     * Teste do método getAgencia, da classe Carro.
     */
    @Test
    public void testGetAgencia() {
        System.out.println("@Test: getAgencia");
        
        Carro carro = new Carro("Abc123", "123456", "azul", 2012, 0);
        Agencia agencia = new Agencia("72222273");
        carro.setAgencia(agencia);
        
        Agencia resultado_esperado = carro.getAgencia();
        Agencia resultado = agencia;
        
        assertEquals(resultado_esperado, resultado);
    }

    /**
     * Teste do método getPlaca, da classe Carro.
     */
    @Test
    public void testGetPlaca() {
        System.out.println("@Test: getPlaca");
        
        String placa = "abC123";
        Carro carro = new Carro(placa, "123456", "azul", 2012, 0);

        
        String resultado_esperado = placa.toUpperCase();
        String resultado = carro.getPlaca();
        
        assertEquals(resultado_esperado, resultado);
    }

    /**
     * Teste do método getRenavam, da classe Carro.
     */
    @Test
    public void testGetRenavam() {
        System.out.println("@Test: getRenavam");
        
        String renavam = "123456";
        Carro carro = new Carro("abC123", renavam, "azul", 2012, 0);

        
        String resultado_esperado = renavam.toUpperCase();
        String resultado = carro.getRenavam();
        
        assertEquals(resultado_esperado, resultado);
    }

    /**
     * Teste do método getCor, da classe Carro.
     */
    @Test
    public void testGetCor() {
        System.out.println("@Test: getCor");
        
        String cor = "AzUl";
        Carro carro = new Carro("abC123", "123456", cor, 2012, 0);

        
        String resultado_esperado = cor.toUpperCase();
        String resultado = carro.getCor();
        
        assertEquals(resultado_esperado, resultado);
    }

    /**
     * Teste do método getAno, da classe Carro.
     */
    @Test
    public void testGetAno() {
        System.out.println("@Test: getAno");
        
        int ano = 2012;
        Carro carro = new Carro("abC123", "123456", "AZUL", ano, 0);

        
        int resultado_esperado = ano;
        int resultado = carro.getAno();
        
        assertEquals(resultado_esperado, resultado);
    }

    /**
     * Teste do método getQuilometragem, da classe Carro.
     */
    @Test
    public void testGetQuilometragem() {
        System.out.println("@Test: getQuilometragem");
        
        double quilometragem = 512.5;
        Carro carro = new Carro("abC123", "123456", "AZUL", 2012, quilometragem);

        
        double resultado_esperado = quilometragem;
        double resultado = carro.getQuilometragem();
        
        assertEquals(resultado_esperado, resultado, 0.01);
    }

    /**
     * Teste do método setAgencia, da classe Carro.
     */
    @Test
    public void testSetAgencia() {
        System.out.println("@Test: setAgencia");
        
        Carro carro = new Carro("Abc123", "123456", "azul", 2012, 0);
        Agencia agencia = new Agencia("72222273");
        carro.setAgencia(agencia);
        
        Agencia resultado_esperado = carro.getAgencia();
        Agencia resultado = agencia;
        
        assertEquals(resultado_esperado, resultado);
    }

    /**
     * Teste do método setCor, da classe Carro.
     */
    @Test
    public void testSetCor() {
        System.out.println("@Test: getCor");
        
        String cor = "AzUl";
        String nova_cor = "PrEtO";
        Carro carro = new Carro("abC123", "123456", cor, 2012, 0);
        carro.setCor(nova_cor);
        
        String resultado_esperado = nova_cor.toUpperCase();
        String resultado = carro.getCor();
        
        assertEquals(resultado_esperado, resultado);
    }

    /**
     * Teste do método setQuilometragem, da classe Carro.
     */
    @Test
    public void testSetQuilometragem() {
        System.out.println("@Test: getQuilometragem");
        
        double quilometragem = 512.5;
        double nova_quilometragem = 1001.7;
        Carro carro = new Carro("abC123", "123456", "AZUL", 2012, quilometragem);
        carro.setQuilometragem(nova_quilometragem);

        
        double resultado_esperado = nova_quilometragem;
        double resultado = carro.getQuilometragem();
        
        assertEquals(resultado_esperado, resultado, 0.01);
    }

    /**
     * Test of mostraResumo method, of class Carro.
     */


    /**
     * Test of mostraResumo method, of class Carro.
     */
//    @Test
//    public void testMostraResumo() {
//        System.out.println("mostraResumo");
//        Carro instance = null;
//        instance.mostraResumo();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of mostraCompleto method, of class Carro.
     */
//    @Test
//    public void testMostraCompleto() {
//        System.out.println("mostraCompleto");
//        Carro instance = null;
//        instance.mostraCompleto();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getId method, of class Carro.
     */
//    @Test
//    public void testGetId() {
//        System.out.println("getId");
//        Carro instance = null;
//        int expResult = 0;
//        int result = instance.getId();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
