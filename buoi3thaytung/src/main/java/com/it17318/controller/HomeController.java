package com.it17318.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @Autowired
    HttpServletRequest request;


    @GetMapping("/search") //localhost:8080/search?q=test
    @ResponseBody
    public String search(@RequestParam(defaultValue = "") String q) {
        return "Term1234: " + q;
    }

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("mess", "Welcome Spring MVC");
        return "index";
    }

    @PostMapping("/save")
    public String save(
            @RequestParam("name") String name,
            @RequestParam("number") int number,
            Model model
    ) {
        model.addAttribute("name", name);
        model.addAttribute("number", number);
        return "product";
    }

//    public static  class Product{
//        private String name;
//        private String number;
//    }

//    @PostMapping("/detail")
//    public String hienThi(Model model, Product product){
//        model.addAttribute("product",product);
//        return "product";
//    }

    @GetMapping("/hien-thi/{id}") //localhost:8080/hien-thi/100
    @ResponseBody
    public String getHienThi(@PathVariable String id) {
        return "product" + id;
    }


}
