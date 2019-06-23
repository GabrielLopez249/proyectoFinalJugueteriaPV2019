/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao;

import aplicacion.modelo.dominio.Categoria;

/**
 *
 * @author gabri
 */
public interface CategoriaDao {
    public void agregarCategoria(Categoria unaCategoria);
    public void modificarCategoria(Categoria unaCategoria);
    public void eliminarCategoria(Categoria unaCategoria);
}
