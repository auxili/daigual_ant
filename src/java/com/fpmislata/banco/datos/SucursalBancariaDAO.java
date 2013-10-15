/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.datos;

import com.fpmislata.banco.negocio.SucursalBancaria;
import java.util.List;

/**
 *
 * @author alumno
 */
public interface SucursalBancariaDAO implements GenericDAO<SucursalBancaria, Integer>{
    public void read(int idSucursalBancaria);
    public void insert(SucursalBancaria sucursalBancaria);
    public void update(SucursalBancaria SucursalBancaria);
    public void delete(int idSucursalBancaria);
    public List<SucursalBancaria> findAll();
    public List<SucursalBancaria> findByCodigo(String Codigo);
}
