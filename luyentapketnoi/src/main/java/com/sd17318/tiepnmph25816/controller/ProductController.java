package com.sd17318.tiepnmph25816.controller;

import com.sd17318.tiepnmph25816.entity.Product;
import com.sd17318.tiepnmph25816.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    private List<Product> listProduct = new ArrayList<>();

    @GetMapping("/product/hien-thi")
    public String hienThi(@ModelAttribute("product") Product product, Model model) {
        listProduct = productService.getAll();
        model.addAttribute("listProduct", listProduct);
        return "product";
    }

    @GetMapping("/product/detail/{id}")
    public String detail(@PathVariable("id") long id, Model model) {
        Product product = productService.getOne(id);
        model.addAttribute("product", product);
        model.addAttribute("listProduct", listProduct);
        return "product";
    }


    @GetMapping("/product/delete/{id}")
    public String delete(@PathVariable("id") long id, Model model) {
        productService.delete(id);
        return "redirect:/product/hien-thi";
    }


    @PostMapping("/product/add")
    public String add(@ModelAttribute("product") Product product) {
        productService.add(product);
        return "redirect:/product/hien-thi";
    }


    @GetMapping("/product/view-update/{id}")
    public String viewUpdate(@PathVariable("id") long id, Model model) {
        Product product = productService.getOne(id);
        model.addAttribute("product", product);
        return "update";
    }

    @PostMapping("/product/update/{id}")
    public String add(@ModelAttribute("product") Product product, @PathVariable("id") long id) {
//        listProduct.set(productService.viTri(listProduct, id), product);
        productService.update(product);
        return "redirect:/product/hien-thi";
    }

    @GetMapping("/product/search")
    public String search(@ModelAttribute("product") Product product,@RequestParam("ten") String ten, Model model){
        listProduct = productService.searchName(listProduct,ten);
        model.addAttribute("listProduct",listProduct);
        return "redirect:/product/hien-thi";
    }

}
