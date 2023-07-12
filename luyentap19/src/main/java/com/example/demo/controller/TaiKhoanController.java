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
    public String hienThi(@ModelAttribute("taiKhoan") TaiKhoan taiKhoan, Model model, @RequestParam(defaultValue = "0") Integer page) {
        Pageable pageable = PageRequest.of(page, 2);
        Page<TaiKhoan> listTaiKhoan = taiKhoanService.getAll(pageable);
        List<ChucVu> listChucVu = chucVuService.getAll();
        model.addAttribute("listTaiKhoan", listTaiKhoan);
        model.addAttribute("listChucVu", listChucVu);
        return "index";
    }

    @GetMapping("/tai-khoan/detail/{id}")
    public String detail(@ModelAttribute("taiKhoan") TaiKhoan taiKhoan, Model model,
                         @RequestParam(defaultValue = "0") Integer page, @PathVariable("id") UUID id) {
        TaiKhoan tk = taiKhoanService.getOne(id);
        Pageable pageable = PageRequest.of(page, 2);
        Page<TaiKhoan> listTaiKhoan = taiKhoanService.getAll(pageable);
        List<ChucVu> listChucVu = chucVuService.getAll();
        model.addAttribute("listTaiKhoan", listTaiKhoan);
        model.addAttribute("listChucVu", listChucVu);
        model.addAttribute("taiKhoan", tk);
        return "index";
    }


    @GetMapping("/tai-khoan/delete/{id}")
    public String detail(@ModelAttribute("taiKhoan") TaiKhoan taiKhoan,
                         @PathVariable("id") UUID id, Model model, @RequestParam(defaultValue = "0") Integer page ) {

        taiKhoanService.delete(id);
        Pageable pageable = PageRequest.of(page, 2);
        Page<TaiKhoan> listTaiKhoan = taiKhoanService.getAll(pageable);
        List<ChucVu> listChucVu = chucVuService.getAll();
        model.addAttribute("listTaiKhoan", listTaiKhoan);
        model.addAttribute("listChucVu", listChucVu);
        model.addAttribute("mess","Xóa thành công");
        return "index";
    }

    @PostMapping("/tai-khoan/add")
    public String add(@Valid @ModelAttribute("taiKhoan") TaiKhoan taiKhoan, BindingResult result, Model model,
                      @RequestParam(defaultValue = "0") Integer page) {
        if (result.hasErrors()) {
            Pageable pageable = PageRequest.of(page, 2);
            Page<TaiKhoan> listTaiKhoan = taiKhoanService.getAll(pageable);
            List<ChucVu> listChucVu = chucVuService.getAll();
            model.addAttribute("listTaiKhoan", listTaiKhoan);
            model.addAttribute("listChucVu", listChucVu);
            return "index";
        }
        Pageable pageable = PageRequest.of(page, 2);
        Page<TaiKhoan> listTaiKhoan = taiKhoanService.getAll(pageable);
        List<ChucVu> listChucVu = chucVuService.getAll();
        model.addAttribute("listTaiKhoan", listTaiKhoan);
        model.addAttribute("listChucVu", listChucVu);
        taiKhoanService.add(taiKhoan);
        model.addAttribute("mess","Thêm thành công");
        return "index";
    }

    @GetMapping("/tai-khoan/search")
    public String search(@ModelAttribute("taiKhoan") TaiKhoan taiKhoan, Model model, @RequestParam(defaultValue = "0") Integer page, @RequestParam("tenTaiKhoan") String tenTaiKhoan) {
        Pageable pageable = PageRequest.of(page, 2);
        Page<TaiKhoan> listTaiKhoan = taiKhoanService.search(tenTaiKhoan, pageable);
        List<ChucVu> listChucVu = chucVuService.getAll();
        model.addAttribute("listTaiKhoan", listTaiKhoan);
        model.addAttribute("listChucVu", listChucVu);
        return "index";
    }

    @GetMapping("/tai-khoan/view-update/{id}")
    public String viewUpdate(@ModelAttribute("taiKhoan") TaiKhoan taiKhoan, Model model,
                         @RequestParam(defaultValue = "0") Integer page, @PathVariable("id") UUID id) {
        TaiKhoan tk = taiKhoanService.getOne(id);
        Pageable pageable = PageRequest.of(page, 2);
        Page<TaiKhoan> listTaiKhoan = taiKhoanService.getAll(pageable);
        List<ChucVu> listChucVu = chucVuService.getAll();
        model.addAttribute("listTaiKhoan", listTaiKhoan);
        model.addAttribute("listChucVu", listChucVu);
        model.addAttribute("taiKhoan", tk);
        return "update";
    }


    @PostMapping("/tai-khoan/update/{id}")
    public String add(@Valid @ModelAttribute("taiKhoan") TaiKhoan taiKhoan, BindingResult result, Model model,
                      @RequestParam(defaultValue = "0") Integer page,@PathVariable("id") UUID id) {
        if (result.hasErrors()) {
            Pageable pageable = PageRequest.of(page, 2);
            Page<TaiKhoan> listTaiKhoan = taiKhoanService.getAll(pageable);
            List<ChucVu> listChucVu = chucVuService.getAll();
            model.addAttribute("listTaiKhoan", listTaiKhoan);
            model.addAttribute("listChucVu", listChucVu);
            return "update";
        }
        Pageable pageable = PageRequest.of(page, 2);
        Page<TaiKhoan> listTaiKhoan = taiKhoanService.getAll(pageable);
        List<ChucVu> listChucVu = chucVuService.getAll();
        model.addAttribute("listTaiKhoan", listTaiKhoan);
        model.addAttribute("listChucVu", listChucVu);
        ChucVu chucVu = chucVuService.getOne(taiKhoan.getChucVu().getId());
        taiKhoan.setChucVu(chucVu);
        taiKhoanService.update(taiKhoan);
        model.addAttribute("mess","Sửa thành công");
        return "index";
    }
}
