package beer.way.application.controller;

import beer.way.application.form.UserForm;
import login.exception.DuplicateAccountException;
import login.user.User;
import login.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
