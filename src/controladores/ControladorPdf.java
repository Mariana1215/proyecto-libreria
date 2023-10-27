/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import DAO.DAOPdf;
import java.time.LocalDate;

/**
 *
 * @author LENOVO
 */
public class ControladorPdf {
     DAOPdf DaoPdf;
     
     public ControladorPdf() {
        this.DaoPdf = new DAOPdf();
    }
     
     public boolean generarPDFPrestamos(String nombreArchivo) {
         return DaoPdf.generarPDFPrestamos(nombreArchivo);
     }
     public boolean generarPDFPrestamoPorFecha(LocalDate fechaInicio, LocalDate fechaFinal, String nombreArchivo) {
         return DaoPdf.generarPDFPrestamoPorFecha(fechaInicio, fechaFinal, nombreArchivo);
     }
     public boolean generarPDFPrestamoPorUsuario(String cedula, String nombreArchivo){
         return DaoPdf.generarPDFPrestamoPorUsuario(cedula, nombreArchivo);
     }
     public boolean generarPDFPrestamoPorUsuarioyFecha(String cedula, LocalDate fechaInicio, LocalDate fechaFinal, String nombreArchivo){
         return DaoPdf.generarPDFPrestamoPorUsuarioyFecha(cedula, fechaInicio, fechaFinal, nombreArchivo);
     }
     public boolean generarPDFRetraso(String nombreArchivo){
         return DaoPdf.generarPDFRetraso(nombreArchivo);
     }
     public boolean generarPDFRetrasoPorUsuario(String cedula, String nombreArchivo) {
         return DaoPdf.generarPDFRetrasoPorUsuario(cedula, nombreArchivo);
     }
     public boolean generarPDFRetrasoPorFecha(LocalDate fechaInicio, LocalDate fechaFinal, String nombreArchivo) {
         return DaoPdf.generarPDFRetrasoPorFecha(fechaInicio, fechaFinal, nombreArchivo);
     }
     public boolean generarPDFDevolucion(String nombreArchivo) {
         return DaoPdf.generarPDFDevolucion(nombreArchivo);
     }
     public boolean generarPDFDevolucionesPorFecha(LocalDate fechaInicio, LocalDate fechaFinal, String nombreArchivo){
         return DaoPdf.generarPDFDevolucionesPorFecha(fechaInicio, fechaFinal, nombreArchivo);
     }
     public boolean generarPDFDevolucionporUsuario(String cedula, String nombreArchivo) {
         return DaoPdf.generarPDFDevolucionporUsuario(cedula, nombreArchivo);
     }
}
