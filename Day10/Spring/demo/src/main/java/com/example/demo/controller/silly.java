package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/first")
public class silly {
    

    @GetMapping
    public String greetings(){
        return "Welcome to REST";

    }

    @DeleteMapping("/hello")
    public Map<String,String> getComplex(){
        Map<String,String> map = new HashMap<String,String>();
        map.put("message","Hello<<getComplex");
        return map;

    }
}
