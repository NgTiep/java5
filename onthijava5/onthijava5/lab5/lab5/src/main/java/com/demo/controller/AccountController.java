package com.demo.controller;

import com.demo.model.Account;
import com.demo.model.Category;
import com.demo.repo.AccountRepo;
import com.demo.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AccountController {

    @Autowired
    AccountRepo repo;

    @RequestMapping("/account/index")
    public String index(Model model) {
        Account item = new Account();
        model.addAttribute("item", item);
        List<Account> items = repo.findAll();
        model.addAttribute("items", items);
        return "account/index";
    }

    @RequestMapping("/account/edit/{username}")
    public String edit(Model model, @PathVariable("username") String username) {
        Account item = repo.findById(username).get();
        model.addAttribute("item", item);
        List<Account> items = repo.findAll();
        model.addAttribute("items", items);
        return "account/index";
    }

    @RequestMapping("/account/create")
    public String create(Account item) {
        repo.save(item);
        return "redirect:/account/index";
    }

    @RequestMapping("/account/update")
    public String update(Account item) {
        repo.save(item);
        return "redirect:/account/edit/" + item.getUsername();
    }

    @RequestMapping("/account/delete/{username}")
    public String create(@PathVariable("username") String username) {
        repo.deleteById(username);
        return "redirect:/account/index";
    }
}
