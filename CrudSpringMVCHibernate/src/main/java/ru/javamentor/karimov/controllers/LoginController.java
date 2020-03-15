package ru.javamentor.karimov.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void handleLogin(HttpServletResponse response)
            throws IOException {
        /*
        *  Логика проверки логина и пароля
        * */

        response.sendRedirect("admin/userlist");
    }
}
