/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import java.util.List;
import org.itson.dominio.Habitat;

/**
 *
 * @author Cristian
 */
public interface I_HabitatsDAO {
    public Habitat agregarHabitat(Habitat habitat);
    
    public Habitat modificarHabitat(String nombreHabitat, Habitat habitatModificada);

    public Habitat buscarHabitat(String nombreHabitat);
    
    

    public List<Habitat> obtenerHabitats();
}
