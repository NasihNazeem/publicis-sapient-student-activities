package com.example.springbootdemo.model.service;


import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Service;

import com.example.springbootdemo.model.beans.User;


@Service
public class UserServiceImpl {
    private static List<User> userList = new ArrayList<>();

    public User storeUser(User user) {
        int counter = userList.size();
        user.setUserId(++counter);
        userList.add(user);

        return user;
    }

    public List<User> getAllUsers(){
        return userList;
    }
}
