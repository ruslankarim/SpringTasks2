package ru.javamentor.karimov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.javamentor.karimov.model.User;
import ru.javamentor.karimov.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class AddUserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/admin/new", method = RequestMethod.GET)
    public String handlerUserForm(Model model, HttpServletRequest request, HttpServletResponse response){
        return "userform";
    }

    @RequestMapping(value = "/admin/insert", method = RequestMethod.POST)
    public String handlerAddUser(Model model, HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        User user = new User(name, address);
        userService.insertUser(user);
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "userlist";
    }
}
