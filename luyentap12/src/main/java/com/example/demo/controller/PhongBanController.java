package com.example.demo.controller;

import com.example.demo.entity.LoaiPhongBan;
import com.example.demo.entity.PhongBan;
import com.example.demo.service.LoaiPhongBanService;
import com.example.demo.service.PhongBanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
public class PhongBanController {

    @Autowired
    LoaiPhongBanService loaiPhongBanService;

    @Autowired
    PhongBanService phongBanService;

    private Pageable pageable;

    @GetMapping("/phong-ban/hien-thi")
    public String hienThi(@ModelAttribute("phongBan") PhongBan phongBan, @RequestParam(defaultValue = "0", name = "page") Integer number, Model model) {
        Pageable pageable = PageRequest.of(number, 2);
        Page<PhongBan> listPB = phongBanService.getAll(pageable);
        List<LoaiPhongBan> listLPB = loaiPhongBanService.getAll();
        model.addAttribute("listLPB", listLPB);
        model.addAttribute("listPB", listPB);
        return "index";
    }

    @GetMapping("/phong-ban/detail/{id}")
    public String detail(@ModelAttribute("phongBan") PhongBan phongBan, @PathVariable("id") UUID id, Model model) {
        PhongBan pb = phongBanService.getOne(id);
        Pageable pageable = PageRequest.of(0, 2);
        Page<PhongBan> listPB = phongBanService.getAll(pageable);
        List<LoaiPhongBan> listLPB = loaiPhongBanService.getAll();
        model.addAttribute("listLPB", listLPB);
        model.addAttribute("listPB", listPB);
        model.addAttribute("phongBan", pb);
        return "index";
    }

    @GetMapping("/phong-ban/delete/{id}")
    public String delete(@ModelAttribute("phongBan") PhongBan phongBan, @PathVariable("id") UUID id, Model model) {
        phongBanService.delete(id);
        pageable = PageRequest.of(0, 2);
        Page<PhongBan> listPB = phongBanService.getAll(pageable);
        List<LoaiPhongBan> listLPB = loaiPhongBanService.getAll();
        model.addAttribute("listLPB", listLPB);
        model.addAttribute("listPB", listPB);
        return "index";
    }

    @PostMapping("/phong-ban/add")
    public String add(@ModelAttribute("phongBan") PhongBan phongBan, Model model) {
        phongBanService.add(phongBan);
        Pageable pageable = PageRequest.of(0, 2);
        Page<PhongBan> listPB = phongBanService.getAll(pageable);
        List<LoaiPhongBan> listLPB = loaiPhongBanService.getAll();
        model.addAttribute("listLPB", listLPB);
        model.addAttribute("listPB", listPB);
        return "index";
    }

    @GetMapping("/phong-ban/view-update/{id}")
    public String viewUpdate(@ModelAttribute("phongBan") PhongBan phongBan, @PathVariable("id") UUID id, Model model) {
        PhongBan pb = phongBanService.getOne(id);
        List<LoaiPhongBan> listLPB = loaiPhongBanService.getAll();
        model.addAttribute("listLPB", listLPB);
        model.addAttribute("phongBan", pb);
        return "update";
    }

    @PostMapping("/phong-ban/update/{id}")
    public String update(@ModelAttribute("phongBan") PhongBan phongBan, @PathVariable("id") UUID id, Model model) {
        LoaiPhongBan loaiPhongBan = loaiPhongBanService.getOne(phongBan.getLoaiPhongBan().getId());
        phongBan.setLoaiPhongBan(loaiPhongBan);
        phongBanService.update(phongBan);
        Pageable pageable = PageRequest.of(0, 2);
        Page<PhongBan> listPB = phongBanService.getAll(pageable);
        List<LoaiPhongBan> listLPB = loaiPhongBanService.getAll();
        model.addAttribute("listLPB", listLPB);
        model.addAttribute("listPB", listPB);
        return "index";
    }


    @GetMapping("/phong-ban/hoat-dong")
    public String hoatDong(@ModelAttribute("phongBan") PhongBan phongBan, Model model) {
        Pageable pageable = PageRequest.of(0, 2);
        Page<PhongBan> listPB = phongBanService.hoatDong(pageable);
        List<LoaiPhongBan> listLPB = loaiPhongBanService.getAll();
        model.addAttribute("listLPB", listLPB);
        model.addAttribute("listPB", listPB);
        return "index";
    }

    @GetMapping("/phong-ban/sap-xep")
    public String sapXep(@ModelAttribute("phongBan") PhongBan phongBan, Model model) {
        Pageable pageable = PageRequest.of(0, 2);
        Page<PhongBan> listPB = phongBanService.sapXep(pageable);
        List<LoaiPhongBan> listLPB = loaiPhongBanService.getAll();
        model.addAttribute("listLPB", listLPB);
        model.addAttribute("listPB", listPB);
        return "index";
    }


    @GetMapping("/phong-ban/search")
    public String search(@ModelAttribute("phongBan") PhongBan phongBan,
                         @RequestParam("ten") String ten,
                         @RequestParam(defaultValue = "0", name = "page") Integer number,
                         Model model) {

        Sort sort = Sort.by("ten").descending();
        Pageable pageable = PageRequest.of(number, 2,sort);
        Page<PhongBan> listPB = phongBanService.searchTen(ten, pageable);
        model.addAttribute("listPB", listPB);
        return "index";
    }

//    @GetMapping("/phong-ban/search")
//    public String search(@ModelAttribute("phongBan") PhongBan phongBan,
//                         @RequestParam("min") int min, @RequestParam("max") int max,
//                         @RequestParam(defaultValue = "0", name = "page") Integer number,
//                         Model model) {
//
//        Pageable pageable = PageRequest.of(number, 2);
//        Page<PhongBan> listPB = phongBanService.minMax(min,max, pageable);
//        model.addAttribute("listPB", listPB);
//        return "index";
//    }
}
