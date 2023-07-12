package com.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	@Autowired HttpServletRequest req;

	@Scheduled(fixedRate = 1000)
	public void run(){
		System.out.println(System.currentTimeMillis());
	}

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("message", "Welcome spring 123");
		return "index";
	}

	@GetMapping("/login")
	public String login(){
		return "login";
	}

	@Autowired
	HttpSession session;

	@PostMapping("/login")
	public String login(@RequestParam String username){
		session.setAttribute("username", username);
		return "redirect:" + session.getAttribute("secureURI");
	}

	@GetMapping("/admin/product")
	public  String listProduct(){
		return "admin/product/index";
	}

	@GetMapping("/admin/order")
	public  String listOrder(){
		return "admin/order/index";
	}
}
