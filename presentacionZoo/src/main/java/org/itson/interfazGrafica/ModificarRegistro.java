/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.interfazGrafica;
import com.formdev.flatlaf.FlatDarkLaf;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.bson.types.ObjectId;
import org.itson.dominio.Habitat;
import org.itson.dominio.Horario;
import org.itson.dominio.Itinerario;
import org.itson.interfaces.IAdministradorItinerarios;
import org.itson.persistencia.ConexionMongoDB;
import org.itson.validadores.Validadores;
/**
 *
 * @author Ryzen 5
 */
public class ModificarRegistro extends javax.swing.JFrame {

    private IAdministradorItinerarios administrador;
    private ConexionMongoDB conexion;
    private List<Habitat> listaHabitats;
    private List<Horario> listaHorarios;
    private Validadores validadores;
    private Itinerario itinerario;
    private List<ObjectId> listaId;
    
    /**
     * Creates new form Registros
     */
    public ModificarRegistro(ConexionMongoDB conexion, IAdministradorItinerarios administrador, Itinerario itinerario) {
        initComponents();
        this.setLocationRelativeTo(null);
        setResizable(false);
        this.administrador = administrador;
        this.conexion = conexion;
        this.listaHabitats = new ArrayList<>();
        this.listaHorarios = new ArrayList<>();
        this.validadores = new Validadores();
        this.itinerario = itinerario;
        this.listaId = new ArrayList<>();
        
        btnRegresar.setIcon(new ImageIcon("src/main/java/org/itson/imagenes/icons8_back_to_60px.png"));
        lblMap.setIcon(new ImageIcon("src/main/java/org/itson/imagenes/zoomap-zonas.png"));
        lbl_ImagenRecorrido.setIcon(new ImageIcon("src/main/java/org/itson/imagenes/icons8_sneaker_40px_1.png"));
        lblReloj.setIcon(new ImageIcon("src/main/java/org/itson/imagenes/icons8_clock_40px.png"));
        lbl_ImagenParticipantes.setIcon(new ImageIcon("src/main/java/org/itson/imagenes/icons8_User_Groups_40px.png"));
        btnGuardar.setIcon(new ImageIcon("src/main/java/org/itson/imagenes/icons8_checked_checkbox_80px_1.png"));
        tbtnA.setIcon(new ImageIcon("src/main/java/org/itson/imagenes/icons8_a_50px_1.png"));
        tbtnB.setIcon(new ImageIcon("src/main/java/org/itson/imagenes/icons8_b_50px.png"));
        tbtnC.setIcon(new ImageIcon("src/main/java/org/itson/imagenes/icons8_c_50px.png"));
        tbtnD.setIcon(new ImageIcon("src/main/java/org/itson/imagenes/icons8_d_50px.png"));
        tbtnE.setIcon(new ImageIcon("src/main/java/org/itson/imagenes/icons8_e_50px.png"));

        txtfHoraInicioLunes.setEnabled(false);
        txtfHoraInicioMartes.setEnabled(false);
        txtfHoraInicioMiercoles.setEnabled(false);
        txtfHoraInicioJueves.setEnabled(false);
        txtfHoraInicioViernes.setEnabled(false);
        txtfHoraInicioSabado.setEnabled(false);
        txtfHoraInicioDomingo.setEnabled(false);

        lblNombreRegistro.setText(this.itinerario.getNombre());
        lblDuracion.setText(String.valueOf(this.itinerario.getDuracion()));
        lblParticipantes.setText(String.valueOf(this.itinerario.getCantidadPersonas()));
        lblLongitud.setText(String.valueOf(this.itinerario.getLongitud()));

        List<Horario> horarios = itinerario.getHorarios();
        for (Horario horario : horarios) {
            if (horario.getDia().equalsIgnoreCase("Lunes")) {
                txtfHoraInicioLunes.setText(horario.getHoraInicio().toString());
            } else {
                if (horario.getDia().equalsIgnoreCase("Martes")) {
                    txtfHoraInicioMartes.setText(horario.getHoraInicio().toString());
                } else {
                    if (horario.getDia().equalsIgnoreCase("Miercoles")) {
                        txtfHoraInicioMiercoles.setText(horario.getHoraInicio().toString());
                    } else {
                        if (horario.getDia().equalsIgnoreCase("Jueves")) {
                            txtfHoraInicioJueves.setText(horario.getHoraInicio().toString());
                        } else {
                            if (horario.getDia().equalsIgnoreCase("Viernes")) {
                                txtfHoraInicioViernes.setText(horario.getHoraInicio().toString());
                            } else {
                                if (horario.getDia().equalsIgnoreCase("Sabado")) {
                                    txtfHoraInicioSabado.setText(horario.getHoraInicio().toString());
                                } else {
                                    if (horario.getDia().equalsIgnoreCase("Domingo")) {
                                        txtfHoraInicioDomingo.setText(horario.getHoraInicio().toString());
                                    }
                                }
                            }
                        }
                    }
                }

            }
        }
        
//        List<Habitat> habitats = administrador.obtenerHabitats();
//        
//        for(Habitat habitat: habitats){
//            if(habitat.getNombre().equalsIgnoreCase("Granja de animales")){
//                tbtnA.setSelected(true);
//            }
//            
//            if(habitat.getNombre().equalsIgnoreCase("Acuaticos")){
//                tbtnB.setSelected(true);
//            }
//            
//            if(habitat.getNombre().equalsIgnoreCase("Reptiles")){
//                tbtnC.setSelected(true);
//            }
//            
//            if(habitat.getNombre().equalsIgnoreCase("Aviarios")){
//                tbtnD.setSelected(true);
//            }
//            
//            if(habitat.getNombre().equalsIgnoreCase("Africanos")){
//                tbtnE.setSelected(true);
//            }
//            
//        }
        
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
        btnGuardar = new javax.swing.JButton();
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
        jLabel1.setText("Modificar registro:");
        jLabel1.setRequestFocusEnabled(false);

        lblNombreRegistro.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblNombreRegistro.setForeground(new java.awt.Color(255, 255, 255));
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
                .addGroup(pnlCTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombreRegistro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pnlCenter.add(pnlCTop, java.awt.BorderLayout.PAGE_START);

        pnlCCenter.setBackground(new java.awt.Color(0, 52, 81));
        pnlCCenter.setForeground(new java.awt.Color(0, 185, 249));
        pnlCCenter.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDias.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDias.setForeground(new java.awt.Color(255, 255, 255));
        lblDias.setText("Dias:");
        pnlCCenter.add(lblDias, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 60, -1, -1));

        cbxLunes.setText("L");
        cbxLunes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxLunesActionPerformed(evt);
            }
        });
        pnlCCenter.add(cbxLunes, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 60, -1, -1));

        cbxDomingo.setText("D");
        cbxDomingo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxDomingoActionPerformed(evt);
            }
        });
        pnlCCenter.add(cbxDomingo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 60, -1, -1));

        cbxMartes.setText("Ma");
        cbxMartes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMartesActionPerformed(evt);
            }
        });
        pnlCCenter.add(cbxMartes, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 60, -1, -1));

        cbxMiercoles.setText("Mi");
        cbxMiercoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMiercolesActionPerformed(evt);
            }
        });
        pnlCCenter.add(cbxMiercoles, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 60, -1, -1));

        cbxJueves.setText("J");
        cbxJueves.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxJuevesActionPerformed(evt);
            }
        });
        pnlCCenter.add(cbxJueves, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 60, -1, -1));

        cbxViernes.setText("V");
        cbxViernes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxViernesActionPerformed(evt);
            }
        });
        pnlCCenter.add(cbxViernes, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 60, -1, 20));

        cbxSabado.setText("S");
        cbxSabado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSabadoActionPerformed(evt);
            }
        });
        pnlCCenter.add(cbxSabado, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 60, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Hora");
        pnlCCenter.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 110, 30, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("de");
        pnlCCenter.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(697, 120, 30, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
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

        btnGuardar.setBackground(new java.awt.Color(0, 52, 81));
        btnGuardar.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(0, 185, 249));
        btnGuardar.setText("SAVE");
        btnGuardar.setBorder(null);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        pnlCCenter.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 320, -1, -1));

        tbtnB.setBackground(new java.awt.Color(62, 170, 206));
        tbtnB.setBorder(null);
        pnlCCenter.add(tbtnB, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, -1, -1));

        tbtnC.setBackground(new java.awt.Color(62, 170, 206));
        tbtnC.setBorder(null);
        pnlCCenter.add(tbtnC, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, -1, -1));

        tbtnD.setBackground(new java.awt.Color(62, 170, 206));
        tbtnD.setBorder(null);
        pnlCCenter.add(tbtnD, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, -1, -1));

        tbtnE.setBackground(new java.awt.Color(62, 170, 206));
        tbtnE.setBorder(null);
        pnlCCenter.add(tbtnE, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 190, -1, -1));

        tbtnA.setBackground(new java.awt.Color(62, 170, 206));
        tbtnA.setBorder(null);
        pnlCCenter.add(tbtnA, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, -1, -1));

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

     public boolean guardarItinerario(){
        if(!lblNombreRegistro.getText().isEmpty()){
            itinerario.setNombre(lblNombreRegistro.getText());
        }
        
        if (!tbtnA.isSelected() && !tbtnB.isSelected() && !tbtnC.isSelected() && !tbtnD.isSelected() && !tbtnE.isSelected()) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar al menos un hábitat.",
                "Error de validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(!cbxLunes.isSelected() && !cbxMartes.isSelected() && !cbxMiercoles.isSelected() && !cbxJueves.isSelected() &&
            !cbxViernes.isSelected() && !cbxSabado.isSelected() && !cbxDomingo.isSelected()) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar al menos un día.",
                "Error de validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        itinerario.setIdHabitat(listaId);
        
        if(!this.generaHorarios()){
            return false;
        }
        
        itinerario.setHorarios(listaHorarios);
        
        int participants = 0;
        
        Random random = new Random();
        participants = random.nextInt(11) + 20;
        
        itinerario.setCantidadPersonas(participants);
        
        int longitudTotal = 0;
        
        for(Habitat habitat: listaHabitats){
            longitudTotal += habitat.getDistancia();
        }
        
        itinerario.setLongitud(longitudTotal);
        
        if(!administrador.validarHorarioDisponible(itinerario)){
            JOptionPane.showMessageDialog(this, "Ya hay un itinerario este dia a esta hora.",
                "Advertencia cruzadas", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        administrador.modificacionItinerario(itinerario);
        
        return true;
             
    }
    
    public boolean generaHorarios(){
        int duracionTotal = 0;
        
        if (cbxLunes.isSelected()) {
            if (validadores.validarHora(txtfHoraInicioLunes.getText())) {
                Horario horarioLunes = new Horario();
                horarioLunes.setDia("Lunes");

                LocalTime horaInicioLunes = LocalTime.parse(txtfHoraInicioLunes.getText(),
                        DateTimeFormatter.ofPattern("HH:mm"));
                horarioLunes.setHoraInicio(horaInicioLunes);

                for (Habitat habitat : listaHabitats) {
                    duracionTotal += habitat.getDuracion();
                }

                horarioLunes.calcularHoraFin(duracionTotal);
                
                     listaHorarios.add(horarioLunes); // Agregar el horario a la lista

               
            } else {
                JOptionPane.showMessageDialog(this, "Verifica que el formato de hora sea correcto.",
                        "Error de formato de hora", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        if (cbxMartes.isSelected()) {
            if (validadores.validarHora(txtfHoraInicioMartes.getText())) {
                Horario horarioMartes = new Horario();
                horarioMartes.setDia("Martes");

                LocalTime horaInicioMartes = LocalTime.parse(txtfHoraInicioMartes.getText(),
                        DateTimeFormatter.ofPattern("HH:mm"));
                horarioMartes.setHoraInicio(horaInicioMartes);

                for (Habitat habitat : listaHabitats) {
                    duracionTotal += habitat.getDuracion();
                }

                horarioMartes.calcularHoraFin(duracionTotal);

                     listaHorarios.add(horarioMartes); // Agregar el horario a la lista

            } else {
                JOptionPane.showMessageDialog(this, "Verifica que el formato de hora sea correcto.",
                        "Error de formato de hora", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        
        if (cbxMiercoles.isSelected()) {
            if (validadores.validarHora(txtfHoraInicioMiercoles.getText())) {
                Horario horarioMiercoles = new Horario();
                horarioMiercoles.setDia("Miercoles");

                LocalTime horaInicioMiercoles = LocalTime.parse(txtfHoraInicioMiercoles.getText(),
                        DateTimeFormatter.ofPattern("HH:mm"));
                horarioMiercoles.setHoraInicio(horaInicioMiercoles);

                for (Habitat habitat : listaHabitats) {
                     duracionTotal += habitat.getDuracion();
                }

                horarioMiercoles.calcularHoraFin(duracionTotal);

                     listaHorarios.add(horarioMiercoles); // Agregar el horario a la lista
                
            } else {
                JOptionPane.showMessageDialog(this, "Verifica que el formato de hora sea correcto.",
                       "Error de formato de hora", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        if (cbxJueves.isSelected()) {
            if (validadores.validarHora(txtfHoraInicioJueves.getText())) {
                Horario horarioJueves = new Horario();
                horarioJueves.setDia("Jueves");

                LocalTime horaInicioJueves = LocalTime.parse(txtfHoraInicioJueves.getText(),
                        DateTimeFormatter.ofPattern("HH:mm"));
                horarioJueves.setHoraInicio(horaInicioJueves);

                for (Habitat habitat : listaHabitats) {
                    duracionTotal += habitat.getDuracion();
                }

                horarioJueves.calcularHoraFin(duracionTotal);

                listaHorarios.add(horarioJueves); // Agregar el horario a la lista
                     
            } else {
                JOptionPane.showMessageDialog(this, "Verifica que el formato de hora sea correcto.",
                        "Error de formato de hora", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        
        if (cbxViernes.isSelected()) {
            if (validadores.validarHora(txtfHoraInicioViernes.getText())) {
                Horario horarioViernes = new Horario();
                horarioViernes.setDia("Viernes");

                LocalTime horaInicioViernes = LocalTime.parse(txtfHoraInicioViernes.getText(),
                        DateTimeFormatter.ofPattern("HH:mm"));
                horarioViernes.setHoraInicio(horaInicioViernes);

                for (Habitat habitat : listaHabitats) {
                    duracionTotal += habitat.getDuracion();
                }

                horarioViernes.calcularHoraFin(duracionTotal);

                     listaHorarios.add(horarioViernes); // Agregar el horario a la lista

            } else {
                JOptionPane.showMessageDialog(this, "Verifica que el formato de hora sea correcto.",
                       "Error de formato de hora", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        if (cbxSabado.isSelected()) {
            if (validadores.validarHora(txtfHoraInicioSabado.getText())) {
                Horario horarioSabado = new Horario();
                horarioSabado.setDia("Sabado");

                LocalTime horaInicioSabado = LocalTime.parse(txtfHoraInicioSabado.getText(),
                        DateTimeFormatter.ofPattern("HH:mm"));
                horarioSabado.setHoraInicio(horaInicioSabado);

                for (Habitat habitat : listaHabitats) {
                    duracionTotal += habitat.getDuracion();
                }

                horarioSabado.calcularHoraFin(duracionTotal);

                listaHorarios.add(horarioSabado); // Agregar el horario a la lista

            } else {
                JOptionPane.showMessageDialog(this, "Verifica que el formato de hora sea correcto.",
                        "Error de formato de hora", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        if (cbxDomingo.isSelected()) {
            if (validadores.validarHora(txtfHoraInicioDomingo.getText())) {
                Horario horarioDomingo = new Horario();
                horarioDomingo.setDia("Domingo");

                LocalTime horaInicioDomingo = LocalTime.parse(txtfHoraInicioDomingo.getText(),
                        DateTimeFormatter.ofPattern("HH:mm"));
                horarioDomingo.setHoraInicio(horaInicioDomingo);

                for (Habitat habitat : listaHabitats) {
                    duracionTotal += habitat.getDuracion();
                }

                horarioDomingo.calcularHoraFin(duracionTotal);

                     listaHorarios.add(horarioDomingo); // Agregar el horario a la lista

            } else {
                JOptionPane.showMessageDialog(this, "Verifica que el formato de hora sea correcto.",
                        "Error de formato de hora", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        
        itinerario.setDuracion(duracionTotal);
        lblDuracion.setText(String.valueOf(duracionTotal));
        
        return true;
    }
    
    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        new Dashboard(conexion).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void cbxDomingoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDomingoActionPerformed
        // TODO add your handling code here:
        if(cbxDomingo.isSelected()){
            txtfHoraInicioDomingo.setEnabled(true);
        } else{
            txtfHoraInicioDomingo.setEnabled(false);
            txtfHoraInicioDomingo.setText("");
        }
    }//GEN-LAST:event_cbxDomingoActionPerformed

    private void cbxLunesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxLunesActionPerformed
        // TODO add your handling code here:
        if(cbxLunes.isSelected()){
            txtfHoraInicioLunes.setEnabled(true);
        } else{
            txtfHoraInicioLunes.setEnabled(false);
            txtfHoraInicioLunes.setText("");
        }
    }//GEN-LAST:event_cbxLunesActionPerformed

    private void cbxMartesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMartesActionPerformed
        // TODO add your handling code here:
        if(cbxMartes.isSelected()){
            txtfHoraInicioMartes.setEnabled(true);
        } else{
            txtfHoraInicioMartes.setEnabled(false);
            txtfHoraInicioMartes.setText("");
        }
    }//GEN-LAST:event_cbxMartesActionPerformed

    private void cbxMiercolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMiercolesActionPerformed
        // TODO add your handling code here:
        if(cbxMiercoles.isSelected()){
            txtfHoraInicioMiercoles.setEnabled(true);
        } else{
            txtfHoraInicioMiercoles.setEnabled(false);
            txtfHoraInicioMiercoles.setText("");
        }
    }//GEN-LAST:event_cbxMiercolesActionPerformed

    private void cbxJuevesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxJuevesActionPerformed
        // TODO add your handling code here:
        if(cbxJueves.isSelected()){
            txtfHoraInicioJueves.setEnabled(true);
        } else{
            txtfHoraInicioJueves.setEnabled(false);
            txtfHoraInicioJueves.setText("");
        }
    }//GEN-LAST:event_cbxJuevesActionPerformed

    private void cbxViernesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxViernesActionPerformed
        // TODO add your handling code here:
        if(cbxViernes.isSelected()){
            txtfHoraInicioViernes.setEnabled(true);
        } else{
            txtfHoraInicioViernes.setEnabled(false);
            txtfHoraInicioViernes.setText("");
        }
    }//GEN-LAST:event_cbxViernesActionPerformed

    private void cbxSabadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSabadoActionPerformed
        // TODO add your handling code here:
        if(cbxViernes.isSelected()){
            txtfHoraInicioSabado.setEnabled(true);
        } else{
            txtfHoraInicioSabado.setEnabled(false);
            txtfHoraInicioSabado.setText("");
        }
    }//GEN-LAST:event_cbxSabadoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if(this.guardarItinerario()){
            new Dashboard(conexion).setVisible(true);
            
            JOptionPane.showMessageDialog(this, "Se ha modificado el itinerario","Felicidades",JOptionPane.INFORMATION_MESSAGE);
            
            dispose();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
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
