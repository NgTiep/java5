package com.it17318.controller.controller;


import com.it17318.controller.entity.Category;
import com.it17318.controller.entity.Product;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
public class HelloController {

    @ModelAttribute
    List<Category> getCategory() {
        return Arrays.asList(
                new Category(1, "a"),
                new Category(2, "b"),
                new Category(3, "c")
        );
    }

    @RequestMapping("/index")
    public String index(@ModelAttribute("product") Product p) throws IOException {
        System.out.println(p);
        if (p.getImage() != null && !p.getImage().isEmpty()) {
            File f = new File("/image/" + p.getImage().getOriginalFilename());
            System.out.println(f.getAbsolutePath());
            p.getImage().transferTo(f);
        }
        return "index";
    }
}
