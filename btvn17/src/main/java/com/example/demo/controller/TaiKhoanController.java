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
    public String hienThi(@ModelAttribute("taiKhoan")TaiKhoan taiKhoan, @RequestParam(defaultValue = "0") Integer page, Model model){
        Pageable pageable = PageRequest.of(page,2);
        Page<TaiKhoan> listTaiKhoan = taiKhoanService.getAll(pageable);
        List<ChucVu> listChucVu = chucVuService.getAll();
        model.addAttribute("listTaiKhoan",listTaiKhoan);
        model.addAttribute("listChucVu",listChucVu);
        return "index";
    }


    @GetMapping("/tai-khoan/detail/{id}")
    public String detail(@ModelAttribute("taiKhoan") TaiKhoan taiKhoan, @PathVariable("id") UUID id, Model model){
        Pageable pageable = PageRequest.of(0,Integer.MAX_VALUE);
        Page<TaiKhoan> listTaiKhoan = taiKhoanService.getAll(pageable);
        List<ChucVu> listChucVu = chucVuService.getAll();
        TaiKhoan tk = taiKhoanService.getOne(id);
        model.addAttribute("taiKhoan",tk);
        model.addAttribute("listTaiKhoan",listTaiKhoan);
        model.addAttribute("listChucVu",listChucVu);
        return "index";
    }


    @GetMapping("/tai-khoan/delete/{id}")
    public String delete(@ModelAttribute("taiKhoan")TaiKhoan taiKhoan, @PathVariable("id") UUID id, Model model){
        taiKhoanService.delete(id);
        return "redirect:/tai-khoan/hien-thi";
    }


    @PostMapping("/tai-khoan/add")
    public String add(@Valid @ModelAttribute("taiKhoan")TaiKhoan taiKhoan, BindingResult result, Model model){
        if(result.hasErrors()){
            Pageable pageable = PageRequest.of(0,Integer.MAX_VALUE);
            Page<TaiKhoan> listTaiKhoan = taiKhoanService.getAll(pageable);
            List<ChucVu> listChucVu = chucVuService.getAll();
            model.addAttribute("listTaiKhoan",listTaiKhoan);
            model.addAttribute("listChucVu",listChucVu);
            return "index";
        }else{
            taiKhoanService.add(taiKhoan);
            return "redirect:/tai-khoan/hien-thi";
        }
    }

    @PostMapping("/tai-khoan/update/{id}")
    public String update(@Valid @ModelAttribute("taiKhoan")TaiKhoan taiKhoan, BindingResult result,@PathVariable("id") UUID id, Model model){
        if(result.hasErrors()){
            Pageable pageable = PageRequest.of(0,2);
            Page<TaiKhoan> listTaiKhoan = taiKhoanService.getAll(pageable);
            List<ChucVu> listChucVu = chucVuService.getAll();
            model.addAttribute("listTaiKhoan",listTaiKhoan);
            model.addAttribute("listChucVu",listChucVu);
            return "index";
        }else{
            ChucVu chucVu = chucVuService.getOne(taiKhoan.getChucVu().getId());
            taiKhoan.setChucVu(chucVu);
            taiKhoanService.update(taiKhoan);
            return "redirect:/tai-khoan/hien-thi";
        }
    }


    @GetMapping("/tai-khoan/view-update/{id}")
    public String viewUpdate(@ModelAttribute("taiKhoan") TaiKhoan taiKhoan, @PathVariable("id") UUID id, Model model){
        Pageable pageable = PageRequest.of(0,2);
        Page<TaiKhoan> listTaiKhoan = taiKhoanService.getAll(pageable);
        List<ChucVu> listChucVu = chucVuService.getAll();
        TaiKhoan tk = taiKhoanService.getOne(id);
        model.addAttribute("taiKhoan",tk);
        model.addAttribute("listTaiKhoan",listTaiKhoan);
        model.addAttribute("listChucVu",listChucVu);
        return "update";
    }

    @GetMapping("/tai-khoan/search")
    public String search(@ModelAttribute("taiKhoan") TaiKhoan taiKhoan, @RequestParam("ten") String ten, Model model){
        Pageable pageable = PageRequest.of(0,Integer.MAX_VALUE);
        Page<TaiKhoan> listTaiKhoan = taiKhoanService.search(ten,pageable);
        List<ChucVu> listChucVu = chucVuService.getAll();
        model.addAttribute("listTaiKhoan",listTaiKhoan);
        model.addAttribute("listChucVu",listChucVu);
        return "index";
    }

    @GetMapping("/tai-khoan/sap-xep")
    public String sapXep(@ModelAttribute("taiKhoan") TaiKhoan taiKhoan, Model model){
        Pageable pageable = PageRequest.of(0,Integer.MAX_VALUE);
        Page<TaiKhoan> listTaiKhoan = taiKhoanService.sapXep(pageable);
        List<ChucVu> listChucVu = chucVuService.getAll();
        model.addAttribute("listTaiKhoan",listTaiKhoan);
        model.addAttribute("listChucVu",listChucVu);
        return "index";
    }


    @GetMapping("/tai-khoan/hoat-dong")
    public String hoatDong(@ModelAttribute("taiKhoan") TaiKhoan taiKhoan, Model model){
        Pageable pageable = PageRequest.of(0,Integer.MAX_VALUE);
        Page<TaiKhoan> listTaiKhoan = taiKhoanService.hoatDong(pageable);
        List<ChucVu> listChucVu = chucVuService.getAll();
        model.addAttribute("listTaiKhoan",listTaiKhoan);
        model.addAttribute("listChucVu",listChucVu);
        return "index";
    }

}
