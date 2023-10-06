/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import DAO.DAOUsuario;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.Prestamo;
import modelos.Usuario;

/**
 *
 * @author LENOVO
 */
public class ControladorUsuario {
    DAOUsuario DAOUsuario;

    public ControladorUsuario() {
        this.DAOUsuario = new DAOUsuario();
    }
    
    
    public Usuario buscarUsuario(String cedula){
        return DAOUsuario.buscarUsuario(cedula);
    }
    public void registrarUsuario(Usuario u) throws SQLException{
        DAOUsuario.registrarUsuario(u);
    }
    public void editarUsuario(Usuario u){
        DAOUsuario.editarUsuario(u);
    }
     public void eliminarUsuario(String cedula){
         DAOUsuario.eliminarUsuario(cedula);
     }
     public ArrayList<Usuario> listarUsuarios(){
         return DAOUsuario.listarUsuarios();
     }
     public void solicitarPrestamo(Prestamo prestamo){
         DAOUsuario.solicitarPrestamo(prestamo);
     }
     public void delvoverPrestamo(Prestamo prestamo){
         DAOUsuario.delvoverPrestamo(prestamo);
     }
}
