package com.demo.controller;

import com.demo.model.Category;
import com.demo.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    CategoryRepo repo;

    @RequestMapping("/category/index")
    public String index(Model model) {
        Category item = new Category();
        model.addAttribute("item", item);
        List<Category> items = repo.findAll();
        model.addAttribute("items", items);
        return "category/index";
    }

    @RequestMapping("/category/edit/{id}")
    public String edit(Model model, @PathVariable("id") String id) {
        Category item = repo.findById(id).get();
        model.addAttribute("item", item);
        List<Category> items = repo.findAll();
        model.addAttribute("items", items);
        return "category/index";
    }

    @RequestMapping("/category/create")
    public String create(Category item) {
        repo.save(item);
        return "redirect:/category/index";
    }

    @RequestMapping("/category/update")
    public String update(Category item) {
        repo.save(item);
        return "redirect:/category/edit/" + item.getId();
    }

    @RequestMapping("/category/delete/{id}")
    public String create(@PathVariable("id") String id) {
        repo.deleteById(id);
        return "redirect:/category/index";
    }
}
