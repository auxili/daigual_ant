package com.fpmislata.banco.datos;

import com.fpmislata.banco.negocio.EntidadBancaria;
import java.util.List;


public interface EntidadBancariaDAO extends GenericDAO<EntidadBancaria, Integer>{
    abstract EntidadBancariaDAO read();
    abstract EntidadBancariaDAO insert();
    abstract EntidadBancariaDAO delete();
    abstract List<EntidadBancaria> findAll();
    abstract List<EntidadBancaria> findByCodigo();
}
