/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.persistencia;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.itson.dominio.Habitat;
import org.itson.dominio.Itinerario;
import org.itson.interfaces.I_HabitatsDAO;

/**
 *
 * @author Cristian
 */
public class HabitatsDAO implements I_HabitatsDAO {

     private final ConexionMongoDB CONEXION;
    private final MongoDatabase BASE_DATOS;
    private final String COLECCION = "habitats";

    public HabitatsDAO(ConexionMongoDB conexion) {
        this.CONEXION = conexion;
        this.BASE_DATOS = conexion.getBaseDatos();
    }
    @Override
    public Habitat agregarHabitat(Habitat habitat) {
       MongoCollection<Habitat> coleccion = BASE_DATOS.getCollection(COLECCION, Habitat.class);
        coleccion.insertOne(habitat);
        return habitat;
    }

    @Override
    public Habitat modificarHabitat(String nombreHabitat, Habitat habitatModificada) {
        MongoCollection<Habitat> coleccion = BASE_DATOS.getCollection(COLECCION, Habitat.class);

        Bson filtro = Filters.eq("nombre", nombreHabitat);

        Bson update = new Document("$set", 
                new Document("distancia", habitatModificada.getDistancia())
                        .append("id"  , habitatModificada.getId())
                            .append("duracion", habitatModificada.getDuracion())
                            .append("nombre", habitatModificada.getNombre()));

        coleccion.updateOne(filtro, update);
        return habitatModificada;
    }

    @Override
    public Habitat buscarHabitat(String nombreHabitat) {
       MongoCollection<Habitat> coleccion = BASE_DATOS.getCollection(COLECCION, Habitat.class);
        Bson filtro = Filters.eq("nombre", nombreHabitat);
        return coleccion.find(filtro).first();
    }

    @Override
    public List<Habitat> obtenerHabitats() {
       MongoCollection<Habitat> coleccion = BASE_DATOS.getCollection(COLECCION, Habitat.class);
        List<Habitat> habitats = new ArrayList<>();
        coleccion.find().into(habitats);
        return habitats;
    }
    
   
}
