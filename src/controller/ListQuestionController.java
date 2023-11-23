package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import model.QuestionModel;
import viewmodel.ListQuestionViewModel;

public class ListQuestionController {
    @FXML
    private ListView<QuestionModel> questionModelListView;

    @FXML
    private void initialize(){
        ListQuestionViewModel viewModel = new ListQuestionViewModel();
        questionModelListView.setItems(viewModel.getQuestions());
    }
}
