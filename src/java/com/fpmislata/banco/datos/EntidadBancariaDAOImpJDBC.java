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

/*DUDA: el connectionFactory se hace para crear una NUEVA conectionFActoryImpDataSource o 
 una NUEVA EntidadBancariaDAOImpJDBC ????????????????????????????????*/

public class EntidadBancariaDAOImpJDBC implements EntidadBancariaDAO{
    
    //abstract Connection getConnection();// cómo conectamos???
    ConnectionFactory connectionFactory = new ConnectionFactoryImpDataSource();
    
    @Override
    public EntidadBancaria read(int idEntidadBancaria){
       try{
        EntidadBancaria entidadBancaria;
        Connection connection = connectionFactory.getConnection();
        String sql = "SELECT * FROM entidadbancaria WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, idEntidadBancaria);
        ResultSet rs = preparedStatement.executeQuery();
        
        if (rs.next() == true) {
            idEntidadBancaria = rs.getInt("id");
            String codigoEntidad = rs.getString("codigoEntidad");
            String nombre = rs.getString("nombre");
            String cif = rs.getString("cif");
            String tipoEntidadBancaria = rs.getString("tipoEntidadBancaria");
            if (rs.next() == true) {
                throw new RuntimeException("Existe más de una EntidadBancaria:" + idEntidadBancaria);
            }
            entidadBancaria = new EntidadBancaria(idEntidadBancaria, codigoEntidad, nombre, cif, TipoEntidadBancaria.valueOf(tipoEntidadBancaria));
        } else {
            RuntimeException runtimeException = new RuntimeException("No existe la entidad Bancaria" + idEntidadBancaria);
            throw runtimeException;
        }
        //cerramos la bd
        connection.close();
        System.out.println("Se ha conectado!!");
        //devolvemos el resultado
        return entidadBancaria;
       }catch(Exception ex){
           throw new RuntimeException(ex);
                   }
    }

    public void insert(EntidadBancaria entidadBancaria){
        try{
        Connection conn = connectionFactory.getConnection();
        String insertTableSQL = "INSERT INTO entidadbancaria"
                + "(id, codigoEntidad, nombre, cif, tipoEntidadBancaria) VALUES"
                + "(?,?,?,?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(insertTableSQL);
        preparedStatement.setInt(1, entidadBancaria.getId());
        preparedStatement.setString(2, entidadBancaria.getCodigoEntidad());
        preparedStatement.setString(3, entidadBancaria.getNombre());
        preparedStatement.setString(4, entidadBancaria.getCif());
        preparedStatement.setString(5, entidadBancaria.getTipoEntidadBancaria().name());
        preparedStatement.executeUpdate();
        System.out.println("Entrada insertada");
        conn.close();
        System.out.println("Se ha conectado!!");
        }catch(Exception ex){
           throw new RuntimeException(ex);
                   }
    }

    public void update(EntidadBancaria entidadBancaria){
        try{
        Connection conn = connectionFactory.getConnection();
        String updateTableSQL = "UPDATE FROM entidadbancaria SET nombre = ?  WHERE id = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(updateTableSQL);
        preparedStatement.setString(1, "TriodosBank");
        preparedStatement.setInt(2, entidadBancaria.getId());
        // execute insert SQL stetement
        preparedStatement.executeUpdate();
        conn.close();
        System.out.println("Se ha conectado!!");
        }catch(Exception ex){
           throw new RuntimeException(ex);
                   }
    }

    public void delete(int idEntidadBancaria){
        try{
        Connection conn = connectionFactory.getConnection();
        String deleteSQL = "DELETE FROM entidadBancaria WHERE id = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(deleteSQL);
        preparedStatement.setInt(1, idEntidadBancaria);
        preparedStatement.executeUpdate();
        System.out.println("Entrada eliminada");
        conn.close();
        System.out.println("Se ha conectado!!");
        }catch(Exception ex){
           throw new RuntimeException(ex);
                   }
    }

    public List<EntidadBancaria> findAll(){
        try{
        List<EntidadBancaria> listaEntidades = new ArrayList<EntidadBancaria>();
        EntidadBancaria entidadBancaria;
        Connection conn = connectionFactory.getConnection();
        String sql = "SELECT * FROM entidadbancaria";
   
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String codigoEntidad = rs.getString("codigoEntidad");
            String nombre = rs.getString("nombre");
            String cif = rs.getString("cif");
            String tipoEntidadBancaria = rs.getString("tipoEntidadBancaria");
            entidadBancaria = new EntidadBancaria(id, codigoEntidad, nombre, cif, TipoEntidadBancaria.valueOf(tipoEntidadBancaria));
            listaEntidades.add(entidadBancaria);
        }
        
        conn.close();
        System.out.println("Se ha conectado!!");
        return listaEntidades;
        }catch(Exception ex){
           throw new RuntimeException(ex);
                   }
    }

    public List<EntidadBancaria> findByCodigo(String codigo){
        try{
        List<EntidadBancaria> listaEntidades = new ArrayList<EntidadBancaria>();
        EntidadBancaria entidadBancaria;
        Connection conn = connectionFactory.getConnection();
        String sql = "SELECT * FROM entidadbancaria where codigo = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, codigo);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String codigoEntidad = rs.getString("codigoEntidad");
            String nombre = rs.getString("nombre");
            String cif = rs.getString("cif");
            String tipoEntidadBancaria = rs.getString("tipoEntidadBancaria");
            entidadBancaria = new EntidadBancaria(id, codigoEntidad, nombre, cif, TipoEntidadBancaria.valueOf(tipoEntidadBancaria));
            listaEntidades.add(entidadBancaria);
        }
        conn.close();
        System.out.println("Se ha conectado!!");
        return listaEntidades;
        }catch(Exception ex){
           throw new RuntimeException(ex);
                   }
    }
}
