package ca.unb.qualifiers.controller;

import ca.unb.qualifiers.model.Course;
import ca.unb.qualifiers.model.User;
import ca.unb.qualifiers.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@EnableAutoConfiguration
public class UserController {
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    @ResponseBody
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping(value = "/")
    public String index(Model model, @RequestParam(value = "error", required = false) String error) {
        model.addAttribute("sign-in-form", new User());
        model.addAttribute("sign-up-form", new User());

        if (error != null) {
            model.addAttribute("loginError", "Invalid username or password.");
        }

        return "index";
    }

    @GetMapping(value = "/login/success")
    public String loginSuccess(Principal principal) {
        return "redirect:/" + principal.getName();
    }

    @GetMapping(path = "/{username}")
    public String dashboard(ModelMap map, Principal principal, @PathVariable String username) {
        LOG.info("dashboard - starting");

        if (!principal.getName().equals(username)) {
            return "404";
        }

        User user = userRepository.findByUsername(username);
        List<Course> courses = user.getEnrolledCourses();
        map.addAttribute("user", user);
        map.addAttribute("courses", courses);

        return "dashboard";
    }
}
