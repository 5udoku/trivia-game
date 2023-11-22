package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import model.QuestionModel;
import viewmodel.MainViewModel;

public class MainController {
    @FXML
    private ListView<QuestionModel> questionModelListView;

    private MainViewModel mainViewModel;

    @FXML
    private void initialize(){
        mainViewModel = new MainViewModel();
        questionModelListView.setItems(mainViewModel.getQuestions());
    }
}
