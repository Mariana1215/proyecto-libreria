/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import conexion.Singleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import modelos.Libro;
import modelos.Prestamo;
import modelos.Usuario;

/**
 *
 * @author LENOVO
 */
public class DAOPrestamo {
    
    private final Connection conn;

    public DAOPrestamo() {
        conn = Singleton.getInstancia().getConnection();
    }
    
    public ArrayList<Prestamo> listarTodosPrestamos(){
        ArrayList<Prestamo> prestamos = new ArrayList<>();
        
        String query = "SELECT * FROM prestamos";
        
        try(PreparedStatement ps = conn.prepareStatement(query)){
            ResultSet rs;
            rs = ps.executeQuery();
            
            while(rs.next()){
                String idUsuario = rs.getString("cedula_usuario");
                String isbn = rs.getString("isbn_libro");
                int idPrestamo = rs.getInt("id_prestamo");
                int cantidadLibros = rs.getInt("cantidad_libros");
                LocalDate fechaLimite = rs.getDate("fecha_limite").toLocalDate();
                LocalDate fechaPrestamo = rs.getDate("fecha_prestamo").toLocalDate();
                LocalDate fechaDevolucion = (rs.getDate("fecha_devolucion") != null) ? rs.getDate("fecha_devolucion").toLocalDate() : null;
                boolean devuelto = rs.getBoolean("devuelto");
                
                Usuario usuario = obtenerUsuario(idUsuario);
                Libro libro = obtenerLibro(isbn);
                
                Prestamo prestamo = new Prestamo(idPrestamo, usuario, libro, fechaPrestamo, fechaLimite, fechaDevolucion, cantidadLibros, devuelto);
                prestamos.add(prestamo);
            }
        }catch(SQLException ex){
            System.err.println(ex.toString());
        }
        return prestamos;
    }
    public ArrayList<Prestamo> listarUsuarioPrestamo(Usuario usuario){
        ArrayList<Prestamo> prestamos = new ArrayList<>();
        
        String query = "SELECT * FROM prestamos WHERE cedula_usuario = ?";
        
        try(PreparedStatement ps = conn.prepareStatement(query)){
            ps.setString(1, usuario.getCedula());
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                String isbn = rs.getString("isbn_libro");
                int idPrestamo = rs.getInt("id_prestamo");
                int cantidadLibros = rs.getInt("cantidad_libros");
                LocalDate fechaLimite = rs.getDate("fecha_limite").toLocalDate();
                LocalDate fechaPrestamo = rs.getDate("fecha_prestamo").toLocalDate();
                LocalDate fechaDevolucion = (rs.getDate("fecha_devolucion") != null) ? rs.getDate("fecha_devolucion").toLocalDate() : null;
                boolean devuelto = rs.getBoolean("devuelto");
                
                Libro libros = obtenerLibro(isbn);
                
                Prestamo prestamo = new Prestamo(idPrestamo, usuario, libros, fechaPrestamo, fechaLimite, fechaDevolucion, cantidadLibros, devuelto);
                prestamos.add(prestamo);
            }
        }catch (SQLException ex){
            System.err.println(ex.toString());
        }
        return prestamos;
    }
    
    public Prestamo seleccionarPrestamo(int id){
        String query = "SELECT * FROM prestamos WHERE id_prestamo = ?";
        
        try(PreparedStatement ps = conn.prepareStatement(query)){
            
            ResultSet rs;
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            if(rs.next()){
                String isbn = rs.getString("isbn_libro");
                String idUsuario = rs.getString("cedula_usuario");
                int cantidadLibros = rs.getInt("cantidad_libros");
                LocalDate fechaLimite = rs.getDate("fecha_limite").toLocalDate();
                LocalDate fechaPrestamo = rs.getDate("fecha_prestamo").toLocalDate();
                LocalDate fechaDevolucion = (rs.getDate("fecha_devolucion") != null) ? rs.getDate("fecha_devolucion").toLocalDate() : null;
                boolean devuelto = rs.getBoolean("devuelto");
                
                Usuario usuario = obtenerUsuario(idUsuario);
                Libro libro = obtenerLibro(isbn);
                
                return new Prestamo(id, usuario, libro, fechaPrestamo, fechaLimite, fechaDevolucion, cantidadLibros, devuelto);                               
            }
        }catch (SQLException ex){
            System.err.println();
        }
        return null;
    }
    
    private Usuario obtenerUsuario(String id){
        DAOUsuario daoUsuario = new DAOUsuario();
        return daoUsuario.buscarUsuario(id);
    }
    private Libro obtenerLibro(String isbn){
        DAOLibro daoLibro = new DAOLibro();
        return daoLibro.buscarLibro(isbn);
        
    }
    
    
}
