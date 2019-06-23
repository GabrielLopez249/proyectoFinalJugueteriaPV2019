/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao.imp;

import aplicacion.dao.CategoriaDao;
import aplicacion.hibernate.configuracion.HibernateUtil;
import aplicacion.modelo.dominio.Categoria;
import org.hibernate.Session;

/**
 *
 * @author gabri
 */
public class CategoriaDaoImp implements CategoriaDao{

    @Override
    public void agregarCategoria(Categoria unaCategoria) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(unaCategoria);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void modificarCategoria(Categoria unaCategoria) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(unaCategoria);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void eliminarCategoria(Categoria unaCategoria) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(unaCategoria);
        session.getTransaction().commit();
        session.close();
    }
    
}
