package com.fpmislata.banco.negocio;


public enum TipoEntidadBancaria  {
    Banco, CajaAhorro, CoopCredito,EstableFinanCredito;
    private String TipoEntidadBancaria;
    
    public String getTipoEntidadBancaria(){
        return TipoEntidadBancaria;
    }
    public void setNombre(String tipoEntidadBancaria){
        TipoEntidadBancaria=tipoEntidadBancaria;
    }
}
