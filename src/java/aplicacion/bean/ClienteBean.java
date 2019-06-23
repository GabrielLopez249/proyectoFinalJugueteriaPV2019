/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.bean;

import aplicacion.dao.ClienteDao;
import aplicacion.dao.imp.ClienteDaoImp;
import aplicacion.modelo.dominio.Cliente;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author gabri
 */
@ManagedBean
@SessionScoped
public class ClienteBean {

    
    public ClienteBean() {
    }
    public void crearUsuario(Cliente cliente){
      ClienteDao clienteDAO=new ClienteDaoImp();
      clienteDAO.agregarCliente(cliente);
    }
}
