package com.fpmislata.banco.datos;


import com.fpmislata.banco.negocio.EntidadBancaria;
import com.fpmislata.banco.negocio.TipoEntidadBancaria;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

public class EntidadBancariaDAO {

    public EntidadBancaria read(int idEntidadBancaria) throws Exception {
        //declaramos variable para el constructor para que se vea en toda el metodo
        EntidadBancaria entidadBancaria;
        //conectamos
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "root", "alumno");

        //elegimos el select
        String sql = "SELECT * FROM entidadbancaria WHERE id=?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, idEntidadBancaria);
        //no usamos while, no gusta
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next() == true) {
            //decaramos variables bd
            idEntidadBancaria = rs.getInt("id");
            String codigoEntidad = rs.getString("codigoEntidad");
            String nombre = rs.getString("nombre");
            String cif = rs.getString("cif");
            String tipoEntidadBancaria = rs.getString("tipoEntidadBancaria");
            if (rs.next() == true) {
                throw new RuntimeException("Existe más de una EntidadBancaria:" + idEntidadBancaria);
            }
            //constructor con las variables de la bd
            entidadBancaria = new EntidadBancaria(idEntidadBancaria, codigoEntidad, nombre, cif, TipoEntidadBancaria.valueOf(tipoEntidadBancaria));
        } else {
            RuntimeException runtimeException = new RuntimeException("No existe la entidad Bancaria" + idEntidadBancaria);
            throw runtimeException;
        }
        //cerramos la bd
        conn.close();
        System.out.println("Se ha conectado!!");
        //devolvemos el resultado
        return entidadBancaria;
    }

    public void insert(EntidadBancaria entidadBancaria) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "root", "alumno");
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
    }

    public void update(EntidadBancaria entidadBancaria) throws Exception {
        //actualiza el nombre de la entidad 
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "root", "alumno");
        String updateTableSQL = "UPDATE FROM entidadbancaria SET nombre = ?  WHERE id = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(updateTableSQL);
        preparedStatement.setString(1, "TriodosBank");
        preparedStatement.setInt(2, entidadBancaria.getId());
        // execute insert SQL stetement
        preparedStatement.executeUpdate();
        conn.close();
        System.out.println("Se ha conectado!!");
    }

    void delete(int idEntidadBancaria) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "root", "alumno");
        String deleteSQL = "DELETE FROM entidadBancaria WHERE id = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(deleteSQL);
        preparedStatement.setInt(1, idEntidadBancaria);
        preparedStatement.executeUpdate();
        System.out.println("Entrada eliminada");
        conn.close();
        System.out.println("Se ha conectado!!");
    }

    public List<EntidadBancaria> findAll() throws Exception {
        List<EntidadBancaria> listaEntidades = new ArrayList<EntidadBancaria>();
        EntidadBancaria entidadBancaria;
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "root", "alumno");
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
    }

    public List<EntidadBancaria> findByCodigo(String codigo) throws Exception {
        List<EntidadBancaria> listaEntidades = new ArrayList<EntidadBancaria>();
        EntidadBancaria entidadBancaria;
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "root", "alumno");
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
    }
}
