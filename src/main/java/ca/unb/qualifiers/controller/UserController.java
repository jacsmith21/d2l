package ca.unb.qualifiers.controller;

import ca.unb.qualifiers.model.User;
import ca.unb.qualifiers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    @ResponseBody
    public String index() {
        return "Hey!";
    }

    @GetMapping("/users")
    @ResponseBody
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }
}
