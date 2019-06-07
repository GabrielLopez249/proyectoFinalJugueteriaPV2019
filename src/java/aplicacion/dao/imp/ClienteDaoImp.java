/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao.imp;

import aplicacion.dao.ClienteDao;
import aplicacion.hibernate.configuracion.HibernateUtil;
import aplicacion.modelo.dominio.Clientes;
import org.hibernate.Session;

/**
 *
 * @author gabri
 */
public class ClienteDaoImp implements ClienteDao{

    @Override
    public void agregarCliente(Clientes unCliente) {
       Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(unCliente);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void modificarCliente(Clientes unCliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
