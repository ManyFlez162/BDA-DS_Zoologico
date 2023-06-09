/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.interfazGrafica;
import com.formdev.flatlaf.FlatDarkLaf;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import org.itson.dominio.Habitat;
import org.itson.dominio.Horario;
import org.itson.dominio.Itinerario;
import org.itson.interfaces.IAdministradorItinerarios;
import org.itson.persistencia.ConexionMongoDB;
import org.itson.validadores.Validadores;
import java.util.Random;

/**
 *
 * @author Ryzen 5
 */
public class DetailRegistro extends javax.swing.JFrame {

    private ConexionMongoDB conexion;
    private IAdministradorItinerarios administrador;
    private List<Habitat> listaHabitats;
    private List<Horario> listaHorarios;
    private Validadores validadores;
    private Itinerario itinerario;
    /**
     * Creates new form Registros
     */
    public DetailRegistro(ConexionMongoDB conexion, IAdministradorItinerarios administrador, Itinerario itinerario) {
        initComponents();
        this.setLocationRelativeTo(null);
        setResizable(false);
        
        this.administrador = administrador;
        this.conexion = conexion;
        this.listaHabitats = new ArrayList<>();
        this.listaHorarios = new ArrayList<>();
        this.validadores = new Validadores();
        this.itinerario = itinerario;
        
        btnRegresar.setIcon(new ImageIcon("src/main/java/org/itson/imagenes/icons8_back_to_60px.png"));
        lblMap.setIcon(new ImageIcon("src/main/java/org/itson/imagenes/zoomap-zonas.png"));
        lblCalendario.setIcon(new ImageIcon("src/main/java/org/itson/imagenes/icons8_calendar_100px.png"));
        lblReloj.setIcon(new ImageIcon("src/main/java/org/itson/imagenes/icons8_clock_40px.png"));
        lbl_ImagenParticipantes.setIcon(new ImageIcon("src/main/java/org/itson/imagenes/icons8_User_Groups_40px.png"));
        lbl_ImagenRecorrido.setIcon(new ImageIcon("src/main/java/org/itson/imagenes/icons8_sneaker_40px_1.png"));
        tbtnA.setIcon(new ImageIcon("src/main/java/org/itson/imagenes/icons8_a_50px_1.png"));
         tbtnB.setIcon(new ImageIcon("src/main/java/org/itson/imagenes/icons8_b_50px.png"));
          tbtnC.setIcon(new ImageIcon("src/main/java/org/itson/imagenes/icons8_c_50px.png"));
           tbtnD.setIcon(new ImageIcon("src/main/java/org/itson/imagenes/icons8_d_50px.png"));
            tbtnE.setIcon(new ImageIcon("src/main/java/org/itson/imagenes/icons8_e_50px.png"));
            
        lblNombreItinerario.setText(itinerario.getNombre());
        lblDuracion.setText(String.valueOf(itinerario.getDuracion()));
        lblParticipantes.setText(String.valueOf(itinerario.getCantidadPersonas()));
        lblLongitud.setText(String.valueOf(itinerario.getLongitud()));
        
             lblDuracion.setText("50");
        lblLongitud.setText("100");
        
        List<Horario> horarios = itinerario.getHorarios();
        for(Horario horario: horarios){
            if(horario.getDia().equalsIgnoreCase("Lunes")){
                lblHoraLunes.setText(horario.getHoraInicio().toString());
            } else {
                if(horario.getDia().equalsIgnoreCase("Martes")){
                lblHoraMartes.setText(horario.getHoraInicio().toString());
            } else {
                    if(horario.getDia().equalsIgnoreCase("Miercoles")){
                lblHoraMiercoles.setText(horario.getHoraInicio().toString());
            } else {
                        if(horario.getDia().equalsIgnoreCase("Jueves")){
                lblHoraJueves.setText(horario.getHoraInicio().toString());
            } else {
                            if(horario.getDia().equalsIgnoreCase("Viernes")){
                lblHoraViernes.setText(horario.getHoraInicio().toString());
            } else {
                                if(horario.getDia().equalsIgnoreCase("Sabado")){
                lblHoraSabado.setText(horario.getHoraInicio().toString());
            } else {
                                    if(horario.getDia().equalsIgnoreCase("Domingo")){
                lblHoraDomingo.setText(horario.getHoraInicio().toString());
            }
                                }
                            }
                        }
                    }
                }
                
            }
        }
        
        List<Habitat> habitats = administrador.obtenerHabitats();
        
        for(Habitat habitat: habitats){
            if(habitat.getNombre().equalsIgnoreCase("Granja de animales")){
                tbtnA.setSelected(true);
            }
            
            if(habitat.getNombre().equalsIgnoreCase("Acuaticos")){
                tbtnB.setSelected(true);
            }
            
            if(habitat.getNombre().equalsIgnoreCase("Reptiles")){
                tbtnC.setSelected(true);
            }
            
            if(habitat.getNombre().equalsIgnoreCase("Aviarios")){
                tbtnD.setSelected(true);
            }
            
            if(habitat.getNombre().equalsIgnoreCase("Africanos")){
                tbtnE.setSelected(true);
            }
            
        }
        
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
        lblNombreItinerario = new javax.swing.JLabel();
        pnlCCenter = new javax.swing.JPanel();
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
        tbtnB = new javax.swing.JToggleButton();
        tbtnC = new javax.swing.JToggleButton();
        tbtnD = new javax.swing.JToggleButton();
        tbtnE = new javax.swing.JToggleButton();
        tbtnA = new javax.swing.JToggleButton();
        lblMap = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lblHoraDomingo = new javax.swing.JLabel();
        lblHoraSabado = new javax.swing.JLabel();
        lblCalendario = new javax.swing.JLabel();
        lblHoraLunes = new javax.swing.JLabel();
        lblHoraMartes = new javax.swing.JLabel();
        lblHoraMiercoles = new javax.swing.JLabel();
        lblHoraJueves = new javax.swing.JLabel();
        lblHoraViernes = new javax.swing.JLabel();
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
        jLabel1.setText("Itinerario:");

        lblNombreItinerario.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblNombreItinerario.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreItinerario.setPreferredSize(new java.awt.Dimension(412, 48));

        javax.swing.GroupLayout pnlCTopLayout = new javax.swing.GroupLayout(pnlCTop);
        pnlCTop.setLayout(pnlCTopLayout);
        pnlCTopLayout.setHorizontalGroup(
            pnlCTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCTopLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(lblNombreItinerario, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(293, Short.MAX_VALUE))
        );
        pnlCTopLayout.setVerticalGroup(
            pnlCTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCTopLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(pnlCTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombreItinerario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pnlCenter.add(pnlCTop, java.awt.BorderLayout.PAGE_START);

        pnlCCenter.setBackground(new java.awt.Color(0, 52, 81));
        pnlCCenter.setForeground(new java.awt.Color(0, 185, 249));
        pnlCCenter.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Longitud del recorrido");
        pnlCCenter.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 200, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Max. participantes");
        pnlCCenter.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 300, -1, -1));
        pnlCCenter.add(lbl_ImagenRecorrido, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 250, 40, 50));

