/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

/**
 *
 * @author Manu
 */
public class Habitat {
    private String nombre;
    private int duracion;
    private int distancia;

    public Habitat(String nombre, int duracion, int distancia) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.distancia = distancia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    @Override
    public String toString() {
        return "Habitat{" +
                "nombre='" + nombre + '\'' +
                ", duracion=" + duracion +
                ", distancia=" + distancia +
                '}';
    }
}
