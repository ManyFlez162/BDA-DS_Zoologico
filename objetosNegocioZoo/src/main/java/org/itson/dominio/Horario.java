/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.time.LocalTime;

/**
 *
 * @author Manu
 */
public class Horario {
    private String dia;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    public Horario() {
    }
    
    public Horario(String dia, LocalTime horaInicio, LocalTime horaFin) {
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }
    
    // Método para calcular la hora de fin basada en la duración de los hábitats
    public void calcularHoraFin(int duracionTotal) {
        this.horaFin = this.horaInicio.plusMinutes(duracionTotal);
    }

    @Override
    public String toString() {
        return "Horario{" + "dia=" + dia + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + '}';
    }
    
}
