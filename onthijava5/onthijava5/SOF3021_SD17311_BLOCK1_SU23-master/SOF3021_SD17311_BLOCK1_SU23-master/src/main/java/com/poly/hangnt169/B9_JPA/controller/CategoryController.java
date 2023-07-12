package com.poly.hangnt169.B9_JPA.controller;

import com.poly.hangnt169.B9_JPA.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/hien-thi")
    public String hienThiDanhSachCate(Model model){
        return "";
    }
}
