/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author LENOVO
 */
public class PrestamoVencidoException extends RuntimeException {

    public PrestamoVencidoException() {
         super("Error, tiene un prestamo vencido");
    }
    
}
