package factory;

import model.QuestionModel;
import java.util.*;

public class QuestionFactory {
    // Used to randomize correct answer position
    private static final Random rand = new Random();

    public QuestionModel createQuestion(String label, String answer, ArrayList<String> options) {
        int answerIndex = QuestionFactory.rand.nextInt(options.size());

        Collections.shuffle(options);
        options.add(answerIndex, answer);

        return new QuestionModel(label, answerIndex, options);
    }
}
