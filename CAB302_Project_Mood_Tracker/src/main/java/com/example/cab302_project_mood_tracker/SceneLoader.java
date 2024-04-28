package com.example.cab302_project_mood_tracker;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class SceneLoader {
    //Creates a scene whenever the function is run
    //Template for a consistent scene style.

    //title : String - Name of the scene
    //stage : Stage - The top level of the container
    //root : Parent - The main scene view
    public static void LoadScene(Stage stage, Parent root, String title) throws IOException, IOException {
        //stage.hide();
        stage.setTitle(title);

        //Gets the screen dimensions and halves it then sets the scene to those.
        //This can create a more professional feel for the application. its worth getting feedback on this.
        int x = (int) (Screen.getPrimary().getBounds().getMaxX() / 2);
        int y = (int) (Screen.getPrimary().getBounds().getMaxY() / 2);

        Scene scene = new Scene(root, x, y);
        scene.getStylesheets().add(SceneLoader.class.getResource("styles.css").toExternalForm());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
