<%-- 
    Document   : delete
    Created on : 07-nov-2013, 10:10:55
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@page import="com.fpmislata.banco.datos.EntidadBancariaDAOImpJDBC"%>
<%@page import="javax.sound.midi.Soundbank"%>
<%@page import="java.util.List"%>
<%@page import="com.fpmislata.banco.negocio.EntidadBancaria"%>
<%@page import="com.fpmislata.banco.datos.EntidadBancariaDAO"%>

<%

EntidadBancariaDAO entidadBancariaDAO = new EntidadBancariaDAOImpJDBC();
String id = request.getParameter("id");
Integer idEntidadBancaria = Integer.parseInt(id);
entidadBancariaDAO.delete(idEntidadBancaria);
List<EntidadBancaria> entidadesBancarias = entidadBancariaDAO.findAll();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <div align="center"> 
            Entidad Bancaria 
            
            Mostrar todas
            <table><th>ID</th><th>CIF</th><th>NOMBRE</th><th>TIPO</th><tr>
            <% for (EntidadBancaria entidadBancaria:entidadesBancarias){%>
                <td><%out.print(entidadBancaria.getId());%></td>
                <td><%out.print(entidadBancaria.getCif());%></td>
                <td><%out.print(entidadBancaria.getNombre());%></td>
                <td><%out.print(entidadBancaria.getTipoEntidadBancaria());%></td>
                </tr>
                <%
            } 
            %>
            <br>
        </div>
    </body>
</html>