package com.example.springbootdemo.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootdemo.model.beans.User;
import com.example.springbootdemo.model.service.UserServiceImpl;


@RestController
@RequestMapping("/user")
public class MyRestApi {
    
    @Autowired
    private UserServiceImpl service;

    @PostMapping
    public User store(@RequestBody User user){
        User createdUser = service.storeUser(user);
        return createdUser;
    }

    @GetMapping
    public Map<Integer,User> fetchUsers(){
        return service.getAllUsers();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Object> getUser(@PathVariable("userId") int id){
        User user = new User();
        Map<String, String> map = new HashMap<>();
        user = service.getUser(id);

        if(user == null){
            map.put("error", "sorry user with an id " + id + " not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map.get("error"));
        }

        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PostMapping("/{userId}/{dob}")
    public ResponseEntity<Object> updateUserDoB(@PathVariable("userId") int id, @PathVariable("dob") String dateofbirth){
        User user = new User();
        Map<String, String> map = new HashMap<>();

        user = service.getUser(id);
        

        if(user != null){
            user.setDob(LocalDate.parse(dateofbirth));
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }else{
            map.put("error", "sorry user with an id " + id + " not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map.get("error"));
        }

        
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Object> deleteUser(@PathVariable("userId") int id){
        User user = new User();
        Map<String, String> map = new HashMap<>();

        user = service.deleteUser(id);
        
        if(user == null){
            map.put("message", id + " is deleted");
            return ResponseEntity.status(HttpStatus.OK).body(map.get("message"));
        } else {
            map.put("error", "sorry user with an id " + id + " not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map.get("error"));
        }

    }
}
