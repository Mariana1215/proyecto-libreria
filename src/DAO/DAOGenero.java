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
import java.util.ArrayList;
import modelos.Genero;

/**
 *
 * @author LENOVO
 */
public class DAOGenero implements DaoInterfaz {

    private final Connection con;

    public DAOGenero() {
        con = Singleton.getInstancia().getConnection();
    } 
    
    @Override
    public ArrayList<Object> listarObjeto() {
        ArrayList<Object> generos = new ArrayList<>();

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
    
    @Override
    public Object buscarObjeto(Object object) {
        String query = "SELECT id_genero, nombre_genero FROM generos WHERE id_genero = ?";
        
        try(PreparedStatement ps = con.prepareStatement(query)){
            ResultSet rs;
             int idGenero = (int) object;
             ps.setInt(1, idGenero);
             rs = ps.executeQuery();
              
            if(rs.next()){
                String nombre = rs.getString("nombre_genero");
                Genero genero = new Genero(nombre);
                return genero;
            }
            
        }catch(SQLException ex){
            System.err.println(ex.toString());
        }
        return null;
    }
    @Override
    public void agregarObjeto(Object object){
        String query = "INSERT INTO generos(id_genero, nombre_genero) VALUES (?,?)";
        try(PreparedStatement ps = con.prepareStatement(query)){
            
            Genero genero = (Genero) object;

            ps.setInt(1, genero.getIdGenero());
            ps.setString(2, genero.getNombreGenero());

            ps.executeUpdate();

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }
    @Override
    public void editarObjeto(Object object) {
        String query = "UPDATE generos SET nombre_genero = ? WHERE id_genero = ?";
        try(PreparedStatement ps = con.prepareStatement(query)){
            
            Genero genero = (Genero) object;

            ps.setString(1, genero.getNombreGenero());
            ps.setInt(2, genero.getIdGenero());

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.toString());

        }
    }
    @Override
    public boolean eliminarObjeto(Object object){
        String query = "DELETE FROM generos WHERE id_genero = ? AND NOT EXISTS (SELECT 1 FROM libros WHERE id_genero = ?)";

        try(PreparedStatement ps = con.prepareStatement(query)){
           
            int idGenero = (int) object;

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
