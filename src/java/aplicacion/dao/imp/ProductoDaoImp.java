/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao.imp;

import aplicacion.dao.ProductoDao;
import aplicacion.hibernate.configuracion.HibernateUtil;
import aplicacion.modelo.dominio.Producto;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author gabri
 */
public class ProductoDaoImp implements ProductoDao{

    @Override
    public void agregarProducto(Producto unP) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(unP);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void modificarProducto(Producto unP) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(unP);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void eliminarProducto(Producto unP) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(unP);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public ArrayList<Producto> buscarProducto(int codProducto) {
        ArrayList<Producto> u = null;
        return u;  
    }
    
}
