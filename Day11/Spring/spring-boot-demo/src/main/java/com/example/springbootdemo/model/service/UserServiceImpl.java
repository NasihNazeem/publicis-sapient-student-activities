package com.example.springbootdemo.model.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springbootdemo.model.beans.User;


@Service
public class UserServiceImpl {
    private static Map<Integer,User> userList = new HashMap<>();

    public User storeUser(User user) {
        int counter = userList.size();
        user.setUserId(++counter);
        userList.put(counter,user);

        return user;
    }

    public Map<Integer, User> getAllUsers(){
        return userList;
    }

    public User getUser(int id){

        if((id != 0) || id < userList.size())
            return userList.get(id);
        else
            return null;
    }

    public User deleteUser(int id){
        if( id != 0 || id < userList.size()){
            userList.remove(id);
            return null;
        } else{
            return userList.get(id);
        }
            
    }
}
