package fpoly.sd17218.assigment.controller;

import fpoly.sd17218.assigment.entity.Category;
import fpoly.sd17218.assigment.entity.Product;
import fpoly.sd17218.assigment.service.CategoryService;
import fpoly.sd17218.assigment.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @GetMapping("/product/hien-thi")
    public String hienThi(@RequestParam(defaultValue = "0") Integer number, Model model) {
        Pageable pageable = PageRequest.of(number, 2);
        Page<Product> listProduct = productService.getAll(pageable);
        model.addAttribute("listProduct", listProduct);
        return "product/index";
    }

    @GetMapping("/product/delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model) {
        productService.delete(id);
        Pageable pageable = PageRequest.of(0, 2);
        Page<Product> listProduct = productService.getAll(pageable);
        model.addAttribute("listProduct", listProduct);
        return "product/index";
    }

    @GetMapping("/product/view-update/{id}")
    public String viewUpdate(@ModelAttribute("product") Product product, @PathVariable("id") Integer id, Model model) {
        Product pd = productService.getOne(id);
        model.addAttribute("product", pd);
        List<Category> listCategory = categoryService.findAll();
        model.addAttribute("listCategory", listCategory);
        return "product/update";
    }


    @PostMapping("/product/update/{id}")
    public String update(@Valid @ModelAttribute("product") Product product, BindingResult result, @PathVariable("id") Integer id, Model model) {
        if (result.hasErrors()) {
            List<Category> listCategory = categoryService.findAll();
            model.addAttribute("listCategory", listCategory);
            return "product/update";
        }
        Category category = categoryService.getOne(product.getCategory().getId());
        product.setCategory(category);
        productService.update(product);
        Pageable pageable = PageRequest.of(0, 2);
        Page<Product> listProduct = productService.getAll(pageable);
        model.addAttribute("listProduct", listProduct);
        return "product/index";
    }


    @GetMapping("/product/view-add")
    public String viewAdd(@ModelAttribute("product") Product product, Model model) {
        List<Category> listCategory = categoryService.findAll();
        model.addAttribute("listCategory", listCategory);
        return "product/add";
    }


    @PostMapping("/product/add")
    public String add(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<Category> listCategory = categoryService.findAll();
            model.addAttribute("listCategory", listCategory);
            return "product/add";
        }
        productService.add(product);
        Pageable pageable = PageRequest.of(0, 2);
        Page<Product> listProduct = productService.getAll(pageable);
        model.addAttribute("listProduct", listProduct);
        return "product/index";
    }
}
