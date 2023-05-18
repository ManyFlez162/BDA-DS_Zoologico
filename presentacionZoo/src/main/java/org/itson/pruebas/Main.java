/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.itson.pruebas;

import org.itson.interfazGrafica.Dashboard;
import org.itson.persistencia.ConexionMongoDB;

/**
 *
 * @author yarvi
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ConexionMongoDB conexion = new ConexionMongoDB();
        new Dashboard(conexion).setVisible(true);
        
    }
    
}
