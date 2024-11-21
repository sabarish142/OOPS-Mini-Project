import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class MongoDBConnection {
    public static void main(String[] args) {
        String uri = "mongodb://localhost:27017"; // Replace with your MongoDB URI
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("quizDB"); // Replace with your database name
            MongoCollection<Document> collection = database.getCollection("questions"); // Replace with your collection name
            
            // Query to find the document
            Document query = new Document("question", "What is 2 + 2?");
            Document result = collection.find(query).first();
            
            if (result != null) {
                System.out.println("Found document: " + result.toJson());
            } else {
                System.out.println("No document found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
