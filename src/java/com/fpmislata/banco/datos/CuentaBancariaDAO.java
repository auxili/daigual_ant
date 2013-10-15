package com.fpmislata.banco.datos;
import com.fpmislata.banco.negocio.CuentaBancaria;
import java.util.List;

public interface CuentaBancariaDAO{
    public CuentaBancariaDAO read(int idCuentaBancaria);

    public void  insert (CuentaBancaria cuentaBancaria);
    
    public void update (CuentaBancaria cuentaBancaria);

    public void delete (int idCuentaBancaria);

    public List<CuentaBancaria> findAll();

    public List<CuentaBancaria> findByCodigo(String codigo);
}
