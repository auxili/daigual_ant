/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.datos;

import java.sql.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author alumno
 */
public class ConnectionFactoryImplDataSource{
    Connection getConnection() throws Exception{
        Context initContext = new
        InitialContext();
        Context envContext  = (Context)initContext.lookup("java:/comp/env");
        DataSource datasource = (DataSource)envContext.lookup("jdbc/banco");
        Connection con = datasource.getConnection();
    return con;
    
}
    
    
}
