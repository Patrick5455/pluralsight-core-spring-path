package com.pluralsight.conference.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class GreetingControl {

    @GetMapping("index")
    public String greet(Map<String, String> map){
        map.put("index", "greeting");
        return "index";
    }
}
