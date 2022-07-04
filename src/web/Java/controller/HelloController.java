package Java.controller;

import Java.model.User;
import Java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
    private final UserService userService;

    @Autowired
    public HelloController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping({"/index", "/"})
    public String printWelcome(Model model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring MVC application with Hibernate.");
        messages.add("Add /users in the browser address bar or click button below to see users list.");
        model.addAttribute("messages", messages);
        return "index";
    }

    @GetMapping("/users")
    public String usersList(Model model) {
        List<User> users = userService.showAllUsers();
        model.addAttribute("userList", users);
        return "users";
    }

    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user";
    }

    @GetMapping("/newUser")
    public String newUser(Model model){
        model.addAttribute("newUser", new User());
        return "newUser";
    }

    @PostMapping("/newUser")
    public String create(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "successPage";
    }

    @GetMapping("/user/{id}/edit")
    public String editUser(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit";
    }

    @PostMapping("/user/edit/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") Long id ) {
        userService.editUser(id, user);
        return "successPage";
    }

    @GetMapping("/user/{id}/delete")
    public String remove(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "successPage";
    }
}