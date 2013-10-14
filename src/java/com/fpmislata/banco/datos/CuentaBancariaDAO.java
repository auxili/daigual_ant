
package com.fpmislata.banco.datos;


import java.util.List;


public class CuentaBancariaDAO extends GenericDAO<CuentaBancaria Integer>{
    abstract CuentaBancariaDAO read();
    abstract CuentadBancariaDAO insert();
    abstract CuentadBancariaDAO delete();
    public abstract List<CuentaBancariaDAO> findAll();
    abstract List<CuentaBancariaDAO> findByCodigo();
}
