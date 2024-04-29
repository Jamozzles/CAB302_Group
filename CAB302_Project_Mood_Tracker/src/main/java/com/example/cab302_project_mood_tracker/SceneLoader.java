package com.example.cab302_project_mood_tracker;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
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
    static double xPos;
    static double yPos;

    public static void LoadScene(Stage stage, Parent root, String title) {
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

        // Set the title on the label
        Label titleLabel = (Label) root.lookup("#applicationTitle");
        if (titleLabel != null) {
            titleLabel.setText(title);
        }

        CheckDrag(root, stage);

        stage.show();
    }

    //Since the style of the window has been changed ive implemented a dragging feature.
    static boolean dragging = false;
    static void CheckDrag(Parent root, Stage stage){
        root.setOnMousePressed(mouseEvent -> {
            xPos = mouseEvent.getSceneX();
            yPos = mouseEvent.getSceneY();

            // Check if the mouse press is within the top 30 pixels
            dragging = mouseEvent.getSceneY() <= 30;
            test();
        });
        root.setOnMouseDragged(mouseEvent -> {
            if (dragging) {
                stage.setX(mouseEvent.getScreenX() - xPos);
                stage.setY(mouseEvent.getScreenY() - yPos);
            }
        });
        root.setOnMouseReleased(mouseEvent -> {
            dragging = false;
        });
    }
    static void test(){
        System.out.println("Dragging");
    }

}
