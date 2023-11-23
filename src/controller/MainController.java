package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import model.QuestionModel;
import viewmodel.MainViewModel;

public class MainController {
    @FXML
    private ListView<QuestionModel> questionModelListView;

    @FXML
    private void initialize(){
        MainViewModel mainViewModel = new MainViewModel();
        questionModelListView.setItems(mainViewModel.getQuestions());
    }
}
