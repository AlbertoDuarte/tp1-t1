/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import automovel.Carro;
import automovel.Marca;
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
     
    public DaoCarro() throws SQLException {
        Connection conn = super.conectarBD();

        String sql = "SELECT * FROM Carros;";
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        
        while(result.next()) {
            int id = result.getInt("id_marca");
            String placa = result.getString("placa");
            String renavam = result.getString("renavam");
            String cor = result.getString("cor");
            int ano = result.getInt("ano");
            double quilometragem = result.getDouble("quilometragem");
            
            Carro carro = new Carro(placa, renavam, cor, ano, quilometragem);
            carro.setId(id);
            carros.add(carro);
        }
    }
     
    /**
     *
     * @param id
     * @return
     */
    @Override
    public Optional<Carro> get(long id) {
        for(Carro carro : carros){
            if(carro.getId() == id) {
                return Optional.ofNullable(carro);
            }
        }
        return Optional.empty();
    }
     
    @Override
    public List<Carro> getTodos() {
        return carros;
    }
     
    @Override
    public void salvar(Carro carro) {
        try {
            Connection conn = super.conectarBD();
            String sql = "INSERT INTO Carros (placa, renavam, cor, ano, quilometragem) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, carro.getPlaca());
            statement.setString(2, carro.getRenavam());
            statement.setString(3, carro.getCor());
            statement.setString(4, Integer.toString(carro.getAno()));
            statement.setString(5, Double.toString(carro.getQuilometragem()));
            statement.executeUpdate();
            
            sql = "SELECT_LAST_INSERTED_ID();";
            Statement statement2 = conn.createStatement();
            ResultSet result = statement2.executeQuery(sql);
            
            int id = result.getInt("SELECT_LAST_INSERTED_ID()");
            carro.setId(id);
            
            super.fecharBD(conn);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        carros.add(carro);
    }
     
    @Override
    public void atualizar(Carro carro, String[] params) {
        carros.add(carro);
    }
     
    @Override
    public void deletar(Carro carro) {
        carros.remove(carro);
    }
}
