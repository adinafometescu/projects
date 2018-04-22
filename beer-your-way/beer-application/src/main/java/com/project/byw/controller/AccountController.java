package com.project.byw.controller;

import com.project.byw.form.UserForm;
import com.project.login.exception.DuplicateAccountException;
import com.project.login.user.User;
import com.project.login.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class AccountController {
    @Autowired
    UserService userService;

    @PostMapping(value = "/register")
    public String register(@Valid @ModelAttribute UserForm userForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "register";
        }
        User user = new User();
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setFirstName(userForm.getFirstName());
        user.setLastName(userForm.getLastName());

        try {
            userService.registerUser(user);
        } catch (DuplicateAccountException e) {
            bindingResult.rejectValue("email", "error.invalid.register");
            return "register";
        }
        return "redirect:/login";

    }

    @GetMapping("/register")
    public String getRegisterPage(Map<String, Object> model) {
        model.put("userForm", new UserForm());
        return "register";
    }

    @GetMapping("/account")
    public String getAccountPage(Map<String, Object> model) {
        return "account";
    }

}
