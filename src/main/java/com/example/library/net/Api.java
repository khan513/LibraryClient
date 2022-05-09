package com.example.library.net;

import com.example.library.model.Book;
import com.example.library.model.User;

import java.io.IOException;
import java.util.List;

public interface Api {

    User login(String login, String Password) throws IOException, ClassNotFoundException;

    void register(User user) throws IOException;

    List<Book> getMyBooks() throws IOException, ClassNotFoundException;
}