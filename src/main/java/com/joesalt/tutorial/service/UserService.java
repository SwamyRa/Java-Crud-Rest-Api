package com.joesalt.tutorial.service;

import com.joesalt.tutorial.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private List<User> store = new ArrayList<User>();

    public UserService() {
        store.add(new User(UUID.randomUUID().toString(), "Swamy Rapolu", "swamyrapolu@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(), "Virat Kohli", "viratkohli@gmail.com"));
    }

    public List<User> getUsers() {
        return this.store;
    }
}
