import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import java.util.List;
import java.util.ArrayList;

public class MongoDBHelper {

    private MongoClient mongoClient;
    private MongoDatabase database;

    // Constructor to establish connection with MongoDB
    public MongoDBHelper() {
        this.mongoClient = MongoClients.create("mongodb://localhost:27017");
        this.database = mongoClient.getDatabase("quizDB"); // Your database name
    }

    // Method to fetch all quiz questions from MongoDB
    public List<Question> getQuestions() {
        MongoCollection<Document> collection = database.getCollection("questions");
        List<Question> questions = new ArrayList<>();

        // Fetch all documents from 'questions' collection
        for (Document doc : collection.find()) {
            String questionText = doc.getString("question");
            List<String> options = (List<String>) doc.get("options");

            // Log the retrieved data for debugging
            System.out.println("Fetched Question: " + questionText);
            System.out.println("Fetched Options: " + options);  // Logs the options list

            // If options are null, initialize as empty list
            if (options == null) {
                options = new ArrayList<>();  // Initialize as an empty list if null
            }

            String correctAnswer = doc.getString("correctAnswer");
            String category = doc.getString("category");

            // Create Question object from MongoDB data
            Question question = new Question(questionText, options, correctAnswer, category);
            questions.add(question);
        }

        return questions;
    }
}
