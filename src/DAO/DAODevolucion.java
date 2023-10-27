/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import conexion.Singleton;
import interfarces.DaoInterfaz;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import modelos.Devolucion;
import modelos.Libro;
import modelos.Usuario;

/**
 *
 * @author LENOVO
 */
public class DAODevolucion implements DaoInterfaz {
    
    private final Connection con;

    public DAODevolucion() {
        con = Singleton.getInstancia().getConnection();
    }
    @Override
    public ArrayList<Object> listarObjeto(){
        ArrayList<Object> devoluciones = new ArrayList<>();
        String query = "SELECT * FROM devoluciones";
        
        try(PreparedStatement ps = con.prepareStatement(query)){
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("id_devoluciones");
                String cedula = rs.getString("id_usuario");
                String isbn = rs.getString("id_libro");
                LocalDate fechaDevolucion = rs.getDate("fecha_devolucion").toLocalDate();
                
                Usuario usuario = obtenerUsuario(cedula);
                Libro libro = obtenerLibro(isbn);
                
                Devolucion devolucion = new Devolucion(id, usuario, libro, fechaDevolucion);
                devoluciones.add(devolucion);
                
            }
        }catch(SQLException ex){
          System.err.println(ex);
        }
        return devoluciones; 
    }
    @Override
    public Object buscarObjeto(Object object){
        String query = "SELECT * FROM devoluciones WHERE id_devoluciones = ?";
        
        try(PreparedStatement ps = con.prepareStatement(query)){
            int id = (int) object;
            
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                String cedula = rs.getString("id_usuario");
                String isbn = rs.getString("id_libro");
                LocalDate fechaDevolucion = rs.getDate("fecha_devolucion").toLocalDate();
                
                Usuario usuario = obtenerUsuario(cedula);
                Libro libro = obtenerLibro(isbn);
                
                new Devolucion(id, usuario, libro, fechaDevolucion);
                
            }
        }catch(SQLException ex){
            System.err.println(ex);
        }
        return null;
    }
    @Override
    public void agregarObjeto(Object object){
        String query = "INSERT INTO devoluciones(id_usuario, id_libro, fecha_devolucion) VALUES (?,?,?)";
        
        try(PreparedStatement ps = con.prepareStatement(query)){
            Devolucion devolucion = (Devolucion) object;
            
            ps.setString(1, devolucion.getUsuario().getCedula());
            ps.setString(2, devolucion.getLibro().getISBN());
            ps.setDate(3, java.sql.Date.valueOf(devolucion.getFechaDevolucion()));
            
            ps.executeQuery();
        }catch(SQLException ex){
            System.err.println(ex);
        }
    }
    @Override
    public void editarObjeto(Object object){
        
    }
    
    @Override
    public boolean eliminarObjeto(Object object){
        return true;
    }
    
    private Usuario obtenerUsuario(String cedula){
        DAOUsuario daoUsuario = new DAOUsuario();
        return (Usuario) daoUsuario.buscarObjeto(cedula);
    }
    
    private Libro obtenerLibro(String isbn){
        DAOLibro daoLibro = new DAOLibro();
        return (Libro) daoLibro.buscarObjeto(isbn);
    }
}
