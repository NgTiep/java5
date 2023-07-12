package com.example.demo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    HttpServletRequest request;
    @Autowired
    HttpServletResponse response;
    @Autowired
    HttpSession session;


    @RequestMapping("/index")
    //@ResponseBody   không cần khi chạy bên view
    public String index(Model model) {
        model.addAttribute("mess", "Hello Spring MVC");
        return "index";
    }

    @RequestMapping("/pages1") //localhost:8080/pages1?name=Nguyen Van A
    public String pages1() {
        String name = request.getParameter("name");
        request.setAttribute("name", name);
        session.setAttribute("name", name);
        return "pages1";
    }


    @RequestMapping("/pages2") //localhost:8080/pages1?name=Nguyen Van A
    public String pages2() {
        return "pages2";
    }

}
