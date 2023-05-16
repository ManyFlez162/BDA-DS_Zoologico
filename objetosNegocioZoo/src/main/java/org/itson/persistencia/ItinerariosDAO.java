package org.itson.persistencia;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.List;
import org.bson.Document;
import org.itson.dominio.Habitat;
import org.itson.dominio.Horario;
import org.itson.dominio.Itinerario;
import org.itson.interfaces.I_ItinerariosDAO;

/**
 *
 * @author Manu
 */
public class ItinerariosDAO implements I_ItinerariosDAO{
    
    private final ConexionMongoDB CONEXION;
    private MongoDatabase database;
    private String coleccion = "itinerarios";

    public ItinerariosDAO(ConexionMongoDB conexion) {
        this.CONEXION = conexion;
        this.database = conexion.getBaseDatos();
    }

    @Override
    public void agregarItinerario(Itinerario itinerario) {
        MongoCollection<Document> collection = database.getCollection(coleccion);
        Document document = new Document("nombre", itinerario.getNombre())
                .append("horarios", itinerario.getHorarios())
                .append("duracion", itinerario.getDuracion())
                .append("longitud", itinerario.getLongitud())
                .append("habitats", itinerario.getHabitats());

        collection.insertOne(document);
    }

    @Override
    public void modificarItinerario(String nombreItinerario, Itinerario itinerarioModificado) {
        MongoCollection<Document> collection = database.getCollection(coleccion);
        Document filter = new Document("nombre", nombreItinerario);
        Document update = new Document("$set", new Document("nombre", itinerarioModificado.getNombre())
                .append("horarios", itinerarioModificado.getHorarios())
                .append("duracion", itinerarioModificado.getDuracion())
                .append("longitud", itinerarioModificado.getLongitud())
                .append("habitats", itinerarioModificado.getHabitats()));

        collection.updateOne(filter, update);
    }

    @Override
    public Itinerario buscarItinerario(String nombreItinerario) {
        MongoCollection<Document> collection = database.getCollection(coleccion);
        Document query = new Document("nombre", nombreItinerario);
        Document result = collection.find(query).first();

        if (result != null) {
            String nombre = result.getString("nombre");
            List<Horario> horarios = result.getList("horarios", Horario.class);
            int duracion = result.getInteger("duracion");
            int longitud = result.getInteger("longitud");
            List<Habitat> habitats = result.getList("habitats", Habitat.class);

            return new Itinerario(nombre, horarios, duracion, longitud, habitats);
        }

        return null;
    }

    @Override
    public Itinerario itinerarioPaginado() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'itinerarioPaginado'");
    }
    
}
