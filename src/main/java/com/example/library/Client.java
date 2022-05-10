package com.example.library;

import com.example.library.model.User;
import com.example.library.net.Api;
import com.example.library.net.TcpApi;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.Socket;

public class Client extends Application {
    public static User user;
    public static Socket socket;
    public static Api api;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        try {
            socket = new Socket("127.0.0.1", 1234);
            api = new TcpApi();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Could not connect to the server, please try again later");
            alert.setTitle("No connection with server");
            alert.setWidth(300);
            alert.setHeight(300);
            alert.show();
            e.printStackTrace();
        }
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("login-view.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getClassLoader().getResource("login.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Library");
        Image icon = new Image(getClass().getClassLoader().getResource("icon.png").toExternalForm());
        stage.getIcons().add(icon);
        stage.show();
    }
}