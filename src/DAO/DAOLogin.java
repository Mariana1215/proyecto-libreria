/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import conexion.Singleton;
import enums.Rol;
import interfarces.DAOLoginInterfaz;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelos.Usuario;

/**
 *
 * @author LENOVO
 */
public class DAOLogin implements DAOLoginInterfaz {
    private final Connection con;

    public DAOLogin() {
        con = Singleton.getInstancia().getConnection();
    }
    
    
    
    
    @Override
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
