package org.itson.persistencia;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 *
 * @author Manu
 */
public class ConexionMongoDB {
    
    private final String BASE_DATOS = "animales";
    
    public MongoDatabase getBaseDatos(/* También se podría hacer con parámetro*/){
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        MongoClientSettings settings = MongoClientSettings.builder()
                .codecRegistry(pojoCodecRegistry)
                .build();
        
        MongoClient conexion = MongoClients.create(settings);
        
        MongoDatabase baseDatos = conexion.getDatabase(BASE_DATOS);
        return baseDatos;
    }
}