package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import viewmodel.NewQuestionViewModel;

public class NewQuestionController {
    @FXML
    private TextField labelField;
    @FXML
    private TextField answerField;
    @FXML
    private TextField optionsField;

    private final NewQuestionViewModel viewModel = new NewQuestionViewModel();

    @FXML
    private void initialize(){
        this.labelField.textProperty().bindBidirectional(viewModel.getLabel());
        this.answerField.textProperty().bindBidirectional(viewModel.getAnswer());
        this.optionsField.textProperty().bindBidirectional(viewModel.getOptions());
    }

    @FXML
    private void handleCreateQuestion(){
        this.viewModel.createQuestion();
        SceneController.activate("Homepage");
    }
}
