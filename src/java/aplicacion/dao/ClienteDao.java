/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao;

import aplicacion.modelo.dominio.Cliente;

/**
 *
 * @author gabri
 */
public interface ClienteDao {
    void agregarCliente(Cliente unCiente);
    void modificarCliente(Cliente unCliente);
}
