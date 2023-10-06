/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import enums.Rol;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import conexion.Singleton;
import excepciones.CantidadException;
import excepciones.PrestamoVencidoException;
import java.time.LocalDate;
import java.util.Date;
import modelos.Libro;
import modelos.Prestamo;
import modelos.Usuario;

/**
 *
 * @author Manuela Gomez
 */
public class DAOUsuario {
   

    private final Connection con;

    public DAOUsuario() {
       con = Singleton.getInstancia().getConnection();
    }

    public Usuario buscarUsuario(String cedula) {
        try{
            PreparedStatement ps;
            ResultSet rs;
            
            String query = "SELECT * FROM usuarios WHERE cedula = ?";
            
            ps = con.prepareStatement(query);
            ps.setString(1, cedula);
            
            rs = ps.executeQuery();
            
            if(rs.next()){ //Si se encuentra algo
                
                String nombre = rs.getString("nombre");
                String telefono = rs.getString("telefono");
                String correo = rs.getString("correo");
                String usuario1 = rs.getString("usuario");
                String contrasenia = rs.getString("contrasenia");
                Rol rol = Rol.valueOf(rs.getString("rol"));
                
                Usuario usuario = new Usuario(usuario1, contrasenia, nombre, cedula, telefono, correo, rol);
                return usuario;
                        
                
            }
        }catch (SQLException ex){
            System.err.println(ex.toString());
        }
        return null;

    }

    public void registrarUsuario(Usuario usuario) throws SQLException {

        try {

            PreparedStatement ps;

            String query = "INSERT INTO usuarios (contrasenia, usuario, nombre, cedula, telefono, correo, rol) VALUES (?,?,?,?,?,?,?)";
            ps = con.prepareStatement(query);

            ps.setString(1, usuario.getContrasenia());
            ps.setString(2, usuario.getUsuario());
            ps.setString(3, usuario.getNombre());
            ps.setString(4, usuario.getCedula());
            ps.setString(5, usuario.getTelefono());
            ps.setString(6, usuario.getCorreo());
            ps.setString(7, usuario.getRol().toString());

            ps.execute();

        } catch (SQLException ex) {
            System.err.println(ex);
            throw new SQLException();
        }

    }

    public void editarUsuario(Usuario usuario) {

        try {
            PreparedStatement ps;

            String query = ("UPDATE usuarios SET contrasenia=?, usuario=?, nombre=?, telefono=?, correo=?  WHERE cedula=?");
            ps = con.prepareStatement(query);

            ps.setString(1, usuario.getContrasenia());
            ps.setString(2, usuario.getUsuario());
            ps.setString(3, usuario.getNombre());
            ps.setString(4, usuario.getTelefono());
            ps.setString(5, usuario.getCorreo());
            ps.setString(6, usuario.getCedula());
            
            ps.execute();

        } catch (SQLException ex) {
            System.err.println(ex);

        }
    }

