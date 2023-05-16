package org.itson.interfaces;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class PantallaRegistro extends JPanel {
    private JButton goBack;
    private JLabel lbl_registros;
    private JLabel correo;
    private JLabel nombre;
    private JLabel id;
    private JLabel correo2;
    private JLabel nombre2;
    private JLabel id2;
    private JButton jcomp9;
    private JButton jcomp10;
    private JList list_itinerario;
    private JLabel lbl_itinerarios;
    private JLabel lbl_itinerario;
    private JLabel lbl_horario;
    private JLabel lbl_zonas;
    private JList list_horario;
    private JList lis_zonas;
    private JButton btn_agregar;
    private JButton btn_modificar;
    private JButton btn_imprimir;

    public PantallaRegistro() {
        //construct preComponents
        String[] list_itinerarioItems = {"Item 1", "Item 2", "Item 3"};
        String[] list_horarioItems = {"Item 1", "Item 2", "Item 3"};
        String[] lis_zonasItems = {"Item 1", "Item 2", "Item 3"};

        //construct components
        goBack = new JButton ("Back");
        lbl_registros = new JLabel ("Registros");
        correo = new JLabel ("Correo:");
        nombre = new JLabel ("Nombre: ");
        id = new JLabel ("ID:");
        correo2 = new JLabel ("visualstudiocodegod@microsoft.com");
        nombre2 = new JLabel ("Miguel Angel Mbappe Gomez");
        id2 = new JLabel ("00125");
        jcomp9 = new JButton ("<");
        jcomp10 = new JButton (">");
        list_itinerario = new JList (list_itinerarioItems);
        lbl_itinerarios = new JLabel ("Itinerarios");
        lbl_itinerario = new JLabel ("Itinerario");
        lbl_horario = new JLabel ("Horario");
        lbl_zonas = new JLabel ("Zonas");
        list_horario = new JList (list_horarioItems);
        lis_zonas = new JList (lis_zonasItems);
        btn_agregar = new JButton ("Agregar");
        btn_modificar = new JButton ("Modificar");
        btn_imprimir = new JButton ("Imprimir");

        //set components properties
        goBack.setToolTipText ("Go Back");

        //adjust size and set layout
        setPreferredSize (new Dimension (907, 577));
        setLayout (null);

        //add components
        add (goBack);
        add (lbl_registros);
        add (correo);
        add (nombre);
        add (id);
        add (correo2);
        add (nombre2);
        add (id2);
        add (jcomp9);
        add (jcomp10);
        add (list_itinerario);
        add (lbl_itinerarios);
        add (lbl_itinerario);
        add (lbl_horario);
        add (lbl_zonas);
        add (list_horario);
        add (lis_zonas);
        add (btn_agregar);
        add (btn_modificar);
        add (btn_imprimir);

        //set component bounds (only needed by Absolute Positioning)
        goBack.setBounds (5, 5, 75, 25);
        lbl_registros.setBounds (415, 30, 70, 30);
        correo.setBounds (85, 75, 70, 25);
        nombre.setBounds (85, 100, 70, 25);
        id.setBounds (85, 125, 70, 25);
        correo2.setBounds (160, 75, 270, 25);
        nombre2.setBounds (160, 100, 210, 25);
        id2.setBounds (160, 125, 100, 25);
        jcomp9.setBounds (700, 465, 45, 25);
        jcomp10.setBounds (755, 465, 45, 25);
        list_itinerario.setBounds (90, 220, 240, 240);
        lbl_itinerarios.setBounds (410, 155, 100, 25);
        lbl_itinerario.setBounds (175, 190, 100, 25);
        lbl_horario.setBounds (420, 190, 100, 25);
        lbl_zonas.setBounds (660, 190, 100, 25);
        list_horario.setBounds (330, 220, 240, 240);
        lis_zonas.setBounds (570, 220, 240, 240);
        btn_agregar.setBounds (280, 510, 100, 25);
        btn_modificar.setBounds (410, 510, 100, 25);
        btn_imprimir.setBounds (540, 510, 100, 25);
    }


    public static void main (String[] args) {
        JFrame frame = new JFrame ("MyPanel");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new PantallaRegistro());
        frame.pack();
        frame.setVisible (true);
    }
}
