/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author Manuela Gomez
 */
public class Historial {
    private Libro libro;
    private String prestamos;
    private String devoluciones;

    public Historial(Libro libro, String prestamos, String devoluciones) {
        this.libro = libro;
        this.prestamos = prestamos;
        this.devoluciones = devoluciones;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public String getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(String prestamos) {
        this.prestamos = prestamos;
    }

    public String getDevoluciones() {
        return devoluciones;
    }

    public void setDevoluciones(String devoluciones) {
        this.devoluciones = devoluciones;
    }
    
    
}
