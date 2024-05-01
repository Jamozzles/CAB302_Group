package com.example.cab302_project_mood_tracker.Controllers;

import com.example.cab302_project_mood_tracker.HelloApplication;
import com.example.cab302_project_mood_tracker.Model.Account;
import com.example.cab302_project_mood_tracker.Model.IAccountDAO;
import com.example.cab302_project_mood_tracker.Model.SqliteAccountDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class LoginController {
    private Stage stage;
    private Parent root;

    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField lastNameTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField phoneTextField;

    public void SwitchToLogin(ActionEvent event) throws IOException {
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("login-view.fxml")));
        GlobalController.loadScene(stage,root, "Login");
    }

    @FXML
    public void createAccount() {
        SqliteAccountDAO accountDAO = new SqliteAccountDAO();
        Account account = new Account(
                firstNameTextField.getText(),
                lastNameTextField.getText(),
                emailTextField.getText(),
                phoneTextField.getText()
        );
        accountDAO.addAccount(account);
        System.out.println(account);
    }

}