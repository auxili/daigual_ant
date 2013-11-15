<%-- 
    Document   : nuevo
    Created on : 07-nov-2013, 10:41:19
    Author     : alumno
--%>

<%@page import="com.fpmislata.banco.negocio.TipoEntidadBancaria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="Get" action="insert.jsp">
            Id:<input type="text" name="id" ><br>
            Codigo<input type="text" name="codigoEntidad"><br>
            CIF:<input type="text" name="cif"><br>
            Nombre:<input type="text" name="nombre"> <br>


            <select name="tipoEntidadBancaria">
                <option selected>Elije entidad</option>
                <option value="<%= TipoEntidadBancaria.CajaAhorro.name()%>">Caja de ahorros</option>
                <option value="<%= TipoEntidadBancaria.Banco.name()%>">Banco</option>
                <option value="<%= TipoEntidadBancaria.CoopCredito.name() %>">Cooperativa Credito</option>
                <option value="<%= TipoEntidadBancaria.EstableFinanCredito.name() %>">Establ. Financiero</option>
            </select>
            <br/><input type="submit">
        </form>
    </body>
</html>
