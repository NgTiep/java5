package com.example.btvn13.controller;

import com.example.btvn13.entity.CoSo;
import com.example.btvn13.entity.TaiKhoanNganHang;
import com.example.btvn13.service.CoSoService;
import com.example.btvn13.service.TaiKhoanNganHangService;
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

    @GetMapping("/co-so/hien-thi")
    public String hienThi(@RequestParam(defaultValue = "0") Integer number, Model model) {
        Pageable pageable = PageRequest.of(number, 3);
        Page<CoSo> listCoSon = coSoService.getAll(pageable);
        model.addAttribute("listCoSo", listCoSon);
        return "index";
    }

    @GetMapping("/co-so/delete/{id}")
    public String delete(@PathVariable("id") UUID id, Model model) {
        coSoService.delete(id);
        Pageable pageable = PageRequest.of(0, 3);
        Page<CoSo> listCoSon = coSoService.getAll(pageable);
        model.addAttribute("listCoSo", listCoSon);
        model.addAttribute("mess","delete thanh cong");

        return "index";
    }

    @GetMapping("/co-so/detail/{id}")
    public String detail(@ModelAttribute("coSo") CoSo coSo, @PathVariable("id") UUID id, Model model) {
        CoSo cs = coSoService.getOne(id);
        List<TaiKhoanNganHang> listTKNH = taiKhoanNganHangService.getAll();
        model.addAttribute("coSo", cs);
        Pageable pageable = PageRequest.of(0, 3);
        Page<CoSo> listCoSon = coSoService.getAll(pageable);
        model.addAttribute("listCoSo", listCoSon);
        model.addAttribute("listTKNH", listTKNH);
        return "add";
    }


    @GetMapping("/co-so/view-add")
    public String viewAdd(@ModelAttribute("coSo") CoSo coSo, Model model) {
        List<TaiKhoanNganHang> listTKNH = taiKhoanNganHangService.getAll();
        Pageable pageable = PageRequest.of(0, 3);
        Page<CoSo> listCoSon = coSoService.getAll(pageable);
        model.addAttribute("listCoSo", listCoSon);
        model.addAttribute("listTKNH", listTKNH);
        return "add";
    }

    @PostMapping("/co-so/add")
    public String add(@Valid @ModelAttribute("coSo") CoSo coSo,
                      BindingResult result,
                      @RequestParam("ma") String ma, Model model) {
        if (result.hasErrors()) {
            List<TaiKhoanNganHang> listTKNH = taiKhoanNganHangService.getAll();
            model.addAttribute("listTKNH", listTKNH);
            return "add";
        }
            coSoService.add(coSo);
            List<TaiKhoanNganHang> listTKNH = taiKhoanNganHangService.getAll();
            Pageable pageable = PageRequest.of(0, 3);
            Page<CoSo> listCoSon = coSoService.getAll(pageable);
            model.addAttribute("listCoSo", listCoSon);
            model.addAttribute("listTKNH", listTKNH);
            model.addAttribute("mess","add thanh cong");
            return "index";
    }

    @GetMapping("/co-so/view-update/{id}")
    public String viewUpdate(@ModelAttribute("coSo") CoSo coSo, @PathVariable("id") UUID id, Model model) {
        CoSo cs = coSoService.getOne(id);
        List<TaiKhoanNganHang> listTKNH = taiKhoanNganHangService.getAll();
        model.addAttribute("coSo", cs);
        Pageable pageable = PageRequest.of(0, 3);
        Page<CoSo> listCoSon = coSoService.getAll(pageable);
        model.addAttribute("listCoSo", listCoSon);
        model.addAttribute("listTKNH", listTKNH);
        return "update";
    }


    @PostMapping("/co-so/update/{id}")
    public String update(@Valid @ModelAttribute("coSo") CoSo coSo,
                         BindingResult result,
                         @PathVariable("id") UUID id,
                         @RequestParam("ma") String ma, Model model) {
        if (result.hasErrors()) {
            List<TaiKhoanNganHang> listTKNH = taiKhoanNganHangService.getAll();
            model.addAttribute("listTKNH", listTKNH);
            return "update";
        }
        TaiKhoanNganHang taiKhoanNganHang = taiKhoanNganHangService.getOne(coSo.getTaiKhoanNganHang().getId());
        coSo.setTaiKhoanNganHang(taiKhoanNganHang);
        coSoService.update(coSo);
        List<TaiKhoanNganHang> listTKNH = taiKhoanNganHangService.getAll();
        Pageable pageable = PageRequest.of(0, 3);
        Page<CoSo> listCoSon = coSoService.getAll(pageable);
        model.addAttribute("listCoSo", listCoSon);
        model.addAttribute("listTKNH", listTKNH);
        model.addAttribute("mess","update thanh cong");

        return "index";
    }
}
