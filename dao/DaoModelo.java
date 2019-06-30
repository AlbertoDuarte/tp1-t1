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
     
    public DaoModelo(DaoMarca daomarca) throws SQLException {
        Connection conn = super.conectarBD();
        this.modelos = new ArrayList<>();

        String sql = "SELECT * FROM Modelos;";
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        
        while(result.next()) {
            int id = result.getInt("id_modelo");
            int id_marca = result.getInt("id_marca");
            String nome = result.getString("nome");
            String combustivel = result.getString("combustivel");
            int n_portas = result.getInt("n_portas");
            
            Modelo modelo = new Modelo(nome, combustivel, n_portas);
            modelo.setId(id);
            this.modelos.add(modelo);
            
            // associa modelos com as marcas
            Optional<Marca> op = daomarca.get(id_marca);
            
            try {
                Marca marca = op.get();
                marca.adicionarModelo(modelo);
                modelo.setMarca(marca);
            } catch(Exception ex) {
                System.out.println("Associacao marca e modelo no banco de dados, mas nao do DaoMarca");
                ex.printStackTrace();
            }
            
        }
        
        super.fecharBD(conn);
    }
     
    @Override
    public Optional<Modelo> get(long id) {
        for(Modelo modelo : this.modelos){
            if(modelo.getId() == id) {
                return Optional.ofNullable(modelo);
            }
        }
        return Optional.empty();
    }
     
    @Override
    public List<Modelo> getTodos() {
        return this.modelos;
    }
     
    @Override
    public void salvar(Modelo modelo) {
        try {
            Connection conn = super.conectarBD();
            String sql = "INSERT INTO Modelos (nome, combustivel, n_portas, id_marca) VALUES (?, ?, ?, ?)";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, modelo.getNome());
            statement.setString(2, modelo.getCombustivel());
            statement.setInt(3, modelo.getNPortas());
            statement.setInt(4, modelo.getMarca().getId());
            statement.executeUpdate();
            
            sql = "SELECT LAST_INSERT_ID();";
            Statement statement2 = conn.createStatement();
            ResultSet result = statement2.executeQuery(sql);
            
            result.next();
            int id = result.getInt("LAST_INSERT_ID()");
            modelo.setId(id);
            
            super.fecharBD(conn);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        

        this.modelos.add(modelo);
    }
     
    @Override
    public void atualizar(Modelo modelo, String[] params) {
        this.modelos.add(modelo);
    }
     
    @Override
    public void deletar(Modelo modelo) {
        this.modelos.remove(modelo);
    }
}
