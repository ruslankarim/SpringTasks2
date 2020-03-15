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
public class DeleteUserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/admin/delete", method = RequestMethod.GET)
    public String handlerDeleteUser(Model model, HttpServletRequest request, HttpServletResponse response){
        long id = Long.parseLong(request.getParameter("id"));
        userService.deleteUser(id);
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "userlist";
    }
}
