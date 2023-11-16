import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
class Question {
    public String label;
    private String answer;
    private ArrayList<String> options = new ArrayList<String>();

    public Question(String question, String answer/*, String[] wrongAnswers*/) {
        this.label = question;
        this.answer = answer;
//        this.wrongAnswers = wrongAnswers;
        this.options.add(answer);
        this.options.add(answer + "_B");
        this.options.add(answer + "_C");
        this.options.add(answer + "_D");
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
        byte userCommand;
        String userInput;

        // Dummy data
        Question q1 = new Question("What's 9 + 10?", "21");
        Question q2 = new Question("Staaaahp!", "I could've dropped my croissant!");

        // Create question


        q1.askQuestion();
        System.out.println(q1.checkAnswer("A"));
        System.out.println(q1.checkAnswer("B"));

        q2.askQuestion();
        System.out.println(q1.checkAnswer("A"));
        System.out.println(q1.checkAnswer("B"));
    }
}