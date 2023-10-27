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
import modelos.Libro;

/**
 *
 * @author LENOVO
 */
public class DAOLibro implements DaoInterfaz {

    private final Connection con;

    public DAOLibro() {
        con = Singleton.getInstancia().getConnection();
    }
    @Override
     public Object buscarObjeto(Object object) {
         String query = "SELECT libros.ISBN, libros.titulo, libros.autor, libros.id_genero, libros.anio, libros.copias,"
                    + "generos.nombre_genero FROM libros JOIN generos ON libros.id_genero = generos.id_genero WHERE libros.ISBN = ?";
        try(PreparedStatement ps = con.prepareStatement(query)){
            
            ResultSet rs;
            
            String isbn = (String) object;
            ps.setString(1, isbn);
            rs = ps.executeQuery();
            
            if(rs.next()){ //Si se encuentra algo
                
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                int anio = rs.getInt("anio");
                int copias = rs.getInt("copias");
                int idGenero = rs.getInt("id_genero");
                String nombreGenero = rs.getString("nombre_genero");
                
                Genero genero = new Genero(idGenero, nombreGenero);
                
                Libro libro = new Libro(isbn, titulo, autor, anio, copias, genero);
                return libro;               
            }
        }catch (SQLException ex){
            System.err.println(ex.toString());
        }
        return null;

    }
   public ArrayList<Libro> buscarLibroPorGenero(int idGenero) {
        ArrayList<Libro> libros = new ArrayList<>();

        try {
            PreparedStatement ps;
            ResultSet rs;

            String query = "SELECT libros.ISBN, libros.titulo, libros.autor, libros.id_genero, libros.anio, libros.copias,"
                    + "generos.nombre_genero FROM libros JOIN generos ON libros.id_genero = generos.id_genero WHERE libros.id_genero = ?";

            ps = con.prepareStatement(query);
            ps.setInt(1, idGenero);
            rs = ps.executeQuery();

            while (rs.next()) {
                String isbn = rs.getString("ISBN");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                int anio = rs.getInt("anio");
                int copias = rs.getInt("copias");
                int idGenero1 = rs.getInt("id_genero");
                String nombreCategoria = rs.getString("nombre_genero");
                
                Genero genero = new Genero(idGenero1, nombreCategoria);
                Libro libro = new Libro(isbn, titulo, autor, anio, copias, genero);
                libros.add(libro);

            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return libros;
    }
   @Override
   public void agregarObjeto(Object object) {
       String query = "INSERT INTO libros(ISBN, titulo, autor, anio, copias, id_genero) VALUES (?,?,?,?,?,?)";
        try(PreparedStatement ps = con.prepareStatement(query)){
            
            Libro libro = (Libro) object;

            ps.setString(1, libro.getISBN());
            ps.setString(2, libro.getTitulo());
            ps.setString(3, libro.getAutor());
            ps.setInt(4, libro.getAnio());
            ps.setInt(5, libro.getCopias());
            ps.setInt(6, libro.getGenero().getIdGenero());

            ps.executeUpdate();

        } catch (SQLException ex) {
            System.err.println(ex.toString());

        }

    }
   @Override
   public void editarObjeto(Object object) {
       String query = "UPDATE libros SET titulo = ?, autor = ?, anio = ?, copias = ?, id_genero = ? WHERE ISBN = ?";
        try(PreparedStatement ps = con.prepareStatement(query)){
            
            Libro libro = (Libro) object;
            
            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getAutor());
            ps.setInt(3, libro.getAnio());
            ps.setInt(4, libro.getCopias());
            ps.setInt(5, libro.getGenero().getIdGenero());
            ps.setString(6, libro.getISBN());

             ps.executeUpdate();

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }
   @Override
   public boolean eliminarObjeto(Object object) {
       String query = "DELETE FROM libros WHERE ISBN = ? AND NOT EXISTS (SELECT 1 FROM prestamos WHERE isbn_libro = ?)";
        try(PreparedStatement ps = con.prepareStatement(query)){
            
            String isbn = (String) object;

            ps.setString(1, isbn);
            ps.setString(2, isbn);

            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return false;
    }
   public ArrayList<Genero> getGeneros() {
        ArrayList<Genero> generos = new ArrayList<>();

        try {
            PreparedStatement ps;
            ResultSet rs;

            String query = "SELECT * FROM generos";

            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                int idGenero = rs.getInt("id_genero");
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
   public ArrayList<Object> listarObjeto() {
        ArrayList<Object> libros = new ArrayList<>();

        try {
            PreparedStatement ps;
            ResultSet rs;

            String query = "SELECT libros.ISBN, libros.titulo, libros.autor, libros.anio, libros.copias, libros.id_genero, "
                    + "generos.nombre_genero FROM libros JOIN generos ON libros.id_genero = generos.id_genero";

            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                String isbn = rs.getString("ISBN");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                int anio = rs.getInt("anio");
                int copias = rs.getInt("copias");
                int idGenero = rs.getInt("id_genero");
                String nombreGenero = rs.getString("nombre_genero");

                Genero genero = new Genero(idGenero, nombreGenero);
                Libro libro = new Libro(isbn, titulo, autor, anio, copias, genero);
                libros.add(libro);
            }
        } catch (SQLException ex) {

            System.err.println(ex.toString());
        }
        return libros;
    }



}
