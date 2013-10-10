/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.datos;

import java.sql.Connection;

/**
 *
 * @author alumno
 */
public class ConnectionFactoryImplDataSource{
    Connection getConnection(){
        Context initContext = new
        InitialContext();
        Context envContext  = (Context)initContext.lookup("java:/comp/env");
        DataSource datasource = (DataSource)envContext.lookup("jdbc/LocalTestDB");
        Connection con = datasource.getConnection();
    return ;
    
}
    
    
}
