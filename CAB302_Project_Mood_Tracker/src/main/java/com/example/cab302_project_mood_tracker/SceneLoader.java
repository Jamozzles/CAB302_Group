package com.example.cab302_project_mood_tracker;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

public final class SceneLoader {
    private static double xPos;
    private static double yPos;

    private SceneLoader() {
        // Private constructor to prevent instantiation
    }

    public static void LoadScene(Stage stage, Parent root, String title) {
        String newTitle = "Mood Tracker | " + title;
        stage.setTitle(newTitle);
        if (root.lookup("#applicationTitle") != null) {
            ((Label) root.lookup("#applicationTitle")).setText(newTitle);
        }

        int x = (int) (Screen.getPrimary().getBounds().getMaxX() / 2);
        int y = (int) (Screen.getPrimary().getBounds().getMaxY() / 2);

        Scene scene = new Scene(root, 800, 500);
        scene.getStylesheets().add(SceneLoader.class.getResource("styles.css").toExternalForm());
        stage.setScene(scene);
        stage.setResizable(false);

        CheckDrag(root, stage);
        addDividerListener(root);
        stage.show();
    }
    private static boolean dragging = false;
    private static void CheckDrag(Parent root, Stage stage) {
        root.setOnMousePressed(mouseEvent -> {
            xPos = mouseEvent.getSceneX();
            yPos = mouseEvent.getSceneY();
            dragging = mouseEvent.getSceneY() <= 30;
        });
        root.setOnMouseDragged(mouseEvent -> {
            if (dragging) {
                stage.setX(mouseEvent.getScreenX() - xPos);
                stage.setY(mouseEvent.getScreenY() - yPos);
            }
        });
        root.setOnMouseReleased(mouseEvent -> dragging = false);
    }

    private static boolean splitPaneOpen = true;
    private static boolean splitPaneMoving = true;

    private static double openDividerPos = 0.195;
    private static double closedDividerPos = 0.0825;
    public static void animateDivider(Parent root) {
        if (root.lookup("#MainSplitPane") != null) {
            SplitPane splitPane = ((SplitPane) root.lookup("#MainSplitPane"));
            double target = splitPaneOpen ? closedDividerPos : openDividerPos;
            splitPaneMoving = true;
            Timeline timeline = new Timeline();
            KeyValue keyValue = new KeyValue(splitPane.getDividers().get(0).positionProperty(), target);
            KeyFrame keyFrame = new KeyFrame(Duration.millis(100), keyValue); // Adjust duration as needed
            timeline.getKeyFrames().add(keyFrame);
            timeline.play();

            timeline.setOnFinished(event -> {
                splitPaneOpen = !splitPaneOpen;
                splitPaneMoving = false;
            });
        }
    }
    public static void addDividerListener(Parent root) {
        if (root.lookup("#MainSplitPane") != null) {
            SplitPane splitPane = ((SplitPane) root.lookup("#MainSplitPane"));
            splitPane.getDividers().get(0).positionProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    // Handle divider position change here
                    if (!splitPaneMoving) {
                        if (splitPaneOpen) {
                            splitPane.setDividerPosition(0, openDividerPos);
                        } else {
                            splitPane.setDividerPosition(0, closedDividerPos);
                        }
                    }
                }
            });
        }
    }
}
