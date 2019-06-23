/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao.imp;

import aplicacion.dao.ModoPagoDao;
import aplicacion.hibernate.configuracion.HibernateUtil;
import aplicacion.modelo.dominio.Modopago;
import org.hibernate.Session;

/**
 *
 * @author gabri
 */
public class ModoPagoDaoImp implements ModoPagoDao{

    @Override
    public void agregarModoPago(Modopago unMPago) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(unMPago);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void modificarMP(Modopago unMpago) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(unMpago);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void eliminarMP(Modopago unMpago) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(unMpago);
        session.getTransaction().commit();
        session.close();
    }
    
}
