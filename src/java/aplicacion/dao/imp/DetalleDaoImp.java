/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao.imp;

import aplicacion.dao.DetalleDao;
import aplicacion.hibernate.configuracion.HibernateUtil;
import aplicacion.modelo.dominio.Detalle;
import org.hibernate.Session;

/**
 *
 * @author gabri
 */
public class DetalleDaoImp implements DetalleDao{

    @Override
    public void agregarDetalle(Detalle unDetalle) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(unDetalle);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void modificarDetalle(Detalle unDetalle) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(unDetalle);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void eliminarDetallle(Detalle unDetalle) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(unDetalle);
        session.getTransaction().commit();
        session.close();
    }
    
}
