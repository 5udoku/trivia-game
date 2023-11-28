package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import model.QuestionModel;
import service.QuestionStore;

import java.io.IOException;
import java.util.UUID;

public class QuestionController extends HBox {
    @FXML
    private Text labelDisplay;
    @FXML
    private Text optionsDisplay;
    private UUID uuid;

    public QuestionController(QuestionModel question) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/QuestionComponent.fxml"));
        loader.setRoot(this);
        loader.setController(this);

        try{
            loader.load();
        } catch (IOException e){
            throw new RuntimeException(e);
        }

        this.uuid = question.getId();
        labelDisplay.textProperty().set(question.getLabel());
        optionsDisplay.textProperty().set(question.getOptions().toString());
    }

    @FXML
    protected void deleteQuestion(){
        QuestionStore.getInstance().removeQuestion(uuid);
    }
}
