package com.bio.cellscontrol;

import com.mongodb.*;

import java.net.UnknownHostException;

public class TestClass {

    private static final String collName = "names";

    public static void main(String... args) {
        try {
            MongoClient mongo = new MongoClient("localhost", 27017);
            for (String name : mongo.getDatabaseNames()) {
                System.out.println(name);
                final DB db = mongo.getDB(name);
                if (name.equals("test")) {
                    addObjectsToNames(db);
                }
                for (String collectionName : db.getCollectionNames()) {
                    final DBCollection collection = db.getCollection(collectionName);
                    System.out.println(collection.getName());
                    final DBCursor cursor = collection.find();
                    for (DBObject object : cursor) {
                        System.err.println(object);
                    }
                }
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }

    private static void addObjectsToNames(final DB db) {
        DBCollection collection = db.getCollection(collName);
        final DBObject obj = BasicDBObjectBuilder.start("name", "Alololsha").append("ages", 20).append("job", "programmer").get();
        collection.insert(obj);
    }

}
