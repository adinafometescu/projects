package com.project.byw.controller;

import login.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String login(@RequestParam(required = false) boolean error,
                        Map<String, Object> model) {
        model.put("error", error);
        return "login";
    }
}
