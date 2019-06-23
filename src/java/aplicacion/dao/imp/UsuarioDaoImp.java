/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao.imp;

import aplicacion.dao.UsuarioDao;
import aplicacion.hibernate.configuracion.HibernateUtil;
import aplicacion.modelo.dominio.Usuario;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author gabri
 */
public class UsuarioDaoImp implements UsuarioDao{

    @Override
    public Usuario validarUsuario(String nombreUs, String passUs) {
        Usuario u = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria=session.createCriteria(Usuario.class);
        criteria.add(Restrictions.like("nombreUsuario", nombreUs));
        criteria.add(Restrictions.like("password", passUs));
        criteria.add(Restrictions.like("estado", true));
        if(!criteria.list().isEmpty()){
            u=(Usuario)criteria.list().get(0);            
        }
        session.getTransaction().commit();
        session.close();
        return u;    
    }

    @Override
    public Usuario obtenerUsuario(String nombreUs) {
        Usuario u = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria=session.createCriteria(Usuario.class);
        criteria.add(Restrictions.like("nombreUsuario", nombreUs));
        if(!criteria.list().isEmpty()){
            u=(Usuario)criteria.list().get(0);            
        }
        session.getTransaction().commit();
        session.close();
        return u;  
    }

    @Override
    public void modificar(Usuario unUsuario) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(unUsuario);
        session.getTransaction().commit();
        session.close();
        
    }

    @Override
    public void crearUsuario(Usuario unUsuario) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(unUsuario);
        session.getTransaction().commit();
        session.close();
    }

}
