module com.example.cab302_project_mood_tracker {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml.crypto;
    requires java.sql;


    opens com.example.cab302_project_mood_tracker to javafx.fxml;
    exports com.example.cab302_project_mood_tracker;
    opens com.example.cab302_project_mood_tracker.Controllers to javafx.fxml;
    exports com.example.cab302_project_mood_tracker.Controllers;
    exports com.example.cab302_project_mood_tracker.Model;
    opens com.example.cab302_project_mood_tracker.Model to javafx.fxml;
}