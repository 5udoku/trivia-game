package service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.QuestionModel;

import java.util.ArrayList;
import java.util.List;

public class QuestionStore {
    private static QuestionStore instance;
    private final ObservableList<QuestionModel> questions = FXCollections.observableArrayList();

    private QuestionStore() {
    } // Private constructor

    // Global access point
    public static QuestionStore getInstance() {
        if (instance == null) {
            instance = new QuestionStore();
        }
        return instance;
    }

    // Method to add a question to the store
    public void addQuestion(QuestionModel question) {
        questions.add(question);
    }

    // Method to get all questions
    public ObservableList<QuestionModel> getQuestions() {
        return questions;
    }
}
