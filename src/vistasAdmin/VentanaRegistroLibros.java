/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistasAdmin;

import controladores.ControladorLibro;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.RowFilter;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelos.Genero;
import modelos.Libro;

/**
 *
 * @author LENOVO
 */
public class VentanaRegistroLibros extends javax.swing.JFrame {
    private final ControladorLibro controlador;
    private TableRowSorter<DefaultTableModel> sorter;

    /**
     * Creates new form VentanaRegistroLibros
     */
    public VentanaRegistroLibros() {
        initComponents();
        setLocationRelativeTo(this);
        controlador = new ControladorLibro();
        llenarTabla();
        setCbxGenero();
        setSpnCopias();
        setCbxGeneroBuscar();
    }
    
    private void setCbxGenero(){
        DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();
        cbxGenero.setModel(modelo);
        
        ArrayList<Genero> generos = controlador.getGeneros();
        modelo.addElement("Elija una opción");
        
        for (Genero genero : generos){
            modelo.addElement(genero.getNombreGenero());
        }
    }
    private void setCbxGeneroBuscar(){
        DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();
        cbxBuscarGenero.setModel(modelo);
        
        ArrayList<Genero> generos = controlador.getGeneros();
        modelo.addElement("Elija una opción");
        
        for (Genero genero : generos){
            modelo.addElement(genero.getNombreGenero());
        }
    }
    
