/**
 * 
 */
package com.iscope.mongodb;

import java.net.UnknownHostException;
import java.util.List;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;

/**
 * @author Des.McCarter
 *
 */
public class Main {
	
    private static DBObject createDBObject(User user) {
        BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
                                 
        docBuilder.append("_id", user.getId());
        docBuilder.append("name", user.getName());
        
        return docBuilder.get();
    }
	
	/**
	 * @param args
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException {
		
	}
	
	private static void createEntityEntries(){
		
		BasicDBObject record = 
				new BasicDBObject("_id","database").append("name","database")
				.append("src", "images/icons/database.jpg");
		

		try {
			EntityDB entityDb = new EntityDB();
		
			entityDb.removeAllEntities();
			
			BasicDBList inputsList = new BasicDBList();
			
			inputsList.add(new BasicDBObject("username","").append("password", "").append("domain", "DOMAIN"));
			
			record.put("inputs", inputsList);
			
			entityDb.insertEntity("database",record);
			
			entityDb.insertEntity("queue", "images/icons/queue.png");
	        
			entityDb.insertEntity("file", "images/icons/fileserver.png");
	        
			entityDb.insertEntity("api", "images/icons/api.png");
	 
			entityDb.insertEntity("service", "images/icons/service.png");
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
