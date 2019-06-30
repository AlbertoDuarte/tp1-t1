/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import agencia.Agencia;
import automovel.Carro;
import automovel.Categoria;
import automovel.Marca;
import automovel.Modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author AlbertoNeto
 */
public class DaoCarro extends ObjetoBD implements Dao<Carro> {
    private List<Carro> carros;
     
    public DaoCarro(DaoModelo daomodelo, DaoCategoria daocategoria, DaoAgencia daoagencia) throws SQLException {
        Connection conn = super.conectarBD();
        this.carros = new ArrayList<>();

        String sql = "SELECT * FROM Carros;";
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        
        while(result.next()) {
            int id = result.getInt("id_carro");
            int id_categoria = result.getInt("id_categoria");
            int id_modelo = result.getInt("id_modelo");
            int id_agencia = result.getInt("id_agencia");
            String placa = result.getString("placa");
            String renavam = result.getString("renavam");
            String cor = result.getString("cor");
            int ano = result.getInt("ano");
            double quilometragem = result.getDouble("quilometragem");
            
            Carro carro = new Carro(placa, renavam, cor, ano, quilometragem);
            carro.setId(id);
            this.carros.add(carro);
        
            // associa carros com os modelos
            Optional<Modelo> op = daomodelo.get(id_modelo);
            
            try {
                Modelo modelo = op.get();
                modelo.adicionarCarro(carro);
                carro.setModelo(modelo);
            } catch(Exception ex) {
                System.out.println("Associacao modelo e carro no banco de dados, mas nao no DaoModelo");
                ex.printStackTrace();
            }
            
            // associa carros com as categorias
            Optional<Categoria> opcat = daocategoria.get(id_categoria);
            
            try {
                Categoria categoria = opcat.get();
                categoria.adicionarCarro(carro);
                carro.setCategoria(categoria);
            } catch(Exception ex) {
                System.out.println("Associacao categoria e carro no banco de dados, mas nao no DaoCategoria");
                ex.printStackTrace();
            }
            
            // associa carros com as agencias
            Optional<Agencia> opage = daoagencia.get(id_agencia);
            
            try {
                Agencia agencia = opage.get();
                agencia.adicionarCarro(carro);
                carro.setAgencia(agencia);
            } catch(Exception ex) {
                System.out.println("Associacao agencia e carro no banco de dados, mas nao no DaoAgencia");
                ex.printStackTrace();
            }
        }
        super.fecharBD(conn);
    }
     
    /**
     *
     * @param id
     * @return
     */
    @Override
    public Optional<Carro> get(long id) {
        for(Carro carro : this.carros){
            if(carro.getId() == id) {
                return Optional.ofNullable(carro);
            }
        }
        return Optional.empty();
    }
     
    @Override
    public List<Carro> getTodos() {
        return this.carros;
    }
     
    @Override
    public void salvar(Carro carro) {
        try {
            Connection conn = super.conectarBD();
            String sql = "INSERT INTO Carros (placa, renavam, cor, ano, quilometragem, id_agencia, id_categoria, id_modelo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, carro.getPlaca());
            statement.setString(2, carro.getRenavam());
            statement.setString(3, carro.getCor());
            statement.setInt(4, carro.getAno());
            statement.setDouble(5, carro.getQuilometragem());
            statement.setInt(6, carro.getAgencia().getId());
            statement.setInt(7, carro.getCategoria().getId());
            statement.setInt(8, carro.getModelo().getId());
            statement.executeUpdate();
            
            sql = "SELECT LAST_INSERT_ID();";
            Statement statement2 = conn.createStatement();
            ResultSet result = statement2.executeQuery(sql);
            
            result.next();
            int id = result.getInt("LAST_INSERT_ID()");
            carro.setId(id);
            
            super.fecharBD(conn);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        this.carros.add(carro);
    }
     
    @Override
    public void atualizar(Carro carro, String[] params) {
        this.carros.add(carro);
    }
     
    @Override
    public void deletar(Carro carro) {
        this.carros.remove(carro);
    }
}
