package com.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.demo.model.Category;
import com.demo.model.Product;
import com.demo.model.SanPham;
import com.demo.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
public class HelloController {
    @Autowired
    HttpServletRequest req;
//
//	@ModelAttribute
//	List<Category> getCategoryList(){
//		return Arrays.asList(
//			new Category(1, "Group1"),
//			new Category(2, "Group2")
//		);
//	}
//
//	@PostMapping("/save-product")
//	public String saveProduct(@Valid @ModelAttribute("product") Product p,
//			  BindingResult bindingResult, Model model) throws IOException {
//		System.out.println(p);
//		if(bindingResult.hasErrors()){
//			model.addAttribute("message",
//				"Some fields are not valid");
//		}
//		if(p.getImage()!=null && !p.getImage().isEmpty()){
//			File f = new File("/images/" + p.getImage().getOriginalFilename());
//			System.out.println(f.getAbsolutePath());
//			p.getImage().transferTo(f);
//		}
//		return "index";
//	}
//
//	@GetMapping("/")
//	public String index(Model model){
//		model.addAttribute("product", new Product());
//		return "index";
//	}

    //    @Autowired
//    SanPham sanPham;
//    //    @Autowired @Qualifier("p1") SanPham p;
////    @Autowired @Qualifier("p2") SanPham p2;
    @Autowired
    SanPhamService sanPhamService;
//
//    @RequestMapping("/")
//    public String index(Model model) {
//        // SanPham sanPham = new SanPham("iphone", 11);
//        model.addAttribute("sanPham", sanPham);
//        return "index";
//    }
//
//    @RequestMapping("/2")
//    public String page2() {
//        sanPham.setPrice(2000);
//        return "redirect:/";
//    }


    @ResponseBody
    @GetMapping("/list-san-pham")
    public String hienThi() {
        return sanPhamService.getAll().toString();
    }

    @ResponseBody
    @GetMapping("/get-san-pham/{id}")
    public String getSanPham(@PathVariable("id") int id) {
        SanPham sp = sanPhamService.getById(id);
        return sp ! = null? sp.toString() : "Not found";
    }
}
