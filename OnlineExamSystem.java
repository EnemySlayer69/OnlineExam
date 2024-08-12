import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    String questionText;
    String[] options;
    String correctAnswer;

    Question(String questionText, String[] options, String correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    boolean checkAnswer(String answer) {
        return correctAnswer.equalsIgnoreCase(answer);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(questionText + "\n");
        for (int i = 0; i < options.length; i++) {
            sb.append((i + 1) + ". " + options[i] + "\n");
        }
        return sb.toString();
    }
}

class Exam {
    private List<Question> questions;
    private int score;

    Exam() {
        questions = new ArrayList<>();
        score = 0;
    }

    void addQuestion(Question question) {
        questions.add(question);
    }

    void start() {
        Scanner scanner = new Scanner(System.in);
        for (Question question : questions) {
            System.out.println(question);
            System.out.print("Enter your answer: ");
            String userAnswer = scanner.nextLine();
            if (question.checkAnswer(userAnswer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect! The correct answer was: " + question.correctAnswer);
            }
        }
        System.out.println("Exam finished! Your score: " + score + "/" + questions.size());
        scanner.close();
    }
}

public class OnlineExamSystem {
    public static void main(String[] args) {
        Exam exam = new Exam();

        // Add questions to the exam
        exam.addQuestion(new Question(
            "What is the capital of France?",
            new String[]{"1. Paris", "2. London", "3. Berlin", "4. Madrid"},
            "Paris"
        ));
        exam.addQuestion(new Question(
            "What is 2 + 2?",
            new String[]{"1. 3", "2. 4", "3. 5", "4. 6"},
            "4"
        ));
        exam.addQuestion(new Question(
            "What is the largest ocean on Earth?",
            new String[]{"1. Atlantic Ocean", "2. Indian Ocean", "3. Arctic Ocean", "4. Pacific Ocean"},
            "Pacific Ocean"
        ));

        // Start the exam
        exam.start();
    }
}
