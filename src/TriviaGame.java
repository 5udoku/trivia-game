import factory.QuestionFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.QuestionModel;
import service.QuestionStore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TriviaGame extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/NewQuestionView.fxml"));
        Parent root = loader.load();

        primaryStage.setTitle("Trivia Game");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        QuestionStore questionStore = QuestionStore.getInstance();
        QuestionFactory questionFactory = new QuestionFactory();

        questionStore.addQuestion(questionFactory.createQuestion("Ciupapi?", "Munenio", new ArrayList<String>(List.of(new String[]{"hello", "world", "pahar!"}))));
        questionStore.addQuestion(questionFactory.createQuestion("What's 9 + 10?", "21", new ArrayList<String>(List.of(new String[]{"hello", "world", "pahar?"}))));



        launch(args);
    }
}