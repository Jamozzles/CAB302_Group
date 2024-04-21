module com.example.cab302_project_mood_tracker {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cab302_project_mood_tracker to javafx.fxml;
    exports com.example.cab302_project_mood_tracker;
}