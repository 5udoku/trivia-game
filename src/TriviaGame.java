import controller.SceneController;
import javafx.application.Application;
import javafx.stage.Stage;

public class TriviaGame extends Application {
    @Override
    public void start(Stage primaryStage) {
        SceneController.setPrimaryStage(primaryStage);

        // Add scenes from FXML files
        SceneController.addScene("Homepage", "../view/MainView.fxml");
        SceneController.addScene("NewQuestion", "../view/NewQuestionView.fxml");
        SceneController.addScene("ListQuestion", "../view/ListQuestionView.fxml");

        primaryStage.setTitle("Trivia Game");
        SceneController.activate("Homepage");
    }

    public static void main(String[] args) {
        launch(args);
    }
}