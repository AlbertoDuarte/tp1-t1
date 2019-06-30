/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import agencia.Agencia;
import automovel.Carro;
import automovel.Categoria;
import automovel.Marca;
import automovel.Modelo;
import dao.DaoAgencia;
import dao.DaoCarro;
import dao.DaoCategoria;
import dao.DaoMarca;
import dao.DaoModelo;
import java.sql.SQLException;
import java.util.Optional;

/**
 *
 * @author root
 */
public class main  {
    
    public static void main(String args[]) throws SQLException {

        
        DaoMarca daomarca = new DaoMarca();
        
        // inicializacao do daomodelo requer daomarca para realizar as associacoes
        DaoModelo daomodelo = new DaoModelo(daomarca);
        
        DaoCategoria daocategoria = new DaoCategoria();

        DaoAgencia daoagencia = new DaoAgencia();
        
        // inicializacao do daocarro requer daomodelo, daocategoria e daoagencia
        // para realizar a associacao carro-modelo, carro-categoria e carro-agencia
        DaoCarro daocarro = new DaoCarro(daomodelo, daocategoria, daoagencia);
        
        
        for(Carro carro : daocarro.getTodos()) {
            System.out.println(carro.toString());
        }
        
        // Simples construcao dos objetos
        Agencia agencia = new Agencia("72222225");
        Categoria categoria = new Categoria("C", 250.00);
        
        Carro carro = new Carro("ABC123", "123123", "branco", 2018, 0.0);
        Modelo modelo = new Modelo("modelox2", "gasolina", 4);
        Marca marca = new Marca("marcax2");
        
        // Antes de salvar carro, todos os seus atributos (modelo, agencia e categoria) precisam estar setados
        // Pois é necessária suas chaves para que sejam inseridas no banco de dados
        // Mesma coisa pro modelo
        modelo.setMarca(marca);
        carro.setModelo(modelo);
        carro.setAgencia(agencia);
        carro.setCategoria(categoria);
        
        
        // Apos criar os objetos, salvar PRIMEIRO quem nao tem chave de outra table
        // Caso contrario, o SQL reclamara que ainda nao existe na tabela a chave
        daomarca.salvar(marca);
        
        daomodelo.salvar(modelo);
        daocategoria.salvar(categoria);
        daoagencia.salvar(agencia);
        
        // Logo, carro devera ser o ultimo a ser salvo pois tem chave do modelo, da categoria e da agencia
        daocarro.salvar(carro);
        
        // Ordem: salvar Marca antes de Modelo
        //        salvar Modelo, Categoria e Agencia (em qualquer ordem) antes de Carro
    }
}