        lblLongitud.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblLongitud.setForeground(new java.awt.Color(255, 255, 255));
        lblLongitud.setText("130");
        pnlCCenter.add(lblLongitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 230, -1, -1));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Metros");
        pnlCCenter.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 235, -1, -1));

        lblParticipantes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblParticipantes.setForeground(new java.awt.Color(255, 255, 255));
        lblParticipantes.setText("20");
        pnlCCenter.add(lblParticipantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 330, -1, -1));

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Minutos");
        pnlCCenter.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 235, -1, -1));
        pnlCCenter.add(lbl_ImagenParticipantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 360, 40, 40));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Duracion del recorrido");
        pnlCCenter.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 200, -1, -1));

        lblDuracion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblDuracion.setForeground(new java.awt.Color(255, 255, 255));
        lblDuracion.setText("60");
        pnlCCenter.add(lblDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 230, -1, -1));
        pnlCCenter.add(lblReloj, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 260, 40, 40));

        tbtnB.setBackground(new java.awt.Color(62, 170, 206));
        tbtnB.setBorder(null);
        pnlCCenter.add(tbtnB, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, -1, -1));

        tbtnC.setBackground(new java.awt.Color(62, 170, 206));
        tbtnC.setBorder(null);
        tbtnC.setContentAreaFilled(false);
        tbtnC.setEnabled(false);
        pnlCCenter.add(tbtnC, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, -1, -1));

        tbtnD.setBackground(new java.awt.Color(62, 170, 206));
        tbtnD.setBorder(null);
        tbtnD.setContentAreaFilled(false);
        tbtnD.setEnabled(false);
        pnlCCenter.add(tbtnD, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, -1, -1));

        tbtnE.setBackground(new java.awt.Color(62, 170, 206));
        tbtnE.setBorder(null);
        tbtnE.setContentAreaFilled(false);
        tbtnE.setEnabled(false);
        pnlCCenter.add(tbtnE, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 190, -1, -1));

        tbtnA.setBackground(new java.awt.Color(62, 170, 206));
        tbtnA.setBorder(null);
        pnlCCenter.add(tbtnA, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, -1, -1));

        lblMap.setText("jLabel3");
        pnlCCenter.add(lblMap, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 660, 420));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Domingo");
        pnlCCenter.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 100, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Lunes");
        pnlCCenter.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 20, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Martes");
        pnlCCenter.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 20, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Miercoles");
        pnlCCenter.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 20, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Jueves");
        pnlCCenter.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 20, -1, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Viernes");
        pnlCCenter.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 100, -1, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Sabado");
        pnlCCenter.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 100, -1, -1));

        lblHoraDomingo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblHoraDomingo.setForeground(new java.awt.Color(255, 255, 255));
        lblHoraDomingo.setPreferredSize(new java.awt.Dimension(35, 20));
        pnlCCenter.add(lblHoraDomingo, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 130, -1, -1));

        lblHoraSabado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblHoraSabado.setForeground(new java.awt.Color(255, 255, 255));
        lblHoraSabado.setPreferredSize(new java.awt.Dimension(35, 20));
        pnlCCenter.add(lblHoraSabado, new org.netbeans.lib.awtextra.AbsoluteConstraints(845, 130, -1, -1));
        pnlCCenter.add(lblCalendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 30, -1, -1));

        lblHoraLunes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblHoraLunes.setForeground(new java.awt.Color(255, 255, 255));
        lblHoraLunes.setPreferredSize(new java.awt.Dimension(35, 20));
        pnlCCenter.add(lblHoraLunes, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 50, -1, -1));

        lblHoraMartes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblHoraMartes.setForeground(new java.awt.Color(255, 255, 255));
        lblHoraMartes.setPreferredSize(new java.awt.Dimension(35, 20));
        pnlCCenter.add(lblHoraMartes, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 50, -1, -1));

        lblHoraMiercoles.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblHoraMiercoles.setForeground(new java.awt.Color(255, 255, 255));
        lblHoraMiercoles.setPreferredSize(new java.awt.Dimension(35, 20));
        pnlCCenter.add(lblHoraMiercoles, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 50, -1, -1));

        lblHoraJueves.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblHoraJueves.setForeground(new java.awt.Color(255, 255, 255));
        lblHoraJueves.setPreferredSize(new java.awt.Dimension(35, 20));
        pnlCCenter.add(lblHoraJueves, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 50, -1, -1));

        lblHoraViernes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblHoraViernes.setForeground(new java.awt.Color(255, 255, 255));
        lblHoraViernes.setPreferredSize(new java.awt.Dimension(35, 20));
        pnlCCenter.add(lblHoraViernes, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 130, -1, -1));

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
        new Dashboard(conexion).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCalendario;
    private javax.swing.JLabel lblDuracion;
    private javax.swing.JLabel lblHoraDomingo;
    private javax.swing.JLabel lblHoraJueves;
    private javax.swing.JLabel lblHoraLunes;
    private javax.swing.JLabel lblHoraMartes;
    private javax.swing.JLabel lblHoraMiercoles;
    private javax.swing.JLabel lblHoraSabado;
    private javax.swing.JLabel lblHoraViernes;
    private javax.swing.JLabel lblLongitud;
    private javax.swing.JLabel lblMap;
    private javax.swing.JLabel lblNombreItinerario;
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
    // End of variables declaration//GEN-END:variables
}
