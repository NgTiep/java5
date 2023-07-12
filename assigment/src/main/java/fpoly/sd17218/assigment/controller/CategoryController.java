package fpoly.sd17218.assigment.controller;

import fpoly.sd17218.assigment.entity.Category;
import fpoly.sd17218.assigment.service.CategoryService;
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
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/category/hien-thi")
    public String hienThi(@RequestParam(defaultValue = "0") Integer number, Model model) {
        Pageable pageable = PageRequest.of(number, 2);
        Page<Category> listCategory = categoryService.getAll(pageable);
        model.addAttribute("listCategory", listCategory);
        return "category/index";
    }

    @GetMapping("/category/delete/{username}")
    public String delete(@PathVariable("username") String username, Model model) {
        categoryService.delete(username);
        Pageable pageable = PageRequest.of(0, 2);
        Page<Category> listCategory = categoryService.getAll(pageable);
        model.addAttribute("listCategory", listCategory);
        return "category/index";
    }

    @GetMapping("/category/view-update/{id}")
    public String viewUpdate(@ModelAttribute("category") Category category, @PathVariable("id") String id, Model model) {
        Category categories = categoryService.getOne(id);
        model.addAttribute("category", categories);
        return "category/update";
    }


    @PostMapping("/category/update/{id}")
    public String update(@Valid @ModelAttribute("category") Category category, BindingResult result, @PathVariable("id") String id, Model model) {
        if (result.hasErrors()) {
            return "category/update";
        }
        categoryService.update(category);
        Pageable pageable = PageRequest.of(0, 2);
        Page<Category> listCategory = categoryService.getAll(pageable);
        model.addAttribute("listCategory", listCategory);
        return "category/index";
    }


    @GetMapping("/category/view-add")
    public String viewAdd(@ModelAttribute("category") Category category, Model model) {
        return "category/add";
    }


    @PostMapping("/category/add")
    public String add(@Valid @ModelAttribute("category") Category category, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "category/add";
        }
        categoryService.add(category);
        Pageable pageable = PageRequest.of(0, 2);
        Page<Category> listCategory = categoryService.getAll(pageable);
        model.addAttribute("listCategory", listCategory);
        return "category/index";
    }
}
