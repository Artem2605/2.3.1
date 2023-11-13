package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("allUsers", userService.getListOfUsers());
        return "users";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping("/addUser")
    public String create(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

//    <form th:method="GET" th:action="'/update/id='+@{${user.getId()}}" th:object="${user}">
//                <input type="submit" value="Изменить"/>
//            </form>
    @GetMapping("/update")
    public String updateUser(@RequestParam(value = "id", defaultValue = "5") Long id,
            Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "update";
    }

    @PostMapping("/updateUser")
    public String update(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/users";
   }
}