<%@page import="com.fpmislata.banco.datos.EntidadBancariaDAOImpHibernate"%>
<%@page import="com.fpmislata.banco.negocio.TipoEntidadBancaria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@page import="com.fpmislata.banco.datos.EntidadBancariaDAOImpJDBC"%>
<%@page import="javax.sound.midi.Soundbank"%>
<%@page import="java.util.List"%>
<%@page import="com.fpmislata.banco.negocio.EntidadBancaria"%>
<%@page import="com.fpmislata.banco.datos.EntidadBancariaDAO"%>

<%
EntidadBancariaDAOImpHibernate entidadBancariaDAO = new EntidadBancariaDAOImpHibernate();
String id = request.getParameter("id");
String codigoEntidad = request.getParameter("codigoEntidad");
String cif = request.getParameter("cif");
String nombre = request.getParameter("nombre");
Integer idEntidadBancaria = Integer.parseInt(id);
String tipoEntidadBancariaStr = request.getParameter("tipoEntidadBancaria");
TipoEntidadBancaria tipoEntidadBancaria = TipoEntidadBancaria.valueOf(tipoEntidadBancariaStr);

EntidadBancaria EntidadNueva = new EntidadBancaria(idEntidadBancaria, codigoEntidad, nombre, cif, tipoEntidadBancaria);

entidadBancariaDAO.update(EntidadNueva);

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
            <h1>ENTIDAD BANCARIA INSERTADA</h1>
            Mostrar todas
            <table class="table table-striped"><th>ID</th><th>CIF</th><th>NOMBRE</th><th>TIPO</th><tr>
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