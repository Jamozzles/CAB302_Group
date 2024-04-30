package com.example.cab302_project_mood_tracker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {
    //Initialises the main scene

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login-view.fxml")));
        stage.initStyle(StageStyle.UNDECORATED);

        SceneLoader.LoadScene(stage, root, "Login");
    }
    public static void main(String[] args) {
        launch();
    }

}