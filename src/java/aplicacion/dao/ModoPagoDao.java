/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao;

import aplicacion.modelo.dominio.Modopago;

/**
 *
 * @author gabri
 */
public interface ModoPagoDao {
    public void agregarModoPago(Modopago unMPago);
    public void modificarMP(Modopago unMpago);
    public void eliminarMP(Modopago unMpago);
}
