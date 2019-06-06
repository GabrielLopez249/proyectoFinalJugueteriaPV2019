/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.form.bean;

import aplicacion.bean.UsuarioBean;
import aplicacion.modelo.dominio.Usuario;
import java.util.ArrayList;
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
public class UsuariosFormBean {

    @ManagedProperty(value="#{UsuarioBean}")
     private UsuarioBean usuariosb;
     private Integer uCodigo;
     private String uNombreUsuario;
     private String uPassword;
     private String uTipoUsuario;
     private boolean uEstado;
     private ArrayList<Usuario> listaUsuarios;
    public UsuariosFormBean() {
        usuariosb=new UsuarioBean();
        
    }
    public String consultarUsuario(){
        String resultado=null;
        Usuario us = getUsuariosb().validarUsuario(getuNombreUsuario(), getuPassword());
        if(us==null){
            FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Credenciales Invalidas","No existe el usuario");
          FacesContext.getCurrentInstance().addMessage(null,facesMessage);
        }
        else{
             FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_INFO,"Credenciales validas","usuario valido");
          FacesContext.getCurrentInstance().addMessage(null,facesMessage);
          FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioValidado",us);
          resultado="/bienvenido";
        }
        return resultado;
    }
    public String getNombreUsuarioValidado(){
        Usuario usuario=(Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValidado");
        return usuario.getNombreUsuario();
    }
    public String cerrarSesion(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_INFO,"Sesion Cerrada","Sesion Cerrada");
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        String resultado="/login";
        return resultado;
    }
    public int verificarSesion(){
        boolean sesionValida=false;
        int tipo=0;
        Usuario usuario=(Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValidado");
        if (usuario!=null){
            sesionValida=true;
            if (usuario.getTipoUsuario().equals("cliente"))
                tipo=1;
        
            if (usuario.getTipoUsuario().equals("admin"))
            {
                tipo=2;
            } 
        }
        return tipo;
    }
    /**
     * @return the usuariosb
     */
    public UsuarioBean getUsuariosb() {
        return usuariosb;
    }

    /**
     * @param usuariosb the usuariosb to set
     */
    public void setUsuariosb(UsuarioBean usuariosb) {
        this.usuariosb = usuariosb;
    }

    /**
     * @return the uCodigo
     */
    public Integer getuCodigo() {
        return uCodigo;
    }

    /**
     * @param uCodigo the uCodigo to set
     */
    public void setuCodigo(Integer uCodigo) {
        this.uCodigo = uCodigo;
    }

    /**
     * @return the uNombreUsuario
     */
    public String getuNombreUsuario() {
        return uNombreUsuario;
    }

    /**
     * @param uNombreUsuario the uNombreUsuario to set
     */
    public void setuNombreUsuario(String uNombreUsuario) {
        this.uNombreUsuario = uNombreUsuario;
    }

    /**
     * @return the uPassword
     */
    public String getuPassword() {
        return uPassword;
    }

    /**
     * @param uPassword the uPassword to set
     */
    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    /**
     * @return the uTipoUsuario
     */
    public String getuTipoUsuario() {
        return uTipoUsuario;
    }

    /**
     * @param uTipoUsuario the uTipoUsuario to set
     */
    public void setuTipoUsuario(String uTipoUsuario) {
        this.uTipoUsuario = uTipoUsuario;
    }

    /**
     * @return the uEstado
     */
    public boolean isuEstado() {
        return uEstado;
    }

    /**
     * @param uEstado the uEstado to set
     */
    public void setuEstado(boolean uEstado) {
        this.uEstado = uEstado;
    }

    /**
     * @return the listaUsuarios
     */
    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    /**
     * @param listaUsuarios the listaUsuarios to set
     */
    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    
}
