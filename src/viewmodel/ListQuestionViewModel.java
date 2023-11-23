package viewmodel;

import javafx.collections.ObservableList;
import model.QuestionModel;
import service.QuestionStore;

public class ListQuestionViewModel {
    private final ObservableList<QuestionModel> questions;

    public ListQuestionViewModel() {
        questions = QuestionStore.getInstance().getQuestions();
    }

    public ObservableList<QuestionModel> getQuestions() {
        return questions;
    }
}
