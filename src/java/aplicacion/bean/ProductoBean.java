/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.bean;

import aplicacion.dao.ProductoDao;
import aplicacion.dao.imp.ProductoDaoImp;
import aplicacion.modelo.dominio.Producto;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author gabri
 */
@ManagedBean
@ViewScoped
public class ProductoBean {

    public ProductoBean() {
    }
    
    public void crearProducto(Producto UnP){
      ProductoDao productoDAO=new ProductoDaoImp();
      productoDAO.agregarProducto(UnP);
    }
}
