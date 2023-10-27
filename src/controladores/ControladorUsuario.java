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
    
    
    public Object buscarObjeto(Object object){
        return DAOUsuario.buscarObjeto(object);
    }
    public void agregarObjeto(Object object){
        DAOUsuario.agregarObjeto(object);
    }
    public void editarObjeto(Object object){
        DAOUsuario.editarObjeto(object);
    }
     public void eliminarObjeto(Object object){
         DAOUsuario.eliminarObjeto(object);
     }
     public ArrayList<Object> listarObjectos(){
         return DAOUsuario.listarObjeto();
     }
     public void solicitarPrestamo(Prestamo prestamo){
         DAOUsuario.solicitarPrestamo(prestamo);
     }
     public void devolverPrestamo(Prestamo prestamo){
         DAOUsuario.devolverPrestamo(prestamo);
     }
}
