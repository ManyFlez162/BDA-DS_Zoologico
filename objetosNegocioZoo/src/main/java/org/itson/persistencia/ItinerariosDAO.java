/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.persistencia;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.itson.dominio.Itinerario;
import org.itson.interfaces.I_ItinerariosDAO;

/**
 *
 * @author Manu
 */
public class ItinerariosDAO implements I_ItinerariosDAO{
    
    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    public ItinerariosDAO() {
        this.mongoClient = new MongoClient("localhost", 27017);
        this.database = mongoClient.getDatabase("mydb");
        this.collection = database.getCollection("itinerarios");
    }

    @Override
    public void agregarItinerario(Itinerario itinerario) {
        Document docItinerario = new Document("nombre", itinerario.getNombre())
            .append("horario", new Document("dia", itinerario.getHorarios().getDia()))
                .append("horaInicio", itinerario.getHorarios().getHoraInicio())
                .append("horaFin", itinerario.getHorarios().getHoraFin()))
            .append("duracion", itinerario.getDuracion())
            .append("longitud", itinerario.getLongitud())
            .append("habitats", itinerario.getHabitats());

        collection.insertOne(docItinerario);
    }

    public void modificarItinerario(String nombreItinerario, Itinerario itinerarioModificado) {
        Document filter = new Document("nombre", nombreItinerario);

        Document update = new Document("$set", new Document("nombre", itinerarioModificado.getNombre())
            .append("horario", new Document("dia", itinerarioModificado.getHorario().getDia())
                .append("horaInicio", itinerarioModificado.getHorario().getHoraInicio())
                .append("horaFin", itinerarioModificado.getHorario().getHoraFin()))
            .append("duracion", itinerarioModificado.getDuracion())
            .append("longitud", itinerarioModificado.getLongitud())
            .append("habitats", itinerarioModificado.getHabitats()));

        collection.updateOne(filter, update);
    }
    
}
