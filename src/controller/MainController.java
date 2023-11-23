package controller;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;

public class MainController {
    @FXML
    private void switchScene(Event e){
        Hyperlink eventSource = (Hyperlink) e.getSource();
        System.out.println(eventSource.getId());

        switch (eventSource.getId()){
            case "newGameLink":
                SceneController.activate("Homepage");
                break;
            case "listQuestionLink":
                SceneController.activate("ListQuestion");
                break;
            case "addQuestionLink":
                SceneController.activate("NewQuestion");
                break;
            default:
                break;
        }
    }
}
