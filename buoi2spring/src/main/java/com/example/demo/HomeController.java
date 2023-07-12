package com.example.demo;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.Date;

@Controller
public class HomeController {


    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("mess", "Welcome Spring Boot");
        return "index";
    }

    @GetMapping("/about")
    public String about(Model model, @RequestParam(value = "id", required = false) Integer id, @RequestParam("username") String username) {
        model.addAttribute("mess", "xin chao cu dan");
        return "about";
    }

    @GetMapping("/hienthi")
    public String hienThi(Model model) {
        model.addAttribute("mess", "Hello SPring");
        model.addAttribute("Hello Spring");
        model.addAttribute("now", new Date());
        model.addAttribute(new Date());
        return "hienthi";
    }


    @GetMapping("/login")
    public String formLogin() {
        return "login";
    }


//    @PostMapping("/login")
//    public String login(Model model,Account account) {
//        if (account.getUsername().equals("NguyenVV4") && account.getPassword().equals("12345")) {
//            model.addAttribute("mess","Login thanh cong");
//        } else {
//            model.addAttribute("mess","Login that bai");
//        }
//        return "login";
//    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping(value = "login")
    public String login(Model model,
                        @RequestParam("username") String username,
                        @RequestParam("password") String password) {
        if (username.equals("NguyenVV4") && password.equals("12345")) {
            model.addAttribute("mess", "Login thanh cong");
        } else {
            model.addAttribute("mess", "Login that bai");
        }
        return "login";
    }
}
