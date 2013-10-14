/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.datos;

import com.fpmislata.banco.negocio.EntidadBancaria;
import com.fpmislata.banco.negocio.TipoEntidadBancaria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alumno
 */
public interface GenericDAO <T, ID>{ 
    public T read(ID id);
    public void insert (ID id);    
    public void update (T t);
    public void delete (T t);
    public List<T> findAll();
    public List<T> findByCodigo(ID id);
}
