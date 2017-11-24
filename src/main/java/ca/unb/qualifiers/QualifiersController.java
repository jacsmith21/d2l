package ca.unb.qualifiers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@EnableAutoConfiguration
public class QualifiersController {
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
