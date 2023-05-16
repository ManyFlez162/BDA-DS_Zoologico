package org.itson.objetosnegociozoo;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import org.itson.dominio.Habitat;
import org.itson.dominio.Horario;
import org.itson.dominio.Itinerario;
import org.itson.interfaces.I_ItinerariosDAO;
import org.itson.persistencia.ConexionMongoDB;
import org.itson.persistencia.ItinerariosDAO;

/**
 *
 * @author Manu
 */
public class ObjetosNegocioZoo {

    public static void main(String[] args) {
        ConexionMongoDB conexion = new ConexionMongoDB();
        I_ItinerariosDAO itinerariosDAO = new ItinerariosDAO(conexion);
        
        // Creando habitats
        Habitat habitat = new Habitat();
        habitat.setNombre("Jirafas");
        habitat.setDistancia(50);
        habitat.setDuracion(15);
        Habitat habitat2 = new Habitat();
        habitat2.setNombre("Cocodrilos");
        habitat2.setDistancia(30);
        habitat2.setDuracion(20);
        
        // Creando lista de habitats
        List<Habitat> habitats = new ArrayList<>();
        habitats.add(habitat);
        habitats.add(habitat2);
        
        // Creando horario
        LocalTime hora = LocalTime.of(10,0);
        
        Horario horario = new Horario();
        horario.setDia("Lunes");
        horario.setHoraInicio(hora);
        horario.calcularHoraFin(habitat.getDuracion()+habitat2.getDuracion());
        
        // Creando otro horario
        LocalTime hora2 = LocalTime.of(9, 30);
        
        Horario horario2 = new Horario();
        horario2.setDia("Miercoles");
        horario2.setHoraInicio(hora2);
        horario2.calcularHoraFin((habitat.getDuracion()+habitat2.getDuracion()));
        
        // Creando lista con los horarios
        List<Horario> horarios = new ArrayList<>();
        horarios.add(horario);
        horarios.add(horario2);
        
        Itinerario itinerario = new Itinerario();
        itinerario.setNombre("Perrillos");
        itinerario.setHorarios(horarios);
        itinerario.setDuracion((habitat.getDuracion()+habitat2.getDuracion()));
        itinerario.setLongitud((habitat.getDistancia()+habitat2.getDistancia()));
        itinerario.setHabitats(habitats);
        itinerario.setCantidadPersonas(20);
        // itinerariosDAO.agregarItinerario(itinerario);
        
        System.out.println(itinerario);
        
    }
}
