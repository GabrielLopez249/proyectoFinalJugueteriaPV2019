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
import org.primefaces.model.UploadedFile;

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
    private transient UploadedFile archivo = null;
    private int codProd;
    public ProductosFormBean() {
    }
    @PostConstruct
    public void agregarProducto(){
        getUnProducto().setEstado(true);
        
        if(getArchivo() != null){
            byte[] contents = getArchivo().getContents();
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
    public String consultarProducto(){
        String resultado=null;
        Producto us = productoBean.obtenerProducto(codProd);
        if(us==null){
            FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Producto Invalido","No existe el producto");
          FacesContext.getCurrentInstance().addMessage(null,facesMessage);
        }
        else{
             FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_INFO,"Producto valido","Producto existe");
          FacesContext.getCurrentInstance().addMessage(null,facesMessage);
          FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Producto",us);
          
        }
        return resultado;
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
     * @return the codProd
     */
    public int getCodProd() {
        return codProd;
    }

    /**
     * @param codProd the codProd to set
     */
    public void setCodProd(int codProd) {
        this.codProd = codProd;
    }

    /**
     * @return the archivo
     */
    public UploadedFile getArchivo() {
        return archivo;
    }

    /**
     * @param archivo the archivo to set
     */
    public void setArchivo(UploadedFile archivo) {
        this.archivo = archivo;
    }
}