    public void eliminarUsuario(String cedula) {
        try {
            PreparedStatement ps;

            String query = "DELETE FROM usuarios WHERE cedula = ?";

            ps = con.prepareStatement(query);
            ps.setString(1, cedula);

            ps.execute();

        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
    public ArrayList<Usuario> listarUsuarios(){
        ArrayList<Usuario> usuarios = new ArrayList<>();
        
        try{
            PreparedStatement ps;
            ResultSet rs;
            
            String query = "SELECT * FROM usuarios";
            
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            
            while (rs.next()){
                String nombre = rs.getString("nombre");
                String cedula = rs.getString("cedula");
                String telefono = rs.getString("telefono");
                String correo = rs.getString("correo");
                String usuario1 = rs.getString("usuario");
                String contrasenia = rs.getString("contrasenia");
                Rol rol = Rol.valueOf(rs.getString("rol"));
                
                Usuario usuario = new Usuario(usuario1, contrasenia, nombre, cedula, telefono, correo, rol);
                usuarios.add(usuario);
            }
        }catch (SQLException ex){
            System.err.println(ex.toString());
        }
        return usuarios;
    }
    
    public void solicitarPrestamo(Prestamo prestamo){
        String query = "INSERT INTO prestamos( cedula_usuario, isbn_libro, cantidad_libros, fecha_prestamo, fecha_limite, fecha_devolucion, devuelto) VALUES"
                + "(?,?,?,?,?,?,?)";
        
        try(PreparedStatement ps = con.prepareStatement(query)){
            Usuario usuario = prestamo.getUsuario();
            
            if(!copiasDisponibles(prestamo.getLibro(), prestamo.getCantidadLibro())){
                throw new CantidadException();
            }
            
            if(prestamoVencido(usuario)){
                throw new PrestamoVencidoException();
            }
            
            ps.setString(1, prestamo.getUsuario().getCedula());
            ps.setString(2, prestamo.getLibro().getISBN());
            ps.setInt(3, prestamo.getCantidadLibro());
            ps.setDate(4, java.sql.Date.valueOf(prestamo.getFechaPrestamo()));
            ps.setDate(5, java.sql.Date.valueOf(prestamo.getFechaLimite()));
            ps.setDate(6, null);
            ps.setBoolean(7, false);
            
            ps.executeUpdate();
            
            eliminarCopiaDisponible(prestamo.getLibro().getISBN(), prestamo.getCantidadLibro());         
        
        }catch (SQLException ex){
            System.err.println(ex.toString());
        }
        
    }
    
    public void delvoverPrestamo(Prestamo prestamo){
        String query = "DELETE FROM prestamos WHERE id_prestamo = ?";
        
        try(PreparedStatement ps = con.prepareStatement(query)){
            ps.setInt(1, prestamo.getId());
            ps.executeUpdate();
            sumarCopiasDisponible(prestamo.getLibro().getISBN(), prestamo.getCantidadLibro());
        }catch (SQLException ex){
            System.err.println(ex.toString());
        }
        
    }
    
    private boolean copiasDisponibles(Libro libro, int cantidadLibro){
        Libro l = obtenerLibro(libro.getISBN());
        
        if(l != null){
            if (cantidadLibro <= libro.getCopias()){
                return true;
            }
        }
        return false;
    }
    
    public boolean prestamoVencido(Usuario usuario){
        String query = "SELECT * FROM prestamos WHERE cedula_usuario = ? AND devuelto = false and fecha_limite < ?";
        try(PreparedStatement ps = con.prepareStatement(query)){
            ps.setString(1, usuario.getCedula());
            Date fechaActual = new Date();
            ps.setDate(2, new java.sql.Date(fechaActual.getTime()));
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                return true;
            }
            
        }catch (SQLException ex){
            System.err.println(ex.toString());
        }
        return false;
    }
    
    private void eliminarCopiaDisponible(String isbn, int cantidad){
        String query = "UPDATE libros SET copias = copias - ? WHERE isbn = ?";
        
        try(PreparedStatement ps = con.prepareStatement(query)){
            
            ps.setInt(1, cantidad);
            ps.setString(2, isbn);
            ps.executeUpdate();
        }catch (SQLException ex){
            System.err.println(ex.toString());
        }
    }
    private void sumarCopiasDisponible(String isbn, int cantidad){
        String query = "UPDATE libros SET copias = copias + ? WHERE isbn = ?";
        
        try(PreparedStatement ps = con.prepareStatement(query)){
            
            ps.setInt(1, cantidad);
            ps.setString(2, isbn);
            ps.executeUpdate();
        }catch (SQLException ex){
            System.err.println(ex.toString());
        }
    }
    
    private Libro obtenerLibro(String isbn){
        DAOLibro daoLibro = new DAOLibro();
        return daoLibro.buscarLibro(isbn);
        
    }
    
}
