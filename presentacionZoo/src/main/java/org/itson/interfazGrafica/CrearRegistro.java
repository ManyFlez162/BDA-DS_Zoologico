/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.interfazGrafica;
import com.formdev.flatlaf.FlatDarkLaf;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import org.bson.types.ObjectId;
import org.itson.dominio.Habitat;
import org.itson.dominio.Horario;
import org.itson.dominio.Itinerario;
import org.itson.implementacion.FachadaAdministradorItinerarios;
import org.itson.interfaces.IAdministradorItinerarios;
import org.itson.persistencia.ConexionMongoDB;
import org.itson.validadores.Validadores;
/**
 *
 * @author Ryzen 5
 */
public class CrearRegistro extends javax.swing.JFrame {

    private IAdministradorItinerarios administrador;
    private ConexionMongoDB conexion;
    private List<Habitat> listaHabitats;
    private List<ObjectId> listaId;
    private List<Horario> listaHorarios;
    private Validadores validadores;
    private Itinerario itinerario;

    
    /**
     * Creates new form Registros
     */
    public CrearRegistro(ConexionMongoDB conexion, IAdministradorItinerarios administrador) {
        initComponents();
        this.setLocationRelativeTo(null);
        setResizable(false);
        this.administrador = administrador;
        this.conexion = conexion;
        this.listaHabitats = new ArrayList<>();
        this.listaHorarios = new ArrayList<>();
        this.validadores = new Validadores();
        this.itinerario = new Itinerario();
        this.listaId = new ArrayList<>();
        
        btnRegresar.setIcon(new ImageIcon("src/main/java/org/itson/imagenes/icons8_back_to_60px.png"));
        lblMap.setIcon(new ImageIcon("src/main/java/org/itson/imagenes/zoomap-zonas.png"));
        btnGuardar.setIcon(new ImageIcon("src/main/java/org/itson/imagenes/icons8_checked_checkbox_80px_1.png"));
        tbtnA.setIcon(new ImageIcon("src/main/java/org/itson/imagenes/icons8_a_50px_1.png"));
        tbtnB.setIcon(new ImageIcon("src/main/java/org/itson/imagenes/icons8_b_50px.png"));
        tbtnC.setIcon(new ImageIcon("src/main/java/org/itson/imagenes/icons8_c_50px.png"));
        tbtnD.setIcon(new ImageIcon("src/main/java/org/itson/imagenes/icons8_d_50px.png"));
        tbtnE.setIcon(new ImageIcon("src/main/java/org/itson/imagenes/icons8_e_50px.png"));
        
        txfLunes.setEnabled(false);
        txfMartes.setEnabled(false);
        txfMiercoles.setEnabled(false);
        txfJueves.setEnabled(false);
        txfViernes.setEnabled(false);
        txfSabado.setEnabled(false);
        txfDomingo.setEnabled(false);
        
        
        
    }

