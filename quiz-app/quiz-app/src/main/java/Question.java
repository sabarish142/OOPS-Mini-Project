import java.util.List;

public class Question {
    private String question;
    private List<String> options;
    private String correctAnswer;
    private String category;

    // Constructor
    public Question(String question, List<String> options, String correctAnswer, String category) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
        this.category = category;
    }

    // Getters
    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getCategory() {
        return category;
    }
}
