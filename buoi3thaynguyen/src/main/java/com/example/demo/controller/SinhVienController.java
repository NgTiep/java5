package com.example.demo.controller;


import com.example.demo.entity.SinhVien;
import com.example.demo.service.SinhVienService;
import com.example.demo.service.impl.SinhVienServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SinhVienController {

    private SinhVienService sinhVienService = new SinhVienServiceImpl();
    private List<SinhVien> listSinhVien = new ArrayList<>();

    @GetMapping("/hien-thi")
    public String form(Model model) {
        listSinhVien = sinhVienService.getAll();
        model.addAttribute("listSinhVien", listSinhVien);
        return "form";
    }


    @GetMapping("/xoa{id}")
    public String form(Model model, @PathVariable("id") int id) {

        listSinhVien.remove(sinhVienService.viTri(listSinhVien, id));
        model.addAttribute("listSinhVien", listSinhVien);
        return "form";
    }

}
