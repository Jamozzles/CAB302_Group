package com.example.cab302_project_mood_tracker.Controllers;

import com.example.cab302_project_mood_tracker.HelloApplication;
import com.example.cab302_project_mood_tracker.Model.Account;
import com.example.cab302_project_mood_tracker.Model.SqliteAccountDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class HelloController {
    private Stage stage;
    private Parent root;

    //Sets up the home screen. this is called when the login button is pressed
    //Check login-view.fxml for more details
    public void SwitchToHome(ActionEvent event) throws IOException {
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("home-view.fxml")));
        GlobalController.loadScene(stage,root, "Home");
    }

    //Sets up the login screen. this is called when the logout button is pressed
    //Check home-view.fxml for more details
    public void SwitchToLogin(ActionEvent event) throws IOException {
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("login-view.fxml")));
        GlobalController.loadScene(stage,root, "Login");
    }
    public void  SwitchToSignup(ActionEvent event) throws IOException{
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("signup-view.fxml")));
        GlobalController.loadScene(stage,root, "Sign up");
    }

    //Sets up the login screen. this is called when the logout button is pressed
    //Check home-view.fxml for more details
    public void SwitchToHistory(ActionEvent event) throws IOException {
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("history-view.fxml"));
        SceneLoader.LoadScene(stage,root, "History");
    }

    //utility functions
    public void  ExitApplication(){
        System.exit(0);
    }

    public void  MinimiseApplication(ActionEvent event) throws IOException{
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    public void animateDivider(ActionEvent event) throws IOException {
        Parent currentRoot = ((Node) event.getSource()).getScene().getRoot();
        GlobalController.animateDivider(currentRoot);
    }
}