package com.example.library.net;

import com.example.library.model.*;

import java.io.IOException;
import java.util.List;

public interface Api {

    User login(String login, String Password) throws IOException, ClassNotFoundException;

    void register(User user) throws IOException;

    List<Book> getMyBooks() throws IOException, ClassNotFoundException;

    List<Book> getAllBooks() throws IOException, ClassNotFoundException;

    List<Author> getAllAuthors() throws IOException, ClassNotFoundException;

    List<Genre> getAllGenres() throws IOException, ClassNotFoundException;

    List<Publisher> getAllPublishers() throws IOException, ClassNotFoundException;
}