    private void setSpnCopias(){
        SpinnerNumberModel modelo = new SpinnerNumberModel();
        
        modelo.setMinimum(0);
        modelo.setMaximum(200);
        spnCopias.setModel(modelo);
        
        JComponent editor = spnCopias.getEditor();
        JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor) editor;
        spinnerEditor.getTextField().setEditable(false);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        lblGestionLibros = new javax.swing.JLabel();
        lblIsbn = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblAutor = new javax.swing.JLabel();
        lblAnio = new javax.swing.JLabel();
        lblCopias = new javax.swing.JLabel();
        lblGenero = new javax.swing.JLabel();
        txtIsbn = new javax.swing.JTextField();
        txtTitulo = new javax.swing.JTextField();
        txtAutor = new javax.swing.JTextField();
        txtAnio = new javax.swing.JTextField();
        cbxGenero = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLibros = new javax.swing.JTable();
        btnRegresar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        spnCopias = new javax.swing.JSpinner();
        lblBuscar = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        lblBuscarGenero = new javax.swing.JLabel();
        cbxBuscarGenero = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(0, 0, 102));

        lblGestionLibros.setFont(new java.awt.Font("Segoe UI Light", 1, 25)); // NOI18N
        lblGestionLibros.setForeground(new java.awt.Color(0, 0, 102));
        lblGestionLibros.setText("GESTIÓN LIBROS");

        lblIsbn.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        lblIsbn.setForeground(new java.awt.Color(0, 0, 102));
        lblIsbn.setText("ISBN");

        lblTitulo.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(0, 0, 102));
        lblTitulo.setText("Título");

        lblAutor.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        lblAutor.setForeground(new java.awt.Color(0, 0, 102));
        lblAutor.setText("Autor");

        lblAnio.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        lblAnio.setForeground(new java.awt.Color(0, 0, 102));
        lblAnio.setText("Año publicación");

        lblCopias.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        lblCopias.setForeground(new java.awt.Color(0, 0, 102));
        lblCopias.setText("Número copias");

        lblGenero.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        lblGenero.setForeground(new java.awt.Color(0, 0, 102));
        lblGenero.setText("Genero");

        txtIsbn.setBackground(new java.awt.Color(255, 255, 255));
        txtIsbn.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        txtIsbn.setForeground(new java.awt.Color(0, 0, 0));

        txtTitulo.setBackground(new java.awt.Color(255, 255, 255));
        txtTitulo.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        txtTitulo.setForeground(new java.awt.Color(0, 0, 0));

        txtAutor.setBackground(new java.awt.Color(255, 255, 255));
        txtAutor.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        txtAutor.setForeground(new java.awt.Color(0, 0, 0));

        txtAnio.setBackground(new java.awt.Color(255, 255, 255));
        txtAnio.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        txtAnio.setForeground(new java.awt.Color(0, 0, 0));

        cbxGenero.setBackground(new java.awt.Color(255, 255, 255));
        cbxGenero.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        cbxGenero.setForeground(new java.awt.Color(0, 0, 0));
        cbxGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tablaLibros.setBackground(new java.awt.Color(255, 255, 255));
        tablaLibros.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        tablaLibros.setForeground(new java.awt.Color(0, 0, 0));
        tablaLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaLibros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaLibrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaLibros);

        btnRegresar.setBackground(new java.awt.Color(255, 255, 255));
        btnRegresar.setFont(new java.awt.Font("Segoe UI Historic", 1, 15)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(0, 0, 102));
        btnRegresar.setText("REGRESAR");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnRegistrar.setBackground(new java.awt.Color(0, 0, 102));
        btnRegistrar.setFont(new java.awt.Font("Segoe UI Historic", 1, 15)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(0, 0, 102));
        btnEditar.setFont(new java.awt.Font("Segoe UI Historic", 1, 15)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(0, 0, 102));
        btnEliminar.setFont(new java.awt.Font("Segoe UI Historic", 1, 15)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        spnCopias.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N

        lblBuscar.setBackground(new java.awt.Color(255, 255, 255));
        lblBuscar.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        lblBuscar.setForeground(new java.awt.Color(0, 0, 102));
        lblBuscar.setText("Buscar");

        txtBuscar.setBackground(new java.awt.Color(255, 255, 255));
        txtBuscar.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        txtBuscar.setForeground(new java.awt.Color(0, 0, 0));
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        lblBuscarGenero.setBackground(new java.awt.Color(255, 255, 255));
        lblBuscarGenero.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        lblBuscarGenero.setForeground(new java.awt.Color(0, 0, 102));
        lblBuscarGenero.setText("Genero");

        cbxBuscarGenero.setBackground(new java.awt.Color(255, 255, 255));
        cbxBuscarGenero.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        cbxBuscarGenero.setForeground(new java.awt.Color(0, 0, 0));
        cbxBuscarGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxBuscarGenero.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxBuscarGeneroItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(424, 424, 424)
                                .addComponent(lblGestionLibros))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnRegresar)
                                .addGap(171, 171, 171)
                                .addComponent(btnRegistrar)
                                .addGap(51, 51, 51)
                                .addComponent(btnEditar)
                                .addGap(56, 56, 56)
                                .addComponent(btnEliminar)))
                        .addContainerGap(378, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblIsbn)
                                    .addComponent(lblTitulo)
                                    .addComponent(lblAutor))
                                .addGap(116, 116, 116)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblAnio)
                                    .addComponent(lblCopias)
                                    .addComponent(lblGenero))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtAnio)
                                    .addComponent(cbxGenero, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(spnCopias))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 704, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(lblBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(90, 90, 90)
                                .addComponent(lblBuscarGenero)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbxBuscarGenero, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(47, 47, 47))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblGestionLibros)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblIsbn)
                            .addComponent(txtIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTitulo)
                            .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAutor)
                            .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAnio)
                            .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCopias)
                            .addComponent(spnCopias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblGenero)
                            .addComponent(cbxGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblBuscar)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBuscarGenero)
                            .addComponent(cbxBuscarGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegistrar)
                            .addComponent(btnEditar)
                            .addComponent(btnEliminar))
                        .addGap(61, 61, 61))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnRegresar)
                        .addGap(72, 72, 72))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        if(validarCampos()){
            JOptionPane.showMessageDialog(null, "Ingrese todos los datos");
            return;
        }

        String isbn = txtIsbn.getText().trim();
        String titulo= txtTitulo.getText().trim();
        String autor = txtAutor.getText().trim();
        int anio = Integer.parseInt(txtAnio.getText());
        int copias = (int) spnCopias.getValue();
        String nombreGenero = cbxGenero.getSelectedItem().toString();
        Genero seleccionarGenero = null;
        
        for (Genero genero : controlador.getGeneros()){
            if(genero.getNombreGenero().equals(nombreGenero)){
                seleccionarGenero = genero;
                break;
            }
        }

        try {
            Libro libro = new Libro(isbn, titulo, autor, anio, copias, seleccionarGenero);
            controlador.agregarObjeto(libro);
            llenarTabla();
            limpiarCampos();
            JOptionPane.showMessageDialog(null, "Libro Registrado");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo registrar el libro");
            System.err.println(ex);
        }
                                                
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        if(validarCampos()){
            JOptionPane.showMessageDialog(null, "Ingrese todos los datos");
            return;
        }

        String isbn = txtIsbn.getText().trim();
        String titulo = txtTitulo.getText().trim();
        String autor = txtAutor.getText().trim();
        int anio = Integer.parseInt(txtAnio.getText());
        int copia = (int) spnCopias.getValue();
        String nombreGenero = cbxGenero.getSelectedItem().toString();
        Genero seleccionarGenero = null;
        
        for (Genero genero : controlador.getGeneros()){
            if(genero.getNombreGenero().equals(nombreGenero)){
                seleccionarGenero = genero;
                break;
            }
        }

        Libro libro = new Libro(isbn, titulo, autor, anio, copia, seleccionarGenero);
        controlador.editarObjeto(libro);
        llenarTabla();
        limpiarCampos();
        JOptionPane.showMessageDialog(null, "Libro editado exitosamente");
       
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        String isbn = txtIsbn.getText().trim();
        controlador.eliminarObjeto(isbn);
        llenarTabla();
        JOptionPane.showMessageDialog(null, "libro eliminado");
        limpiarCampos();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        // TODO add your handling code here:
        filtrar();
    }//GEN-LAST:event_txtBuscarKeyReleased

    
    private void cbxBuscarGeneroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxBuscarGeneroItemStateChanged
        // TODO add your handling code here:
        if(cbxBuscarGenero.getSelectedIndex() != 0){
            int idGenero = cbxBuscarGenero.getSelectedIndex();
            
            DefaultTableModel modelo = new DefaultTableModel();
            
            modelo.setColumnIdentifiers(new Object[]{
                "ISBN","Titulo", "Autor", "Año", "Copias", "Genero"
            });
            tablaLibros.setModel(modelo);
            ArrayList<Libro> libros = controlador.buscarLibroPorGenero(idGenero);
            
            if(!libros.isEmpty()){
                for(Libro libro : libros){
                    modelo.addRow(new Object[]{
                        libro.getISBN(),
                        libro.getTitulo(),
                        libro.getAutor(),
                        libro.getAnio(),
                        libro.getCopias(),
                        libro.getGenero().getNombreGenero()
                    });
                }
            }else{
                llenarTabla();
            }
        }else{
            llenarTabla();
        }
    }//GEN-LAST:event_cbxBuscarGeneroItemStateChanged

    private void tablaLibrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaLibrosMouseClicked
        // TODO add your handling code here:
        int seleccion = tablaLibros.getSelectedRow();
        
        txtIsbn.setText(tablaLibros.getValueAt(seleccion, 0).toString());
        txtTitulo.setText(tablaLibros.getValueAt(seleccion, 1).toString());
        txtAutor.setText(tablaLibros.getValueAt(seleccion, 2).toString());
        txtAnio.setText(tablaLibros.getValueAt(seleccion, 3).toString());
        spnCopias.setValue(Integer.parseInt(tablaLibros.getValueAt(seleccion, 4).toString()));
        cbxGenero.setSelectedItem(tablaLibros.getValueAt(seleccion, 5).toString());
    }//GEN-LAST:event_tablaLibrosMouseClicked

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        VentanaOpciones ventana = new VentanaOpciones();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private boolean validarCampos(){
        return (txtIsbn.getText().isEmpty() || txtTitulo.getText().isEmpty() || txtAutor.getText().isEmpty() 
                || txtAnio.getText().isEmpty() || spnCopias.getValue().toString().equals("0") || cbxGenero.getSelectedIndex() == 0);
    }
    
    private void filtrar(){
        String filterText = txtBuscar.getText().trim();
        RowFilter<Object, Object> isbn = RowFilter.regexFilter(filterText, 0);
        RowFilter<Object, Object> titulo = RowFilter.regexFilter("(?i)" + filterText, 1);
        RowFilter<Object, Object> autor = RowFilter.regexFilter("(?i)" + filterText, 2);
        RowFilter<Object, Object> anio = RowFilter.regexFilter(filterText, 3);
        RowFilter<Object, Object> copias = RowFilter.regexFilter(filterText, 4);
        RowFilter<Object, Object> genero = RowFilter.regexFilter("(?i)" + filterText, 5);
        
        sorter.setRowFilter(RowFilter.orFilter(Arrays.asList(isbn, titulo, autor, anio, copias, genero)));
        
        
    }

    private void limpiarCampos() {
        txtIsbn.setText("");
        txtTitulo.setText("");
        txtAutor.setText("");
        txtAnio.setText("");
        spnCopias.setValue(0);
        cbxGenero.setSelectedIndex(0);
    }

private void llenarTabla() {
        DefaultTableModel modelo = new DefaultTableModel();
        ArrayList<Object> libros = controlador.listarObject();
        modelo.setColumnIdentifiers(new Object[]{
            "ISBN", "Titulo", "Autor", "Año", "Copias", "Genero"
        });
        tablaLibros.setModel(modelo);
        tablaLibros.setAutoCreateRowSorter(true);
        sorter = new TableRowSorter<>(modelo);
        tablaLibros.setRowSorter(sorter);
        
        for (int i = 0; i < libros.size(); i++) {
            Libro libro = (Libro) libros.get(i);
            modelo.addRow(new Object[]{
                libro.getISBN(),
                libro.getTitulo(),
                libro.getAutor(),
                libro.getAnio(),
                libro.getCopias(),
                libro.getGenero().getNombreGenero()
            });
        }
    }

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbxBuscarGenero;
    private javax.swing.JComboBox<String> cbxGenero;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAnio;
    private javax.swing.JLabel lblAutor;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblBuscarGenero;
    private javax.swing.JLabel lblCopias;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblGestionLibros;
    private javax.swing.JLabel lblIsbn;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JSpinner spnCopias;
    private javax.swing.JTable tablaLibros;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtIsbn;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
