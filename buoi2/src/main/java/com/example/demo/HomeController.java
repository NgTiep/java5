package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("message", "Welcome to Spring MVC");
        return "index";
    }
}
