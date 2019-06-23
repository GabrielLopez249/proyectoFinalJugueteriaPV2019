/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.form.bean;

import aplicacion.bean.ClienteBean;
import aplicacion.modelo.dominio.Cliente;
import aplicacion.modelo.dominio.Usuario;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author gabri
 */
@ManagedBean
@ViewScoped
public class ClienteFormBean {

    @ManagedProperty(value="#{clienteBean}")
    private ClienteBean clienteBean;
    private Usuario unUsuario;
    private String nomUs;
    private String apeUs;
    private String tell;
    private int dni;
    private String domicilio;
    private String provincia;
    private String pais;
    private Date fechaNac;
    private String email;
    private Cliente unCliente;
    
    public ClienteFormBean() {
        
    }
    public void agregarCliente(){
        getClienteBean().crearUsuario(unCliente);
        
    }

    /**
     * @return the dni
     */
    public int getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(int dni) {
        this.dni = dni;
    }

    /**
     * @return the domicilio
     */
    public String getDomicilio() {
        return domicilio;
    }

    /**
     * @param domicilio the domicilio to set
     */
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    /**
     * @return the provincia
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * @param provincia the provincia to set
     */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    /**
     * @return the pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * @return the fechaNac
     */
    public Date getFechaNac() {
        return fechaNac;
    }

    /**
     * @param fechaNac the fechaNac to set
     */
    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the clienteBean
     */
    public ClienteBean getClienteBean() {
        return clienteBean;
    }

    /**
     * @param clienteBean the clienteBean to set
     */
    public void setClienteBean(ClienteBean clienteBean) {
        this.clienteBean = clienteBean;
    }

    /**
     * @return the unUsuario
     */
    public Usuario getUnUsuario() {
        return unUsuario;
    }

    /**
     * @param unUsuario the unUsuario to set
     */
    public void setUnUsuario(Usuario unUsuario) {
        this.unUsuario = unUsuario;
    }

    /**
     * @return the nomUs
     */
    public String getNomUs() {
        return nomUs;
    }

    /**
     * @param nomUs the nomUs to set
     */
    public void setNomUs(String nomUs) {
        this.nomUs = nomUs;
    }

    /**
     * @return the apeUs
     */
    public String getApeUs() {
        return apeUs;
    }

    /**
     * @param apeUs the apeUs to set
     */
    public void setApeUs(String apeUs) {
        this.apeUs = apeUs;
    }

    /**
     * @return the tell
     */
    public String getTell() {
        return tell;
    }

    /**
     * @param tell the tell to set
     */
    public void setTell(String tell) {
        this.tell = tell;
    }

    /**
     * @return the unCliente
     */
    public Cliente getUnCliente() {
        return unCliente;
    }

    /**
     * @param unCliente the unCliente to set
     */
    public void setUnCliente(Cliente unCliente) {
        this.unCliente = unCliente;
    }
    
}
