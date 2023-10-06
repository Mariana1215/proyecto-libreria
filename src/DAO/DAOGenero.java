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
import java.util.ArrayList;
import modelos.Genero;

/**
 *
 * @author LENOVO
 */
public class DAOGenero {

    private final Connection con;

    public DAOGenero() {
        con = Singleton.getInstancia().getConnection();
    }
    public ArrayList<Genero> listarGeneros() {
        ArrayList<Genero> generos = new ArrayList<>();

        try {
            PreparedStatement ps;
            ResultSet rs;

            String query = "SELECT * FROM generos";

            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                int idGenero= rs.getInt("id_genero");
                String nombreGenero = rs.getString("nombre_genero");

                Genero genero = new Genero(idGenero, nombreGenero);
                generos.add(genero);
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return generos;
    }
    
    public Genero buscarGenero(String nombreGenero) {
        try {
            PreparedStatement ps;
            ResultSet rs;

            String query = "SELECT id_genero, nombre_genero FROM generos WHERE nombre_genero = ?";

            ps = con.prepareStatement(query);
            ps.setString(1, nombreGenero);
            rs = ps.executeQuery();

            if (rs.next()) {
                int idGenero = rs.getInt("id_genero");
                String nombreGenero1 = rs.getString("nombre_genero");

                Genero genero = new Genero(idGenero, nombreGenero1);

                return genero;
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return null;
    }
    
    public void agregarGenero(Genero genero) throws SQLException {
        try {
            PreparedStatement ps;

            String query = "INSERT INTO generos(id_genero, nombre_genero) VALUES (?,?)";
            ps = con.prepareStatement(query);

            ps.setInt(1, genero.getIdGenero());
            ps.setString(2, genero.getNombreGenero());

            ps.executeUpdate();

        } catch (SQLException ex) {
            System.err.println(ex.toString());
            throw new SQLException();
        }
    }
    
    public void editarGenero(int idGenero, String nombreGenero) throws SQLException {
        try {
            PreparedStatement ps;

            String query = "UPDATE generos SET nombre_genero = ? WHERE id_genero = ?";

            ps = con.prepareStatement(query);
            ps.setString(1, nombreGenero);
            ps.setInt(2, idGenero);

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            throw new SQLException();
        }
    }
    public boolean eliminarGenero(int idGenero) throws SQLException{

        try {
            PreparedStatement ps;

            String query = "DELETE FROM generos WHERE id_genero = ? AND NOT EXISTS (SELECT 1 FROM libros WHERE id_genero = ?)";

            ps = con.prepareStatement(query);
            ps.setInt(1, idGenero);
            ps.setInt(2, idGenero);

            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return false;
    }
}
