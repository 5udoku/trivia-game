import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
class Question {
    public String label;
    private String answer;
    private ArrayList<String> options = new ArrayList<String>();

    public Question(String question, String answer, String[] wrongAnswers) {
        this.label = question;
        this.answer = answer;
        this.options.add(answer);

        for(int i = 0; i < wrongAnswers.length; i++){
            this.options.add(wrongAnswers[i]);
        }
    }

    public void askQuestion() {
        System.out.println(this.label + "\n");
        for(int i = 0; i < this.options.size(); i++){
            char optionLetter = (char)('A' + i);
            System.out.print((i % 2 == 1 ? " [" : "[")
                    + optionLetter
                    + "]: "
                    + this.options.get(i)
                    + (i % 2 == 1 ? "\n" : ""));
        }
    }

    public boolean checkAnswer(String answer) {
        return answer.equals("A");
//        return this.answer.equals(answer);
    }
}

public class Main {
    public static void main(String[] args) {
        // User Input
        Scanner myScanner = new Scanner(System.in);
        String question;
        String answer;
        String[] wrongAnswers;

        // Create question
        System.out.println("Please ask question: ");
        question = myScanner.nextLine();
        System.out.println("Answer: ");
        answer = myScanner.nextLine();
        System.out.println("Wrong options separated by commas: ");
        wrongAnswers = myScanner.nextLine().split(",");
        Question q = new Question(question, answer, wrongAnswers);

        // Ask and check answer
        q.askQuestion();
        String temp = myScanner.nextLine();
        System.out.println(q.checkAnswer(temp));
        temp = myScanner.nextLine();
        System.out.println(q.checkAnswer(temp));
    }
}