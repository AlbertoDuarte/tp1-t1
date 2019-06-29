/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import automovel.Carro;
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
public class DaoModelo extends ObjetoBD implements Dao<Modelo> {
    private List<Modelo> modelos;
     
    public DaoModelo(List<Carro> carros) throws SQLException {
        Connection conn = super.conectarBD();
        this.modelos = new ArrayList<>();

        String sql = "SELECT * FROM Modelos;";
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        
        while(result.next()) {
            int id = result.getInt("id_marca");
            String nome = result.getString("nome");
            String combustivel = result.getString("combustivel");
            int n_portas = result.getInt("n_portas");
            
            Modelo modelo = new Modelo(nome, combustivel, n_portas);
            modelo.setId(id);
            modelos.add(modelo);
        }
        
        // coloca carros em seus respectivos modelos
        modelos.stream().forEach((modelo) -> {
            carros.stream().filter((carro) -> (carro.getModelo().getId() == modelo.getId())).forEach((carro) -> {
                modelo.adicionarCarro(carro);
            });
        });
    }
     
    @Override
    public Optional<Modelo> get(long id) {
        for(Modelo modelo : modelos){
            if(modelo.getId() == id) {
                return Optional.ofNullable(modelo);
            }
        }
        return Optional.empty();
    }
     
    @Override
    public List<Modelo> getTodos() {
        return modelos;
    }
     
    @Override
    public void salvar(Modelo modelo) {
        try {
            Connection conn = super.conectarBD();
            String sql = "INSERT INTO Marcas (nome) VALUES (?)";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, modelo.getNome());
            statement.executeUpdate();
            
            sql = "SELECT_LAST_INSERTED_ID();";
            Statement statement2 = conn.createStatement();
            ResultSet result = statement2.executeQuery(sql);
            
            int id = result.getInt("SELECT_LAST_INSERTED_ID()");
            modelo.setId(id);
            
            super.fecharBD(conn);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        

        modelos.add(modelo);
    }
     
    @Override
    public void atualizar(Modelo modelo, String[] params) {
        modelos.add(modelo);
    }
     
    @Override
    public void deletar(Modelo modelo) {
        modelos.remove(modelo);
    }
}
