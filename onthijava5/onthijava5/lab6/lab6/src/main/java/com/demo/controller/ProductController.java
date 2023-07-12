package com.demo.controller;

import com.demo.model.Product;
import com.demo.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    ProductRepo repo;



    @GetMapping("/product/search-and-page")
    public String searchAndPage(Model model,
                                @RequestParam("keywords") Optional<String> kw,
                                @RequestParam("p") Optional<Integer> p) {
//        String kwords = kw.orElse((String)httpSession.getAttribute("keywords"));
        String kwords = kw.orElse("");
//        kwords = kwords == null?"":kwords;
//        httpSession.setAttribute("keywords", kwords);
        Pageable pageable = PageRequest.of(p.orElse(0), 4);
        Page<Product> page = repo.findByKeywords("%" + kwords + "%", pageable);
        model.addAttribute("page", page);
        return "product/search-and-page";
    }

    @RequestMapping("/product/search")
    public String searchProduct(Model model, @RequestParam Optional<Double> min,
                                @RequestParam Optional<Double> max) {
        double minPrice = min.orElse(Double.MIN_VALUE);
        double maxPrice = max.orElse(Double.MAX_VALUE);
        List<Product> items = repo.findByPrice(minPrice, maxPrice);
        model.addAttribute("items", items);
        return "product/search";
    }


    @RequestMapping("/product/search-by-price")
    public String searchByPrice(Model model, @RequestParam Optional<Double> min,
                                @RequestParam Optional<Double> max) {
        double minPrice = min.orElse(Double.MIN_VALUE);
        double maxPrice = max.orElse(Double.MAX_VALUE);
        List<Product> items = repo.findByPriceBetween(minPrice, maxPrice);
        model.addAttribute("items", items);
        return "product/search-by-price";
    }


    @GetMapping("/product/search-by-page")
    public String searchByPage(Model model,
                                @RequestParam("keywords") Optional<String> kw,
                                 @RequestParam("p") Optional<Integer> p) {
//        String kwords = kw.orElse((String)httpSession.getAttribute("keywords"));
        String kwords = kw.orElse("");
//        kwords = kwords == null?"":kwords;
//        httpSession.setAttribute("keywords", kwords);
        Pageable pageable = PageRequest.of(p.orElse(0), 4);
        Page<Product> page = repo.findAllByNameLike("%" + kwords + "%", pageable);
        model.addAttribute("page", page);
        return "product/search-by-page";
    }

}
