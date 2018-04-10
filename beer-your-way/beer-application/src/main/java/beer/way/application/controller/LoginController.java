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

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String login(@RequestParam(required = false) boolean error) {
        return "login";
    }

    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<?> register(@ModelAttribute UserForm userForm) {

        User user = new User();
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());

        try {
            userService.registerUser(user);
        } catch (DuplicateAccountException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);

    }
}
