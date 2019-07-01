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
public class DaoAgencia extends ObjetoBD implements Dao<Agencia> {
    private List<Agencia> agencias;
     
    public DaoAgencia() throws SQLException {
        Connection conn = super.conectarBD();
        this.agencias = new ArrayList<>();

        String sql = "SELECT * FROM Agencias;";
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        
        while(result.next()) {
            int id = result.getInt("id_agencia");
            String cep = result.getString("cep");
            
            Agencia agencia = new Agencia(cep);
            agencia.setId(id);
            this.agencias.add(agencia);
        }
    }
     
    @Override
    public Optional<Agencia> get(long id) {
        for(Agencia agencia : this.agencias){
            if(agencia.getId() == id) {
                return Optional.ofNullable(agencia);
            }
        }
        return Optional.empty();
    }
     
    @Override
    public List<Agencia> getTodos() {
        return this.agencias;
    }
     
    @Override
    public void salvar(Agencia agencia) {
        try {
            Connection conn = super.conectarBD();
            String sql = "INSERT INTO Agencias (cep) VALUES (?)";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, agencia.getCEP());
            statement.executeUpdate();
            
            int id = super.getLastInsertId(conn);

            agencia.setId(id);
            
            super.fecharBD(conn);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        

        this.agencias.add(agencia);
    }
     
    @Override
    public void atualizar(Agencia agencia) {
        try {
            Connection conn = super.conectarBD();
            String sql = "UPDATE Agencias SET cep=? WHERE id_agencia=?";
            
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, agencia.getCEP());
            statement.setInt(2, agencia.getId());
            statement.executeUpdate();
                    
            super.fecharBD(conn);
            
            for(int i = 0; i < this.agencias.size(); i++) {
                if(this.agencias.get(i).getId() == agencia.getId()) {
                    this.agencias.set(i, agencia);
                    break;
                }
            }
                
        } catch (SQLException ex) {
            Logger.getLogger(DaoAgencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    @Override
    public void deletar(Agencia agencia) {
        try {
            Connection conn = super.conectarBD();
            String sql = "DELETE FROM Agencias WHERE id_agencia=?";
            
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, agencia.getId());
            statement.executeUpdate();
            
            super.fecharBD(conn);
        } catch (SQLException ex) {
            Logger.getLogger(DaoAgencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        boolean removido = this.agencias.removeIf(o -> (o.getId() == agencia.getId()));
        
        if(!removido)
            System.out.println("agencia nao removido da lista na dao! Erro!");
    }
}
