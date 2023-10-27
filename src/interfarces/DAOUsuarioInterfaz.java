/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfarces;

import excepciones.CantidadException;
import excepciones.PrestamoVencidoException;
import modelos.Prestamo;


/**
 *
 * @author LENOVO
 */
public interface DAOUsuarioInterfaz {
    
    void solicitarPrestamo(Prestamo prestamo) throws CantidadException, PrestamoVencidoException;
    void devolverPrestamo(Prestamo prestamo);
}
