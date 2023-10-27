/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import DAO.DAOGenero;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author LENOVO
 */
public class ControladorGenero {
    
    DAOGenero DAOGenero;

    public ControladorGenero() {
        this.DAOGenero = new DAOGenero();
    }
    
    public ArrayList<Object> listarObjeto() {
        return DAOGenero.listarObjeto();
    }
    
    public Object buscarObject(Object object) {
        return DAOGenero.buscarObjeto(object);
    }
    
    public void agregarObjeto(Object object) throws SQLException {
        DAOGenero.agregarObjeto(object);
    }
    
    public void editarObject(Object object) throws SQLException {
        DAOGenero.editarObjeto(object);
    }
    
    public boolean eliminarObjeto(Object object) throws SQLException {
        return DAOGenero.eliminarObjeto(object);
    }
    
}
