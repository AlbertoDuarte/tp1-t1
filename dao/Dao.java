/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author root
 */
public interface Dao<T> {
    Optional<T> get(long id);
     
    List<T> getTodos();
    
    void salvar(T t);
     
    void atualizar(T t);
     
    void deletar(T t);
}
