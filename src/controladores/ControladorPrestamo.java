/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import DAO.DAOPrestamo;
import DAO.DAOUsuario;
import java.util.ArrayList;
import modelos.Prestamo;
import modelos.Usuario;

/**
 *
 * @author LENOVO
 */
public class ControladorPrestamo {
    
    DAOPrestamo DAOPrestamo;
    DAOUsuario DAOUsuario;

    public ControladorPrestamo() {
        DAOPrestamo = new DAOPrestamo();
        DAOUsuario = new DAOUsuario();
    }
    
    public ArrayList<Prestamo> listarTodosPrestamos(){
        return DAOPrestamo.listarTodosPrestamos();
    }
    public ArrayList<Prestamo> listarUsuarioPrestamo(Usuario usuario){
        return DAOPrestamo.listarUsuarioPrestamo(usuario);
    }
    public Prestamo seleccionarPrestamo(int id){
        return DAOPrestamo.seleccionarPrestamo(id);
    }
    public void solicitarPrestamo(Prestamo prestamo){
        DAOUsuario.solicitarPrestamo(prestamo);
    }
    public void delvoverPrestamo(Prestamo prestamo){
        DAOUsuario.delvoverPrestamo(prestamo);
    }
     public boolean prestamoVencido(Usuario usuario){
         return DAOUsuario.prestamoVencido(usuario);
     }
    
}
