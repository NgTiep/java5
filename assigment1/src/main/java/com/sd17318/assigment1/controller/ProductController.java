package com.sd17318.assigment1.controller;

import com.sd17318.assigment1.model.Category;
import com.sd17318.assigment1.model.Product;
import com.sd17318.assigment1.service.CategoryService;
import com.sd17318.assigment1.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    private List<Product> listProduct = new ArrayList<>();

    @GetMapping("/")
    public String listProduct(Model model) {
        if (listProduct.isEmpty()) {
            listProduct = productService.getAll();
        }
        model.addAttribute("productList", listProduct);
        return "product/list";
    }

    @GetMapping("/product/view-add")
    public String viewAdd(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categoryList", categoryService.getAll());
        return "product/add";
    }

    @GetMapping("/product/view-update/{id}")
    public String viewUpdate(@PathVariable Integer id, Model model) {
        Product product = productService.update(listProduct, id);
        model.addAttribute("product", product);
        model.addAttribute("categoryList", categoryService.getAll());
        return "product/update";
    }

    @PostMapping("/product/update/{id}")
    public String update(@Valid @ModelAttribute("product") Product product, BindingResult result, @PathVariable("id") int id, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("productList", listProduct);
            model.addAttribute("categoryList", productService.getAll());
            return "product/update";
        }
        Category category = categoryService.findById(product.getCategory().getId());
        product.setCategory(category);
        int viTri = productService.viTri(listProduct, id);
        listProduct.set(viTri, product);
        model.addAttribute("productList", listProduct);
        return "product/list";
    }

    @PostMapping("/product/add")
    public String add(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("productList", listProduct);
            model.addAttribute("categoryList", categoryService.getAll());
            return "product/add";
        }
        productService.addProduct(product);
        model.addAttribute("productList", listProduct);
        return "product/list";
    }

    @GetMapping("/delete-product/{id}")
    public String deleteProduct(@PathVariable("id") int id, Model model) {
        productService.delete(id);
        model.addAttribute("productList", listProduct);
        return "product/list";
    }
}

