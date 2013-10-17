/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.datos;

import com.fpmislata.banco.negocio.MovimientoBancario;
import java.util.List;

/**
 *
 * @author alumno
 */
public interface MovimientoBancarioDAO implements GenericDAO<MovimientoBancario, Integer>{
   /* public void read(int idSucursalBancaria);
    public void insert(MovimientoBancario sucursalBancaria);
    public void update(MovimientoBancario SucursalBancaria);
    public void delete(int idSucursalBancaria);
    public List<MovimientoBancario> findAll();*/
    public List<MovimientoBancario> findByCodigo(String Codigo);
}