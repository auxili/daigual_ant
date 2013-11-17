<%@page import="com.fpmislata.banco.datos.EntidadBancariaDAOImpHibernate"%>
<%@page import="com.fpmislata.banco.negocio.EntidadBancaria"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    EntidadBancariaDAOImpHibernate entidadBancariaDAO = new EntidadBancariaDAOImpHibernate();
    String nombre = request.getParameter("nombre");
    List<EntidadBancaria> entidadesBancariasFinded = entidadBancariaDAO.findByNombre(nombre);

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado de la busqueda</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
        <link href="/js/bootstrap.js" rel="javascript" type="text/javascript">
    </head>
    <body>
        <div align="center" style="margin: 40px 50px;">
            <h1>Busqueda finalizada</h1>
            <p>Resultado busqueda para: <% out.print(nombre);%> </p>

            <table class="table table-bordered"><th>ID</th><th>Codigo</th><th>CIF</th><th>Nombre</th><th>TIPO</th><tr>
                    <% for (EntidadBancaria entidadBancaria : entidadesBancariasFinded) {%>
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
        <p><a href="buscar.jsp">Realizar otra busqueda</a></p>
        </div>
    </body>
</html>
