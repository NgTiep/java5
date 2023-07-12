package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Bai1Controller {

    @RequestMapping("/ok")
    public String ok() {
        return "ok";
    }

    @PostMapping("/ctrl/ok")
    @ResponseBody
    public String m1() {
        return "m1";
    }

    @GetMapping("/ctrl/ok")
    @ResponseBody
    public String m2() {
        return "m2";
    }

    @PostMapping("/ctrl/ok/2")
    @ResponseBody
    public String m3() {
        return "m3";
    }


}
