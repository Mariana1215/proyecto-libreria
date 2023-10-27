/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfarces;

import java.time.LocalDate;

/**
 *
 * @author LENOVO
 */
public interface DaoPDFInterfaz {
    
    boolean generarPDFPrestamos(String nombreArchivo);
    boolean generarPDFPrestamoPorUsuario(String cedula, String nombreArchivo);
    boolean generarPDFPrestamoPorFecha(LocalDate fechaInicio, LocalDate fechaFinal, String nombreArchivo);
    boolean generarPDFPrestamoPorUsuarioyFecha(String cedula, LocalDate fechaInicio, LocalDate fechaFinal, String nombreArchivo);
    
    boolean generarPDFRetraso(String nombreArchivo);
    boolean generarPDFRetrasoPorUsuario(String cedula, String nombreArchivo);
    boolean generarPDFRetrasoPorFecha(LocalDate fechaInicio, LocalDate fechaFinal, String nombreArchivo);
    
    boolean generarPDFDevolucion(String nombreArchivo);
    boolean generarPDFDevolucionporUsuario(String cedula, String nombreArchivo);
    boolean generarPDFDevolucionesPorFecha(LocalDate fechaInicio, LocalDate fechaFinal, String nombreArchivo);
    
}
