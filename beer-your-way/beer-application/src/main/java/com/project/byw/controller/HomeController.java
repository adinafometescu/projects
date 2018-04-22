package com.project.byw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getHomePage(Map<String,Object> model) {
        return "index";
    }

}
