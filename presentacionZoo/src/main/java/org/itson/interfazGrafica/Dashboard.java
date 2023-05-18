/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.interfazGrafica;
import com.formdev.flatlaf.FlatDarkLaf;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import org.itson.dominio.Horario;
import org.itson.dominio.Itinerario;
import org.itson.implementacion.FachadaAdministradorItinerarios;
import org.itson.interfaces.IAdministradorItinerarios;
import org.itson.persistencia.ConexionMongoDB;
/**
 *
 * @author Ryzen 5
 */
public class Dashboard extends javax.swing.JFrame {

    private IAdministradorItinerarios administrador;
    private ConexionMongoDB conexion;
    private int paginaActual = 1;
    
    /**
     * Creates new form Registros
     */
    public Dashboard(ConexionMongoDB conexion) {
        initComponents();
        this.setLocationRelativeTo(null);
        setResizable(false);
        administrador = new FachadaAdministradorItinerarios(conexion);
        this.conexion = conexion;
        
        btnRegresar.setIcon(new ImageIcon("src/main/java/org/itson/imagenes/icons8_back_to_60px.png"));
        id.setIcon(new ImageIcon("src/main/java/org/itson/imagenes/icons8_name_tag_20px.png"));
        correo.setIcon(new ImageIcon("src/main/java/org/itson/imagenes/icons8_mail_20px.png"));
        nombre.setIcon(new ImageIcon("src/main/java/org/itson/imagenes/icons8_name_20px.png"));
        btnAniadir.setIcon(new ImageIcon("src/main/java/org/itson/imagenes/icons8_add_50px.png"));
        btnModificar.setIcon(new ImageIcon("src/main/java/org/itson/imagenes/icons8_edit_50px.png"));
        btnImprimir.setIcon(new ImageIcon("src/main/java/org/itson/imagenes/icons8_eye_50px.png"));
        btnRegresarPagina.setIcon(new ImageIcon("src/main/java/org/itson/imagenes/arrow_40Lpx.png"));
        btnAvanzarPagina.setIcon(new ImageIcon("src/main/java/org/itson/imagenes/icons8_arrow_40px.png"));
        
        generarTablaItinerarios();
        
    }

