package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import web.model.User;
import web.service.UserServiceImpl;

@Controller
public class UserController {

    private UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("allUsers", userService.getListOfUsers());
        return "users";
    }

//    @GetMapping("/new")
//    public String newUser(Model model) {
//        model.addAttribute("newUser", new User());
//        return "new";
//    }
//
//    @PostMapping
//    public String create(@ModelAttribute("user") User user) {
//        userService.addUser(user);
//        return "redirect:/users";
//    }
}