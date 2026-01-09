import model.Question;
import service.ExamService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExamService service = new ExamService();

        String username = "admin"; // could ask user to login

        System.out.println("===== ONLINE EXAM MANAGEMENT SYSTEM =====");
        System.out.println("Welcome " + username);

        // Option to add questions (Admin)
        System.out.print("Do you want to add a question? (yes/no): ");
        String add = sc.nextLine();
        if (add.equalsIgnoreCase("yes")) {
            System.out.print("Enter question: ");
            String question = sc.nextLine();
            System.out.print("Option A: ");
            String a = sc.nextLine();
            System.out.print("Option B: ");
            String b = sc.nextLine();
            System.out.print("Option C: ");
            String c = sc.nextLine();
            System.out.print("Option D: ");
            String d = sc.nextLine();
            System.out.print("Correct option (A/B/C/D): ");
            String correct = sc.nextLine();
            service.addQuestion(question, a, b, c, d, correct);
        }

        // Start exam
        List<Question> questions = service.getAllQuestions();
        int score = 0;
        for (Question q : questions) {
            System.out.println("\nQuestion: " + q.getQuestion());
            System.out.println("A. " + q.getOptionA());
            System.out.println("B. " + q.getOptionB());
            System.out.println("C. " + q.getOptionC());
            System.out.println("D. " + q.getOptionD());
            System.out.print("Your Answer: ");
            String ans = sc.nextLine();

            if (ans.equalsIgnoreCase(q.getCorrectOption())) {
                score++;
            }
        }

        System.out.println("\nExam completed!");
        System.out.println("Your Score: " + score + " out of " + questions.size());

        service.saveResult(username, score, questions.size());
        System.out.println("Result saved successfully!");

        sc.close();
    }
}
