<%@page import="com.fpmislata.banco.negocio.EntidadBancaria"%>
<%@page import="java.util.List"%>
<%@page import="com.fpmislata.banco.datos.EntidadBancariaDAOImpHibernate"%>
<%@page import="com.fpmislata.banco.datos.EntidadBancariaDAO"%>
<%@page import="com.fpmislata.banco.datos.EntidadBancariaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Busqueda</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
        <link href="/js/bootstrap.js" rel="javascript" type="text/javascript">
    </head>
    <body>
        <div align="center" style="margin: 40px 50px;"> 
            <h1>BUSCAR Entidad Bancaria</h1>
            <form method="Get" action="muestraBuscarNombre.jsp" class="form-search">
                <input type="text" name="nombre">
                <button type="submit" class="btn">Buscar</button>
                </input>
            </form>
            <p><a href="index.jsp">Inicio</a></p>
        </div>

    </body>
</html>
