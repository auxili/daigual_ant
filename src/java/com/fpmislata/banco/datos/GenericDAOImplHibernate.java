package com.fpmislata.banco.datos;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

//Este hay que poner que le ID que es PK de la BD hay que hacerla serializable
public class GenericDAOImplHibernate<T, ID extends Serializable> implements GenericDAO<T, ID>{ 
    /*public T read(ID id);
    public void insert (T t);    
    public void update (T t);
    public void delete (ID id);
    public List<T> findAll();*/
    
   
    SessionFactory sessionFactory;

    public GenericDAOImplHibernate(/*SessionFactory sessionFactory*/) {
        this.sessionFactory = HibernateUtil.getSessionFactory();

    }

    //READ
    @Override
    public T read(ID id) {
       /*Session session = sessionFactory.openSession();*/
        Session session = sessionFactory.getCurrentSession();
        T t;
        try {
            session.beginTransaction();
            t = (T) session.get(getEntityClass(), id);
            session.getTransaction().commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
            throw new RuntimeException(ex);
        }finally {
            if ((session!=null) && (session.isConnected()==true)) {
                /*Y NO CERRAMOS LAS SESIONES porque sino no podemos hacer una
                 carga perezosa
                 */
                /*session.close();*/
            }
        }
        return t;
    }
    //UPDATE

    @Override
    public void update(T t) {
        Session session = sessionFactory.getCurrentSession();
  
        try {
            session.beginTransaction();
            session.update(t);
            session.getTransaction().commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
            throw new RuntimeException(ex);
        }finally {
            if ((session!=null) && (session.isConnected()==true)) {
                
            }
        }
    }
    @Override
    public void delete(ID id) {
        //DELETE
        Session session = sessionFactory.getCurrentSession();
        T t;
        try {
            session.beginTransaction();
            t = (T) session.get(getEntityClass(), id);
            session.delete(t);
            session.getTransaction().commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
            throw new RuntimeException(ex);
        }finally {
            if ((session!=null) && (session.isConnected()==true)) {
              
            }
        }
    }

    @Override
    public void insert(T t) {
        Session session = sessionFactory.getCurrentSession();
        //SAVE: hace como un insert
        try {
            session.beginTransaction();
            session.save(t);
            session.getTransaction().commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
            throw new RuntimeException(ex);
        } finally {
            if ((session!=null) && (session.isConnected()==true)) {
                
            }
        }
    }




    @Override
    public List<T> findAll() {
        //Esto ya no es SQL es HQL (Hibernate)
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT t FROM "+getEntityClass().getName()+" t ");
        List list = query.list();
        session.close();
        return list;
        
    }
    private Class<T> getEntityClass() {
         return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
     }
}
