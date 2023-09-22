/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import DAO.DAOGenero;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.Genero;

/**
 *
 * @author LENOVO
 */
public class ControladorGenero {
    
    DAOGenero DAOGenero;

    public ControladorGenero() {
        this.DAOGenero = new DAOGenero();
    }
    
    public ArrayList<Genero> listarGeneros() {
        return DAOGenero.listarGeneros();
    }
    
    public Genero buscarGenero(String nombreGenero) {
        return DAOGenero.buscarGenero(nombreGenero);
    }
    
    public void agregarGenero(Genero genero) throws SQLException {
        DAOGenero.agregarGenero(genero);
    }
    
    public void editarGenero(int idGenero, String nombreGenero) throws SQLException {
        DAOGenero.editarGenero(idGenero, nombreGenero);
    }
    
    public boolean eliminarGenero(int idGenero) throws SQLException {
        return DAOGenero.eliminarGenero(idGenero);
    }
    
}
