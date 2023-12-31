/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistasPdf;

import controladores.ControladorPdf;
import javax.swing.JOptionPane;
import vistasAdmin.VentanaHistorialDevoluciones;
import vistasAdmin.VentanaHistorialPrestamo;

/**
 *
 * @author LENOVO
 */
public class VentanaGeneralDevolucion extends javax.swing.JFrame {
    ControladorPdf controlador;


    /**
     * Creates new form VentanaGeneral
     */
    public VentanaGeneralDevolucion() {
        initComponents();
        setLocationRelativeTo(this);
        controlador = new ControladorPdf();
    }
    
    private boolean validarCampos() {
        return (txtTituloReporte.getText().isEmpty());
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
        lblReporteGeneral = new javax.swing.JLabel();
        lblTituloReporte = new javax.swing.JLabel();
        txtTituloReporte = new javax.swing.JTextField();
        btnRegresar = new javax.swing.JButton();
        btnGenerar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 102));

        lblReporteGeneral.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        lblReporteGeneral.setForeground(new java.awt.Color(0, 0, 102));
        lblReporteGeneral.setText("REPORTE GENERAL ");

        lblTituloReporte.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        lblTituloReporte.setForeground(new java.awt.Color(0, 0, 102));
        lblTituloReporte.setText("Titulo reporte");

        txtTituloReporte.setBackground(new java.awt.Color(255, 255, 255));
        txtTituloReporte.setForeground(new java.awt.Color(0, 0, 0));

        btnRegresar.setBackground(new java.awt.Color(255, 255, 255));
        btnRegresar.setFont(new java.awt.Font("Segoe UI Historic", 1, 15)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(0, 0, 102));
        btnRegresar.setText("REGRESAR");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnGenerar.setBackground(new java.awt.Color(0, 0, 102));
        btnGenerar.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        btnGenerar.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerar.setText("GENERAR");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(btnRegresar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGenerar)
                .addGap(163, 163, 163))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(158, Short.MAX_VALUE)
                .addComponent(lblTituloReporte)
                .addGap(67, 67, 67)
                .addComponent(txtTituloReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(231, 231, 231))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(323, 323, 323)
                .addComponent(lblReporteGeneral)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblReporteGeneral)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(189, 189, 189)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTituloReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTituloReporte))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 243, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar)
                    .addComponent(btnGenerar))
                .addGap(113, 113, 113))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        // TODO add your handling code here:
        if(validarCampos()){
            JOptionPane.showMessageDialog(null, "Ingrese el título del reporte");
            return;
        }
        
        String tituloReporte = txtTituloReporte.getText().trim();
        
        boolean success = controlador.generarPDFDevolucion(tituloReporte);
        
        if(success){
            JOptionPane.showMessageDialog(null, "Reporte generado");
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null, "No se pudo generar el reporte");
        }
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        VentanaHistorialDevoluciones ventana = new VentanaHistorialDevoluciones();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblReporteGeneral;
    private javax.swing.JLabel lblTituloReporte;
    private javax.swing.JTextField txtTituloReporte;
    // End of variables declaration//GEN-END:variables
}
