<%@page import="com.fpmislata.banco.datos.EntidadBancariaDAOImpHibernate"%>
<%@page import="com.fpmislata.banco.datos.EntidadBancariaDAOImpJDBC"%>
<%@page import="javax.sound.midi.Soundbank"%>
<%@page import="java.util.List"%>
<%@page import="com.fpmislata.banco.negocio.EntidadBancaria"%>
<%@page import="com.fpmislata.banco.datos.EntidadBancariaDAO"%>
<%
EntidadBancariaDAO entidadBancariaDAO = new EntidadBancariaDAOImpHibernate();
List<EntidadBancaria> entidadesBancarias = entidadBancariaDAO.findAll();
%>
<html>
    <head>
        <title>EntidadBancaria</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
        <link href="/js/bootstrap.js" rel="javascript" type="text/javascript">
    </head>
    <body>
        <div align="center" style="margin: 40px 50px;"> 
            <h1>Entidades Bancarias</h1>
            <table class="table table-striped"><th>ID</th><th>Codigo</th><th>CIF</th><th>NOMBRE</th><th>TIPO</th><th>Elimina</th><th>Edita</th><tr>
            <% for (EntidadBancaria entidadBancaria:entidadesBancarias){%>
                <td><%out.print(entidadBancaria.getId());%></td>
                <td><%out.print(entidadBancaria.getCodigoEntidad());%></td>
                <td><%out.print(entidadBancaria.getCif());%></td>
                <td><%out.print(entidadBancaria.getNombre());%></td>
                <td><%out.print(entidadBancaria.getTipoEntidadBancaria());%></td>
                <td><a href="delete.jsp?id=<%= entidadBancaria.getId() %>">Borrar</a></td>
                <td><a href="readforupdate.jsp?id=<%= entidadBancaria.getId() %>">Editar</a></td>
                </tr>
                <%
            } 
            %>
            </table>
            <a href="readforinsert.jsp">Insertar entidad bancaria</a>
            <p><a href="buscar.jsp">Buscar Entidad Bancaria</a></p>
        </div>
    </body>
</html>


