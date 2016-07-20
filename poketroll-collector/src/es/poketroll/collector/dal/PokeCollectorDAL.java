package es.poketroll.collector.dal;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class PokeCollectorDAL {
	
	public static MongoClient getConexion(String host, Integer port){
		return new MongoClient( host , port );
	}
	
	public static MongoDatabase getDatabase(MongoClient con, String database){
		return con.getDatabase(database);
	}
}
