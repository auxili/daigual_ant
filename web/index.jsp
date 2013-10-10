<%@page import="javax.sound.midi.Soundbank"%>
<%@page import="java.util.List"%>
<%@page import="com.fpmislata.banco.negocio.EntidadBancaria"%>
<%@page import="com.fpmislata.banco.datos.EntidadBancariaDAO"%>

<%
EntidadBancariaDAO entidadBancariaDAO = new EntidadBancariaDAO();
//EntidadBancaria entidadBancaria = entidadBancariaDAO.read(6);
List<EntidadBancaria> entidadesBancarias = entidadBancariaDAO.findAll();
       
%>
<html>
    <head>
        <title>EntidadBancaria</title>
    </head>
    <body>
        <div align="center"> 
            Entidad Bancaria 
 
            Mostrar todas
            <table><th>ID</th><th>CIF</th><th>NOMBRE</th><th>TIPO</th><tr>
            <% for (EntidadBancaria entidadBancaria:entidadesBancarias){
                %><td><%out.print(entidadBancaria.getId());%></td>
                <td><%out.print(entidadBancaria.getCif());%></td>
                <td><%out.print(entidadBancaria.getNombre());%></td>
                <td><%out.print(entidadBancaria.getTipoEntidadBancaria());%></td>
                </tr>
                <%
            } 
            %>
            </table>
            <br>
        </div>
    </body>
</html>


