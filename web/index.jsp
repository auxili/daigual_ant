<%@page import="com.fpmislata.banco.datos.EntidadBancariaDAOImpJDBC"%>
<%@page import="javax.sound.midi.Soundbank"%>
<%@page import="java.util.List"%>
<%@page import="com.fpmislata.banco.negocio.EntidadBancaria"%>
<%@page import="com.fpmislata.banco.datos.EntidadBancariaDAO"%>

<%

EntidadBancariaDAO entidadBancariaDAO = new EntidadBancariaDAOImpJDBC();
//EntidadBancaria entidadBancaria = entidadBancariaDAO.read(6);
List<EntidadBancaria> entidadesBancarias = entidadBancariaDAO.findAll();
String nombre=request.getParameter("nombre");
List<EntidadBancaria> entidadesBancarias1 = entidadBancariaDAO.findByNombre(nombre);

%>
<html>
    <head>
        <title>EntidadBancaria</title>
    </head>
    <body>
        <div align="center"> 
            <a href="nuevo.jsp">Insertar entidad bancaria</a>
            <br>
            Entidad Bancaria 
            Mostrar todas
            <table><th>ID</th><th>CIF</th><th>NOMBRE</th><th>TIPO</th><th>Elimina</th><tr>
            <% for (EntidadBancaria entidadBancaria:entidadesBancarias){%>
                <td><%out.print(entidadBancaria.getId());%></td>
                <td><%out.print(entidadBancaria.getCif());%></td>
                <td><%out.print(entidadBancaria.getNombre());%></td>
                <td><%out.print(entidadBancaria.getTipoEntidadBancaria());%></td>
                <td><a href="delete.jsp?id=<%= entidadBancaria.getId() %>">Borrar</a></td>
                </tr>
                <%
            } 
            %>
            </table><%out.print(nombre);%>
            <br>
        </div>
            <div align="center"> 
            Entidad Bancaria 
 
            Mostrar todas que contengan la letra a
            <table><th>ID</th><th>CIF</th><th>NOMBRE</th><th>TIPO</th><tr>
            <% for (EntidadBancaria entidadBancaria:entidadesBancarias1){
                %><td><%out.print(entidadBancaria.getId());%></td>
                <td><%out.print(entidadBancaria.getCif());%></td>
                <td><%out.print(entidadBancaria.getNombre());%></td>
                <td><%out.print(entidadBancaria.getTipoEntidadBancaria());%></td>
                </tr>
                <%
            } 
            %>
            </table><%out.print(nombre);%>
            <br>
        </div>
    </body>
</html>


