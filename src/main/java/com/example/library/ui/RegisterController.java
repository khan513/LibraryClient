package com.example.library.ui;

import com.example.library.Client;
import com.example.library.model.Sex;
import com.example.library.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.library.util.Alert.showAlert;

public class RegisterController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField nameField;
    @FXML
    private TextField surnameField;
    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passwordField;

    @FXML
    private RadioButton rbtnMale;

    public void switchToLoginScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getClassLoader().getResource("login-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public String getSex() {
        if (rbtnMale.isSelected())
            return "Male";
        return "Female";
    }

    public void register(ActionEvent event) {
        if (Client.api == null) {
            showAlert(Alert.AlertType.INFORMATION, "No connection, please try again later");
            return;
        }
        try {
            String name = nameField.getText().strip();
            String surname = surnameField.getText().strip();
            String login = loginField.getText().strip();
            String password = passwordField.getText().strip();
            if (name.isEmpty() || surname.isEmpty() || login.isEmpty() || password.isEmpty()) {
                showAlert(Alert.AlertType.WARNING, "Please enter your credential properly!");
                return;
            }
            Client.user = new User(name, surname, login, password, Sex.valueOf(getSex()));
            Client.api.register(Client.user);
            switchToMainScene(event);
        } catch (IOException e) {
            showAlert(Alert.AlertType.INFORMATION, "No connection, please try again later");
            e.printStackTrace();
        }
    }

    public void switchToMainScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getClassLoader().getResource("main-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getClassLoader().getResource("login.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}