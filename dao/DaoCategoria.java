/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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
public class DaoCategoria extends ObjetoBD implements Dao<Categoria> {
    private List<Categoria> categorias;
     
    public DaoCategoria() throws SQLException {
        Connection conn = super.conectarBD();
        this.categorias = new ArrayList<>();

        String sql = "SELECT * FROM Categorias;";
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        
        while(result.next()) {
            int id = result.getInt("id_categoria");
            String letra = result.getString("letra");
            double diaria = result.getDouble("valor_diaria");
            
            Categoria categoria = new Categoria(letra, diaria);
            categoria.setId(id);
            this.categorias.add(categoria);
        }
        
        super.fecharBD(conn);
    }
     
    @Override
    public Optional<Categoria> get(long id) {
        for(Categoria categoria : this.categorias){
            if(categoria.getId() == id) {
                return Optional.ofNullable(categoria);
            }
        }
        return Optional.empty();
    }
     
    @Override
    public List<Categoria> getTodos() {
        return categorias;
    }
     
    @Override
    public void salvar(Categoria categoria) {
        try {
            Connection conn = super.conectarBD();
            String sql = "INSERT INTO Categorias (letra, valor_diaria) VALUES (?, ?)";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, categoria.getLetra());
            statement.setString(2, Double.toString(categoria.getValorDiaria()));
            statement.executeUpdate();
            
            int id = super.getLastInsertId(conn);
            categoria.setId(id);
            
            super.fecharBD(conn);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        

        this.categorias.add(categoria);
    }
     
    @Override
    public void atualizar(Categoria categoria) {
        try {
            Connection conn = super.conectarBD();
            String sql = "UPDATE Categorias SET letra=?, valor_diaria=? WHERE id_categoria=?";
            
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, categoria.getLetra());
            statement.setDouble(2, categoria.getValorDiaria());
            statement.setInt(3, categoria.getId());
            statement.executeUpdate();
                    
            super.fecharBD(conn);
            
            for(int i = 0; i < this.categorias.size(); i++) {
                if(this.categorias.get(i).getId() == categoria.getId()) {
                    this.categorias.set(i, categoria);
                    break;
                }
            }
                
        } catch (SQLException ex) {
            Logger.getLogger(DaoCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    @Override
    public void deletar(Categoria categoria) {
        try {
            Connection conn = super.conectarBD();
            String sql = "DELETE FROM Categorias WHERE id_categoria=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setInt(1, categoria.getId());
            statement.executeUpdate();
            
            super.fecharBD(conn);
        } catch (SQLException ex) {
            Logger.getLogger(DaoCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        boolean removido = this.categorias.removeIf(o -> (o.getId() == categoria.getId()));
        
        if(!removido)
            System.out.println("categoria nao removido da lista na dao! Erro!");
    }
}
