package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import javax.validation.Valid;

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
    public String create(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new";
        } else {
            userService.addUser(user);
            return "redirect:/users";
        }
    }

//    <form th:method="GET" th:action="'/update/id='+@{${user.getId()}}" th:object="${user}">
//                <input type="submit" value="Изменить"/>
//            </form>
    @GetMapping("/update")
    public String updateUser(@RequestParam(value = "id") Long id,
            Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "update";
    }

    @PostMapping("/updateUser")
    public String update(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "update";
        } else {
            userService.updateUser(user);
            return "redirect:/users";
        }
   }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam(value = "id") Long id,
                             Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "delete";
    }

    @PostMapping("/deleteUser")
    public String delete(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "delete";
        } else {
            userService.deleteUserById(user.getId());
            return "redirect:/users";
        }
    }
}