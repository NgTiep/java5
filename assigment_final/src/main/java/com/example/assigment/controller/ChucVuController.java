package com.example.assigment.controller;

import com.example.assigment.entity.ChucVu;
import com.example.assigment.service.ChucVuService;
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

import java.util.UUID;

@Controller
public class ChucVuController {

    @Autowired
    ChucVuService chucVuService;

    @GetMapping("/chuc-vu/hien-thi")
    public String hienThi(@ModelAttribute("chucVu") ChucVu chucVu, @RequestParam(defaultValue = "0") Integer page, Model model) {
        Pageable pageable = PageRequest.of(page, 2);
        Page<ChucVu> listChucVu = chucVuService.getAll(pageable);
        model.addAttribute("listChucVu", listChucVu);
        return "chuc_vu/index";
    }

    @GetMapping("/chuc-vu/detail/{id}")
    public String detail(@ModelAttribute("chucVu") ChucVu chucVu, @PathVariable("id") UUID id, Model model) {
        ChucVu cv = chucVuService.getOne(id);
        Pageable pageable = PageRequest.of(0, Integer.MAX_VALUE);
        Page<ChucVu> listChucVu = chucVuService.getAll(pageable);
        model.addAttribute("listChucVu", listChucVu);
        model.addAttribute("chucVu", cv);
        return "chuc_vu/index";
    }

    @GetMapping("/chuc-vu/delete/{id}")
    public String delete(@ModelAttribute("chucVu") ChucVu chucVu, @PathVariable("id") UUID id, Model model) {
        Pageable pageable = PageRequest.of(0, 2);
        Page<ChucVu> listChucVu = chucVuService.getAll(pageable);
        model.addAttribute("listChucVu", listChucVu);
        chucVuService.delete(id);
        return "chuc_vu/index";
    }

    @PostMapping("/chuc-vu/add")
    public String add(@Valid @ModelAttribute("chucVu") ChucVu chucVu, BindingResult result, Model model){
        if(result.hasErrors()){
            Pageable pageable = PageRequest.of(0, 2);
            Page<ChucVu> listChucVu = chucVuService.getAll(pageable);
            model.addAttribute("listChucVu", listChucVu);
            return "chuc_vu/index";
        }
        Pageable pageable = PageRequest.of(0, 2);
        Page<ChucVu> listChucVu = chucVuService.getAll(pageable);
        model.addAttribute("listChucVu", listChucVu);
        chucVuService.add(chucVu);
        return "chuc_vu/index";
    }

    @GetMapping("/chuc-vu/view-update/{id}")
    public String viewUpdate(@ModelAttribute("chucVu") ChucVu chucVu, @PathVariable("id") UUID id, Model model) {
        ChucVu cv = chucVuService.getOne(id);
        model.addAttribute("chucVu", cv);
        return "chuc_vu/update";
    }


    @PostMapping("/chuc-vu/update/{id}")
    public String update(@Valid @ModelAttribute("chucVu") ChucVu chucVu, BindingResult result,@PathVariable("id") UUID id, Model model){
        if(result.hasErrors()){
            return "chuc_vu/update";
        }
        Pageable pageable = PageRequest.of(0, 2);
        Page<ChucVu> listChucVu = chucVuService.getAll(pageable);
        model.addAttribute("listChucVu", listChucVu);
        chucVuService.update(chucVu);
        return "chuc_vu/index";
    }
}
