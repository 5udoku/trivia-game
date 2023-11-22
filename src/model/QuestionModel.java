package model;

import java.util.ArrayList;

public class QuestionModel {
    public String label;
    private final int answerIndex;
    private final ArrayList<String> options = new ArrayList<>();

    public QuestionModel(String question, int answerIndex, ArrayList<String> options) {
        this.label = question;
        this.answerIndex = answerIndex;
        this.options.addAll(options);
    }

    @Override
    public String toString() {
        return "QuestionModel{" +
                "label='" + label + '\'' +
                ", options=" + options +
                '}';
    }

    public String getLabel() {
        return label;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public boolean checkAnswer(int i) {
        return this.answerIndex == i;
    }
}
