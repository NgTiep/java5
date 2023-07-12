package fpoly.sd17318.assgment1.controller;

import fpoly.sd17318.assgment1.dao.CategoryDAO;
import fpoly.sd17318.assgment1.dao.ProductDAO;
import fpoly.sd17318.assgment1.models.Category;
import fpoly.sd17318.assgment1.models.Product;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

public class ProductController {

    @Autowired
    ProductDAO productDAO;

    @Autowired
    CategoryDAO categoryDAO;

    private List<Product> listProduct = new ArrayList<>();

    @GetMapping("/")
    public String listProduct(Model model) {
        if (listProduct.isEmpty()) {
            listProduct = productDAO.getAll();
        }
        model.addAttribute("productList", listProduct);
        return "product/list";
    }

    @GetMapping("/product/view-add")
    public String viewAdd(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categoryList", categoryDAO.getAll());
        return "product/add";
    }

    @GetMapping("/product/view-update/{id}")
    public String viewUpdate(@PathVariable Integer id, Model model) {
        Product product = productDAO.update(listProduct, id);
        model.addAttribute("product", product);
        model.addAttribute("categoryList", categoryDAO.getAll());
        return "product/update";
    }

    @PostMapping("/product/update/{id}")
    public String update(@Valid @ModelAttribute("product") Product product, BindingResult result, @PathVariable("id") int id, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("productList", listProduct);
            model.addAttribute("categoryList", categoryDAO.getAll());
            return "product/update";
        }
        Category category = categoryDAO.findById(product.getCategory().getId());
        product.setCategory(category);
        int viTri = productDAO.viTri(listProduct, id);
        listProduct.set(viTri, product);
        model.addAttribute("productList", listProduct);
        return "product/list";
    }

    @PostMapping("/product/add")
    public String add(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("productList", listProduct);
            model.addAttribute("categoryList", categoryDAO.getAll());
            return "product/add";
        }
        productDAO.addProduct(product);
        model.addAttribute("productList", listProduct);
        return "product/list";
    }

    @GetMapping("/delete-product/{id}")
    public String deleteProduct(@PathVariable("id") int id, Model model) {
        productDAO.delete(id);
        model.addAttribute("productList", listProduct);
        return "product/list";
    }
}
