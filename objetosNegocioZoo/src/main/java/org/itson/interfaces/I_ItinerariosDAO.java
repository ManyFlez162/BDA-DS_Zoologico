/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import org.itson.dominio.Itinerario;

/**
 *
 * @author Cristian Eduardo Arreola Valenzuela 233140, Jorge Eduardo Elias Cazarez 187134, Manuel Francisco Flores Velazquez 233301, Alejandro Gil Aguilar 228773
 */
public interface I_ItinerariosDAO {
    public void agregarItinerario(Itinerario itinerario);

    public void modificarItinerario(String nombreItinerario, Itinerario itinerarioModificado);

    public Itinerario buscarItinerario(String nombreItinerario);

    public Itinerario itinerarioPaginado();


}
