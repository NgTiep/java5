package com.example.demo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    HttpSession session;
    @Autowired
    HttpServletResponse response;
    @Autowired
    HttpServletRequest request;


    @GetMapping("/login")
    public String getFormLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String login(Model model, @RequestParam("username") String username, @RequestParam("password") String password) {
        if (username.isEmpty() && password.isEmpty()) {
            model.addAttribute("mess", "Error isEmpty");
        } else if (username.equals("tiepnmph25816") && password.equals("12345")) {
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            model.addAttribute("mess", "Login thanh cong");
            return "home";
        } else {
            model.addAttribute("mess", "Login that bai");
        }
        return "login";
    }
}
