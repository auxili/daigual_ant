<%@page import="com.fpmislata.banco.datos.EntidadBancariaDAOImpHibernate"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.fpmislata.banco.datos.EntidadBancariaDAOImpJDBC"%>
<%@page import="javax.sound.midi.Soundbank"%>
<%@page import="java.util.List"%>
<%@page import="com.fpmislata.banco.negocio.EntidadBancaria"%>
<%@page import="com.fpmislata.banco.datos.EntidadBancariaDAO"%>

<%

    EntidadBancariaDAO entidadBancariaDAO = new EntidadBancariaDAOImpHibernate();
    String id = request.getParameter("id");
    Integer idEntidadBancaria = Integer.parseInt(id);
    entidadBancariaDAO.delete(idEntidadBancaria);
    List<EntidadBancaria> entidadesBancarias = entidadBancariaDAO.findAll();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Borrado Entidad</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
        <link href="/js/bootstrap.js" rel="javascript" type="text/javascript">
    </head>
    <body>
        <div align="center" style="margin: 40px 50px;"> 
            <h1>Entidad Bancaria Borrada</h1>
            <table class="table table-striped"><th>ID</th><th>Codigo</th><th>CIF</th><th>Nombre</th><th>TIPO</th>
                <tr>
                    <% for (EntidadBancaria entidadBancaria : entidadesBancarias) {%>
                    <td><%out.print(entidadBancaria.getId());%></td>
                    <td><%out.print(entidadBancaria.getCodigoEntidad());%></td>
                    <td><%out.print(entidadBancaria.getCif());%></td>
                    <td><%out.print(entidadBancaria.getNombre());%></td>
                    <td><%out.print(entidadBancaria.getTipoEntidadBancaria());%></td>
                </tr>
                <%
                    }
                %>
            </table>
            <p><a href="index.jsp">Inicio</a></p>
        </div>
    </body>
</html>
