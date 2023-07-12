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

    @GetMapping("tai-khoan/hien-thi")
    public String hienThi(@ModelAttribute("taiKhoan") TaiKhoan taiKhoan,
                          @RequestParam(defaultValue = "0") Integer page, Model model) {
        Pageable pageable = PageRequest.of(page, 2);
        Page<TaiKhoan> listTaiKhoan = taiKhoanService.getAll(pageable);
        List<ChucVu> listChucVu = chucVuService.getAll();
        model.addAttribute("listTaiKhoan", listTaiKhoan);
        model.addAttribute("listChucVu", listChucVu);
        return "index";
    }

    @GetMapping("tai-khoan/detail/{id}")
    public String detail(@ModelAttribute("taiKhoan") TaiKhoan taiKhoan,
                         @RequestParam(defaultValue = "0") Integer page,
                         @PathVariable("id") UUID id, Model model) {
        TaiKhoan tk = taiKhoanService.getOne(id);
        Pageable pageable = PageRequest.of(page, 2);
        Page<TaiKhoan> listTaiKhoan = taiKhoanService.getAll(pageable);
        List<ChucVu> listChucVu = chucVuService.getAll();
        model.addAttribute("listTaiKhoan", listTaiKhoan);
        model.addAttribute("listChucVu", listChucVu);
        model.addAttribute("taiKhoan", tk);
        return "index";
    }

    @GetMapping("tai-khoan/delete/{id}")
    public String delete(@ModelAttribute("taiKhoan") TaiKhoan taiKhoan,
                         @RequestParam(defaultValue = "0") Integer page,
                         @PathVariable("id") UUID id, Model model) {
        taiKhoanService.delete(id);
        Pageable pageable = PageRequest.of(page, 2);
        Page<TaiKhoan> listTaiKhoan = taiKhoanService.getAll(pageable);
        List<ChucVu> listChucVu = chucVuService.getAll();
        model.addAttribute("listTaiKhoan", listTaiKhoan);
        model.addAttribute("listChucVu", listChucVu);
        model.addAttribute("mess", "delete thanh cong");
        return "index";
    }

    @PostMapping("tai-khoan/add")
    public String add(@Valid @ModelAttribute("taiKhoan") TaiKhoan taiKhoan, BindingResult result,
                      @RequestParam(defaultValue = "0") Integer page, Model model) {
        if (result.hasErrors()) {
            Pageable pageable = PageRequest.of(page, 2);
            Page<TaiKhoan> listTaiKhoan = taiKhoanService.getAll(pageable);
            List<ChucVu> listChucVu = chucVuService.getAll();
            model.addAttribute("listTaiKhoan", listTaiKhoan);
            model.addAttribute("listChucVu", listChucVu);
            return "index";
        }
        taiKhoanService.add(taiKhoan);
        Pageable pageable = PageRequest.of(page, 2);
        Page<TaiKhoan> listTaiKhoan = taiKhoanService.getAll(pageable);
        List<ChucVu> listChucVu = chucVuService.getAll();
        model.addAttribute("listTaiKhoan", listTaiKhoan);
        model.addAttribute("listChucVu", listChucVu);
        model.addAttribute("mess", "add thanh cong");
        return "index";
    }


    @GetMapping("tai-khoan/view-update/{id}")
    public String viewUpdate(@ModelAttribute("taiKhoan") TaiKhoan taiKhoan,
                             @RequestParam(defaultValue = "0") Integer page,
                             @PathVariable("id") UUID id, Model model) {
        TaiKhoan tk = taiKhoanService.getOne(id);
        Pageable pageable = PageRequest.of(page, 2);
        Page<TaiKhoan> listTaiKhoan = taiKhoanService.getAll(pageable);
        List<ChucVu> listChucVu = chucVuService.getAll();
        model.addAttribute("listTaiKhoan", listTaiKhoan);
        model.addAttribute("listChucVu", listChucVu);
        model.addAttribute("taiKhoan", tk);
        return "update";
    }

    @PostMapping("tai-khoan/update/{id}")
    public String add(@Valid @ModelAttribute("taiKhoan") TaiKhoan taiKhoan, BindingResult result,
                      @RequestParam(defaultValue = "0") Integer page, Model model,
                      @PathVariable("id") UUID id) {
        if (result.hasErrors()) {
            List<ChucVu> listChucVu = chucVuService.getAll();
            model.addAttribute("listChucVu", listChucVu);
            return "update";
        }
        ChucVu chucVu = chucVuService.getOne(taiKhoan.getChucVu().getId());
        taiKhoan.setChucVu(chucVu);
        taiKhoanService.update(taiKhoan);
        Pageable pageable = PageRequest.of(page, 2);
        Page<TaiKhoan> listTaiKhoan = taiKhoanService.getAll(pageable);
        List<ChucVu> listChucVu = chucVuService.getAll();
        model.addAttribute("listTaiKhoan", listTaiKhoan);
        model.addAttribute("listChucVu", listChucVu);
        model.addAttribute("mess", "update thanh cong");
        return "index";
    }


    @GetMapping("tai-khoan/search")
    public String search(@ModelAttribute("taiKhoan") TaiKhoan taiKhoan,
                         @RequestParam(defaultValue = "0") Integer page,
                         @RequestParam("toDate") String toDate, @RequestParam("endDate") String endDate,
                         Model model) {
        Pageable pageable = PageRequest.of(page, 2);
        Page<TaiKhoan> listTaiKhoan = taiKhoanService.search(toDate, endDate, pageable);
        List<ChucVu> listChucVu = chucVuService.getAll();
        model.addAttribute("listTaiKhoan", listTaiKhoan);
        model.addAttribute("listChucVu", listChucVu);
        return "index";
    }
}
