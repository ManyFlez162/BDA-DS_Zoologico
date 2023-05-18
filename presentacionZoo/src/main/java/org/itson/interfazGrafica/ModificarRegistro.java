/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.interfazGrafica;
import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.ImageIcon;
/**
 *
 * @author Ryzen 5
 */
public class ModificarRegistro extends javax.swing.JFrame {

    /**
     * Creates new form Registros
     */
    public ModificarRegistro() {
        initComponents();
         btnRegresar.setIcon(new ImageIcon("src/main/java/org/itson/imagenes/icons8_back_to_60px"));
         lblMap.setIcon(new ImageIcon("src/main/java/org/itson/imagenes/zoomap-zonas"));
          lbl_ImagenRecorrido.setIcon(new ImageIcon("src/main/java/org/itson/imagenes/icons8_sneaker_40px_1"));
        lblReloj.setIcon(new ImageIcon("src/main/java/org/itson/imagenes/icons8_clock_40px"));
        lbl_ImagenParticipantes.setIcon(new ImageIcon("src/main/java/org/itson/imagenes/icons8_User_Groups_40px"));
        lblGuardar.setIcon(new ImageIcon("src/main/java/org/itson/imagenes/icons8_checked_checkbox_80px_1"));
        tbtnA.setIcon(new ImageIcon("src/main/java/org/itson/imagenes/icons8_a_50px_1"));
         tbtnB.setIcon(new ImageIcon("src/main/java/org/itson/imagenes/icons8_b_50px"));
          tbtnC.setIcon(new ImageIcon("src/main/java/org/itson/imagenes/icons8_c_50px"));
           tbtnD.setIcon(new ImageIcon("src/main/java/org/itson/imagenes/icons8_d_50px"));
            tbtnE.setIcon(new ImageIcon("src/main/java/org/itson/imagenes/icons8_e_50px"));
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
        lblNombreRegistro = new javax.swing.JLabel();
        pnlCCenter = new javax.swing.JPanel();
        lblDias = new javax.swing.JLabel();
        cbxLunes = new javax.swing.JCheckBox();
        cbxDomingo = new javax.swing.JCheckBox();
        cbxMartes = new javax.swing.JCheckBox();
        cbxMiercoles = new javax.swing.JCheckBox();
        cbxJueves = new javax.swing.JCheckBox();
        cbxViernes = new javax.swing.JCheckBox();
        cbxSabado = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtfHoraInicioMiercoles = new javax.swing.JFormattedTextField();
        txtfHoraInicioMartes = new javax.swing.JFormattedTextField();
        txtfHoraInicioLunes = new javax.swing.JFormattedTextField();
        txtfHoraInicioJueves = new javax.swing.JFormattedTextField();
        txtfHoraInicioViernes = new javax.swing.JFormattedTextField();
        txtfHoraInicioSabado = new javax.swing.JFormattedTextField();
        txtfHoraInicioDomingo = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbl_ImagenRecorrido = new javax.swing.JLabel();
        lblLongitud = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblParticipantes = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbl_ImagenParticipantes = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblDuracion = new javax.swing.JLabel();
        lblReloj = new javax.swing.JLabel();
        lblGuardar = new javax.swing.JButton();
        tbtnB = new javax.swing.JToggleButton();
        tbtnC = new javax.swing.JToggleButton();
        tbtnD = new javax.swing.JToggleButton();
        tbtnE = new javax.swing.JToggleButton();
        tbtnA = new javax.swing.JToggleButton();
        lblMap = new javax.swing.JLabel();
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
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itson/imagenes/icons8_back_to_60px.png"))); // NOI18N
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
        jLabel1.setText("Modificar registro:");
        jLabel1.setRequestFocusEnabled(false);

        lblNombreRegistro.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblNombreRegistro.setText("Rey Leon");
        lblNombreRegistro.setPreferredSize(new java.awt.Dimension(292, 48));

        javax.swing.GroupLayout pnlCTopLayout = new javax.swing.GroupLayout(pnlCTop);
        pnlCTop.setLayout(pnlCTopLayout);
        pnlCTopLayout.setHorizontalGroup(
            pnlCTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCTopLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(lblNombreRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(556, Short.MAX_VALUE))
        );
        pnlCTopLayout.setVerticalGroup(
            pnlCTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCTopLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(pnlCTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblNombreRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pnlCenter.add(pnlCTop, java.awt.BorderLayout.PAGE_START);

        pnlCCenter.setBackground(new java.awt.Color(0, 52, 81));
        pnlCCenter.setForeground(new java.awt.Color(0, 185, 249));
        pnlCCenter.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDias.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDias.setText("Dias:");
        pnlCCenter.add(lblDias, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 60, -1, -1));

        cbxLunes.setText("L");
        pnlCCenter.add(cbxLunes, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 60, -1, -1));

        cbxDomingo.setText("D");
        cbxDomingo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxDomingoActionPerformed(evt);
            }
        });
        pnlCCenter.add(cbxDomingo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 60, -1, -1));

        cbxMartes.setText("Ma");
        pnlCCenter.add(cbxMartes, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 60, -1, -1));

        cbxMiercoles.setText("Mi");
        pnlCCenter.add(cbxMiercoles, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 60, -1, -1));

        cbxJueves.setText("J");
        pnlCCenter.add(cbxJueves, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 60, -1, -1));

        cbxViernes.setText("V");
        pnlCCenter.add(cbxViernes, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 60, -1, 20));

        cbxSabado.setText("S");
        pnlCCenter.add(cbxSabado, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 60, -1, -1));

        jLabel3.setText("Hora");
        pnlCCenter.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 110, 30, -1));

        jLabel4.setText("de");
        pnlCCenter.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(697, 120, 30, -1));

        jLabel5.setText("Inicio");
        pnlCCenter.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 130, -1, -1));

        jLabel6.setText(":");
        pnlCCenter.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 120, -1, -1));

        txtfHoraInicioMiercoles.setPreferredSize(new java.awt.Dimension(60, 22));
        pnlCCenter.add(txtfHoraInicioMiercoles, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 120, 40, -1));

        txtfHoraInicioMartes.setPreferredSize(new java.awt.Dimension(60, 22));
        pnlCCenter.add(txtfHoraInicioMartes, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 120, 40, -1));

        txtfHoraInicioLunes.setPreferredSize(new java.awt.Dimension(60, 22));
        pnlCCenter.add(txtfHoraInicioLunes, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 120, 40, -1));

        txtfHoraInicioJueves.setPreferredSize(new java.awt.Dimension(60, 22));
        pnlCCenter.add(txtfHoraInicioJueves, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 120, 40, -1));

        txtfHoraInicioViernes.setPreferredSize(new java.awt.Dimension(60, 22));
        pnlCCenter.add(txtfHoraInicioViernes, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 120, 40, -1));

        txtfHoraInicioSabado.setPreferredSize(new java.awt.Dimension(60, 22));
        pnlCCenter.add(txtfHoraInicioSabado, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 120, 40, -1));

        txtfHoraInicioDomingo.setPreferredSize(new java.awt.Dimension(60, 22));
        pnlCCenter.add(txtfHoraInicioDomingo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 120, 40, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Longitud del recorrido");
        pnlCCenter.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 200, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Max. participantes");
        pnlCCenter.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 300, -1, -1));

        lbl_ImagenRecorrido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itson/imagenes/icons8_sneaker_40px_1.png"))); // NOI18N
        pnlCCenter.add(lbl_ImagenRecorrido, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 250, 40, 50));

        lblLongitud.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblLongitud.setText("130");
        pnlCCenter.add(lblLongitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 230, -1, -1));

        jLabel11.setText("Metros");
        pnlCCenter.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 235, -1, -1));

        lblParticipantes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblParticipantes.setText("20");
        pnlCCenter.add(lblParticipantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 330, -1, -1));

        jLabel13.setText("Minutos");
        pnlCCenter.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 235, -1, -1));

        lbl_ImagenParticipantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itson/imagenes/icons8_User_Groups_40px.png"))); // NOI18N
        pnlCCenter.add(lbl_ImagenParticipantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 360, 40, 40));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setText("Duracion del recorrido");
        pnlCCenter.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 200, -1, -1));

        lblDuracion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblDuracion.setText("60");
        pnlCCenter.add(lblDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 230, -1, -1));

        lblReloj.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itson/imagenes/icons8_clock_40px.png"))); // NOI18N
        pnlCCenter.add(lblReloj, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 260, 40, 40));

        lblGuardar.setBackground(new java.awt.Color(0, 52, 81));
        lblGuardar.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        lblGuardar.setForeground(new java.awt.Color(0, 185, 249));
        lblGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itson/imagenes/icons8_checked_checkbox_80px_1.png"))); // NOI18N
        lblGuardar.setText("SAVE");
        lblGuardar.setBorder(null);
        pnlCCenter.add(lblGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 430, -1, -1));

        tbtnB.setBackground(new java.awt.Color(62, 170, 206));
        tbtnB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itson/imagenes/icons8_b_50px.png"))); // NOI18N
        tbtnB.setBorder(null);
        pnlCCenter.add(tbtnB, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, -1, -1));

        tbtnC.setBackground(new java.awt.Color(62, 170, 206));
        tbtnC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itson/imagenes/icons8_c_50px.png"))); // NOI18N
        tbtnC.setBorder(null);
        pnlCCenter.add(tbtnC, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, -1, -1));

        tbtnD.setBackground(new java.awt.Color(62, 170, 206));
        tbtnD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itson/imagenes/icons8_d_50px.png"))); // NOI18N
        tbtnD.setBorder(null);
        pnlCCenter.add(tbtnD, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, -1, -1));

        tbtnE.setBackground(new java.awt.Color(62, 170, 206));
        tbtnE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itson/imagenes/icons8_e_50px.png"))); // NOI18N
        tbtnE.setBorder(null);
        pnlCCenter.add(tbtnE, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 190, -1, -1));

        tbtnA.setBackground(new java.awt.Color(62, 170, 206));
        tbtnA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itson/imagenes/icons8_a_50px_1.png"))); // NOI18N
        tbtnA.setBorder(null);
        pnlCCenter.add(tbtnA, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, -1, -1));

        lblMap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/itson/imagenes/zoomap-zonas.png"))); // NOI18N
        lblMap.setText("jLabel3");
        pnlCCenter.add(lblMap, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 660, 420));

        pnlCenter.add(pnlCCenter, java.awt.BorderLayout.CENTER);

        pnlCBottom.setBackground(new java.awt.Color(0, 52, 81));
        pnlCBottom.setPreferredSize(new java.awt.Dimension(1147, 50));

        javax.swing.GroupLayout pnlCBottomLayout = new javax.swing.GroupLayout(pnlCBottom);
        pnlCBottom.setLayout(pnlCBottomLayout);
        pnlCBottomLayout.setHorizontalGroup(
            pnlCBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1180, Short.MAX_VALUE)
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

    private void cbxDomingoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDomingoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxDomingoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        FlatDarkLaf.setup();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarRegistro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresar;
    private javax.swing.JCheckBox cbxDomingo;
    private javax.swing.JCheckBox cbxJueves;
    private javax.swing.JCheckBox cbxLunes;
    private javax.swing.JCheckBox cbxMartes;
    private javax.swing.JCheckBox cbxMiercoles;
    private javax.swing.JCheckBox cbxSabado;
    private javax.swing.JCheckBox cbxViernes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDias;
    private javax.swing.JLabel lblDuracion;
    private javax.swing.JButton lblGuardar;
    private javax.swing.JLabel lblLongitud;
    private javax.swing.JLabel lblMap;
    private javax.swing.JLabel lblNombreRegistro;
    private javax.swing.JLabel lblParticipantes;
    private javax.swing.JLabel lblReloj;
    private javax.swing.JLabel lbl_ImagenParticipantes;
    private javax.swing.JLabel lbl_ImagenRecorrido;
    private javax.swing.JPanel pnlCBottom;
    private javax.swing.JPanel pnlCCenter;
    private javax.swing.JPanel pnlCTop;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlRoot;
    private javax.swing.JPanel pnlSide;
    private javax.swing.JToggleButton tbtnA;
    private javax.swing.JToggleButton tbtnB;
    private javax.swing.JToggleButton tbtnC;
    private javax.swing.JToggleButton tbtnD;
    private javax.swing.JToggleButton tbtnE;
    private javax.swing.JFormattedTextField txtfHoraInicioDomingo;
    private javax.swing.JFormattedTextField txtfHoraInicioJueves;
    private javax.swing.JFormattedTextField txtfHoraInicioLunes;
    private javax.swing.JFormattedTextField txtfHoraInicioMartes;
    private javax.swing.JFormattedTextField txtfHoraInicioMiercoles;
    private javax.swing.JFormattedTextField txtfHoraInicioSabado;
    private javax.swing.JFormattedTextField txtfHoraInicioViernes;
    // End of variables declaration//GEN-END:variables
}
