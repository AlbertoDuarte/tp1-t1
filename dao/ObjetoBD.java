/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public class ObjetoBD {
    static String dbURL = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
    static String username = "root";
    static String password = "Arr52&cl";
    
    public Connection conectarBD() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dbURL, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(ObjetoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return conn;
    }
    
    public void fecharBD(Connection conn) {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ObjetoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getLastInsertId(Connection conn) throws SQLException {
            String sql = "SELECT LAST_INSERT_ID();";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            result.next();
            int id = result.getInt("LAST_INSERT_ID()");
            
            return id;
    }
}
