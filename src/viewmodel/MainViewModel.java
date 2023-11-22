package viewmodel;

import javafx.collections.ObservableList;
import model.QuestionModel;
import service.QuestionStore;

public class MainViewModel {
    private final ObservableList<QuestionModel> questions;

    public MainViewModel() {
        questions = QuestionStore.getInstance().getQuestions();
    }

    public ObservableList<QuestionModel> getQuestions() {
        return questions;
    }
}
