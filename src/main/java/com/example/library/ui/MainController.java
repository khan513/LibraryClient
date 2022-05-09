package com.example.library.ui;

import com.example.library.Client;
import com.example.library.model.Author;
import com.example.library.model.Book;
import com.example.library.model.Genre;
import com.example.library.model.Publisher;
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
    public TableView<Book> tableBooks;
    public TableColumn<Book, Long> idColumn1;
    public TableColumn<Book, String> titleColumn1;
    public TableColumn<Book, Integer> pagesColumn1;
    public TableColumn<Book, Double> ratingColumn1;
    public TableColumn<Book, String> isbnColumn1;
    public TableColumn<Book, Date> dateColumn1;
    @FXML
    public Pane pAuthors;
    @FXML
    public TableView<Author> tableAuthors;
    public TableColumn<Author, Long> idColumn2;
    public TableColumn<Author, String> nameColumn;
    public TableColumn<Author, String> surnameColumn;
    @FXML
    public Pane pGenres;
    @FXML
    public TableView<Genre> tableGenres;
    public TableColumn<Genre, Long> idColum3;
    public TableColumn<Genre, String> genreColumn;
    @FXML
    public Pane pPublishers;
    @FXML
    public TableView<Publisher> tablePublishers;
    public TableColumn<Publisher, Long> idColumn4;
    public TableColumn<Publisher, String> nameColumn1;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lName.setText(Client.user.getName());
        lSurname.setText(Client.user.getSurname());
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        pagesColumn.setCellValueFactory(new PropertyValueFactory<>("total_pages"));
        ratingColumn.setCellValueFactory(new PropertyValueFactory<>("rating"));
        isbnColumn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("published_date"));
        idColumn1.setCellValueFactory(new PropertyValueFactory<>("id"));
        titleColumn1.setCellValueFactory(new PropertyValueFactory<>("title"));
        pagesColumn1.setCellValueFactory(new PropertyValueFactory<>("total_pages"));
        ratingColumn1.setCellValueFactory(new PropertyValueFactory<>("rating"));
        isbnColumn1.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        dateColumn1.setCellValueFactory(new PropertyValueFactory<>("published_date"));
        idColumn2.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        idColum3.setCellValueFactory(new PropertyValueFactory<>("id"));
        genreColumn.setCellValueFactory(new PropertyValueFactory<>("genre"));
        idColumn4.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn1.setCellValueFactory(new PropertyValueFactory<>("name"));
        btnMyBooksClicked(new ActionEvent());
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
            showAlert(Alert.AlertType.INFORMATION, "Could not load your books, please try again later");
            e.printStackTrace();
        }
    }

    public void btnBooksClicked(ActionEvent event) {
        pMyBooks.setVisible(false);
        pBooks.setVisible(true);
        pAuthors.setVisible(false);
        pGenres.setVisible(false);
        pPublishers.setVisible(false);
        try {
            tableBooks.getItems().addAll(Client.api.getAllBooks());
        } catch (IOException | ClassNotFoundException e) {
            showAlert(Alert.AlertType.INFORMATION, "Could not load the books, please try again later");
            e.printStackTrace();
        }
    }


    public void btnAuthorsClicked(ActionEvent event) {
        pMyBooks.setVisible(false);
        pBooks.setVisible(false);
        pAuthors.setVisible(true);
        pGenres.setVisible(false);
        pPublishers.setVisible(false);
        try {
            tableAuthors.getItems().addAll(Client.api.getAllAuthors());
        } catch (IOException | ClassNotFoundException e) {
            showAlert(Alert.AlertType.INFORMATION, "Could not load the authors, please try again later");
            e.printStackTrace();
        }
    }

    public void btnGenresClicked(ActionEvent event) {
        pMyBooks.setVisible(false);
        pBooks.setVisible(false);
        pAuthors.setVisible(false);
        pGenres.setVisible(true);
        pPublishers.setVisible(false);
        try {
            tableGenres.getItems().addAll(Client.api.getAllGenres());
        } catch (IOException | ClassNotFoundException e) {
            showAlert(Alert.AlertType.INFORMATION, "Could not load the genres, please try again later");
            e.printStackTrace();
        }
    }

    public void btnPublishersClicked(ActionEvent event) {
        pMyBooks.setVisible(false);
        pBooks.setVisible(false);
        pAuthors.setVisible(false);
        pGenres.setVisible(false);
        pPublishers.setVisible(true);
        try {
            tablePublishers.getItems().addAll(Client.api.getAllPublishers());
        } catch (IOException | ClassNotFoundException e) {
            showAlert(Alert.AlertType.INFORMATION, "Could not load the publishers, please try again later");
            e.printStackTrace();
        }
    }
}