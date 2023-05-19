/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.itson.pruebas;


import java.util.List;
import org.itson.dominio.Habitat;
import org.itson.implementacion.FachadaAdministradorItinerarios;
import org.itson.interfaces.IAdministradorItinerarios;
import org.itson.interfazGrafica.Dashboard;
import org.itson.persistencia.ConexionMongoDB;
import org.itson.persistencia.HabitatsDAO;

/**
 *
 * @author Manu
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ConexionMongoDB conexion = new ConexionMongoDB();
        cargarHabitats();
        new Dashboard(conexion).setVisible(true);
         
    }
    
    public static void cargarHabitats(){
        
        
        
        ConexionMongoDB conexion = new ConexionMongoDB();
        HabitatsDAO habitatsDAO = new HabitatsDAO(conexion);
        IAdministradorItinerarios administrador = new FachadaAdministradorItinerarios(conexion);
        List<Habitat> habitats;
        habitats = administrador.obtenerHabitats();
         if(habitats.isEmpty()){
             
             Habitat habitat1 = new Habitat("Granja de animales", 25, 200);
        Habitat habitat2 = new Habitat("Acuaticos", 25, 210);
        Habitat habitat3 = new Habitat("Reptiles", 20, 100);
        Habitat habitat4 = new Habitat("Aviarios", 25, 170);
        Habitat habitat5 = new Habitat("Africanos", 35, 300);
            
             
              habitatsDAO.agregarHabitat(habitat1);
        habitatsDAO.agregarHabitat(habitat2);
        habitatsDAO.agregarHabitat(habitat3);
        habitatsDAO.agregarHabitat(habitat4);
        habitatsDAO.agregarHabitat(habitat5);
         }        
        
        
        
       
    }
    
}
