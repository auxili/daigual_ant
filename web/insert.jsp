<%@page import="com.fpmislata.banco.datos.EntidadBancariaDAOImpHibernate"%>
<%@page import="com.fpmislata.banco.negocio.TipoEntidadBancaria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.fpmislata.banco.datos.EntidadBancariaDAOImpJDBC"%>
<%@page import="javax.sound.midi.Soundbank"%>
<%@page import="java.util.List"%>
<%@page import="com.fpmislata.banco.negocio.EntidadBancaria"%>
<%@page import="com.fpmislata.banco.datos.EntidadBancariaDAO"%>

<%
    EntidadBancariaDAO entidadBancariaDAO = new EntidadBancariaDAOImpHibernate();
    String id = request.getParameter("id");
    String codigoEntidad = request.getParameter("codigoEntidad");
    String cif = request.getParameter("cif");
    String nombre = request.getParameter("nombre");
    Integer idEntidadBancaria = Integer.parseInt(id);
    String tipoEntidadBancariaStr = request.getParameter("tipoEntidadBancaria");
    TipoEntidadBancaria tipoEntidadBancaria = TipoEntidadBancaria.valueOf(tipoEntidadBancariaStr);

    EntidadBancaria EntidadNueva = new EntidadBancaria(idEntidadBancaria, codigoEntidad, nombre, cif, tipoEntidadBancaria);

    entidadBancariaDAO.insert(EntidadNueva);
    List<EntidadBancaria> entidadesBancarias = entidadBancariaDAO.findAll();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insertar Entidad Bancaria</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
        <link href="/js/bootstrap.js" rel="javascript" type="text/javascript">
    </head>
    <body>
        <div align="center" style="margin: 60px 50px;"> 
            Entidad Bancaria 
            <h1>ENTIDAD BANCARIA INSERTADA</h1>
            Mostrar todas

            <table class="table table-striped"><th>ID</th><th>Codigo</th><th>CIF</th><th>Nombre</th><th>TIPO</th><tr>
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
            <p><a href="buscar.jsp">Buscar Entidad Bancaria</a></p>
        </div>

    </body>
</html>