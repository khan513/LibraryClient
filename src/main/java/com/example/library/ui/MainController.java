package com.example.library.ui;

import com.example.library.Client;
import com.example.library.model.Book;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import static com.example.library.util.Alert.showAlert;

public class MainController implements Initializable {

    @FXML
    public Label lName;
    @FXML
    public Label lSurname;
    @FXML
    public Button btnMyBooks;
    @FXML
    public Button btnBooks;
    @FXML
    public Button btnAuthors;
    @FXML
    public Button btnGenres;
    @FXML
    public Button btnPublishers;
    @FXML
    public Pane pMyBooks;
    @FXML
    public TableView<Book> tableMyBooks;
    public TableColumn<Book, Long> idColumn;
    public TableColumn<Book, String> titleColumn;
    public TableColumn<Book, Integer> pagesColumn;
    public TableColumn<Book, Double> ratingColumn;
    public TableColumn<Book, String> isbnColumn;
    public TableColumn<Book, Date> dateColumn;
    @FXML
    public Pane pBooks;
    @FXML
    public Pane pAuthors;
    @FXML
    public Pane pGenres;
    @FXML
    public Pane pPublishers;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lName.setText(Client.user.getName());
        lSurname.setText(Client.user.getSurname());
        btnMyBooksClicked(new ActionEvent());
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        pagesColumn.setCellValueFactory(new PropertyValueFactory<>("total_pages"));
        ratingColumn.setCellValueFactory(new PropertyValueFactory<>("rating"));
        isbnColumn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("published_date"));
    }

    public void btnMyBooksClicked(ActionEvent event) {
        pMyBooks.setVisible(true);
        pBooks.setVisible(false);
        pAuthors.setVisible(false);
        pGenres.setVisible(false);
        pPublishers.setVisible(false);
        try {
            tableMyBooks.getItems().addAll(Client.api.getMyBooks());
        } catch (IOException | ClassNotFoundException e) {
            showAlert(Alert.AlertType.INFORMATION, "Could not load the books, please try again later");
            e.printStackTrace();
        }

    }

    public void btnBooksClicked(ActionEvent event) {
        pMyBooks.setVisible(false);
        pBooks.setVisible(true);
        pAuthors.setVisible(false);
        pGenres.setVisible(false);
        pPublishers.setVisible(false);
    }


    public void btnAuthorsClicked(ActionEvent event) {
        pMyBooks.setVisible(false);
        pBooks.setVisible(false);
        pAuthors.setVisible(true);
        pGenres.setVisible(false);
        pPublishers.setVisible(false);
    }

    public void btnGenresClicked(ActionEvent event) {
        pMyBooks.setVisible(false);
        pBooks.setVisible(false);
        pAuthors.setVisible(false);
        pGenres.setVisible(true);
        pPublishers.setVisible(false);
    }

    public void btnPublishersClicked(ActionEvent event) {
        pMyBooks.setVisible(false);
        pBooks.setVisible(false);
        pAuthors.setVisible(false);
        pGenres.setVisible(false);
        pPublishers.setVisible(true);
    }
}