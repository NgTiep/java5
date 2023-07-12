package com.example.demo.controller;

import com.example.demo.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Bai3Controller {
    @GetMapping("/product")
    public String getProduct() {
        return "product";
    }

    @PostMapping("/product")
    public String product(Model model, Product product) {
        model.addAttribute("name", product.getName());
        model.addAttribute("number", product.getNumber());
        return "product";
    }
}
