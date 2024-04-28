package com.example.cab302_project_mood_tracker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private Parent root;

    //Initialises the main scene
    @Override
    public void start(Stage stage) throws IOException {
        root = FXMLLoader.load(getClass().getResource("login-view.fxml"));
        SceneLoader.LoadScene(stage,root, "Mood Tracker | Login");
    }
    public static void main(String[] args) {
        launch();
    }

}