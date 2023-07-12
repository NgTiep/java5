package com.example.btvn15.controller;

import com.example.btvn15.entity.ChucVu;
import com.example.btvn15.entity.TaiKhoan;
import com.example.btvn15.service.ChucVuService;
import com.example.btvn15.service.TaiKhoanService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
public class TaiKhoanController {

    @Autowired
    TaiKhoanService taiKhoanService;

    @Autowired
    ChucVuService chucVuService;


    @GetMapping("/tai-khoan/hien-thi")
    public String hienThi(@ModelAttribute("taiKhoan") TaiKhoan taiKhoan, @RequestParam(defaultValue = "0") Integer number, Model model) {
        Pageable pageable = PageRequest.of(number, 2);
        Page<TaiKhoan> listTaiKhoan = taiKhoanService.getAll(pageable);
        List<ChucVu> listChucVu = chucVuService.getAll();
        model.addAttribute("listTaiKhoan", listTaiKhoan);
        model.addAttribute("listChucVu", listChucVu);
        return "index";
    }

    @GetMapping("/tai-khoan/detail/{id}")
    public String detail(@ModelAttribute("taiKhoan") TaiKhoan taiKhoan, @PathVariable("id") UUID id, Model model) {
        TaiKhoan tk = taiKhoanService.getOne(id);
        Pageable pageable = PageRequest.of(0, 2);
        Page<TaiKhoan> listTaiKhoan = taiKhoanService.getAll(pageable);
        List<ChucVu> listChucVu = chucVuService.getAll();
        model.addAttribute("listTaiKhoan", listTaiKhoan);
        model.addAttribute("listChucVu", listChucVu);
        model.addAttribute("taiKhoan", tk);
        return "index";
    }


    @GetMapping("/tai-khoan/delete/{id}")
    public String delete(@PathVariable("id") UUID id, Model model) {
        taiKhoanService.delete(id);
        return "redirect:/tai-khoan/hien-thi";
    }

    @PostMapping("/tai-khoan/add")
    public String add(@ModelAttribute("taiKhoan") TaiKhoan taiKhoan, Model model) {
        taiKhoanService.add(taiKhoan);
        return "redirect:/tai-khoan/hien-thi";
    }

    @GetMapping("/tai-khoan/view-update/{id}")
    public String viewUpdate(@ModelAttribute("taiKhoan") TaiKhoan taiKhoan, @PathVariable("id") UUID id, Model model) {
        TaiKhoan tk = taiKhoanService.getOne(id);
        List<ChucVu> listChucVu = chucVuService.getAll();
        model.addAttribute("listChucVu", listChucVu);
        model.addAttribute("taiKhoan", tk);
        return "update";
    }

    @PostMapping("/tai-khoan/update/{id}")
    public String update(@ModelAttribute("taiKhoan") TaiKhoan taiKhoan, @PathVariable("id") UUID id, Model model) {
        ChucVu cv = chucVuService.getOne(taiKhoan.getChucVu().getId());
        taiKhoan.setChucVu(cv);
        taiKhoanService.update(taiKhoan);
        return "redirect:/tai-khoan/hien-thi";
    }

    @GetMapping("/tai-khoan/search")
    public String search(@ModelAttribute("taiKhoan") TaiKhoan taiKhoan, @RequestParam("ten") String ten, Model model){
        Pageable pageable = PageRequest.of(0, Integer.MAX_VALUE);
        Page<TaiKhoan> search = taiKhoanService.search(ten, pageable);
        model.addAttribute("listTaiKhoan",search);
        return "index";

    }

    @GetMapping("/tai-khoan/hoat-dong")
    public String hoatDong(@ModelAttribute("taiKhoan") TaiKhoan taiKhoan, Model model) {
        Pageable pageable = PageRequest.of(0, Integer.MAX_VALUE);
        Page<TaiKhoan> listTaiKhoan = taiKhoanService.hoaDong(pageable);
        model.addAttribute("listTaiKhoan", listTaiKhoan);
        return "index";

    }

    @GetMapping("/tai-khoan/sap-xep")
    public String sapXep(@ModelAttribute("taiKhoan") TaiKhoan taiKhoan, Model model) {
        Pageable pageable = PageRequest.of(0, Integer.MAX_VALUE);
        Page<TaiKhoan> listTaiKhoan = taiKhoanService.sapXep(pageable);
        model.addAttribute("listTaiKhoan", listTaiKhoan);
        return "index";

    }
}
