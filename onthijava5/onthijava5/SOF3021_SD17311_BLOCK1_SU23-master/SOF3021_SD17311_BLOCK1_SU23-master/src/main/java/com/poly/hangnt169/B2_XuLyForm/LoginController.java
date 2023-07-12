package com.poly.hangnt169.B2_XuLyForm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login(){
        return "/buoi2/login";
    }

    @PostMapping("/ket-qua")
    public String xuLyLogin(@RequestParam("uname")String name ,
                            @RequestParam("psw")String password  , Model model){
        // Lay gia tri tu o input (view) sang controller
        // J4: request.getParameter("ten cua o input);
        // J5: @RequestParam
        model.addAttribute("name" , name);
        model.addAttribute("pass" , password);
        return "/buoi2/hien-thi-ket-qua";
    }
}
