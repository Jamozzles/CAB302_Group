package com.example.cab302_project_mood_tracker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.Console;
import java.io.IOException;

public class HelloController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void SwitchToHome(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("home-view.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Mood Tracker | Home");

        scene = new Scene(root, 1280, 725);
        stage.setScene(scene);
        stage.show();
    }
    public void SwitchToLogin(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("login-view.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Mood Tracker | Login");

        scene = new Scene(root, 1280, 725);
        stage.setScene(scene);
        stage.show();
    }
}