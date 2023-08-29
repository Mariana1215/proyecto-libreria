/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public ResultSet buscarUsuario(String cedula) {
        String where = "";

        if (!"".equals(cedula)) {
            where = "WHERE codigo = '" + cedula + "'";
        }

        try {
            PreparedStatement ps;
            ResultSet rs;

            String sql = "SELECT * FROM usuarios " + where;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            return rs;

        } catch (SQLException e) {
            System.err.println(e);

        }
        return null;

    }

    public void registrarUsuario(Usuario usuario) throws SQLException {

        try {

            PreparedStatement ps;

            String query = "INSERT INTO productos (contrasenia, usuario, nombre, cedula, telefono) VALUES (?,?,?,?,?)";
            ps = con.prepareStatement(query);

            ps.setString(1, usuario.getContrasenia());
            ps.setString(2, usuario.getUsuario());
            ps.setString(3, usuario.getNombre());
            ps.setString(4, usuario.getCedula());
            ps.setString(5, usuario.getTelefono());
            ps.setString(6, usuario.getCorreo());

            ps.execute();

        } catch (SQLException ex) {
            System.err.println(ex);
            throw new SQLException();
        }

    }

    public void editarUsuario(Usuario usuario) {

        try {
            PreparedStatement ps;

            String query = ("UPDATE usuarios SET contrasenia=?, usuario=?, nombre=?, telefono=?, correo=? , WHERE cedula=?");
            ps = con.prepareStatement(query);

            ps.setString(1, usuario.getContrasenia());
            ps.setString(2, usuario.getUsuario());
            ps.setString(3, usuario.getNombre());
            ps.setString(4, usuario.getCedula());
            ps.setString(5, usuario.getTelefono());
            ps.setString(6, usuario.getCorreo());

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
            ps.setString(4, cedula);

            ps.execute();

        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
    
}
