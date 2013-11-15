<%@page import="com.fpmislata.banco.datos.EntidadBancariaDAOImpHibernate"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="com.fpmislata.banco.negocio.TipoEntidadBancaria"%>
<%@page import="com.fpmislata.banco.datos.EntidadBancariaDAOImpJDBC"%>
<%@page import="javax.sound.midi.Soundbank"%>
<%@page import="java.util.List"%>
<%@page import="com.fpmislata.banco.negocio.EntidadBancaria"%>
<%@page import="com.fpmislata.banco.datos.EntidadBancariaDAO"%>

<%
EntidadBancariaDAO entidadBancariaDAO = new EntidadBancariaDAOImpHibernate();
String id = request.getParameter("id");
Integer idEntidadBancaria = Integer.parseInt(id);
EntidadBancaria entidadBancaria = entidadBancariaDAO.read(idEntidadBancaria);

List<EntidadBancaria> entidadesBancarias = entidadBancariaDAO.findAll();
%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="Get" action="update.jsp">
            Id<input type="text" name="id" readonly="readonly" value="<%out.print(entidadBancaria.getId());%>"><br>
            Codigo<input type="text" name="codigoEntidad" value="<%out.print(entidadBancaria.getCodigoEntidad());%>"><br>
            CIF:<input type="text" name="cif" value="<%out.print(entidadBancaria.getCif());%>"><br>
            Nombre:<input type="text" name="nombre" value="<%out.print(entidadBancaria.getNombre());%>"> <br>            
            
            <select name="tipoEntidadBancaria">
                <option selected>Elije entidad</option>
                <option value="<%= TipoEntidadBancaria.CajaAhorro.name()%>">Caja de ahorros</option>
                <option value="<%= TipoEntidadBancaria.Banco.name()%>">Banco</option>
                <option value="<%= TipoEntidadBancaria.CoopCredito.name() %>">Cooperativa Credito</option>
                <option value="<%= TipoEntidadBancaria.EstableFinanCredito.name() %>">Establ. Financiero</option>
            </select>
            
            <input type="submit">
        </form>
        
    </body>
</html>