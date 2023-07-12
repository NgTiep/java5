package com.demo.controller;

import com.demo.model.Category;
import com.demo.model.Product;
import com.demo.model.Report;
import com.demo.repo.CategoryRepo;
import com.demo.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class HelloController {
	@Autowired
	CategoryRepo categoryRepo;
	final int PAGE_SIZE = 5;
	@ResponseBody
	@GetMapping("/list-category")
	public List<Category> listCategory(@RequestParam(defaultValue="0")int page){
		Sort sort = Sort.by(Sort.Direction.ASC, "name");
		Pageable pageable = PageRequest.of(page, PAGE_SIZE, sort);
		return categoryRepo.findAll(pageable).toList();
	}

	@RequestMapping("/add-category")
	public String addCategory(@RequestParam String name){
		Category c = new Category();
		c.setName(name);
		categoryRepo.save(c);
		return "redirect:/list-category";
	}

	@RequestMapping("/update-category/{id}")
	public String updateCategory(@PathVariable int id, @RequestParam String name){
		Category c = categoryRepo.findById(id).orElse(null);
		if(c!=null){
			c.setName(name);
			categoryRepo.save(c);
		}
		return "redirect:/list-category";
	}

	@RequestMapping("/delete-category/{id}")
	public String deleteCategory(@PathVariable int id){
		categoryRepo.deleteById(id);
		return "redirect:/list-category";
	}

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("message", "Welcome spring 123");
		return "index";
	}

	@Autowired
	ProductRepo productRepo;

	@GetMapping("/list-product")
	@ResponseBody
	public List<Product> listProduct(){
		return productRepo.findAll();
	}

	@GetMapping("/get-product-by-name")
	@ResponseBody
	public List<Product> getProductByName(@RequestParam String name){
		return productRepo.findByName(name);
	}

	@GetMapping("/search-product")
	@ResponseBody
	public List<Product> searchProduct(@RequestParam int cid, @RequestParam String keyword,
			   @RequestParam(defaultValue = "0") int p){
		Sort sort = Sort.by(Sort.Direction.ASC, "price");
		Pageable pageable = PageRequest.of(p, 2, sort);
		return productRepo.searchProduct(cid, "%" + keyword + "%", pageable);
	}

	@GetMapping("/report")
	@ResponseBody
	public List<Report> getReport(){
		return productRepo.getReport();
	}
}
