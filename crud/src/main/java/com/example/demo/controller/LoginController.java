package com.example.demo.controller;

import com.example.demo.entity.SinhVien;
import com.example.demo.service.SinhVienService;
import com.example.demo.service.impl.SinhVienServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String login(Model model, @RequestParam("username") String username,
                        @RequestParam("password") String password) {
        if (username.isEmpty() && password.isEmpty()) {
            model.addAttribute("mess", "Error isEmpty");
        } else if (username.equals("tiepnmph25816") && password.equals("12345")) {
            model.addAttribute("mess", "Login thành cong");
        } else {
            model.addAttribute("mess", "Login that bai");
        }
        return "login";
    }
}
