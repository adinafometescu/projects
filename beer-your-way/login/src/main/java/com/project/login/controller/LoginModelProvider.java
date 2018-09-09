package com.project.login.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.security.Principal;
import java.util.Map;

@ControllerAdvice
public class LoginModelProvider {

    @ModelAttribute
    public void setLogin(Principal principal, Map<String, Object> model) {
        if (principal != null) {
            model.put("loginEmail", principal.getName());
        }
    }
}
