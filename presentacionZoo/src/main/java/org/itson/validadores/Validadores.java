/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.itson.validadores;

import java.util.regex.Pattern;

/**
 *
 * @author Cristian
 */
public class Validadores {


        public boolean validarTiempo(int minutos) {
        return minutos > 0 && minutos <= 90;
    }
     
     public boolean validarHora(String hora) {
        String patron = "^([01]?\\d|2[0-3]):[0-5]\\d$";
        return Pattern.matches(patron, hora);
    }
    
}
