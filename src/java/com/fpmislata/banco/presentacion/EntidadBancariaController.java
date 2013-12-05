/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.presentacion;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fpmislata.banco.datos.EntidadBancariaDAO;
import com.fpmislata.banco.datos.EntidadBancariaDAOImpHibernate;
import com.fpmislata.banco.negocio.EntidadBancaria;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author alumno
 */
@Controller
public class EntidadBancariaController {

    @Autowired
    EntidadBancariaDAO entidadBancariaDAO;

    @RequestMapping(value = {"/EntidadBancaria/{idEntidadBancaria}"}, method = RequestMethod.GET)
    public void read(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @PathVariable("idEntidadBancaria") int idEntidadBancaria) throws Exception {
        try {
            //obtener los datos
            EntidadBancaria entidadBancaria = entidadBancariaDAO.read(idEntidadBancaria);

            //cabeceras
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);


            //devolver los datos
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(entidadBancaria);
            httpServletResponse.getWriter().println(json);
        } catch (Exception ex) {
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (Exception exfin) {
            }
        }
    }

    @RequestMapping(value = {"/EntidadBancaria/{idEntidadBancaria}"}, method = RequestMethod.DELETE)
    public void delete(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @PathVariable("idEntidadBancaria") int idEntidadBancaria) throws Exception {
        //EntidadBancaria entidadBancaria = new EntidadBancariaDAOImpHibernate();
        try {
            entidadBancariaDAO.delete(idEntidadBancaria);
            httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } catch (Exception ex) {
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            try {
                ex.printStackTrace(httpServletResponse.getWriter());

            } catch (Exception exfin) {
            }
        }
    }
}
