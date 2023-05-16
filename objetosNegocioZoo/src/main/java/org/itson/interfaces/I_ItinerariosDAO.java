/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import org.itson.dominio.Itinerario;

/**
 *
 * @author Manu
 */
public interface I_ItinerariosDAO {
    public void agregarItinerario(Itinerario itinerario);

    public void modificarItinerario(String nombreItinerario, Itinerario itinerarioModificado);

    public Itinerario buscarItinerario(String nombreItinerario);

    public Itinerario itinerarioPaginado();
}
