/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.datos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author alumno
 */
public class ConnectionFactoryImpDataSource implements ConnectionFactory {

    @Override
    public Connection getConnection() {
        Connection con = null;
        try {
            Context initContext=new InitialContext();;
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource datasource = (DataSource)envContext.lookup("jdbc/banco");
            con = datasource.getConnection();
            return con;
        } catch (Exception ex) {
            throw new RuntimeException(ex);

            /*public Connection getConnection() throws Exception{
             Context initContext = new InitialContext();
             Context envContext  = (Context)initContext.lookup("java:/comp/env");
             DataSource datasource = (DataSource)envContext.lookup("jdbc/banco");
             Connection con = datasource.getConnection();
             return con;
             */
        }

    }
    }
