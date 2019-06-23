/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao.imp;

import aplicacion.dao.FacturaDao;
import aplicacion.hibernate.configuracion.HibernateUtil;
import aplicacion.modelo.dominio.Factura;
import org.hibernate.Session;

/**
 *
 * @author gabri
 */
public class FacturaDaoImp implements FacturaDao{

    @Override
    public void agregarFartura(Factura unaFactura) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(unaFactura);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void modificarFactura(Factura unaFactura) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(unaFactura);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void eliminarFactura(Factura unaFactura) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(unaFactura);
        session.getTransaction().commit();
        session.close();
    }
    
}
