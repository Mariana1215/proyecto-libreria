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
import conexion.ConexionBD;
import modelos.Usuario;

/**
 *
 * @author Manuela Gomez
 */
public class ControladorLogin {

    private final ConexionBD conn;
    private final Connection con;

    public ControladorLogin() {
        conn = new ConexionBD();
        con = conn.getConexion();
    }

    public Usuario buscarUsuario(String usuario, String contrasenia) {

        try {
            PreparedStatement ps;
            ResultSet rs;

            String query = "SELECT * FROM usuarios WHERE usuario = ? AND CONTRASENIA = ?";

            ps = con.prepareStatement(query);
            ps.setString(1, usuario);
            ps.setString(2, contrasenia);

            rs = ps.executeQuery();

            if (rs.next()) {
                String cedula = rs.getString("cedula");
                String nombre = rs.getString("nombre");
                String telefono = rs.getString("telefono");
                String correo = rs.getString("correo");
                Rol rol = Rol.valueOf(rs.getString("rol"));

                Usuario usuario2 = new Usuario(usuario, contrasenia, nombre, cedula, telefono, correo, rol);
                return usuario2;
            }

        } catch (SQLException ex){
            System.err.println(ex.toString());
        } 
        return null;
        }

    }
