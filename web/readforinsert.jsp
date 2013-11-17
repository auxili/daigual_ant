<%@page import="com.fpmislata.banco.negocio.TipoEntidadBancaria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insertar</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
        <link href="/js/bootstrap.js" rel="javascript" type="text/javascript">
    </head>
    <body>
        <div id="contieneTabla" style="margin: 40px 100px">
            <p>Inserte su entidad Bancaria nueva</p>
            <form class="form-inline" method="Get" action="insert.jsp">
                <input type="text" name="id" class="input-small" placeholder="IdEntidad"><br>
                <input type="text" name="codigoEntidad" class="input-small" placeholder="Codigo"><br>
                <input type="text" name="cif" class="input-small" placeholder="C.I.F."><br>
                <input type="text" name="nombre" class="input-small" placeholder="Nombre"> <br>


                <select name="tipoEntidadBancaria">
                    <option selected>Elije entidad</option>
                    <option value="<%= TipoEntidadBancaria.CajaAhorro.name()%>">Caja de ahorros</option>
                    <option value="<%= TipoEntidadBancaria.Banco.name()%>">Banco</option>
                    <option value="<%= TipoEntidadBancaria.CoopCredito.name()%>">Cooperativa Credito</option>
                    <option value="<%= TipoEntidadBancaria.EstableFinanCredito.name()%>">Establ. Financiero</option>
                </select>
                <br/><br/><input type="submit" class="btn">
            </form>
                <p><a href="index.jsp">Inicio</a></p>
                <p><a href="buscar.jsp">Buscar Entidad Bancaria</a></p>
        </div>
    </body>
</html>
