/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import DAO.DAODevolucion;
import java.util.ArrayList;
import modelos.Devolucion;

/**
 *
 * @author LENOVO
 */
public class ControladorDevolucion {
    DAODevolucion daoDevolucion;

    public ControladorDevolucion() {
        daoDevolucion = new DAODevolucion();
    }
    
    public ArrayList<Object> listarObjeto(){
        return daoDevolucion.listarObjeto();
    }
    
    public void agregarObjeto(Devolucion devolucion){
        daoDevolucion.agregarObjeto(devolucion);
    }
    public Object buscarObjeto(int id){
        return daoDevolucion.buscarObjeto(id);
    }
 
}
