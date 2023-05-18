/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementacion;

import java.time.LocalTime;
import java.util.List;
import org.itson.dominio.Horario;
import org.itson.dominio.Itinerario;
import org.itson.interfaces.IAdministradorItinerarios;
import org.itson.interfaces.I_ItinerariosDAO;
import org.itson.persistencia.ConexionMongoDB;
import org.itson.persistencia.ItinerariosDAO;

/**
 *
 * @author Manu
 */
public class FachadaAdministradorItinerarios implements IAdministradorItinerarios{
    private I_ItinerariosDAO itinerariosDAO;
    
    public FachadaAdministradorItinerarios(ConexionMongoDB conexion){
        itinerariosDAO = new ItinerariosDAO(conexion);
    }

    @Override
    public boolean validarNombreItinerario(Itinerario itinerario) {
        String nombre = itinerario.getNombre();
        
        List<Itinerario> itinerarios = itinerariosDAO.obtenerTodosLosItinerarios();
        for(Itinerario iti : itinerarios){
            if(iti.getNombre().equalsIgnoreCase(nombre)){
                return false;
            }
        }
        
        return true;
    }

    @Override
    public boolean validarHorarioDisponible(Itinerario itinerario) {
        List<Itinerario> itinerariosBuscados = itinerariosDAO.obtenerTodosLosItinerarios();
        
        for(Itinerario itinerarioBuscado: itinerariosBuscados){
            for(Horario horarioBuscado: itinerarioBuscado.getHorarios()){
                if(horarioBuscado.getDia().equals(itinerario.getHorarios().get(0).getDia())){
                    LocalTime inicioBuscado = horarioBuscado.getHoraInicio();
                    LocalTime finBuscado = horarioBuscado.getHoraFin();
                
                    LocalTime inicioNuevo = itinerario.getHorarios().get(0).getHoraInicio();
                    LocalTime finNuevo = itinerario.getHorarios().get(0).getHoraFin();
                
                    if((inicioNuevo.isAfter(inicioBuscado) && inicioNuevo.isBefore(finBuscado)) 
                            || (finNuevo.isAfter(inicioBuscado) && finNuevo.isBefore(finBuscado))){
                        return false;
                    }
                }
                
            }
        }
        
        return true;
        
    }

    @Override
    public boolean validarDistanciaRecorrido(Itinerario itinerario) {
        int distanciaTotal = itinerario.getLongitud();
        
        return (distanciaTotal <=1500);
        
    }

    @Override
    public void enviarItinerario(Itinerario itinerario) {
        itinerariosDAO.agregarItinerario(itinerario);
    }

    @Override
    public void modificacionItinerario(Itinerario itinerario) {
        itinerariosDAO.modificarItinerario(itinerario.getNombre(), itinerario);
    }

    @Override
    public Itinerario regresarItinerario(Itinerario itinerario) {
        return itinerariosDAO.buscarItinerario(itinerario.getNombre());
    }

    @Override
    public List<Itinerario> regresarTodosItinerarios() {
        return itinerariosDAO.obtenerTodosLosItinerarios();
    }

    @Override
    public List<Itinerario> itinerariosPaginado(int pagina, int elementosPorPagina) {
        return itinerariosDAO.itinerariosPaginado(pagina, elementosPorPagina);
    }
    
    
    
}
