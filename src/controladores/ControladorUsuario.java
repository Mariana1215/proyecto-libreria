/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import enums.Rol;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.ConexionBD;
import modelos.Usuario;

/**
 *
 * @author Manuela Gomez
 */
public class ControladorUsuario {
   
    private final ConexionBD conn;
    private final Connection con;

    public ControladorUsuario() {
        conn = new ConexionBD();
        con = conn.getConexion();
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
    
}
