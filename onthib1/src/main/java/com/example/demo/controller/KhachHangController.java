package com.example.demo.controller;

import com.example.demo.entity.HangKhachHang;
import com.example.demo.entity.KhachHang;
import com.example.demo.service.HangKhachHangService;
import com.example.demo.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class KhachHangController {

    @Autowired
    KhachHangService khachHangService;

    @Autowired
    HangKhachHangService hangKhachHangService;

    @GetMapping("/khach-hang/hien-thi")
    public String hienThi(@RequestParam(defaultValue = "0") Integer page, Model model) {
        Pageable pageable = PageRequest.of(page, 3);
        Page<KhachHang> listKhachHang = khachHangService.getAll(pageable);
        List<HangKhachHang> listHKH = hangKhachHangService.getAll();
        model.addAttribute("listKhachHang", listKhachHang);
        model.addAttribute("listHKH", listHKH);
        return "index";
    }

    @GetMapping("/khach-hang/search")
    public String search(@RequestParam(defaultValue = "0") Integer page, Model model,
                         @RequestParam("timKiem") String timKiem,
                         @RequestParam("hangKhachHang") HangKhachHang hangKhachHang) {
        Pageable pageable = PageRequest.of(page, 3);
        Page<KhachHang> listKhachHang = khachHangService.search(timKiem, hangKhachHang, pageable);
        List<HangKhachHang> listHKH = hangKhachHangService.getAll();
        model.addAttribute("listKhachHang", listKhachHang);
        model.addAttribute("listHKH", listHKH);
        return "index";
    }
}
