/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.bean;

import aplicacion.dao.UsuarioDao;
import aplicacion.modelo.dominio.Usuario;
import aplicacion.dao.imp.UsuarioDaoImp;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author gabri
 */
@ManagedBean
@ViewScoped
public class UsuarioBean {

    public UsuarioBean() {
    }
    public Usuario validarUsuario(String nombreUs, String passwUs){
        Usuario usuario=null;
        UsuarioDao usuarioDAO=new UsuarioDaoImp();
        usuario=usuarioDAO.validarUsuario(nombreUs, passwUs);
        return usuario;
    }

    public Usuario obtenerUsuario(String nombreUsuario){
        UsuarioDao usuarioDao=new UsuarioDaoImp();
        return usuarioDao.obtenerUsuario(nombreUsuario);
    }
}
