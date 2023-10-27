/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfarces;

import java.util.ArrayList;
import modelos.Prestamo;
import modelos.Usuario;

/**
 *
 * @author LENOVO
 */
public interface DAOPrestamosInterfaz {
    
    ArrayList<Prestamo> listarTodosPrestamos();
    ArrayList<Prestamo> listarUsuarioPrestamo(Usuario usuario);
    Prestamo seleccionarPrestamo(int id);
    
}
