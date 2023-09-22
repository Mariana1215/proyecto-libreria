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
    
    public Libro buscarLibro(String isbn) {
        return DAOLibro.buscarLibro(isbn);
    }
   
    public ArrayList<Libro> buscarLibroPorGenero(int idGenero) {
        return DAOLibro.buscarLibroPorGenero(idGenero);
    }
    public void agregarLibro(Libro libro) throws SQLException {
        DAOLibro.agregarLibro(libro);
    }
    public boolean editarLibro(Libro libro) {
        return DAOLibro.editarLibro(libro);
    }
    public boolean eliminarLibro(String isbn) {
        return DAOLibro.eliminarLibro(isbn);
    }
    public ArrayList<Genero> getGeneros() {
        return DAOLibro.getGeneros();
    }
    public ArrayList<Libro> listarLibros() {
        return DAOLibro.listarLibros();
    }
}
