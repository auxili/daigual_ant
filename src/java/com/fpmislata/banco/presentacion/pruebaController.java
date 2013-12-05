/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.presentacion;

import com.fpmislata.banco.datos.EntidadBancariaDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author alumno
 */
@Controller
public class pruebaController {

    @RequestMapping({"/beer.json"})
    public void prueba(HttpServletRequest request, HttpServletResponse response){
        try {
            response.getWriter().println("OSTIA PUTAAAAAAAAAAAAAA :D");
        } catch (IOException ex) {
            Logger.getLogger(pruebaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
