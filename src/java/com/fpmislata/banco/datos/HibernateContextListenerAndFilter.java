/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.datos;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author alumno
 */
public class HibernateContextListenerAndFilter implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //AQUI VA EL HibernateUtil.buildSessionFactory();
        System.out.println("HOLA: soy tu conciencia.");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ADIOS: tu conciencia ha muerto");
        //AQUI VA EL HibernateUtil.closeSessionFactory();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
