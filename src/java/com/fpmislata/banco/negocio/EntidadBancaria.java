package com.fpmislata.banco.negocio;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KIKE
 */
public class EntidadBancaria {
    	private int idEntidad;
	private String codigoEntidad;
	private String nombre;
	private String cif;
	private TipoEntidadBancaria tipoEntidadBancaria;
        private List<SucursalBancaria> sucursalBancaria= new ArrayList();

    public EntidadBancaria(int idEntidad, String codigoEntidad, String nombre, String cif, TipoEntidadBancaria tipoEntidadBancaria) {
        this.idEntidad = idEntidad;
        this.codigoEntidad = codigoEntidad;
        this.nombre = nombre;
        this.cif = cif;
        this.tipoEntidadBancaria = tipoEntidadBancaria;
    }

    /**
     * @return the id
     */
    public int getId() {
        return getIdEntidad();
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.setIdEntidad(id);
    }

    /**
     * @return the codigoEntidad
     */
    public String getCodigoEntidad() {
        return codigoEntidad;
    }

    /**
     * @param codigoEntidad the codigoEntidad to set
     */
    public void setCodigoEntidad(String codigoEntidad) {
        this.codigoEntidad = codigoEntidad;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the cif
     */
    public String getCif() {
        return cif;
    }

    /**
     * @param cif the cif to set
     */
    public void setCif(String cif) {
        this.cif = cif;
    }

    /**
     * @return the tipoEntidadBancaria
     */
    public TipoEntidadBancaria getTipoEntidadBancaria() {
        return tipoEntidadBancaria;
    }

    /**
     * @param tipoEntidadBancaria the tipoEntidadBancaria to set
     */
    public void setTipoEntidadBancaria(TipoEntidadBancaria tipoEntidadBancaria) {
        this.tipoEntidadBancaria = tipoEntidadBancaria;
    }

    /**
     * @return the idEntidad
     */
    public int getIdEntidad() {
        return idEntidad;
    }

    /**
     * @param idEntidad the idEntidad to set
     */
    public void setIdEntidad(int idEntidad) {
        this.idEntidad = idEntidad;
    }

    /**
     * @return the sucursalBancaria
     */
    public List<SucursalBancaria> getSucursalBancaria() {
        return sucursalBancaria;
    }

    /**
     * @param sucursalBancaria the sucursalBancaria to set
     */
    public void setSucursalBancaria(List<SucursalBancaria> sucursalBancaria) {
        this.sucursalBancaria = sucursalBancaria;
    }

}
