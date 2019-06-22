/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automovel;

import colecoes.Colecionavel;

/**
 *
 * @author root
 */
public abstract class ObjetoId implements Colecionavel{
    private int id;
    
    ObjetoId(int id) {
        this.id = id;
    }
    public int get_id() {
        return this.id;
    }
}
