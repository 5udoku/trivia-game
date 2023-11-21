import java.util.*;

class Question {
    public String label;
    private final int answerIndex;
    private final ArrayList<String> options = new ArrayList<>();
    private static final Random rand = new Random();

    public Question(String question, String answer, String[] wrongAnswers) {
        this.label = question;

        // Insert options and shuffle
        this.options.addAll(Arrays.asList(wrongAnswers));
        Collections.shuffle(this.options);

        // Insert at random index 0 <-> N-1
        this.answerIndex = Question.rand.nextInt(wrongAnswers.length);
        this.options.add(this.answerIndex, answer);
    }

    public void askQuestion() {
        System.out.println(this.label);
        for(int i = 0; i < this.options.size(); i++){
            char optionLetter = (char)('A' + i);
            System.out.print((i % 2 == 1 ? " [" : "[")
                    + optionLetter
                    + "]: "
                    + this.options.get(i)
                    + (i % 2 == 1 ? "\n" : ""));
        }
    }

    public boolean checkAnswer(char c) {
        return this.answerIndex == c - 'A';
    }
}

class QuestionFactory{
    Question createQuestion(){
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
        wrongAnswers = Arrays
                .stream(myScanner.nextLine().split(","))
                .map(String::trim)
                .toArray(String[]::new);
        for (int i = 0; i < wrongAnswers.length; i++){
            wrongAnswers[i] = wrongAnswers[i].trim();
        }

        return new Question(question, answer, wrongAnswers);
    }
}

class QuestionStore{
    private static QuestionStore instance;
    private final List<Question> questions = new ArrayList<>();

    private QuestionStore() {} // Private constructor

    // Global access point
    public static QuestionStore getInstance() {
        if (instance == null) {
            instance = new QuestionStore();
        }
        return instance;
    }

    // Method to add a question to the store
    public void addQuestion(Question question) {
        questions.add(question);
    }

    // Method to get all questions
    public List<Question> getQuestions() {
        return questions;
    }
}

public class Main {
    public static void main(String[] args) {
        QuestionStore qStore = QuestionStore.getInstance();
        Scanner myScanner = new Scanner(System.in);
        QuestionFactory qf = new QuestionFactory();

        // Generate questions
        Question q1 = qf.createQuestion();
//        Question q2 = qf.createQuestion();
//        Question q3 = qf.createQuestion();
        qStore.addQuestion(q1);
//        qStore.addQuestion(q2);
//        qStore.addQuestion(q3);

        // Ask and check answer
        qStore.getQuestions().forEach((q) -> {
            q.askQuestion();
            char tmp = myScanner.next("[A-Z]").charAt(0);
            System.out.println(q.checkAnswer(tmp));
        });
    }
}