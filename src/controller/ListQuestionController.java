package controller;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import model.QuestionModel;
import viewmodel.ListQuestionViewModel;


public class ListQuestionController {
    @FXML
    private VBox questionList;

    @FXML
    private void initialize(){
        ListQuestionViewModel viewModel = new ListQuestionViewModel();
        ObservableList<QuestionModel> dataList = viewModel.getQuestions();

        dataList.addListener((ListChangeListener.Change<? extends QuestionModel> c) -> {
            while (c.next()) {
                if (c.wasAdded()) {
                    for (QuestionModel addedItem : c.getAddedSubList()) {
                        QuestionController question = new QuestionController(addedItem);
                        question.setId(addedItem.getId().toString());
                        questionList.getChildren().add(question);
                    }
                }
                if (c.wasRemoved()) {
                    for (QuestionModel removedItem : c.getRemoved()) {
                        questionList.getChildren().removeIf((n) -> n.getId().equals(removedItem.getId().toString()));
                    }
                }
            }
        });
    }

    @FXML
    private void goBack(){
        SceneController.activate("Homepage");
    }
}
