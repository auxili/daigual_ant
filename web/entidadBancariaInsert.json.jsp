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
