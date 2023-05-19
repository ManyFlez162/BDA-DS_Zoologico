/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import java.util.List;
import org.bson.types.ObjectId;
import org.itson.dominio.Habitat;
import org.itson.dominio.Itinerario;
import org.itson.excepciones.PersistenciaException;

/**
 *
 * @author Manu
 */
public interface IAdministradorItinerarios {
    
    public boolean validarNombreItinerario(Itinerario itinerario);
    
    public boolean validarHorarioDisponible(Itinerario itinerario);
    
    public boolean validarDistanciaRecorrido(Itinerario itinerario);
    
    public void enviarItinerario(Itinerario itinerario);
    
    public void modificacionItinerario(Itinerario itinerario);
    
    public Itinerario regresarItinerarioPorNombre(String nombreItinerario);
    
    public Itinerario regresarItinerario(Itinerario itinerario);
    
    public Habitat obtenerHabitatPorNombre(String nombre);
    
    public ObjectId obtenerIdHabitat(String nombre);
    
    public List<Habitat> obtenerHabitats();
    
    public List<Itinerario> regresarTodosItinerarios();
    
    public List<Itinerario> itinerariosPaginado(int pagina, int elementosPorPagina);
    
}
