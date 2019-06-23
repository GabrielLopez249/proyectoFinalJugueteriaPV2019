/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao;

import aplicacion.modelo.dominio.Detalle;

/**
 *
 * @author gabri
 */
public interface DetalleDao {
    public void agregarDetalle(Detalle unDetalle);
    public void modificarDetalle(Detalle unDetalle);
    public void eliminarDetallle(Detalle unDetalle);
}
