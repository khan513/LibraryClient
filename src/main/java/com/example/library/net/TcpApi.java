package com.example.library.net;

import com.example.library.Client;
import com.example.library.model.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import static com.example.library.net.RequestType.GET;

public class TcpApi implements Api {

    private ObjectOutputStream out;

    private ObjectInputStream in;

    public TcpApi() throws IOException {
        out = new ObjectOutputStream(Client.socket.getOutputStream());
        in = new ObjectInputStream(Client.socket.getInputStream());
    }

    @Override
    public User login(String login, String password) throws IOException, ClassNotFoundException {
        out.writeObject(new Request(GET, "LOGIN", null, List.of(login, password)));
        return (User) in.readObject();
    }

    @Override
    public void register(User user) throws IOException {
        out.writeObject(new Request(RequestType.POST, "REGISTER", user, null));
    }

    @Override
    public List<Book> getMyBooks() throws IOException, ClassNotFoundException {
        out.writeObject(new Request(GET, "USER'S BOOKS", null, List.of(String.valueOf(Client.user.getId()))));
        return (List<Book>) in.readObject();
    }

    @Override
    public List<Book> getAllBooks() throws IOException, ClassNotFoundException {
        out.writeObject(new Request(GET, "ALL THE BOOKS", null, null));
        return (List<Book>) in.readObject();
    }

    @Override
    public List<Author> getAllAuthors() throws IOException, ClassNotFoundException {
        out.writeObject(new Request(GET, "ALL THE AUTHORS", null, null));
        return (List<Author>) in.readObject();
    }

    @Override
    public List<Genre> getAllGenres() throws IOException, ClassNotFoundException {
        out.writeObject(new Request(GET, "ALL THE GENRES", null, null));
        return (List<Genre>) in.readObject();
    }

    @Override
    public List<Publisher> getAllPublishers() throws IOException, ClassNotFoundException {
        out.writeObject(new Request(GET, "ALL THE PUBLISHERS", null, null));
        return (List<Publisher>) in.readObject();
    }
}