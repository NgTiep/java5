package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AdminController {
    //  Category
    @GetMapping("/admin/category/index")
    public String listCategory(){
        return "admin/category/list";
    }

    @GetMapping("/admin/category/create")
    public String createCategory(){
        return "admin/category/form";
    }

    @GetMapping("/admin/category/edit/{id}")
    public String editCategory(@PathVariable int id){
        return "admin/category/form";
    }

    //  Product
    @GetMapping("/admin/product/index")
    public String listProduct(){
        return "admin/product/list";
    }

    @GetMapping("/admin/product/create")
    public String createProduct(){
        return "admin/product/form";
    }

    @GetMapping("/admin/product/edit/{id}")
    public String editProduct(@PathVariable int id){
        return "admin/product/form";
    }

    //  Account
    @GetMapping("/admin/account/index")
    public String listAccount(){
        return "admin/account/list";
    }

    @GetMapping("/admin/account/create")
    public String createAccount(){
        return "admin/account/form";
    }

    @GetMapping("/admin/account/edit/{id}")
    public String editAccount(@PathVariable int id){
        return "admin/account/form";
    }
}
