package ru.javamentor.karimov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.javamentor.karimov.model.User;
import ru.javamentor.karimov.service.UserService;

import java.util.List;

@Controller
public class UserListController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/userlist", method = RequestMethod.GET)
    public String handler(ModelMap model){
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "userlist";
    }
}
