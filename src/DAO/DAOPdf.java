/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import conexion.Singleton;
import interfarces.DaoPDFInterfaz;
import java.awt.Desktop;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author LENOVO
 */
public class DAOPdf implements DaoPDFInterfaz {

    private final Connection con;
    private final Document documento;

    public DAOPdf() {
        con = Singleton.getInstancia().getConnection();
        documento = new Document();
    }

    @Override
    public boolean generarPDFPrestamos(String nombreArchivo) {
        boolean tienePrestamos = false;

        try {
            String ruta = System.getProperty("user.home");

            PdfPTable tabla = crearTabla();

            String query = "SELECT usuarios.cedula, usuarios.nombre, libros.titulo, generos.nombre_genero, prestamos.fecha_prestamo"
                    + " FROM prestamos JOIN usuarios ON prestamos.cedula_usuario = usuarios.cedula JOIN libros ON prestamos.isbn_libro = libros.ISBN JOIN generos ON libros.id_genero = generos.id_genero";
            try ( PreparedStatement ps = con.prepareStatement(query)) {
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    tienePrestamos = true;

                    String fecha = LocalDate.now().toString();
                    String archivo = nombreArchivo + "_" + fecha;

                    PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/" + archivo + ".pdf"));
                    documento.open();

                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                    } while (rs.next());
                    documento.add(tabla);
                    documento.close();

                    abrirArchivo(ruta, archivo);

                }
            } catch (DocumentException | SQLException ex) {
                System.out.println(ex.toString());
            }
        } catch (HeadlessException | FileNotFoundException ex) {
            System.out.println(ex.toString());

        }
        return tienePrestamos;
    }

    @Override
    public boolean generarPDFPrestamoPorFecha(LocalDate fechaInicio, LocalDate fechaFinal, String nombreArchivo) {
        boolean tienePrestamos = false;
        try {
            String ruta = System.getProperty("user.home");

            PdfPTable tabla = crearTabla();

            String query = "SELECT usuarios.cedula, usuarios.nombre, libros.titulo,generos.nombre_genero, prestamos.fecha_prestamo"
                    + " FROM prestamos JOIN usuarios ON prestamos.cedula_usuario = usuarios.cedula JOIN libros ON prestamos.isbn_libro = libros.ISBN JOIN generos ON libros.id_genero = generos.id_genero WHERE fecha_prestamo >= ? AND fecha_prestamo <= ?";
            try ( PreparedStatement ps = con.prepareStatement(query)) {
                ps.setDate(1, java.sql.Date.valueOf(fechaInicio.toString()));
                ps.setDate(2, java.sql.Date.valueOf(fechaFinal.toString()));

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    tienePrestamos = true;

                    String fecha = LocalDate.now().toString();
                    String archivo = nombreArchivo + "_" + fecha;

                    PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/" + archivo + ".pdf"));
                    documento.open();

                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));

                    } while (rs.next());
                    documento.add(tabla);
                    documento.close();

                    abrirArchivo(ruta, archivo);
                }
            } catch (DocumentException | SQLException ex) {
            }
        } catch (HeadlessException | FileNotFoundException ex) {

        }
        return tienePrestamos;
    }

    @Override
    public boolean generarPDFPrestamoPorUsuario(String cedula, String nombreArchivo) {

        boolean tienePrestamos = false;
        try {
            String ruta = System.getProperty("user.home");

            PdfPTable tabla = crearTabla();

            String query = "SELECT usuarios.cedula, usuarios.nombre, libros.titulo, generos.nombre_genero, prestamos.fecha_prestamo"
                    + " FROM prestamos JOIN usuarios ON prestamos.cedula_usuario = usuarios.cedula JOIN libros ON prestamos.isbn_libro = libros.ISBN JOIN generos ON libros.id_genero = generos.id_genero WHERE prestamos.cedula_usuario = ?";
            try ( PreparedStatement ps = con.prepareStatement(query)) {
                ps.setString(1, cedula);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    tienePrestamos = true;

                    String fecha = LocalDate.now().toString();
                    String archivo = nombreArchivo + "_" + fecha;

                    PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/" + archivo + ".pdf"));
                    documento.open();

                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));

                    } while (rs.next());
                    documento.add(tabla);
                    documento.close();

                    abrirArchivo(ruta, archivo);
                }

            } catch (DocumentException | SQLException ex) {

            }

        } catch (HeadlessException | FileNotFoundException ex) {

        }

        return tienePrestamos;
    }

    @Override
    public boolean generarPDFPrestamoPorUsuarioyFecha(String cedula, LocalDate fechaInicio, LocalDate fechaFinal, String nombreArchivo) {
        boolean tienePrestamos = false;
        try {
            String ruta = System.getProperty("user.home");

            PdfPTable tabla = crearTabla();

            String query = "SELECT usuarios.cedula, usuarios.nombre, libros.ISBN, libros.autor, libros.titulo, generos.nombre_genero, prestamos.fecha_prestamo, prestamos.fecha_limite"
                    + " FROM prestamos JOIN usuarios ON prestamos.cedula_usuario = usuarios.cedula JOIN libros ON prestamos.isbn_libro = libros.ISBN JOIN generos"
                    + " ON libros.id_genero = generos.id_genero WHERE fecha_prestamo >= ? AND fecha_prestamo <= ? AND prestamos.cedula_usuario = ?";

            try ( PreparedStatement ps = con.prepareStatement(query)) {
                ps.setDate(1, java.sql.Date.valueOf(fechaInicio.toString()));
                ps.setDate(2, java.sql.Date.valueOf(fechaFinal.toString()));
                ps.setString(3, cedula);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    tienePrestamos = true;

                    String fecha = LocalDate.now().toString();
                    String archivo = nombreArchivo + "_" + fecha;

                    PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/" + archivo + ".pdf"));
                    documento.open();

                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                        tabla.addCell(rs.getString(6));
                        tabla.addCell(rs.getString(7));
                        tabla.addCell(rs.getString(8));
                    } while (rs.next());
                    documento.add(tabla);
                    documento.close();

                    abrirArchivo(ruta, archivo);
                }
            } catch (DocumentException | SQLException ex) {

            }
        } catch (HeadlessException | FileNotFoundException ex) {

        }
        return tienePrestamos;
    }

    @Override
    public boolean generarPDFRetraso(String nombreArchivo) {
        boolean tienePrestamosVencidos = false;

        try {
            String ruta = System.getProperty("user.home");

            PdfPTable tabla = crearTablaRetrasos();

            String query = "SELECT usuarios.cedula, usuarios.nombre, libros.titulo, prestamos.fecha_prestamos, prestamos.fecha_limite, prestamos.cantidad_libros"
                    + " FROM prestamos JOIN usuarios ON prestamos.cedula_usuario = usuarios.cedula JOIN libros ON prestamos.isbn_libro = libros.ISBN JOIN generos"
                    + " ON libros.id_genero = genero.id_genero WHERE prestamos.fecha_limite < ?";

            try ( PreparedStatement ps = con.prepareStatement(query)) {
                ps.setDate(1, java.sql.Date.valueOf(LocalDate.now().toString()));
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    tienePrestamosVencidos = true;

                    String fecha = LocalDate.now().toString();
                    String archivo = nombreArchivo + "_" + fecha;

                    PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/" + archivo + ".pdf"));
                    documento.open();

                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                        tabla.addCell(rs.getString(6));
                    } while (rs.next());
                    documento.add(tabla);
                    documento.close();

                    abrirArchivo(ruta, archivo);
                }
            } catch (DocumentException | SQLException ex) {

            }
        } catch (HeadlessException | FileNotFoundException ex) {

        }
        return tienePrestamosVencidos;
    }

    @Override
    public boolean generarPDFRetrasoPorUsuario(String cedula, String nombreArchivo) {
        boolean tienePrestamosVencidos = false;
        try {
            String ruta = System.getProperty("user.home");

            PdfPTable tabla = crearTablaRetrasos();

            String query = "SELECT usuarios.cedula, usuarios.nombre, libros.titulo, prestamos.fecha_prestamos, prestamos.fecha_limite, prestamos.cantidad_libros"
                    + " FROM prestamos JOIN usuarios ON prestamos.cedula_usuario = usuarios.cedula JOIN libros ON prestamos.isbn_libro = libros.ISBN"
                    + " WHERE prestamos.cedula_usuario = ? AND prestamos.fecha_limite < ?";

            try ( PreparedStatement ps = con.prepareStatement(query)) {
                ps.setDate(1, java.sql.Date.valueOf(cedula));
                ps.setDate(2, java.sql.Date.valueOf(LocalDate.now().toString()));

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    tienePrestamosVencidos = true;

                    String fecha = LocalDate.now().toString();
                    String archivo = nombreArchivo + "_" + fecha;

                    PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/" + archivo + ".pdf"));
                    documento.open();

                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                        tabla.addCell(rs.getString(6));
                    } while (rs.next());
                    documento.add(tabla);
                    documento.close();

                    abrirArchivo(ruta, archivo);
                }
            } catch (DocumentException | SQLException ex) {

            }

        } catch (HeadlessException | FileNotFoundException ex) {

        }
        return tienePrestamosVencidos;
    }

    @Override
    public boolean generarPDFRetrasoPorFecha(LocalDate fechaInicio, LocalDate fechaFinal, String nombreArchivo) {
        boolean tienePrestamosVencidos = false;
        try {
            String ruta = System.getProperty("user.home");

            PdfPTable tabla = crearTablaRetrasos();

            String query = "SELECT usuarios.cedula, usuarios.nombre, libros.titulo, prestamos.fecha_prestamos, prestamos.fecha_limite, prestamos.cantidad_libros"
                    + " FROM prestamos JOIN usuarios ON prestamos.cedula_usuario = usuarios.cedula JOIN libros ON prestamos.isbn_libro = libros.ISBN JOIN generos"
                    + " ON libros.id_genero = generos.id_genero WHERE fecha_prestamo >= ? AND fecha_prestamo <= ? AND prestamos.fecha_limite < ?";
            try ( PreparedStatement ps = con.prepareStatement(query)) {
                ps.setDate(1, java.sql.Date.valueOf(fechaInicio.toString()));
                ps.setDate(2, java.sql.Date.valueOf(fechaFinal.toString()));
                ps.setDate(3, java.sql.Date.valueOf(LocalDate.now().toString()));

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    tienePrestamosVencidos = true;

                    String fecha = LocalDate.now().toString();
                    String archivo = nombreArchivo + "_" + fecha;

                    PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/" + archivo + ".pdf"));
                    documento.open();

                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                        tabla.addCell(rs.getString(6));
                    } while (rs.next());
                    documento.add(tabla);
                    documento.close();

                    abrirArchivo(ruta, archivo);
                }
            } catch (DocumentException | SQLException ex) {

            }
        } catch (HeadlessException | FileNotFoundException ex) {

        }
        return tienePrestamosVencidos;
    }

    @Override
    public boolean generarPDFDevolucion(String nombreArchivo) {
        boolean tienePrestamos = false;

        try {
            String ruta = System.getProperty("user.home");

            PdfPTable tabla = crearTabla();

            String query = "SELECT usuarios.cedula, usuarios.nombre, libros.titulo, generos.nombre_genero, devoluciones.fecha_devolucion FROM"
                    + " devoluciones JOIN usuarios ON devoluciones.id_usuario = usuarios.cedula JOIN libros ON devoluciones.id_libro = libros.ISBN JOIN generos ON libros.id_genero = generos.id_genero";
            try ( PreparedStatement ps = con.prepareStatement(query)) {
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    tienePrestamos = true;

                    String fecha = LocalDate.now().toString();
                    String archivo = nombreArchivo + "_" + fecha;

                    PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/" + archivo + ".pdf"));
                    documento.open();

                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));

                    } while (rs.next());
                    documento.add(tabla);
                    documento.close();

                    abrirArchivo(ruta, archivo);
                }
            } catch (DocumentException | SQLException ex) {

            }
        } catch (HeadlessException | FileNotFoundException ex) {

        }
        return tienePrestamos;
    }

    @Override
    public boolean generarPDFDevolucionesPorFecha(LocalDate fechaInicio, LocalDate fechaFinal, String nombreArchivo) {
        boolean tienePrestamos = false;

        try {
            String ruta = System.getProperty("user.home");

            PdfPTable tabla = crearTabla();

            String query = "SELECT usuarios.cedula, usuarios.nombre, libros.titulo, generos.nombre_genero, devoluciones.fecha_devolucion FROM"
                    + " devoluciones JOIN usuarios ON devoluciones.id_usuario = usuarios.cedula JOIN libros ON devoluciones.id_libro = libros.ISBN JOIN generos ON libros.id_genero = generos.id_genero WHERE fecha_devolucion >= ? AND fecha_devolucion <= ?";
            try ( PreparedStatement ps = con.prepareStatement(query)) {
                ps.setDate(1, java.sql.Date.valueOf(fechaInicio.toString()));
                ps.setDate(2, java.sql.Date.valueOf(fechaFinal.toString()));
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    tienePrestamos = true;

                    String fecha = LocalDate.now().toString();
                    String archivo = nombreArchivo + "_" + fecha;

                    PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/" + archivo + ".pdf"));
                    documento.open();

                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                    } while (rs.next());
                    documento.add(tabla);
                    documento.close();

                    abrirArchivo(ruta, archivo);
                }
            } catch (DocumentException | SQLException ex) {

            }
        } catch (HeadlessException | FileNotFoundException ex) {

        }
        return tienePrestamos;
    }

    @Override
    public boolean generarPDFDevolucionporUsuario(String cedula, String nombreArchivo) {
        boolean tienePrestamos = false;

        try {
            String ruta = System.getProperty("user.home");

            PdfPTable tabla = crearTabla();

            String query = "SELECT usuarios.cedula, usuarios.nombre, libros.titulo, generos.nombre_genero, devoluciones.fecha_devolucion FROM"
                    + " devoluciones JOIN usuarios ON devoluciones.id_usuario = usuarios.cedula JOIN libros ON devoluciones.id_libro = libros.ISBN JOIN generos ON libros.id_genero = generos.id_genero WHERE devoluciones.id_usuario = ?";
            try ( PreparedStatement ps = con.prepareStatement(query)) {
                ps.setString(1, cedula);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    tienePrestamos = true;

                    String fecha = LocalDate.now().toString();
                    String archivo = nombreArchivo + "_" + fecha;

                    PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/" + archivo + ".pdf"));
                    documento.open();

                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                    } while (rs.next());
                    documento.add(tabla);
                    documento.close();

                    abrirArchivo(ruta, archivo);
                }
            } catch (DocumentException | SQLException ex) {

            }
        } catch (HeadlessException | FileNotFoundException ex) {

        }
        return tienePrestamos;
    }

    private PdfPTable crearTablaRetrasos() {
        float[] columnWidths = {7, 15, 15, 15, 15, 7};
        PdfPTable tabla = new PdfPTable(columnWidths);

        tabla.addCell("Cédula usuario");
        tabla.addCell("Nombre usuario");
        tabla.addCell("Titulo libro");
        tabla.addCell("Género");
        tabla.addCell("Fecha vencimiento");
        tabla.addCell("Libros");

        return tabla;
    }

    private PdfPTable crearTabla() {
        float[] columnWidths = {7, 15, 15, 15, 15};
        PdfPTable tabla = new PdfPTable(columnWidths);

        tabla.addCell("Cédula usuario");
        tabla.addCell("Nombre usuario");
        tabla.addCell("Titulo libro");
        tabla.addCell("Género");
        tabla.addCell("Fecha");

        return tabla;

    }

    private void abrirArchivo(String ruta, String archivo) {
        try {
            Desktop.getDesktop().open(new File(ruta + "/Desktop/" + archivo + ".pdf"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
