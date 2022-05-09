package com.example.library.util;

import javafx.scene.control.ButtonType;

public class Alert extends javafx.scene.control.Alert {

    public Alert(AlertType alertType) {
        super(alertType);
    }

    public Alert(AlertType alertType, String s, ButtonType... buttonTypes) {
        super(alertType, s, buttonTypes);
    }

    public static void showAlert(javafx.scene.control.Alert.AlertType type, String msg) {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(type);
        alert.setTitle(msg);
        alert.setWidth(300);
        alert.setHeight(300);
        alert.show();
    }
}
