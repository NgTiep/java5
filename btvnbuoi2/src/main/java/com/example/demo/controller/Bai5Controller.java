package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Bai5Controller {
    @RequestMapping("/bai5/a")
    public String m1() {
        return "bai5";
    }

    @RequestMapping("/bai5/b")
    public String m2(Model model) {
        model.addAttribute("message", "I come from b");
        return "forward:/bai5/a";
    }

    @RequestMapping("/bai5/c")
    public String m3(RedirectAttributes params) {
        params.addAttribute("message", "I come from c");
        return "redirect:/bai5/a";
    }

    @ResponseBody
    @RequestMapping("/bai5/d")
    public String m4() {
        return "I come from d";
    }
}
