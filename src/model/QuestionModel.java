package model;

import java.util.ArrayList;
import java.util.UUID;

public class QuestionModel {
    private final UUID id;
    private final String label;
    private final int answerIndex;
    private final ArrayList<String> options = new ArrayList<>();

    public QuestionModel(String question, int answerIndex, ArrayList<String> options) {
        this.id = UUID.randomUUID();
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

    public UUID getId(){
        return id;
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
