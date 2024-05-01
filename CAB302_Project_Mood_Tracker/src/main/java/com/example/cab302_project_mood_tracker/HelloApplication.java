package com.example.cab302_project_mood_tracker;

import com.example.cab302_project_mood_tracker.Controllers.GlobalController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {
    public static final String TITLE = "Mood Tracker | ";
    public static final int WIDTH = 800;
    public static final int HEIGHT = 500;

    //Initialises the main scene
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login-view.fxml")));
        stage.initStyle(StageStyle.UNDECORATED);

        GlobalController.loadScene(stage, root, "Login");
    }
    public static void main(String[] args) {
        launch();
    }
}