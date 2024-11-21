import java.util.List;
import java.util.Scanner;
public class QuizApp {
    public static void main(String[] args) {
        // Initialize MongoDB helper to fetch questions
        MongoDBHelper mongoDBHelper = new MongoDBHelper();
        List<Question> questions = mongoDBHelper.getQuestions();
        
        int score = 0; // Variable to track score
        Scanner scanner = new Scanner(System.in);

        // Loop through all the questions
        for (Question question : questions) {
            System.out.println(question.getQuestion());
            List<String> options = question.getOptions();

            // Display the options to the user
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }

            // Get user's answer
            System.out.print("Enter your option : ");
            int userAnswer = scanner.nextInt();

            // Check if the answer is correct
            if (userAnswer > 0 && userAnswer <= options.size()) {
                if (options.get(userAnswer - 1).equals(question.getCorrectAnswer())) {
                    score++;  // Increase score if correct
                    System.out.println("Correct!");
                } else {
                    System.out.println("Incorrect. The correct answer is: " + question.getCorrectAnswer());
                }
            } else {
                System.out.println("Invalid option. Please choose a number between 1 and " + options.size());
            }
            System.out.println(); // For spacing
        }

        // Output the final score
        System.out.println("Your score: " + score + "/" + questions.size());
        scanner.close(); // Close the scanner
    }
}
