/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.time.LocalDate;

/**
 *
 * @author LENOVO
 */
public class Devolucion {
    
    private int id;
    
    private final Usuario usuario;
    private final Libro libro;
    private final LocalDate fechaDevolucion;

    public Devolucion(int id, Usuario usuario, Libro libro, LocalDate fechaDevolucion) {
        this.id = id;
        this.usuario = usuario;
        this.libro = libro;
        this.fechaDevolucion = fechaDevolucion;
    }

    public Devolucion(Usuario usuario, Libro libro) {
        this.usuario = usuario;
        this.libro = libro;
        this.fechaDevolucion = LocalDate.now();
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Libro getLibro() {
        return libro;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }
    
    
    
}
