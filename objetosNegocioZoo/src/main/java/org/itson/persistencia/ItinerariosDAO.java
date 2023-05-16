package org.itson.persistencia;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import java.util.ArrayList;
import java.util.List;
import org.itson.dominio.Itinerario;
import org.itson.interfaces.I_ItinerariosDAO;
import org.bson.conversions.Bson;

/**
 *
 * @author Manu
 */
public class ItinerariosDAO implements I_ItinerariosDAO{
    
    private final ConexionMongoDB CONEXION;
    private final MongoDatabase BASE_DATOS;
    private final String COLECCION = "itinerarios";

    public ItinerariosDAO(ConexionMongoDB conexion) {
        this.CONEXION = conexion;
        this.BASE_DATOS = conexion.getBaseDatos();
    }

    @Override
    public Itinerario agregarItinerario(Itinerario itinerario) {
        MongoCollection<Itinerario> coleccion = BASE_DATOS.getCollection(COLECCION, Itinerario.class);
        coleccion.insertOne(itinerario);
        return itinerario;
    }
    
    @Override
    public Itinerario modificarItinerario(String nombreItinerario, Itinerario itinerarioModificado) {
        MongoCollection<Itinerario> coleccion = BASE_DATOS.getCollection(COLECCION, Itinerario.class);
        Bson filtro = Filters.eq("nombre", nombreItinerario);
        Bson actualizacion = Updates.combine(
            Updates.set("nombre", itinerarioModificado.getNombre()),
            Updates.set("horarios", itinerarioModificado.getHorarios()),
            Updates.set("duracion", itinerarioModificado.getDuracion()),
            Updates.set("longitud", itinerarioModificado.getLongitud()),
            Updates.set("habitats", itinerarioModificado.getHabitats())    
        );
        
        coleccion.updateOne(filtro, actualizacion);
        return itinerarioModificado;
    }

    @Override
    public Itinerario buscarItinerario(String nombreItinerario) {
        MongoCollection<Itinerario> coleccion = BASE_DATOS.getCollection(COLECCION, Itinerario.class);
        Bson filtro = Filters.eq("nombre", nombreItinerario);
        return coleccion.find(filtro).first();
    }

    @Override
    public List<Itinerario> itinerariosPaginado(int pagina, int elementosPorPagina) {
        MongoCollection<Itinerario> coleccion = BASE_DATOS.getCollection(COLECCION, Itinerario.class);
        int salto = (pagina-1) * elementosPorPagina;
        
        FindIterable<Itinerario> iterable = coleccion.find().skip(salto).limit(elementosPorPagina);
        List<Itinerario> itinerarios = new ArrayList<>();
        iterable.into(itinerarios);
        
        return itinerarios;
    }
    
}
