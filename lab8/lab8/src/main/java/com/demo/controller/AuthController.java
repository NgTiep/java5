package com.demo.controller;

import javax.servlet.http.HttpSession;

import com.demo.dao.AccountDAO;
import com.demo.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {
	@Autowired
	AccountDAO dao;

	@Autowired HttpSession session;

	@GetMapping("/account/login")
	public String login() {
		return "account/login";
	}

	@PostMapping("/account/login")
	public String login(Model model,
						@RequestParam("username") String username,
						@RequestParam("password") String password) {
		try {

			Account user = dao.getOne(username);
			if(!user.getPassword().equals(password)) {
				model.addAttribute("message", "Invalid password");
			} else {
				String uri = (String) session.getAttribute("security-uri");
				session.setAttribute("user",user);
				if(uri != null) {
					return "redirect:" + uri;
				} else {
					model.addAttribute("message", "Login succeed");
				}
			}
		} catch (Exception e) {
			model.addAttribute("message", "Invalid username");
		}
		return "account/login";
	}

	@GetMapping("/order/index")
	public String listOrder(){
		return "order/index";
	}

	@GetMapping("/admin/settings")
	public String adminSettings(){
		return "admin/settings";
	}
}
