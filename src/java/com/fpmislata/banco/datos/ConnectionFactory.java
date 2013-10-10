package com.fpmislata.banco.datos;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
/**
 *
 * @author alumno
 */
public interface ConnectionFactory {
    
    Connection getConnection();
    
}
