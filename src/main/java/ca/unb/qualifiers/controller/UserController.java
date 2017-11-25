package ca.unb.qualifiers.controller;

import ca.unb.qualifiers.model.User;
import ca.unb.qualifiers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@EnableAutoConfiguration
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    @ResponseBody
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping(value = {"/", "/signup"})
    public String index(Model model, @RequestParam(value = "error", required = false) String error) {
        model.addAttribute("sign-in-form", new User());
        model.addAttribute("sign-up-form", new User());

        if (error != null) {
            model.addAttribute("loginError", "Invalid username or password.");
        }

        return "index";
    }

    /*@PostMapping(value = "/signup")
    public String registration(@ModelAttribute("sign-up-form") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("accountCreationError", bindingResult.getFieldError().getCode());
            model.addAttribute("accountType", userForm.getHasExtendedPrivileges() ? "Instructor" : "Student");
            return "index";
        }

        userService.save(userForm);
        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/" + userForm.getUsername();
    }

    @GetMapping(value = "/login/success")
    public String loginSucess(Principal principal) {
        return "redirect:/" + principal.getName();
    }

    @GetMapping(path = "/{username}")
    public String dashboard(ModelMap map, Principal principal, @PathVariable String username) {
        if (!principal.getName().equals(username)) {
            return "404";
        }
        User user = userRepository.findByUsername(username);
        map.addAttribute("user", user);
        map.addAttribute("courseList", user.getCourses());
        return "dashboard";
    }*/
}
