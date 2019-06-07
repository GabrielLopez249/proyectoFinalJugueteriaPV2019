/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.form.bean;

import aplicacion.modelo.dominio.Clientes;
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
    Clientes cliente;
    int dni;
    String domicilio;
    String provincia;
    String pais;
    Date fechaNac;
    String email;
    
    public ClienteFormBean() {
        
    }
    
}
