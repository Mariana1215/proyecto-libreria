/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author Manuela Gomez
 */
public class Libro {
    private String ISBN;
    private String titulo;
    private String autor;
    private int anio;
    private int copias;
    private Genero genero;

    public Libro(String ISBN,String titulo, String autor, int anio, int copias, Genero genero) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.anio = anio;
        this.copias = copias;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public Genero getGenero() {
        return genero;
    }
    
    public int getAnio() {
        return anio;
    }

    public int getCopias() {
        return copias;
    }

    public void setCopias(int copias) {
        this.copias = copias;
    }

    public String getISBN() {
        return ISBN;
    }
    

}
