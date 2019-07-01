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
import java.util.logging.Level;
import java.util.logging.Logger;

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
            
            int id = super.getLastInsertId(conn);
            modelo.setId(id);
            
            super.fecharBD(conn);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        

        this.modelos.add(modelo);
    }
     
    @Override
    public void atualizar(Modelo modelo) {
        try {
            Connection conn = super.conectarBD();
            String sql = "UPDATE Modelos SET nome=?, combustivel=?, n_portas=?, id_marca=? WHERE id_modelo=?";
            
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, modelo.getNome());
            statement.setString(2, modelo.getCombustivel());
            statement.setInt(3, modelo.getNPortas());
            statement.setInt(4, modelo.getMarca().getId());
            statement.setInt(5, modelo.getId());
            statement.executeUpdate();
                    
            super.fecharBD(conn);
            
            for(int i = 0; i < this.modelos.size(); i++) {
                if(this.modelos.get(i).getId() == modelo.getId()) {
                    this.modelos.set(i, modelo);
                    break;
                }
            }
                
        } catch (SQLException ex) {
            Logger.getLogger(DaoModelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    @Override
    public void deletar(Modelo modelo) {
        try {
            Connection conn = super.conectarBD();
            String sql = "DELETE FROM Modelos WHERE id_modelo=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setInt(1, modelo.getId());
            statement.executeUpdate();
            
            super.fecharBD(conn);
        } catch (SQLException ex) {
            Logger.getLogger(DaoMarca.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        boolean removido = this.modelos.removeIf(o -> (o.getId() == modelo.getId()));
        
        if(!removido)
            System.out.println("modelo nao removido da lista na dao! Erro!");
    }
}
