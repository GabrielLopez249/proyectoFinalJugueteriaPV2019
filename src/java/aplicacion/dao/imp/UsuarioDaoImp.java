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
    public Usuario validarUsuario(String nombreUsuario, String password) {
        Usuario u = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria=session.createCriteria(Usuario.class);
        criteria.add(Restrictions.like("usuNombreUsuario", nombreUsuario));
        criteria.add(Restrictions.like("usuPassword", password));
        criteria.add(Restrictions.like("estado", true));
        if(!criteria.list().isEmpty()){
            u=(Usuario)criteria.list().get(0);            
        }
        session.getTransaction().commit();
        session.close();
        return u;    
    }

    @Override
    public Usuario obtenerUsuario(String nombreUsuario) {
        Usuario u = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria=session.createCriteria(Usuario.class);
        criteria.add(Restrictions.like("usuNombreUsuario", nombreUsuario));
        if(!criteria.list().isEmpty()){
            u=(Usuario)criteria.list().get(0);            
        }
        session.getTransaction().commit();
        session.close();
        return u;  
    }

    @Override
    public void modificar(Usuario unUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
