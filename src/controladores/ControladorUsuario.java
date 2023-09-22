/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import DAO.DAOUsuario;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.Usuario;

/**
 *
 * @author LENOVO
 */
public class ControladorUsuario {
    DAOUsuario usuario;

    public ControladorUsuario() {
        this.usuario = usuario;
    }
    
    
    public Usuario buscarUsuario(String cedula){
        return usuario.buscarUsuario(cedula);
    }
    public void registrarUsuario(Usuario u) throws SQLException{
        usuario.registrarUsuario(u);
    }
    public void editarUsuario(Usuario u){
        usuario.editarUsuario(u);
    }
     public void eliminarUsuario(String cedula){
         usuario.eliminarUsuario(cedula);
     }
     public ArrayList<Usuario> listarUsuarios(){
         return usuario.listarUsuarios();
     }
}
