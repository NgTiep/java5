package com.example.demo.controller;

import com.example.demo.entity.CoSo;
import com.example.demo.entity.TaiKhoanNganHang;
import com.example.demo.service.CoSoService;
import com.example.demo.service.TaiKhoanNganHangService;
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
public class CoSoController {

    @Autowired
    CoSoService coSoService;

    @Autowired
    TaiKhoanNganHangService taiKhoanNganHangService;

    private Pageable pageable;

    @GetMapping("/co-so/hien-thi")
    public String hienThi(@ModelAttribute("coSo") CoSo coSo, @RequestParam(defaultValue = "0") Integer number, Model model) {
        Pageable pageable = PageRequest.of(number, 2);
        Page<CoSo> listCoSo = coSoService.getAll(pageable);
        Page<TaiKhoanNganHang> listTKNH = taiKhoanNganHangService.getAll(pageable);
        model.addAttribute("listCoSo", listCoSo);
        model.addAttribute("listTKNH", listTKNH);
        return "index";
    }


    @GetMapping("/co-so/delete/{id}")
    public String delete(@ModelAttribute("coSo") CoSo coSo, @PathVariable("id") UUID id, Model model) {
        coSoService.delete(id);
        Pageable pageable = PageRequest.of(0, 2);
        Page<CoSo> listCoSo = coSoService.getAll(pageable);
        Page<TaiKhoanNganHang> listTKNH = taiKhoanNganHangService.getAll(pageable);
        model.addAttribute("listCoSo", listCoSo);
        model.addAttribute("listTKNH", listTKNH);
        return "index";
    }


    @GetMapping("/co-so/detail/{id}")
    public String detail(@ModelAttribute("coSo") CoSo coSo, @PathVariable("id") UUID id, Model model) {
        CoSo cs = coSoService.getOne(id);
        Pageable pageable = PageRequest.of(0, 2);
        Page<CoSo> listCoSo = coSoService.getAll(pageable);
        Page<TaiKhoanNganHang> listTKNH = taiKhoanNganHangService.getAll(pageable);
        model.addAttribute("listCoSo", listCoSo);
        model.addAttribute("listTKNH", listTKNH);
        model.addAttribute("coSo", cs);
        return "index";
    }

    @PostMapping("/co-so/add")
    public String add(@Valid @ModelAttribute("coSo") CoSo coSo, BindingResult result, Model model) {
        if(result.hasErrors()){
            Pageable pageable = PageRequest.of(0, 2);
            Page<CoSo> listCoSo = coSoService.getAll(pageable);
            Page<TaiKhoanNganHang> listTKNH = taiKhoanNganHangService.getAll(pageable);
            model.addAttribute("listCoSo", listCoSo);
            model.addAttribute("listTKNH", listTKNH);
            return "index";
        }
        coSoService.add(coSo);
        pageable = PageRequest.of(0, 2);
        Page<CoSo> listCoSo = coSoService.getAll(pageable);
        Page<TaiKhoanNganHang> listTKNH = taiKhoanNganHangService.getAll(pageable);
        model.addAttribute("listCoSo", listCoSo);
        model.addAttribute("listTKNH", listTKNH);
        return "index";
    }


    @GetMapping("/co-so/view-update/{id}")
    public String viewUpdate(@ModelAttribute("coSo") CoSo coSo, @PathVariable("id") UUID id, Model model) {
        CoSo cs = coSoService.getOne(id);
        Page<TaiKhoanNganHang> listTKNH = taiKhoanNganHangService.getAll(pageable);
        model.addAttribute("listTKNH", listTKNH);
        model.addAttribute("coSo", cs);
        return "update";
    }


    @PostMapping("/co-so/update/{id}")
    public String update(@Valid @ModelAttribute("coSo") CoSo coSo, BindingResult result, Model model) {
        if(result.hasErrors()){
            Page<TaiKhoanNganHang> listTKNH = taiKhoanNganHangService.getAll(pageable);
            model.addAttribute("listTKNH", listTKNH);
            return "update";
        }
        TaiKhoanNganHang taiKhoanNganHang = taiKhoanNganHangService.getOne(coSo.getTaiKhoanNganHang().getId());
        coSo.setTaiKhoanNganHang(taiKhoanNganHang);
        coSoService.update(coSo);
        pageable = PageRequest.of(0, 2);
        Page<CoSo> listCoSo = coSoService.getAll(pageable);
        Page<TaiKhoanNganHang> listTKNH = taiKhoanNganHangService.getAll(pageable);
        model.addAttribute("listCoSo", listCoSo);
        model.addAttribute("listTKNH", listTKNH);
        return "index";
    }
}
