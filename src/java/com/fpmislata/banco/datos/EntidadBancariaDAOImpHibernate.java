package com.fpmislata.banco.datos;

import com.fpmislata.banco.negocio.EntidadBancaria;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class EntidadBancariaDAOImpHibernate extends GenericDAOImplHibernate<EntidadBancaria, Integer> implements EntidadBancariaDAO {
     public List<EntidadBancaria> findByCodigo(String Codigo) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT entidadBancaria FROM  WHERE idEntidadBancaria = ?");
        query.setString(0, Codigo);
        List list = query.list();
        session.close();
        return list;
    }


    public List<EntidadBancaria> findByNombre(String letraNombre) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT entidadBancaria FROM EntidadBancaria entidadBancaria WHERE nombre like ?");
        query.setString(0, "%"+letraNombre+"%");
        List list = query.list();
        session.close();
        return list;
    }   

}
