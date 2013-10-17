/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.datos;

import java.util.List;

public interface GenericDAO <T, ID>{ 
    public T read(ID id);
    public void insert (T t);    
    public void update (T t);
    public void delete (ID id);
    public List<T> findAll();
    //public List<T> findByCodigo(ID id);
}
