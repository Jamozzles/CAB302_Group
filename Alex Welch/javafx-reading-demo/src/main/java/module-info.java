module com.example.javafxreadingdemo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafxreadingdemo to javafx.fxml;
    exports com.example.javafxreadingdemo;
}