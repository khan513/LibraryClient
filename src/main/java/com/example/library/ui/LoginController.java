package com.example.library.ui;

import com.example.library.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.library.util.Alert.showAlert;

public class LoginController {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passwordField;

    public void login(ActionEvent event) {
        if (Client.api == null) {
            showAlert(AlertType.INFORMATION, "No connection, please try again later");
            return;
        }
        try {
            String login = loginField.getText().strip();
            String password = passwordField.getText().strip();
            if (login.isEmpty() || password.isEmpty()) {
                showAlert(AlertType.WARNING, "Invalid login or password!");
                return;
            }
            if ((Client.user = Client.api.login(login, password)) == null) {
                showAlert(AlertType.WARNING, "Incorrect login or password!");
                return;
            }
            switchToMainScene(event);
        } catch (IOException | ClassNotFoundException e) {
            showAlert(AlertType.INFORMATION, "No connection, please try again later");
            e.printStackTrace();
        }
    }

    public void switchToRegisterScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getClassLoader().getResource("register-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getClassLoader().getResource("register.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void switchToMainScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getClassLoader().getResource("main-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getClassLoader().getResource("main.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}