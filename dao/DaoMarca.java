/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AlbertoNeto
 */
public class DaoMarca extends ObjetoBD implements Dao<Marca> {
    private List<Marca> marcas;
     
    public DaoMarca() throws SQLException {
        Connection conn = super.conectarBD();
        this.marcas = new ArrayList<>();

        String sql = "SELECT * FROM Marcas;";
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        
        while(result.next()) {
            int id = result.getInt("id_marca");
            String nome = result.getString("nome");
            
            Marca marca = new Marca(nome);
            marca.setId(id);
            this.marcas.add(marca);
        }
        
        super.fecharBD(conn);
    }
     
    @Override
    public Optional<Marca> get(long id) {
        for(Marca marca : marcas){
            if(marca.getId() == id) {
                return Optional.ofNullable(marca);
            }
        }
        return Optional.empty();
    }
     
    @Override
    public List<Marca> getTodos() {
        return this.marcas;
    }
     
    @Override
    public void salvar(Marca marca) {
        try {
            Connection conn = super.conectarBD();
            String sql = "INSERT INTO Marcas (nome) VALUES (?)";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, marca.getNome());
            statement.executeUpdate();
            
            int id = super.getLastInsertId(conn);
            marca.setId(id);
            
            super.fecharBD(conn);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        

        this.marcas.add(marca);
    }
     
    @Override
    public void atualizar(Marca marca) {
        try {
            Connection conn = super.conectarBD();
            String sql = "UPDATE Marcas SET nome=? WHERE id_marca=?";
            
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, marca.getNome());
            statement.setInt(2, marca.getId());
            statement.executeUpdate();
                    
            super.fecharBD(conn);
            
            for(int i = 0; i < this.marcas.size(); i++) {
                if(this.marcas.get(i).getId() == marca.getId()) {
                    this.marcas.set(i, marca);
                    break;
                }
            }
                
        } catch (SQLException ex) {
            Logger.getLogger(DaoMarca.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    @Override
    public void deletar(Marca marca) {
        try {
            Connection conn = super.conectarBD();
            String sql = "DELETE FROM Marcas WHERE id_marca=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setInt(1, marca.getId());
            statement.executeUpdate();
            
            super.fecharBD(conn);
        } catch (SQLException ex) {
            Logger.getLogger(DaoMarca.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        boolean removido = this.marcas.removeIf(o -> (o.getId() == marca.getId()));
        
        if(!removido)
            System.out.println("marca nao removido da lista na dao! Erro!");
    }
}
