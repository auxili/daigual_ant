package com.fpmislata.banco.datos;

import com.fpmislata.banco.negocio.EntidadBancaria;
import java.util.List;


public interface EntidadBancariaDAO extends GenericDAO<EntidadBancaria, Integer>{
    /*public void read(int idEntidadBancaria);
    public void insert(EntidadBancaria entidadBancaria);
    public void update(EntidadBancaria entidadBancaria);
    public void delete(int idEntidadBancaria);
    public List<EntidadBancaria> findAll();*/
    public List<EntidadBancaria> findByCodigo(String Codigo);
    public List<EntidadBancaria> findByNombre(String letraNombre);
}
