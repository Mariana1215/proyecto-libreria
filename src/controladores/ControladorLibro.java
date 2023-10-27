/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import DAO.DAOLibro;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.Genero;
import modelos.Libro;

/**
 *
 * @author LENOVO
 */
public class ControladorLibro {
    
    DAOLibro DAOLibro;
    
    public ControladorLibro() {
        this.DAOLibro = new DAOLibro();
    }
    
    public Object buscarObjeto(Object object) {
        return DAOLibro.buscarObjeto(object);
    }
   
    public ArrayList<Libro> buscarLibroPorGenero(int idGenero) {
        return DAOLibro.buscarLibroPorGenero(idGenero);
    }
    public void agregarObjeto(Object object) throws SQLException {
        DAOLibro.agregarObjeto(object);
    }
    public void editarObjeto(Object object) {
        DAOLibro.editarObjeto(object);
    }
    public boolean eliminarObjeto(Object object) {
        return DAOLibro.eliminarObjeto(object);
    }
    public ArrayList<Genero> getGeneros() {
        return DAOLibro.getGeneros();
    }
    public ArrayList<Object> listarObject() {
        return DAOLibro.listarObjeto();
    }
}