    public boolean guardarItinerario(){
        if(!txtfNombreItinerario.getText().isEmpty()){
            itinerario.setNombre(txtfNombreItinerario.getText());
        } else{
            JOptionPane.showMessageDialog(this, "Por favor, indique el nombre del itinerario.",
                "Error de validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(!administrador.validarNombreItinerario(itinerario)){
            JOptionPane.showMessageDialog(this, "El nombre del itinerario ya existe. Por favor, elija otro nombre.",
                "Error de validación", JOptionPane.ERROR_MESSAGE);
            return false;
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
       
        administrador.enviarItinerario(itinerario);
        return true;
        
    }
    
    public boolean generaHorarios(){
        int duracionTotal = 0;
        
        if (cbxLunes.isSelected()) {
            if (validadores.validarHora(txfLunes.getText())) {
                Horario horarioLunes = new Horario();
                horarioLunes.setDia("Lunes");

                LocalTime horaInicioLunes = LocalTime.parse(txfLunes.getText(),
                        DateTimeFormatter.ofPattern("HH:mm"));
                horarioLunes.setHoraInicio(horaInicioLunes);

                for (Habitat habitat : listaHabitats) {
                    duracionTotal += habitat.getDuracion();
                }

                horarioLunes.calcularHoraFin(duracionTotal);
                
                 listaHorarios.add(horarioLunes); // Agregar el horario a la lista
               
        }
        }

        if (cbxMartes.isSelected()) {
            if (validadores.validarHora(txfMartes.getText())) {
                Horario horarioMartes = new Horario();
                horarioMartes.setDia("Martes");

                LocalTime horaInicioMartes = LocalTime.parse(txfMartes.getText(),
                        DateTimeFormatter.ofPattern("HH:mm"));
                horarioMartes.setHoraInicio(horaInicioMartes);

                for (Habitat habitat : listaHabitats) {
                    duracionTotal += habitat.getDuracion();
                }

                horarioMartes.calcularHoraFin(duracionTotal);
                
                 listaHorarios.add(horarioMartes); // Agregar el horario a la lista

                
        }
        }
        
        if (cbxMiercoles.isSelected()) {
            if (validadores.validarHora(txfMiercoles.getText())) {
                Horario horarioMiercoles = new Horario();
                horarioMiercoles.setDia("Miercoles");

                LocalTime horaInicioMiercoles = LocalTime.parse(txfMiercoles.getText(),
                        DateTimeFormatter.ofPattern("HH:mm"));
                horarioMiercoles.setHoraInicio(horaInicioMiercoles);

                for (Habitat habitat : listaHabitats) {
                     duracionTotal += habitat.getDuracion();
                }

                horarioMiercoles.calcularHoraFin(duracionTotal);
                
                 listaHorarios.add(horarioMiercoles); // Agregar el horario a la lista
            }
               
        }

        if (cbxJueves.isSelected()) {
            if (validadores.validarHora(txfJueves.getText())) {
                Horario horarioJueves = new Horario();
                horarioJueves.setDia("Jueves");

                LocalTime horaInicioJueves = LocalTime.parse(txfJueves.getText(),
                        DateTimeFormatter.ofPattern("HH:mm"));
                horarioJueves.setHoraInicio(horaInicioJueves);

                for (Habitat habitat : listaHabitats) {
                    duracionTotal += habitat.getDuracion();
                }

                horarioJueves.calcularHoraFin(duracionTotal);

               
                     listaHorarios.add(horarioJueves); // Agregar el horario a la lista
            }
        }
        
        if (cbxViernes.isSelected()) {
            if (validadores.validarHora(txfViernes.getText())) {
                Horario horarioViernes = new Horario();
                horarioViernes.setDia("Viernes");

                LocalTime horaInicioViernes = LocalTime.parse(txfViernes.getText(),
                        DateTimeFormatter.ofPattern("HH:mm"));
                horarioViernes.setHoraInicio(horaInicioViernes);

                for (Habitat habitat : listaHabitats) {
                    duracionTotal += habitat.getDuracion();
                }

                horarioViernes.calcularHoraFin(duracionTotal);
                
                 listaHorarios.add(horarioViernes); // Agregar el horario a la lista

            }
        }

        if (cbxSabado.isSelected()) {
            if (validadores.validarHora(txfSabado.getText())) {
                Horario horarioSabado = new Horario();
                horarioSabado.setDia("Sabado");

                LocalTime horaInicioSabado = LocalTime.parse(txfSabado.getText(),
                        DateTimeFormatter.ofPattern("HH:mm"));
                horarioSabado.setHoraInicio(horaInicioSabado);

                for (Habitat habitat : listaHabitats) {
                    duracionTotal += habitat.getDuracion();
                }

                horarioSabado.calcularHoraFin(duracionTotal);
                
                 listaHorarios.add(horarioSabado); // Agregar el horario a la lista

            }
            
        }

        if (cbxDomingo.isSelected()) {
            if (validadores.validarHora(txfDomingo.getText())) {
                Horario horarioDomingo = new Horario();
                horarioDomingo.setDia("Domingo");

                LocalTime horaInicioDomingo = LocalTime.parse(txfDomingo.getText(),
                        DateTimeFormatter.ofPattern("HH:mm"));
                horarioDomingo.setHoraInicio(horaInicioDomingo);

                for (Habitat habitat : listaHabitats) {
                    duracionTotal += habitat.getDuracion();
                }

                horarioDomingo.calcularHoraFin(duracionTotal);
                
                 listaHorarios.add(horarioDomingo); // Agregar el horario a la lista

        }
        }
        itinerario.setDuracion(duracionTotal);
        
        return true;
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
        lblDetalles = new javax.swing.JLabel();
        pnlCCenter = new javax.swing.JPanel();
        lblNombreItinerario = new javax.swing.JLabel();
        txtfNombreItinerario = new javax.swing.JTextField();
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
        btnGuardar = new javax.swing.JButton();
        tbtnB = new javax.swing.JToggleButton();
        tbtnC = new javax.swing.JToggleButton();
        tbtnD = new javax.swing.JToggleButton();
        tbtnE = new javax.swing.JToggleButton();
        tbtnA = new javax.swing.JToggleButton();
        lblMap = new javax.swing.JLabel();
        txfDomingo = new javax.swing.JTextField();
        txfLunes = new javax.swing.JTextField();
        txfMartes = new javax.swing.JTextField();
        txfMiercoles = new javax.swing.JTextField();
        txfJueves = new javax.swing.JTextField();
        txfViernes = new javax.swing.JTextField();
        txfSabado = new javax.swing.JTextField();
        lblNombreZonaD = new javax.swing.JLabel();
        lblNombreZonaE = new javax.swing.JLabel();
        lblNombreZonaA = new javax.swing.JLabel();
        lblNombreZonaB = new javax.swing.JLabel();
        lblNombreZonaC = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
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
        jLabel1.setText("Registro de nuevo itinerario");

        lblDetalles.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDetalles.setForeground(new java.awt.Color(255, 255, 255));
        lblDetalles.setText("Llene los campos correspondientes del itinerario:");

        javax.swing.GroupLayout pnlCTopLayout = new javax.swing.GroupLayout(pnlCTop);
        pnlCTop.setLayout(pnlCTopLayout);
        pnlCTopLayout.setHorizontalGroup(
            pnlCTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCTopLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addContainerGap(716, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCTopLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblDetalles)
                .addGap(183, 183, 183))
        );
        pnlCTopLayout.setVerticalGroup(
            pnlCTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCTopLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDetalles)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pnlCenter.add(pnlCTop, java.awt.BorderLayout.PAGE_START);

        pnlCCenter.setBackground(new java.awt.Color(0, 52, 81));
        pnlCCenter.setForeground(new java.awt.Color(0, 185, 249));
        pnlCCenter.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombreItinerario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNombreItinerario.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreItinerario.setText("Nombre del Itinerario:");
        pnlCCenter.add(lblNombreItinerario, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, -1, -1));

        txtfNombreItinerario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfNombreItinerarioActionPerformed(evt);
            }
        });
        pnlCCenter.add(txtfNombreItinerario, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 10, 280, -1));

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
        pnlCCenter.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 230, -1, -1));

        tbtnB.setBackground(new java.awt.Color(62, 170, 206));
        tbtnB.setBorder(null);
        tbtnB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtnBActionPerformed(evt);
            }
        });
        pnlCCenter.add(tbtnB, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, -1, -1));

        tbtnC.setBackground(new java.awt.Color(62, 170, 206));
        tbtnC.setBorder(null);
        tbtnC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtnCActionPerformed(evt);
            }
        });
        pnlCCenter.add(tbtnC, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, -1, -1));

        tbtnD.setBackground(new java.awt.Color(62, 170, 206));
        tbtnD.setBorder(null);
        tbtnD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtnDActionPerformed(evt);
            }
        });
        pnlCCenter.add(tbtnD, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, -1, -1));

        tbtnE.setBackground(new java.awt.Color(62, 170, 206));
        tbtnE.setBorder(null);
        tbtnE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtnEActionPerformed(evt);
            }
        });
        pnlCCenter.add(tbtnE, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 190, -1, -1));

        tbtnA.setBackground(new java.awt.Color(62, 170, 206));
        tbtnA.setBorder(null);
        tbtnA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtnAActionPerformed(evt);
            }
        });
        pnlCCenter.add(tbtnA, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, -1, -1));

        lblMap.setText("jLabel3");
        pnlCCenter.add(lblMap, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 660, 420));
        pnlCCenter.add(txfDomingo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 120, 40, -1));
        pnlCCenter.add(txfLunes, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 120, 40, -1));
        pnlCCenter.add(txfMartes, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 120, 40, -1));
        pnlCCenter.add(txfMiercoles, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 120, 40, -1));
        pnlCCenter.add(txfJueves, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 120, 40, -1));
        pnlCCenter.add(txfViernes, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 120, 40, -1));
        pnlCCenter.add(txfSabado, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 120, 40, -1));

        lblNombreZonaD.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreZonaD.setText("Aviarios");
        pnlCCenter.add(lblNombreZonaD, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 460, -1, -1));

        lblNombreZonaE.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreZonaE.setText("Africanos");
        pnlCCenter.add(lblNombreZonaE, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 490, -1, -1));

        lblNombreZonaA.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreZonaA.setText("Granja de Animales");
        pnlCCenter.add(lblNombreZonaA, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 370, -1, -1));

        lblNombreZonaB.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreZonaB.setText("Acuaticos");
        pnlCCenter.add(lblNombreZonaB, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 400, -1, -1));

        lblNombreZonaC.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreZonaC.setText("Reptiles");
        pnlCCenter.add(lblNombreZonaC, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 430, -1, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("A");
        pnlCCenter.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 370, -1, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("B");
        pnlCCenter.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 400, -1, -1));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("C");
        pnlCCenter.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 430, -1, -1));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("D");
        pnlCCenter.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 460, -1, -1));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("E");
        pnlCCenter.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 490, -1, -1));

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
        new Dashboard(conexion).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void txtfNombreItinerarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfNombreItinerarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfNombreItinerarioActionPerformed

    private void cbxDomingoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDomingoActionPerformed
        if(cbxDomingo.isSelected()){
            txfDomingo.setEnabled(true);
        } else{
            txfDomingo.setEnabled(false);
            txfDomingo.setText("");
        }
    }//GEN-LAST:event_cbxDomingoActionPerformed

    private void cbxLunesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxLunesActionPerformed
        if(cbxLunes.isSelected()){
            txfLunes.setEnabled(true);
        } else{
            txfLunes.setEnabled(false);
            txfLunes.setText("");
        }
    }//GEN-LAST:event_cbxLunesActionPerformed

    private void cbxMartesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMartesActionPerformed
        if(cbxMartes.isSelected()){
            txfMartes.setEnabled(true);
        } else{
            txfMartes.setEnabled(false);
            txfMartes.setText("");
        }
    }//GEN-LAST:event_cbxMartesActionPerformed

    private void cbxMiercolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMiercolesActionPerformed
        if(cbxMiercoles.isSelected()){
            txfMiercoles.setEnabled(true);
        } else{
            txfMiercoles.setEnabled(false);
            txfMiercoles.setText("");
        }
    }//GEN-LAST:event_cbxMiercolesActionPerformed

    private void cbxJuevesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxJuevesActionPerformed
        if(cbxJueves.isSelected()){
            txfJueves.setEnabled(true);
        } else{
            txfJueves.setEnabled(false);
            txfJueves.setText("");
        }
    }//GEN-LAST:event_cbxJuevesActionPerformed

    private void cbxViernesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxViernesActionPerformed
        // TODO add your handling code here:
        if(cbxViernes.isSelected()){
            txfViernes.setEnabled(true);
        } else{
            txfViernes.setEnabled(false);
            txfViernes.setText("");
        }
    }//GEN-LAST:event_cbxViernesActionPerformed

    private void cbxSabadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSabadoActionPerformed
        // TODO add your handling code here:
        if(cbxSabado.isSelected()){
            txfSabado.setEnabled(true);
        } else{
            txfSabado.setEnabled(false);
            txfSabado.setText("");
        }
    }//GEN-LAST:event_cbxSabadoActionPerformed

    private void tbtnAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtnAActionPerformed
        // TODO add your handling code here:

        if (tbtnA.isSelected()) {
            listaId.add(administrador.obtenerHabitatPorNombre(lblNombreZonaA.getText()).getId());
        } else {
           listaId.removeIf(id -> id.equals(administrador.obtenerHabitatPorNombre(lblNombreZonaA.getText()).getId()));
        }


    }//GEN-LAST:event_tbtnAActionPerformed

    private void tbtnBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtnBActionPerformed
     if (tbtnB.isSelected()) {
            listaId.add(administrador.obtenerHabitatPorNombre(lblNombreZonaB.getText()).getId());
        } else {
            listaId.removeIf(id -> id.equals(administrador.obtenerHabitatPorNombre(lblNombreZonaB.getText()).getId()));
        }
    }//GEN-LAST:event_tbtnBActionPerformed

    private void tbtnCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtnCActionPerformed
      if (tbtnC.isSelected()) {
            listaId.add(administrador.obtenerHabitatPorNombre(lblNombreZonaC.getText()).getId());
        } else {
            listaId.removeIf(id -> id.equals(administrador.obtenerHabitatPorNombre(lblNombreZonaC.getText()).getId()));
        }
    }//GEN-LAST:event_tbtnCActionPerformed

    private void tbtnDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtnDActionPerformed
        // TODO add your handling code here:
     if (tbtnD.isSelected()) {
            listaId.add(administrador.obtenerHabitatPorNombre(lblNombreZonaD.getText()).getId());
        } else {
            listaId.removeIf(id -> id.equals(administrador.obtenerHabitatPorNombre(lblNombreZonaD.getText()).getId()));
        }
    }//GEN-LAST:event_tbtnDActionPerformed

    private void tbtnEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtnEActionPerformed
       if (tbtnE.isSelected()) {
            listaId.add(administrador.obtenerHabitatPorNombre(lblNombreZonaE.getText()).getId());
        } else {
            listaId.removeIf(id -> id.equals(administrador.obtenerHabitatPorNombre(lblNombreZonaE.getText()).getId()));
        }
    }//GEN-LAST:event_tbtnEActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        
        if(this.guardarItinerario()){
            new Dashboard(conexion).setVisible(true);
            
            JOptionPane.showMessageDialog(this, "Se ha registrado el itinerario nuevo","Felicidades",JOptionPane.INFORMATION_MESSAGE);
            
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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDetalles;
    private javax.swing.JLabel lblDias;
    private javax.swing.JLabel lblMap;
    private javax.swing.JLabel lblNombreItinerario;
    private javax.swing.JLabel lblNombreZonaA;
    private javax.swing.JLabel lblNombreZonaB;
    private javax.swing.JLabel lblNombreZonaC;
    private javax.swing.JLabel lblNombreZonaD;
    private javax.swing.JLabel lblNombreZonaE;
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
    private javax.swing.JTextField txfDomingo;
    private javax.swing.JTextField txfJueves;
    private javax.swing.JTextField txfLunes;
    private javax.swing.JTextField txfMartes;
    private javax.swing.JTextField txfMiercoles;
    private javax.swing.JTextField txfSabado;
    private javax.swing.JTextField txfViernes;
    private javax.swing.JTextField txtfNombreItinerario;
    // End of variables declaration//GEN-END:variables
}
