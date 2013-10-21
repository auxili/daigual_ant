/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.datos;
import java.math.BigDecimal;
import com.fpmislata.banco.negocio.MovimientoBancario;
import com.fpmislata.banco.negocio.TipoMovimientoBancario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KiKe
 */
public class MovimientoBancarioDAOImpJDBC implements EntidadBancariaDAO{

    //abstract Connection getConnection();// cómo conectamos???
    ConnectionFactory connectionFactory = new ConnectionFactoryImpDataSource();

    @Override
    public MovimientoBancario read(Integer idMovimientoBancario) {
        try {
            MovimientoBancario movimientoBancario;
            Connection connection = connectionFactory.getConnection();
            String sql = "SELECT * FROM movimientoBancario WHERE idMovimientoBancario=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idMovimientoBancario);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next() == true) {
                idMovimientoBancario = rs.getInt("idMovimientoBancario");
                BigDecimal importe = rs.getBigDecimal("importe");
                String fecha = rs.getString("fecha");
                BigDecimal saldoTotal = rs.getBigDecimal("saldoTotal");
                String concepto = rs.getString("concepto");
                String tipoMovimientoBancario = rs.getString("tipoMovimientoBancario");
                if (rs.next() == true) {
                    throw new RuntimeException("Existe más de una MovimientoBancario:" + idMovimientoBancario);
                }
                movimientoBancario = new MovimientoBancario(idMovimientoBancario, TipoMovimientoBancario.valueOf(tipoMovimientoBancario), importe, fecha, saldoTotal,concepto);
            } else {
                RuntimeException runtimeException = new RuntimeException("No existe el MovimientoBancario" + idMovimientoBancario);
                throw runtimeException;
            }
            //cerramos la bd
            connection.close();
            System.out.println("Se ha conectado!!");
            //devolvemos el resultado
            return movimientoBancario;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void insert(MovimientoBancario movimientoBancario) {
        try {
            Connection conn = connectionFactory.getConnection();
            String insertTableSQL = "INSERT INTO entidadbancaria"
                    + "(idMovimientoBancario, importe, fecha, saldoTotal, concepto, tipoMovimientoBancario) VALUES"
                    + "(?,?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(insertTableSQL);
            preparedStatement.setInt(1, movimientoBancario.getIdMovimientoBancario());
            preparedStatement.setBigDecimal(2, movimientoBancario.getImporte());
            preparedStatement.setString(3, movimientoBancario.getFecha());
            preparedStatement.setBigDecimal(4, movimientoBancario.getSaldoTotal());
            preparedStatement.setString(5, movimientoBancario.getConcepto());
            preparedStatement.setString(6, movimientoBancario.getTipoMovimientoBancario().name());
            preparedStatement.executeUpdate();
            System.out.println("Entrada insertada");
            conn.close();
            System.out.println("Se ha conectado!!");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void update(MovimientoBancario movimientoBancario) {
        try {
            Connection conn = connectionFactory.getConnection();
            String updateTableSQL = "UPDATE FROM entidadbancaria SET nombre = ?  WHERE id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(updateTableSQL);
            preparedStatement.setString(1, "TriodosBank");
            preparedStatement.setInt(2, entidadBancaria.getId());
            // execute insert SQL stetement
            preparedStatement.executeUpdate();
            conn.close();
            System.out.println("Se ha conectado!!");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void delete(Integer idEntidadBancaria) {
        String deleteSQL = "DELETE FROM entidadBancaria WHERE id = ?";
        try {
            Connection conn = connectionFactory.getConnection();

            PreparedStatement preparedStatement = conn.prepareStatement(deleteSQL);
            preparedStatement.setInt(1, idEntidadBancaria);
            preparedStatement.executeUpdate();
            conn.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<EntidadBancaria> findAll() {
        try {
            List<EntidadBancaria> listaEntidades = new ArrayList();
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
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<EntidadBancaria> findByCodigo(String codigo) {
        try {
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
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    
    
    
    
    
    @Override
    public List<EntidadBancaria> findByNombre(String letraNombre){
        
         if (letraNombre==null|| letraNombre.trim().equals("")){
            try {
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
            return listaEntidades;
            
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
         }else
             try {
            List<EntidadBancaria> listaEntidades = new ArrayList<EntidadBancaria>();
            EntidadBancaria entidadBancaria;
            Connection conn = connectionFactory.getConnection();
            
            String sql = "SELECT * FROM entidadbancaria where nombre like ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, "%"+letraNombre+"%");
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
            return listaEntidades;
            
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
}
