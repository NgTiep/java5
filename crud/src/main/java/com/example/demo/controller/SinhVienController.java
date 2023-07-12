package com.example.demo.controller;


import com.example.demo.entity.SinhVien;
import com.example.demo.service.SinhVienService;
import com.example.demo.service.impl.SinhVienServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SinhVienController {

    private SinhVienService sinhVienService = new SinhVienServiceImpl();
    private List<SinhVien> listSinhVien = new ArrayList<>();

    @GetMapping("/sinh-vien/hien-thi")
    public String getHienThi(Model model) {
        listSinhVien = sinhVienService.getAll();
        model.addAttribute("listSinhVien", listSinhVien);
        return "hien-thi";
    }

    @GetMapping("/sinh-vien/search")
    public String search(Model model, SinhVien sinhVien) {
        listSinhVien = sinhVienService.search(listSinhVien, sinhVien.getTen());
        model.addAttribute("listSinhVien", listSinhVien);
        return "hien-thi";
    }

    @GetMapping("/sinh-vien/sinh-vien-nu")
    public String giangVienNu(Model model) {
        listSinhVien = sinhVienService.giangVienNu(listSinhVien, false);
        model.addAttribute("listSinhVien", listSinhVien);
        return "hien-thi";
    }

    @GetMapping("/sinh-vien/sap-xep")
    public String sapXep(Model model) {
        listSinhVien = sinhVienService.sortTuoi(listSinhVien);
        model.addAttribute("listSinhVien", listSinhVien);
        return "hien-thi";
    }

}
