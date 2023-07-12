package com.example.demo.controller;


import com.example.demo.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class Bai4Controller {

    @GetMapping("/bai4")
    public String form(Model model) {
        Product p = new Product();
        p.setName("iPhone 30");
        p.setNumber(Integer.valueOf(1000));
        model.addAttribute("name1", p.getName());
        model.addAttribute("number1", p.getNumber());
        return "bai4";
    }

    @PostMapping("/bai4/product/save")
    public String save(Model model, Product p) {
        model.addAttribute("name", p.getName());
        model.addAttribute("number", p.getNumber());
        return "bai4";
    }

    @ModelAttribute("items")
    public List<Product> getItems2() {
        return Arrays.asList(new Product("A", 1000), new Product("B", 1000));
    }
}
