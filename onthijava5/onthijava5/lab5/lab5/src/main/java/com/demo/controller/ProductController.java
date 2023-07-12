package com.demo.controller;

import com.demo.model.Product;
import com.demo.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductRepo repo;

    @RequestMapping("/product/sort")
    public String sort(Model model, @RequestParam(value = "field", defaultValue = "price") String field) {
        Sort sort = Sort.by(Sort.Direction.DESC, field);
        model.addAttribute("field", field.toUpperCase());
        List<Product> items = repo.findAll(sort);
        model.addAttribute("items", items);
        return "product/sort";
    }

    @RequestMapping("/product/page")
    public String paginate(Model model, @RequestParam(defaultValue = "0") int p) {
        Pageable pageable = PageRequest.of(p, 5);
        Page<Product> page = repo.findAll(pageable);
        model.addAttribute("page", page);
        return "product/page";
    }
}
