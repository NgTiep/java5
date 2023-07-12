package com.example.btvn.controller;

import com.example.btvn.entity.LoaiPhongBan;
import com.example.btvn.entity.PhongBan;
import com.example.btvn.service.LoaiPhongBanService;
import com.example.btvn.service.PhongBanService;
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
public class PhongBanController {

    @Autowired
    PhongBanService phongBanService;

    @Autowired
    LoaiPhongBanService loaiPhongBanService;

    private Page<PhongBan> listPhongBan;

    @GetMapping("/phong-ban/hien-thi")
    public String hienThiTatCa(@ModelAttribute("phongBan") PhongBan phongBan, @RequestParam(defaultValue = "0", name = "page") Integer number, Model model) {
        Pageable pageable = PageRequest.of(number, 5);
        Page<PhongBan> listPhongBan = phongBanService.getAll(pageable);
        List<LoaiPhongBan> listLoaiPhongBan = loaiPhongBanService.getAll();
        model.addAttribute("listPhongBan", listPhongBan);
        model.addAttribute("listLoaiPhongBan", listLoaiPhongBan);
        return "index";
    }


    @PostMapping("/phong-ban/add")
    public String add(@Valid @ModelAttribute("phongBan") PhongBan phongBan,
                      BindingResult result, @RequestParam("ma") String ma, Model model) {
        if (result.hasErrors()) {
            Pageable pageable = PageRequest.of(0, 5);
            listPhongBan = phongBanService.getAll(pageable);
            List<LoaiPhongBan> listLoaiPhongBan = loaiPhongBanService.getAll();
            model.addAttribute("listPhongBan", listPhongBan);
            model.addAttribute("listLoaiPhongBan", listLoaiPhongBan);
        } else if (phongBan.getMa() == ma) {
            model.addAttribute("mess", "ma khong dc trung");
            Pageable pageable = PageRequest.of(0, 5);
            listPhongBan = phongBanService.getAll(pageable);
            List<LoaiPhongBan> listLoaiPhongBan = loaiPhongBanService.getAll();
            model.addAttribute("listPhongBan", listPhongBan);
            model.addAttribute("listLoaiPhongBan", listLoaiPhongBan);
        }else{
            phongBanService.add(phongBan);
            Pageable pageable = PageRequest.of(0, 5);
            Page<PhongBan> listPhongBan = phongBanService.getAll(pageable);
            List<LoaiPhongBan> listLoaiPhongBan = loaiPhongBanService.getAll();
            model.addAttribute("listPhongBan", listPhongBan);
            model.addAttribute("listLoaiPhongBan", listLoaiPhongBan);
            model.addAttribute("mess", "add thành công");
        }
        return "index";
    }

    @GetMapping("/phong-ban/detail/{id}")
    public String detail(@ModelAttribute("phongBan") PhongBan phongBan, @PathVariable("id") UUID id, Model model) {
        PhongBan pb = phongBanService.getOne(id);
        model.addAttribute("phongBan", pb);
        Pageable pageable = PageRequest.of(0, 5);
        Page<PhongBan> listPhongBan = phongBanService.getAll(pageable);
        List<LoaiPhongBan> listLoaiPhongBan = loaiPhongBanService.getAll();
        model.addAttribute("listPhongBan", listPhongBan);
        model.addAttribute("listLoaiPhongBan", listLoaiPhongBan);
        return "index";
    }

    @GetMapping("/phong-ban/delete/{id}")
    public String delete(@ModelAttribute("phongBan") PhongBan phongBan, @PathVariable("id") UUID id, Model model) {
        phongBanService.delete(id);
        Pageable pageable = PageRequest.of(0, 5);
        Page<PhongBan> listPhongBan = phongBanService.getAll(pageable);
        List<LoaiPhongBan> listLoaiPhongBan = loaiPhongBanService.getAll();
        model.addAttribute("listPhongBan", listPhongBan);
        model.addAttribute("listLoaiPhongBan", listLoaiPhongBan);
        model.addAttribute("mess", "delete thành công");

        return "index";
    }

    @GetMapping("/phong-ban/view-update/{id}")
    public String viewUpdate(@ModelAttribute("phongBan") PhongBan phongBan, @PathVariable("id") UUID id, Model model) {
        PhongBan pb = phongBanService.getOne(id);
        model.addAttribute("phongBan", pb);
        List<LoaiPhongBan> listLoaiPhongBan = loaiPhongBanService.getAll();
        model.addAttribute("listLoaiPhongBan", listLoaiPhongBan);
        return "update";
    }


    @PostMapping("/phong-ban/update/{id}")
    public String add(@Valid @ModelAttribute("phongBan") PhongBan phongBan, BindingResult result, @PathVariable("id") UUID id, Model model) {
       if(result.hasErrors()){
           List<LoaiPhongBan> listLoaiPhongBan = loaiPhongBanService.getAll();
           model.addAttribute("listLoaiPhongBan", listLoaiPhongBan);
           return "update";
       }
        LoaiPhongBan loaiPhongBan = loaiPhongBanService.getOne(phongBan.getLoaiPhongBan().getId());
        phongBan.setLoaiPhongBan(loaiPhongBan);
        phongBanService.update(phongBan);
        Pageable pageable = PageRequest.of(0, 5);
        Page<PhongBan> listPhongBan = phongBanService.getAll(pageable);
        List<LoaiPhongBan> listLoaiPhongBan = loaiPhongBanService.getAll();
        model.addAttribute("listPhongBan", listPhongBan);
        model.addAttribute("listLoaiPhongBan", listLoaiPhongBan);
        model.addAttribute("mess", "update thành công");
        return "index";
    }
}