    public void generarTablaItinerarios(){
        DefaultTableModel modelo = (DefaultTableModel) tablaItinerarios.getModel();
        modelo.setRowCount(0);
        int elementosPagina = 2;
        
        List<Itinerario> itinerarios = administrador.itinerariosPaginado(paginaActual, elementosPagina);
        
        for(Itinerario itinerario: itinerarios){
            String nombre = itinerario.getNombre();
            List<Horario> horarios = itinerario.getHorarios();
            StringBuilder diasString = new StringBuilder();
            
            for(int i = 0; i<horarios.size(); i++){
                Horario horario = horarios.get(i);
                String dia = horario.getDia();
                
                if(i>0){
                    diasString.append(" - ");
                }
                
                diasString.append(dia);
                
            }
            
            modelo.addRow(new Object[]{nombre, diasString.toString()});
            
        }
        
        tablaItinerarios.setModel(modelo);
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlRoot = new javax.swing.JPanel();
        pnlSide = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        pnlCenter = new javax.swing.JPanel();
        pnlCTop = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblOpcion = new javax.swing.JLabel();
        lblDetalles = new javax.swing.JLabel();
        pnlCCenter = new javax.swing.JPanel();
        id = new javax.swing.JLabel();
        correo = new javax.swing.JLabel();
        nombre = new javax.swing.JLabel();
        lbl_Id = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaItinerarios = new javax.swing.JTable();
        btnImprimir = new javax.swing.JButton();
        btnAniadir = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnAvanzarPagina = new javax.swing.JButton();
        btnRegresarPagina = new javax.swing.JButton();
        pnlCBottom = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlRoot.setLayout(new java.awt.BorderLayout());

        pnlSide.setBackground(new java.awt.Color(0, 23, 31));
        pnlSide.setPreferredSize(new java.awt.Dimension(100, 648));

        jPanel1.setBackground(new java.awt.Color(0, 23, 31));
        jPanel1.setPreferredSize(new java.awt.Dimension(100, 150));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 20));

        btnRegresar.setBackground(new java.awt.Color(0, 23, 31));
        btnRegresar.setForeground(new java.awt.Color(0, 23, 31));
        btnRegresar.setBorder(null);
        btnRegresar.setBorderPainted(false);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar);

        pnlSide.add(jPanel1);

        pnlRoot.add(pnlSide, java.awt.BorderLayout.WEST);

        pnlCenter.setBackground(new java.awt.Color(0, 52, 81));
        pnlCenter.setLayout(new java.awt.BorderLayout());

        pnlCTop.setBackground(new java.awt.Color(0, 52, 81));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registro de itinerarios");

        lblOpcion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblOpcion.setForeground(new java.awt.Color(255, 255, 255));
        lblOpcion.setText("Seleccione una opción:");

        lblDetalles.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDetalles.setForeground(new java.awt.Color(255, 255, 255));
        lblDetalles.setText("Para modificar e imprimir, primero seleccione un itinerario de la tabla");

        javax.swing.GroupLayout pnlCTopLayout = new javax.swing.GroupLayout(pnlCTop);
        pnlCTop.setLayout(pnlCTopLayout);
        pnlCTopLayout.setHorizontalGroup(
            pnlCTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCTopLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCTopLayout.createSequentialGroup()
                .addContainerGap(347, Short.MAX_VALUE)
                .addComponent(lblDetalles)
                .addGap(97, 97, 97)
                .addComponent(lblOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(150, 150, 150))
        );
        pnlCTopLayout.setVerticalGroup(
            pnlCTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCTopLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlCTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDetalles)))
        );

        pnlCenter.add(pnlCTop, java.awt.BorderLayout.PAGE_START);

        pnlCCenter.setBackground(new java.awt.Color(0, 52, 81));
        pnlCCenter.setForeground(new java.awt.Color(0, 185, 249));
        pnlCCenter.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        id.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        id.setForeground(new java.awt.Color(255, 255, 255));
        id.setText("ID:");
        pnlCCenter.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        correo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        correo.setForeground(new java.awt.Color(255, 255, 255));
        correo.setText("Correo:");
        pnlCCenter.add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        nombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nombre.setForeground(new java.awt.Color(255, 255, 255));
        nombre.setText("Nombre:");
        pnlCCenter.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, 20));

        lbl_Id.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_Id.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Id.setText("00118");
        pnlCCenter.add(lbl_Id, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, -1, -1));

        lblCorreo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCorreo.setForeground(new java.awt.Color(255, 255, 255));
        lblCorreo.setText("sigan@viendo.com");
        pnlCCenter.add(lblCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        lblNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("José de la Cruz Porfirio Díaz");
        pnlCCenter.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, -1, -1));

        tablaItinerarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Zona Oeste S/D", "Sabado - Domingo"}
            },
            new String [] {
                "Itinerario", "Horario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaItinerarios.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaItinerarios);
        if (tablaItinerarios.getColumnModel().getColumnCount() > 0) {
            tablaItinerarios.getColumnModel().getColumn(0).setResizable(false);
            tablaItinerarios.getColumnModel().getColumn(1).setResizable(false);
        }

        pnlCCenter.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(343, 20, 490, -1));

        btnImprimir.setBackground(new java.awt.Color(0, 52, 81));
        btnImprimir.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnImprimir.setForeground(new java.awt.Color(0, 185, 249));
        btnImprimir.setText("Imprimir");
        btnImprimir.setBorder(null);
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        pnlCCenter.add(btnImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 190, -1, -1));

        btnAniadir.setBackground(new java.awt.Color(0, 52, 81));
        btnAniadir.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAniadir.setForeground(new java.awt.Color(0, 185, 249));
        btnAniadir.setText("Añadir");
        btnAniadir.setBorder(null);
        btnAniadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAniadirActionPerformed(evt);
            }
        });
        pnlCCenter.add(btnAniadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 40, -1, -1));

        btnModificar.setBackground(new java.awt.Color(0, 52, 81));
        btnModificar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(0, 185, 249));
        btnModificar.setText("Modificar");
        btnModificar.setBorder(null);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        pnlCCenter.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 120, -1, -1));

        btnAvanzarPagina.setBackground(new java.awt.Color(0, 52, 81));
        btnAvanzarPagina.setForeground(new java.awt.Color(0, 185, 249));
        btnAvanzarPagina.setBorder(null);
        btnAvanzarPagina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvanzarPaginaActionPerformed(evt);
            }
        });
        pnlCCenter.add(btnAvanzarPagina, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 450, 40, 40));

        btnRegresarPagina.setBackground(new java.awt.Color(0, 52, 81));
        btnRegresarPagina.setBorder(null);
        btnRegresarPagina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarPaginaActionPerformed(evt);
            }
        });
        pnlCCenter.add(btnRegresarPagina, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 450, 40, 40));

        pnlCenter.add(pnlCCenter, java.awt.BorderLayout.CENTER);

        pnlCBottom.setBackground(new java.awt.Color(0, 52, 81));
        pnlCBottom.setPreferredSize(new java.awt.Dimension(1147, 50));

        javax.swing.GroupLayout pnlCBottomLayout = new javax.swing.GroupLayout(pnlCBottom);
        pnlCBottom.setLayout(pnlCBottomLayout);
        pnlCBottomLayout.setHorizontalGroup(
            pnlCBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1187, Short.MAX_VALUE)
        );
        pnlCBottomLayout.setVerticalGroup(
            pnlCBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        pnlCenter.add(pnlCBottom, java.awt.BorderLayout.SOUTH);

        pnlRoot.add(pnlCenter, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlRoot, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnAniadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAniadirActionPerformed
        // TODO add your handling code here:
        new CrearRegistro(conexion, administrador, this).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAniadirActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnRegresarPaginaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarPaginaActionPerformed
        // TODO add your handling code here:
        if(paginaActual > 1){
            paginaActual--;
            generarTablaItinerarios();
        }
    }//GEN-LAST:event_btnRegresarPaginaActionPerformed

    private void btnAvanzarPaginaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvanzarPaginaActionPerformed
        // TODO add your handling code here:
        List<Itinerario> itinerarios = administrador.regresarTodosItinerarios();
        int elementosPagina = 2;
        int numPaginas = (int) Math.ceil((double) itinerarios.size() / elementosPagina);
        
        if(paginaActual<numPaginas){
            paginaActual++;
            generarTablaItinerarios();
        }
        
    }//GEN-LAST:event_btnAvanzarPaginaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAniadir;
    private javax.swing.JButton btnAvanzarPagina;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnRegresarPagina;
    private javax.swing.JLabel correo;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblDetalles;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblOpcion;
    private javax.swing.JLabel lbl_Id;
    private javax.swing.JLabel nombre;
    private javax.swing.JPanel pnlCBottom;
    private javax.swing.JPanel pnlCCenter;
    private javax.swing.JPanel pnlCTop;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlRoot;
    private javax.swing.JPanel pnlSide;
    private javax.swing.JTable tablaItinerarios;
    // End of variables declaration//GEN-END:variables
}
