package com.demo.controller;

import com.demo.model.Report;
import com.demo.repo.ReportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class RepostController {

    @Autowired
    ReportRepo repo;

    @RequestMapping("/report/inventory-by-category")
    public String inventory(Model model) {
        List<Report> items = repo.getInventoryByCategory();
        model.addAttribute("items", items);
        return "report/inventory-by-category";
    }
}
