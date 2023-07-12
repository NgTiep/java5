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
    KhachHangService khachHangService;

    @Autowired
    PhieuGiamGiaService phieuGiamGiaService;

    @GetMapping("/phieugiamgia/hien-thi")
    public String hienThi(@ModelAttribute("phieuGiamGia") PhieuGiamGia phieuGiamGia,
                          @RequestParam(defaultValue = "0") Integer page, Model model) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<PhieuGiamGia> listPGG = phieuGiamGiaService.getAll(pageable);
        List<KhachHang> listKH = khachHangService.getAll();
        model.addAttribute("listPGG", listPGG);
        model.addAttribute("listKH", listKH);
        return "index";
    }

    @GetMapping("/phieugiamgia/delete/{maPhieu}")
    public String delete(@ModelAttribute("phieuGiamGia") PhieuGiamGia phieuGiamGia,
                         @RequestParam(defaultValue = "0") Integer page, Model model,
                         @PathVariable("maPhieu") String maPhieu) {
        phieuGiamGiaService.delete(maPhieu);
        Pageable pageable = PageRequest.of(page, 5);
        Page<PhieuGiamGia> listPGG = phieuGiamGiaService.getAll(pageable);
        List<KhachHang> listKH = khachHangService.getAll();
        model.addAttribute("listPGG", listPGG);
        model.addAttribute("listKH", listKH);
        model.addAttribute("mess", "Xóa thành công");
        return "index";
    }

    @GetMapping("/phieugiamgia/detail/{maPhieu}")
    public String detail(@ModelAttribute("phieuGiamGia") PhieuGiamGia phieuGiamGia,
                         @RequestParam(defaultValue = "0") Integer page, Model model,
                         @PathVariable("maPhieu") String maPhieu) {
        PhieuGiamGia pgg = phieuGiamGiaService.getOne(maPhieu);
        Pageable pageable = PageRequest.of(page, 5);
        Page<PhieuGiamGia> listPGG = phieuGiamGiaService.getAll(pageable);
        List<KhachHang> listKH = khachHangService.getAll();
        model.addAttribute("listPGG", listPGG);
        model.addAttribute("listKH", listKH);
        model.addAttribute("phieuGiamGia", pgg);
        return "index";
    }

    @PostMapping("/phieugiamgia/add")
    public String add(@Valid @ModelAttribute("phieuGiamGia") PhieuGiamGia phieuGiamGia, BindingResult result,
                      @RequestParam(defaultValue = "0") Integer page, Model model) {
        boolean error = result.hasErrors();
        if (phieuGiamGia.getKhachHang() == null) {
            model.addAttribute("error", "Mời bạn chọn mục khách hàng");
            error = true;
        }
        if (error) {
            Pageable pageable = PageRequest.of(page, 5);
            Page<PhieuGiamGia> listPGG = phieuGiamGiaService.getAll(pageable);
            List<KhachHang> listKH = khachHangService.getAll();
            model.addAttribute("listPGG", listPGG);
            model.addAttribute("listKH", listKH);
            return "index";
        }
        phieuGiamGiaService.save(phieuGiamGia);
        Pageable pageable = PageRequest.of(page, 5);
        Page<PhieuGiamGia> listPGG = phieuGiamGiaService.getAll(pageable);
        List<KhachHang> listKH = khachHangService.getAll();
        model.addAttribute("listPGG", listPGG);
        model.addAttribute("listKH", listKH);
        model.addAttribute("mess", "Thêm thành công");
        return "index";
    }

    @GetMapping("/phieugiamgia/view-update/{maPhieu}")
    public String viewUpdate(@ModelAttribute("phieuGiamGia") PhieuGiamGia phieuGiamGia,
                             @RequestParam(defaultValue = "0") Integer page, Model model,
                             @PathVariable("maPhieu") String maPhieu) {
        PhieuGiamGia pgg = phieuGiamGiaService.getOne(maPhieu);
        Pageable pageable = PageRequest.of(page, 5);
        Page<PhieuGiamGia> listPGG = phieuGiamGiaService.getAll(pageable);
        List<KhachHang> listKH = khachHangService.getAll();
        model.addAttribute("listPGG", listPGG);
        model.addAttribute("listKH", listKH);
        model.addAttribute("phieuGiamGia", pgg);
        return "update";
    }

    @PostMapping("/phieugiamgia/update/{maPhieu}")
    public String update(@Valid @ModelAttribute("phieuGiamGia") PhieuGiamGia phieuGiamGia, BindingResult result,
                         @RequestParam(defaultValue = "0") Integer page, Model model,
                         @PathVariable("maPhieu") String maPhieu) {
        boolean error = result.hasErrors();
        if (phieuGiamGia.getKhachHang() == null) {
            model.addAttribute("error", "Mời bạn chọn mục khách hàng");
            error = true;
        }
        if (error) {
            Pageable pageable = PageRequest.of(page, 5);
            Page<PhieuGiamGia> listPGG = phieuGiamGiaService.getAll(pageable);
            List<KhachHang> listKH = khachHangService.getAll();
            model.addAttribute("listPGG", listPGG);
            model.addAttribute("listKH", listKH);
            return "update";
        }
        phieuGiamGiaService.save(phieuGiamGia);
        Pageable pageable = PageRequest.of(page, 5);
        Page<PhieuGiamGia> listPGG = phieuGiamGiaService.getAll(pageable);
        List<KhachHang> listKH = khachHangService.getAll();
        model.addAttribute("listPGG", listPGG);
        model.addAttribute("listKH", listKH);
        model.addAttribute("mess", "Sửa thành công");
        return "index";
    }


    @GetMapping("/phieugiamgia/search")
    public String search(@ModelAttribute("phieuGiamGia") PhieuGiamGia phieuGiamGia,
                         @RequestParam(defaultValue = "0") Integer page, Model model,
                         @RequestParam("tuNgay") String tuNgay, @RequestParam("denNgay") String denNgay,
                         @RequestParam("khachHang") KhachHang khachHang) {
        if (tuNgay.isEmpty() || denNgay.isEmpty()) {
            Pageable pageable = PageRequest.of(page, 5);
            Page<PhieuGiamGia> listPGG = phieuGiamGiaService.searchCBB(khachHang, pageable);
            List<KhachHang> listKH = khachHangService.getAll();
            model.addAttribute("listPGG", listPGG);
            model.addAttribute("listKH", listKH);
            return "index";
        }
        Pageable pageable = PageRequest.of(page, 5);
        Page<PhieuGiamGia> listPGG = phieuGiamGiaService.searchAll(tuNgay, denNgay, khachHang, pageable);
        List<KhachHang> listKH = khachHangService.getAll();
        model.addAttribute("listPGG", listPGG);
        model.addAttribute("listKH", listKH);
        return "index";
    }
}
