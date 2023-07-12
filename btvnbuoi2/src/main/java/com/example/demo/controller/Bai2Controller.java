package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Bai2Controller {
    @RequestMapping("/param/form")
    public String form() {
        return "form";
    }

    @PostMapping("/param/save/{x}")
    public String save(Model model, @PathVariable String x, @RequestParam("y") String y) {
        model.addAttribute("x", x);
        model.addAttribute("y", y);
        return "form";
    }
}
