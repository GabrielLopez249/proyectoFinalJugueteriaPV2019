/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao;

import aplicacion.modelo.dominio.Factura;

/**
 *
 * @author gabri
 */
public interface FacturaDao {
    public void agregarFartura(Factura unaFactura);
    public void modificarFactura(Factura unaFactura);
    public void eliminarFactura(Factura unaFactura);
}
