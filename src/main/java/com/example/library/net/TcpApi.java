package com.example.library.net;

import com.example.library.Client;
import com.example.library.model.Book;
import com.example.library.model.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class TcpApi implements Api {

    private ObjectOutputStream out;

    private ObjectInputStream in;

    public TcpApi() throws IOException {
        out = new ObjectOutputStream(Client.socket.getOutputStream());
        in = new ObjectInputStream(Client.socket.getInputStream());
    }

    @Override
    public User login(String login, String password) throws IOException, ClassNotFoundException {
        out.writeObject(new Request(RequestType.GET, "LOGIN", null, List.of(login, password)));
        return (User) in.readObject();
    }

    @Override
    public void register(User user) throws IOException {
        out.writeObject(new Request(RequestType.POST, "REGISTER", user, null));
    }

    @Override
    public List<Book> getMyBooks() throws IOException, ClassNotFoundException {
        out.writeObject(new Request(RequestType.GET, "USER'S BOOKS", null, List.of(String.valueOf(Client.user.getId()))));
        return (List<Book>) in.readObject();
    }
}