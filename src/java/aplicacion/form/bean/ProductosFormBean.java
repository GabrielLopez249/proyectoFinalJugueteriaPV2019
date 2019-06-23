 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.form.bean;

import aplicacion.bean.ProductoBean;
import aplicacion.modelo.dominio.Categoria;
import aplicacion.modelo.dominio.Producto;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
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
public class ProductosFormBean {
    @ManagedProperty(value="#{productoBean}")
    private ProductoBean productoBean;
    private Producto unProducto;
    private ArrayList<Categoria> categorias;
    private transient UploadFile archivo = null;
    
    public ProductosFormBean() {
    }
    @PostConstruct
    public void agregarProducto(){
        getUnProducto().setEstado(true);
        
        if(getArchivo() != null){
            byte[] contents = getArchivo.getContents();
            getUnProducto().setFoto(contents);
        }
       else
        {
            getUnProducto().getFoto(null);
        }
        try {
            getProductoBean().crearProducto(getUnProducto());
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Producto agregado correctamente", "producto" + getUnProducto().getDescripcion());
             FacesContext.getCurrentInstance().addMessage(null, facesMessage);    
        } catch(Exception e){
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error Grave", "No se puede agregar el producto");
             FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
            setUnProducto(new Producto());
    }

    /**
     * @return the unProducto
     */
    public Producto getUnProducto() {
        return unProducto;
    }

    /**
     * @param unProducto the unProducto to set
     */
    public void setUnProducto(Producto unProducto) {
        this.unProducto = unProducto;
    }

    /**
     * @return the categorias
     */
    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    /**
     * @param categorias the categorias to set
     */
    public void setCategorias(ArrayList<Categoria> categorias) {
        this.categorias = categorias;
    }

    /**
     * @return the productoBean
     */
    public ProductoBean getProductoBean() {
        return productoBean;
    }

    /**
     * @param productoBean the productoBean to set
     */
    public void setProductoBean(ProductoBean productoBean) {
        this.productoBean = productoBean;
    }

    /**
     * @return the archivo
     */
    public UploadFile getArchivo() {
        return archivo;
    }

    /**
     * @param archivo the archivo to set
     */
    public void setArchivo(UploadFile archivo) {
        this.archivo = archivo;
    }
}
