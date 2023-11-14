package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;
import javax.validation.Valid;

@Controller
public class UserController {

    private final UserService USER_SERVICE;

    @Autowired
    public UserController(UserService userService) {
        this.USER_SERVICE = userService;
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("allUsers", USER_SERVICE.getListOfUsers());
        return "users";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping("/addUser")
    public String create(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new";
        } else {
            USER_SERVICE.addUser(user);
            return "redirect:/users";
        }
    }

    @GetMapping("/update")
    public String updateUser(@RequestParam(value = "id") Long id,
                             Model model) {
        model.addAttribute("user", USER_SERVICE.getUserById(id));
        return "update";
    }

    @PostMapping("/updateUser")
    public String update(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "update";
        } else {
            USER_SERVICE.updateUser(user);
            return "redirect:/users";
        }
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam(value = "id") Long id,
                             Model model) {
        model.addAttribute("user", USER_SERVICE.getUserById(id));
        return "delete";
    }

    @PostMapping("/deleteUser")
    public String delete(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "delete";
        } else {
            USER_SERVICE.deleteUserById(user.getId());
            return "redirect:/users";
        }
    }
}