package com.example.demo.controller;


import com.example.demo.entity.ChucVu;
import com.example.demo.entity.TaiKhoan;
import com.example.demo.service.ChucVuService;
import com.example.demo.service.TaiKhoanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    public String hienThi(Model model, @RequestParam(defaultValue = "0") Integer page){
        Pageable pageable = PageRequest.of(page,2);
        Page<TaiKhoan> listTaiKhoan = taiKhoanService.getAll(pageable);
        model.addAttribute("listTaiKhoan",listTaiKhoan);
        return "index";
    }


    @GetMapping("/tai-khoan/delete/{id}")
    public String delete(@PathVariable("id")UUID id){
        taiKhoanService.delete(id);
        return "redirect:/tai-khoan/hien-thi";
    }

    @GetMapping("/tai-khoan/detail/{id}")
    public String detail(@ModelAttribute("taiKhoan") TaiKhoan taiKhoan, @PathVariable("id")UUID id, Model model){
        TaiKhoan tk = taiKhoanService.getOne(id);
        List<ChucVu> listChucVu = chucVuService.getAll();
        model.addAttribute("taiKhoan",tk);
        model.addAttribute("listChucVu",listChucVu);
        return "add";
    }

    @GetMapping("/tai-khoan/view-add")
    public String viewAdd(@ModelAttribute("taiKhoan") TaiKhoan taiKhoan,Model model){
        List<ChucVu> listChucVu = chucVuService.getAll();
        model.addAttribute("listChucVu",listChucVu);
        return "add";
    }

    @PostMapping("/tai-khoan/add")
    public String add(@Valid  @ModelAttribute("taiKhoan") TaiKhoan taiKhoan, BindingResult result, Model model){
        if(result.hasErrors()){
            List<ChucVu> listChucVu = chucVuService.getAll();
            model.addAttribute("listChucVu",listChucVu);
            return "add";
        }else{
            taiKhoanService.add(taiKhoan);
            return "redirect:/tai-khoan/hien-thi";
        }
    }


    @GetMapping("/tai-khoan/view-update/{id}")
    public String viewUpdate(@ModelAttribute("taiKhoan") TaiKhoan taiKhoan, @PathVariable("id")UUID id, Model model){
        TaiKhoan tk = taiKhoanService.getOne(id);
        List<ChucVu> listChucVu = chucVuService.getAll();
        model.addAttribute("taiKhoan",tk);
        model.addAttribute("listChucVu",listChucVu);
        return "update";
    }

    @PostMapping("/tai-khoan/update/{id}")
    public String update(@Valid  @ModelAttribute("taiKhoan") TaiKhoan taiKhoan, BindingResult result,@PathVariable("id")UUID id, Model model){
        if(result.hasErrors()){
            List<ChucVu> listChucVu = chucVuService.getAll();
            model.addAttribute("listChucVu",listChucVu);
            return "update";
        }else{
            ChucVu chucVu=chucVuService.getOne(taiKhoan.getChucVu().getId());
            taiKhoan.setChucVu(chucVu);
            taiKhoanService.update(taiKhoan);
            return "redirect:/tai-khoan/hien-thi";
        }
    }
}
