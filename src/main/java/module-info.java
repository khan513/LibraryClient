module com.example.library {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.library.model to javafx.base;
    opens com.example.library to javafx.fxml;
    exports com.example.library;
    exports com.example.library.ui;
    opens com.example.library.ui to javafx.fxml;
}