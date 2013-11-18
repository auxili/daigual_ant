<%@page import="com.fpmislata.banco.datos.EntidadBancariaDAOImpHibernate"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
        <link href="/js/bootstrap.js" rel="javascript" type="text/javascript">
    </head>
    <body>
        <div id="contieneTabla" style="margin: 40px 100px; width: 200px">
            <h5>Actualice la entidad Bancaria</h5>

            <form method="Get" action="update.jsp">
                <table class="table table-striped">
                    <tr>
                        <td>Id</td><td><input type="text" name="id" readonly="readonly" class="input-small" value="<%out.print(entidadBancaria.getId());%>"></td>
                    </tr>
                    <tr>
                        <td>Codigo</td><td><input type="text" name="codigoEntidad" value="<%out.print(entidadBancaria.getCodigoEntidad());%>"></td>
                    </tr>
                    <tr>
                        <td>CIF:</td><td><input type="text" name="cif" value="<%out.print(entidadBancaria.getCif());%>"></td>
                    </tr>
                    <tr>
                        <td>Nombre:</td><td><input type="text" name="nombre" value="<%out.print(entidadBancaria.getNombre());%>"></td>
                    </tr>
                    <tr>
                        <td>
                            <select name="tipoEntidadBancaria">
                                <option selected>Elije entidad</option>
                                <option value="<%= TipoEntidadBancaria.CajaAhorro.name()%>">Caja de ahorros</option>
                                <option value="<%= TipoEntidadBancaria.Banco.name()%>">Banco</option>
                                <option value="<%= TipoEntidadBancaria.CoopCredito.name()%>">Cooperativa Credito</option>
                                <option value="<%= TipoEntidadBancaria.EstableFinanCredito.name()%>">Establ. Financiero</option>
                            </select>
                        </td>

                        <td><input type="submit"></td>
                    </tr>
                </table>
            </form>
            <p><a href="index.jsp">Inicio</a></p>
        </div>
    </body>
</html>