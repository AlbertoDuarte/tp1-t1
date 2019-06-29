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

/**
 *
 * @author AlbertoNeto
 */
public class DaoCategoria extends ObjetoBD implements Dao<Categoria> {
    private List<Categoria> categorias;
     
    public DaoCategoria(List<Carro> carros) throws SQLException {
        Connection conn = super.conectarBD();
        this.categorias = new ArrayList<>();

        String sql = "SELECT * FROM Marcas;";
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        
        while(result.next()) {
            int id = result.getInt("id_categoria");
            String letra = result.getString("letra");
            double diaria = result.getDouble("valor_diaria");
            
            Categoria categoria = new Categoria(letra, diaria);
            categoria.setId(id);
            categorias.add(categoria);
        }
        
        categorias.stream().forEach((categoria) -> {
            carros.stream().filter((carro) -> (carro.getCategoria().getId() == categoria.getId() )).forEach((carro) -> {
                categoria.adicionarCarro(carro);
            });
        });
    }
     
    @Override
    public Optional<Categoria> get(long id) {
        for(Categoria categoria : categorias){
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
            String sql = "INSERT INTO Categorias (letra, valor_diario) VALUES (?, ?)";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, categoria.getLetra());
            statement.setString(1, Double.toString(categoria.getValorDiaria()));
            statement.executeUpdate();
            
            sql = "SELECT_LAST_INSERTED_ID();";
            Statement statement2 = conn.createStatement();
            ResultSet result = statement2.executeQuery(sql);
            
            int id = result.getInt("SELECT_LAST_INSERTED_ID()");
            categoria.setId(id);
            
            super.fecharBD(conn);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        

        categorias.add(categoria);
    }
     
    @Override
    public void atualizar(Categoria categoria, String[] params) {
        categorias.add(categoria);
    }
     
    @Override
    public void deletar(Categoria categoria) {
        categorias.remove(categoria);
    }
}
