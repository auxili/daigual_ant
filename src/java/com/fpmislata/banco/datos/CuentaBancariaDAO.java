package com.fpmislata.banco.datos;
import com.fpmislata.banco.negocio.CuentaBancaria;
import java.util.List;

public interface CuentaBancariaDAO extends GenericDAO<CuentaBancaria, Integer>{

    public List<CuentaBancaria> findByCodigo(String codigo);
    public List<CuentaBancaria> findByNombre(String letraNombre);
}
