/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.form.bean;

import aplicacion.bean.UsuarioBean;
import aplicacion.modelo.dominio.Cliente;
import aplicacion.modelo.dominio.Usuario;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author gabri
 */
@ManagedBean
@ViewScoped
public class loginFormBean {
    @ManagedProperty(value="#{usuarioBean}")
    private UsuarioBean usuarioBean;
    private String nombreUs;
    private String passwUs;
    Cliente cliente;
    /**
     * Creates a new instance of loginFormBean
     */
    public loginFormBean() {
        //usuarioBean = new UsuarioBean();
    }
        public String consultarUsuario(){
        String resultado=null;
        Usuario us = usuarioBean.validarUsuario(nombreUs, passwUs);
        if(us==null){
            FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Credenciales Invalidas","No existe el usuario");
          FacesContext.getCurrentInstance().addMessage(null,facesMessage);
        }
        else{
             FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_INFO,"Credenciales validas","usuario valido");
          FacesContext.getCurrentInstance().addMessage(null,facesMessage);
          FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioValidado",us);
          if (us.getTipoUsuario().equals("admin"))
              resultado="administrador?faces-redirect=true";
          else
              resultado= "listadoProductos";
        }
        return resultado;
    }
    public String cerrarSesion(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_INFO,"Sesion Cerrada","Sesion Cerrada");
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        String resultado="jugueteriaLogin";
        return resultado;
    }

    /**
     * @return the usuarioBean
     */
    public UsuarioBean getUsuarioBean() {
        return usuarioBean;
    }

    /**
     * @param usuarioBean the usuarioBean to set
     */
    public void setUsuarioBean(UsuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
    }

    /**
     * @return the nombreUs
     */
    public String getNombreUs() {
        return nombreUs;
    }

    /**
     * @param nombreUs the nombreUs to set
     */
    public void setNombreUs(String nombreUs) {
        this.nombreUs = nombreUs;
    }

    /**
     * @return the passwUs
     */
    public String getPasswUs() {
        return passwUs;
    }

    /**
     * @param passwUs the passwUs to set
     */
    public void setPasswUs(String passwUs) {
        this.passwUs = passwUs;
    }
}
