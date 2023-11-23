package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SceneController {
    private static Stage primaryStage;
    private static final Map<String, Scene> sceneMap = new HashMap<>();

    public static void setPrimaryStage(Stage primaryStage){
        SceneController.primaryStage = primaryStage;
    }

    public static void addScene(String name, String fxmlPath){
        try {
            FXMLLoader loader = new FXMLLoader(SceneController.class.getResource(fxmlPath));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            sceneMap.put(name, scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void activate(String name){
        Scene scene = sceneMap.get(name);
        if (scene != null){
            primaryStage.setScene(scene);
            primaryStage.show();
        } else {
            throw new RuntimeException("Scene \"" + name + "\" not found in SceneMap.");
        }
    }
}
