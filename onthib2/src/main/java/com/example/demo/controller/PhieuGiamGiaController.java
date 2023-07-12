package com.example.demo.controller;


import com.example.demo.entity.KhachHang;
import com.example.demo.entity.PhieuGiamGia;
import com.example.demo.service.KhachHangService;
import com.example.demo.service.PhieuGiamGiaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PhieuGiamGiaController {

    @Autowired
    KhachHangService khachHangService;

    @Autowired
    PhieuGiamGiaService phieuGiamGiaService;

    @GetMapping("phieugiamgia/hien-thi")
    public String hienThi(@ModelAttribute("phieuGiamGia") PhieuGiamGia phieuGiamGia,
                          @RequestParam(defaultValue = "0") Integer page, Model model) {
        Pageable pageable = PageRequest.of(page, 3);
        Page<PhieuGiamGia> listPGG = phieuGiamGiaService.getAll(pageable);
        List<KhachHang> listKH = khachHangService.getAll();
        model.addAttribute("listPGG", listPGG);
        model.addAttribute("listKH", listKH);
        return "index";
    }

//    @GetMapping("phieu-giam-gia/detail/{maPhieu}")
//    public String detail(@ModelAttribute("phieuGiamGia") PhieuGiamGia phieuGiamGia,
//                         @RequestParam(defaultValue = "0") Integer page, Model model,
//                         @PathVariable("maPhieu") String maPhieu) {
//        PhieuGiamGia pgg = phieuGiamGiaService.getOne(maPhieu);
//        Pageable pageable = PageRequest.of(page, 3);
//        Page<PhieuGiamGia> listPGG = phieuGiamGiaService.getAll(pageable);
//        List<KhachHang> listKH = khachHangService.getAll();
//        model.addAttribute("listPGG", listPGG);
//        model.addAttribute("listKH", listKH);
//        model.addAttribute("phieuGiamGia", pgg);
//        return "index";
//    }
//
//
//    @GetMapping("phieu-giam-gia/delete/{maPhieu}")
//    public String delete(@ModelAttribute("phieuGiamGia") PhieuGiamGia phieuGiamGia,
//                         @RequestParam(defaultValue = "0") Integer page, Model model,
//                         @PathVariable("maPhieu") String maPhieu) {
//        phieuGiamGiaService.delete(maPhieu);
//        Pageable pageable = PageRequest.of(page, 3);
//        Page<PhieuGiamGia> listPGG = phieuGiamGiaService.getAll(pageable);
//        List<KhachHang> listKH = khachHangService.getAll();
//        model.addAttribute("listPGG", listPGG);
//        model.addAttribute("listKH", listKH);
//        model.addAttribute("mess", "delete thanh cong");
//        return "index";
//    }
//
//    @PostMapping("phieu-giam-gia/add")
//    public String add(@Valid @ModelAttribute("phieuGiamGia") PhieuGiamGia phieuGiamGia,
//                      BindingResult result, @RequestParam(defaultValue = "0") Integer page, Model model) {
//        if (result.hasErrors()) {
//            Pageable pageable = PageRequest.of(page, 3);
//            Page<PhieuGiamGia> listPGG = phieuGiamGiaService.getAll(pageable);
//            List<KhachHang> listKH = khachHangService.getAll();
//            model.addAttribute("listPGG", listPGG);
//            model.addAttribute("listKH", listKH);
//            return "index";
//        }
//        phieuGiamGiaService.add(phieuGiamGia);
//        Pageable pageable = PageRequest.of(page, 3);
//        Page<PhieuGiamGia> listPGG = phieuGiamGiaService.getAll(pageable);
//        List<KhachHang> listKH = khachHangService.getAll();
//        model.addAttribute("listPGG", listPGG);
//        model.addAttribute("listKH", listKH);
//        model.addAttribute("mess", "add thanh cong");
//        return "index";
//    }
//
//    @GetMapping("phieu-giam-gia/view-update/{maPhieu}")
//    public String viewUpdate(@ModelAttribute("phieuGiamGia") PhieuGiamGia phieuGiamGia,
//                             @RequestParam(defaultValue = "0") Integer page, Model model,
//                             @PathVariable("maPhieu") String maPhieu) {
//        PhieuGiamGia pgg = phieuGiamGiaService.getOne(maPhieu);
//        Pageable pageable = PageRequest.of(page, 3);
//        Page<PhieuGiamGia> listPGG = phieuGiamGiaService.getAll(pageable);
//        List<KhachHang> listKH = khachHangService.getAll();
//        model.addAttribute("listPGG", listPGG);
//        model.addAttribute("listKH", listKH);
//        model.addAttribute("phieuGiamGia", pgg);
//        return "update";
//    }
//
//    @PostMapping("phieu-giam-gia/update/{maPhieu}")
//    public String update(@Valid @ModelAttribute("phieuGiamGia") PhieuGiamGia phieuGiamGia,
//                         BindingResult result, @RequestParam(defaultValue = "0") Integer page,
//                         Model model, @PathVariable("maPhieu") String maPhieu) {
//        if (result.hasErrors()) {
//            Pageable pageable = PageRequest.of(page, 3);
//            Page<PhieuGiamGia> listPGG = phieuGiamGiaService.getAll(pageable);
//            List<KhachHang> listKH = khachHangService.getAll();
//            model.addAttribute("listPGG", listPGG);
//            model.addAttribute("listKH", listKH);
//            return "update";
//        }
//        phieuGiamGiaService.update(phieuGiamGia);
//        Pageable pageable = PageRequest.of(page, 3);
//        Page<PhieuGiamGia> listPGG = phieuGiamGiaService.getAll(pageable);
//        List<KhachHang> listKH = khachHangService.getAll();
//        model.addAttribute("listPGG", listPGG);
//        model.addAttribute("listKH", listKH);
//        model.addAttribute("mess", "update thanh cong");
//        return "index";
//    }

    @GetMapping("phieugiamgia/search")
    public String search(@ModelAttribute("phieuGiamGia") PhieuGiamGia phieuGiamGia,
                         @RequestParam(defaultValue = "0") Integer page, Model model,
                         @RequestParam("tuNgay") String tuNgay,
                         @RequestParam("denNgay") String denNgay,
                         @RequestParam("khachHang") KhachHang khachHang) {

        Pageable pageable = PageRequest.of(page, Integer.MAX_VALUE);
        Page<PhieuGiamGia> listPGG = phieuGiamGiaService.search(tuNgay, denNgay, khachHang, pageable);
        List<KhachHang> listKH = khachHangService.getAll();
        model.addAttribute("listPGG", listPGG);
        model.addAttribute("listKH", listKH);
        return "index";
    }

}
