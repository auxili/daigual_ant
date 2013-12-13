/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.presentacion;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fpmislata.banco.datos.EntidadBancariaDAO;
import com.fpmislata.banco.datos.EntidadBancariaDAOImpHibernate;
import com.fpmislata.banco.negocio.EntidadBancaria;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping(value = {"/EntidadBancaria"}, method = RequestMethod.GET)
    public void find(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse) throws Exception {
        try {
            //obtener los datos
            List<EntidadBancaria> entidadBancaria = entidadBancariaDAO.findAll();

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

    @RequestMapping(value = {"/EntidadBancaria"}, method = RequestMethod.POST)
    public void insert(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @RequestBody String json) {
        try {
            //transformamos el json a java
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            EntidadBancaria entidadBancaria = (EntidadBancaria) objectMapper.readValue(json, EntidadBancaria.class);

            //obtener los datos
            entidadBancariaDAO.insert(entidadBancaria);

            //cabeceras
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);

            //devolver los datos
            json = objectMapper.writeValueAsString(entidadBancaria);
            httpServletResponse.getWriter().println(json);
            /*
             *@validation: probamos la validacion por consola para luego hacerlo en su propia clase
             */
            /*
        } catch (javax.validation.ConstraintViolationException cve) {
            System.out.println("No se ha podido insertar la EntidadBancaria debido a los siguientes errores:");
            for (ConstraintViolation constraintViolation : cve.getConstraintViolations()) {
                System.out.println("En el campo '" + constraintViolation.getPropertyPath() + "':" + constraintViolation.getMessage());
            }*/
        } catch (Exception ex) {
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (Exception exfin) {
            }
        }
    }

    @RequestMapping(value = {"/EntidadBancaria/{idEntidadBancaria}"}, method = RequestMethod.PUT)
    public void update(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @PathVariable("idEntidadBancaria") int idEntidadBancaria, @RequestBody String json) throws Exception {
        try {
            //transformamos el json a java
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            EntidadBancaria entidadBancaria = (EntidadBancaria) objectMapper.readValue(json, EntidadBancaria.class);

            //obtener los datos
            EntidadBancaria entidadBancariaUpdate = entidadBancariaDAO.read(idEntidadBancaria);

            entidadBancariaUpdate.setNombre(entidadBancaria.getNombre());
            entidadBancariaUpdate.setCodigoEntidad(entidadBancaria.getCodigoEntidad());
            entidadBancariaUpdate.setCif(entidadBancaria.getCif());
            entidadBancariaUpdate.setSucursalBancaria(entidadBancaria.getSucursalBancaria());
            entidadBancariaUpdate.setTipoEntidadBancaria(entidadBancaria.getTipoEntidadBancaria());


            entidadBancariaDAO.update(entidadBancariaUpdate);

            //cabeceras
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);

            //devolver los datos
            json = objectMapper.writeValueAsString(entidadBancariaUpdate);
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
}
