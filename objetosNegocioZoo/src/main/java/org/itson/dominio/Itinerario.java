/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.util.List;

/**
 *
 * @author Manu
 */
public class Itinerario {
    private String nombre;
    private List<Horario> horarios;
    private int duracion;
    private int longitud;
    private int cantidadPersonas;
    private List<Habitat> habitats;

    public Itinerario(String nombre, List<Horario> horarios, int duracion, int longitud, List<Habitat> habitats) {
        this.nombre = nombre;
        this.horarios = horarios;
        this.duracion = duracion;
        this.longitud = longitud;
        this.habitats = habitats;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public List<Habitat> getHabitats() {
        return habitats;
    }

    public void setHabitats(List<Habitat> habitats) {
        this.habitats = habitats;
    }

    public void setCantidadPersonas(int personas){
        this.cantidadPersonas = personas;
    }

    public int getCantidadPersonas(){
        return cantidadPersonas;
    }

    @Override
    public String toString() {
        return "Itinerario{" +
                "nombre='" + nombre + '\'' +
                ", horarios=" + horarios +
                ", duracion=" + duracion +
                ", longitud=" + longitud +
                ", habitats=" + habitats +
                ", personas=" + cantidadPersonas +
                '}';
    }
}
