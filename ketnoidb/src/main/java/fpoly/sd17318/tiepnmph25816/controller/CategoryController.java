package fpoly.sd17318.tiepnmph25816.controller;

import fpoly.sd17318.tiepnmph25816.entity.Category;
import fpoly.sd17318.tiepnmph25816.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    private List<Category> listCategory = new ArrayList<>();

    @GetMapping("/category/hien-thi")
    public String hienThi(@ModelAttribute("cate") Category category, Model model) {
        listCategory = categoryService.getAll();
        model.addAttribute("listCategory", listCategory);
        return "hien-thi";
    }


    @GetMapping("/category/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        categoryService.delete(id);
        return "redirect:/category/hien-thi";
    }

    @GetMapping("/category/detail/{id}")
    public String detail(@PathVariable("id") long id, Model model) {
        Category cate = categoryService.getOne(id);
        model.addAttribute("cate", cate);
        model.addAttribute("listCategory", listCategory);
        return "hien-thi";
    }

    @PostMapping("/category/add")
    public String add(@ModelAttribute("cate") Category category, Model model) {
        categoryService.add(category);
        return "redirect:/category/hien-thi";
    }

    @GetMapping("/category/view-update/{id}")
    public String viewUpdate(@PathVariable("id") long id, Model model) {
        Category cate = categoryService.getOne(id);
        model.addAttribute("cate", cate);
        return "update";
    }

    @PostMapping("/category/update/{id}")
    public String update(@ModelAttribute("cate") Category category, @PathVariable("id") long id) {
        listCategory.set(categoryService.viTri(listCategory, id), category);
        categoryService.update(category);
        return "redirect:/category/hien-thi";
    }
}
