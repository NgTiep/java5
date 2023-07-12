package com.demo.controller;


import com.demo.entity.KhachHang;
import com.demo.entity.PhieuGiamGia;
import com.demo.service.KhachHangService;
import com.demo.service.PhieuGiamGiaService;
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

import javax.validation.Valid;
import java.util.List;

@Controller
public class PhieuGiamGiaController {

    @Autowired
    PhieuGiamGiaService phieuGiamGiaService;

    @Autowired
    KhachHangService khachHangService;

    @GetMapping("/phieu-giam-gia/hien-thi")
    public String hienThi(@ModelAttribute("phieuGiamGia") PhieuGiamGia phieuGiamGia,
                          @RequestParam(defaultValue = "0") Integer page, Model model) {
        Pageable pageable = PageRequest.of(page, 3);
        Page<PhieuGiamGia> listPGG = phieuGiamGiaService.getAll(pageable);
        List<KhachHang> listKH = khachHangService.getAll();
        model.addAttribute("listPGG", listPGG);
        model.addAttribute("listKH", listKH);
        return "index";
    }


    @GetMapping("/phieu-giam-gia/delete/{maphieu}")
    public String delete(@ModelAttribute("phieuGiamGia") PhieuGiamGia phieuGiamGia,
                         @RequestParam(defaultValue = "0") Integer page, Model model,
                         @PathVariable("maphieu") String maphieu) {
        phieuGiamGiaService.delete(maphieu);
        Pageable pageable = PageRequest.of(page, 3);
        Page<PhieuGiamGia> listPGG = phieuGiamGiaService.getAll(pageable);
        List<KhachHang> listKH = khachHangService.getAll();
        model.addAttribute("listPGG", listPGG);
        model.addAttribute("listKH", listKH);
        model.addAttribute("mess", "Xóa thành công");
        return "index";
    }


    @GetMapping("/phieu-giam-gia/detail/{maphieu}")
    public String detail(@ModelAttribute("phieuGiamGia") PhieuGiamGia phieuGiamGia,
                         @RequestParam(defaultValue = "0") Integer page, Model model,
                         @PathVariable("maphieu") String maphieu) {
        PhieuGiamGia pgg = phieuGiamGiaService.getOne(maphieu);
        Pageable pageable = PageRequest.of(page, 3);
        Page<PhieuGiamGia> listPGG = phieuGiamGiaService.getAll(pageable);
        List<KhachHang> listKH = khachHangService.getAll();
        model.addAttribute("listPGG", listPGG);
        model.addAttribute("listKH", listKH);
        model.addAttribute("phieuGiamGia", pgg);
        return "index";
    }


    @PostMapping("/phieu-giam-gia/add")
    public String add(@Valid @ModelAttribute("phieuGiamGia") PhieuGiamGia phieuGiamGia, BindingResult result,
                      @RequestParam(defaultValue = "0") Integer page, Model model) {
        if (result.hasErrors()) {
            Pageable pageable = PageRequest.of(page, 3);
            Page<PhieuGiamGia> listPGG = phieuGiamGiaService.getAll(pageable);
            List<KhachHang> listKH = khachHangService.getAll();
            model.addAttribute("listPGG", listPGG);
            model.addAttribute("listKH", listKH);
            return "index";
        }
        phieuGiamGiaService.add(phieuGiamGia);
        Pageable pageable = PageRequest.of(page, 3);
        Page<PhieuGiamGia> listPGG = phieuGiamGiaService.getAll(pageable);
        List<KhachHang> listKH = khachHangService.getAll();
        model.addAttribute("listPGG", listPGG);
        model.addAttribute("listKH", listKH);
        model.addAttribute("mess", "Thêm thành công");
        return "index";
    }

    @GetMapping("/phieu-giam-gia/view-update/{maphieu}")
    public String viewUpdate(@ModelAttribute("phieuGiamGia") PhieuGiamGia phieuGiamGia,
                             @RequestParam(defaultValue = "0") Integer page, Model model,
                             @PathVariable("maphieu") String maphieu) {
        PhieuGiamGia pgg = phieuGiamGiaService.getOne(maphieu);
        Pageable pageable = PageRequest.of(page, 3);
        Page<PhieuGiamGia> listPGG = phieuGiamGiaService.getAll(pageable);
        List<KhachHang> listKH = khachHangService.getAll();
        model.addAttribute("listPGG", listPGG);
        model.addAttribute("listKH", listKH);
        model.addAttribute("phieuGiamGia", pgg);
        return "update";
    }


    @PostMapping("/phieu-giam-gia/update/{maphieu}")
    public String update(@Valid @ModelAttribute("phieuGiamGia") PhieuGiamGia phieuGiamGia, BindingResult result,
                         @RequestParam(defaultValue = "0") Integer page, Model model, @PathVariable("maphieu") String maphieu) {
        if (result.hasErrors()) {
            Pageable pageable = PageRequest.of(page, 3);
            Page<PhieuGiamGia> listPGG = phieuGiamGiaService.getAll(pageable);
            List<KhachHang> listKH = khachHangService.getAll();
            model.addAttribute("listPGG", listPGG);
            model.addAttribute("listKH", listKH);
            return "update";
        }
        phieuGiamGiaService.update(phieuGiamGia);
        Pageable pageable = PageRequest.of(page, 3);
        Page<PhieuGiamGia> listPGG = phieuGiamGiaService.getAll(pageable);
        List<KhachHang> listKH = khachHangService.getAll();
        model.addAttribute("listPGG", listPGG);
        model.addAttribute("listKH", listKH);
        model.addAttribute("mess", "Sửa thành công");
        return "index";
    }


    @GetMapping("/phieu-giam-gia/search")
    public String search(@ModelAttribute("phieuGiamGia") PhieuGiamGia phieuGiamGia,
                         @RequestParam(defaultValue = "0") Integer page, Model model,
                         @RequestParam("ngayBatDau") String ngayBatDau, @RequestParam("ngayKetThuc") String ngayKetThuc,
                         @RequestParam("khachhang") KhachHang khachhang) {
        Pageable pageable = PageRequest.of(page, 3);
        Page<PhieuGiamGia> listPGG = phieuGiamGiaService.search(ngayBatDau, ngayKetThuc, khachhang, pageable);
        List<KhachHang> listKH = khachHangService.getAll();
        model.addAttribute("listPGG", listPGG);
        model.addAttribute("listKH", listKH);
        return "index";
    }

}
