/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao;

import aplicacion.modelo.dominio.Producto;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public interface ProductoDao {
    public void agregarProducto(Producto unP);
    public void modificarProducto(Producto unP);
    public void eliminarProducto(Producto unP);
    public ArrayList<Producto> buscarProducto(int codProducto);
}
