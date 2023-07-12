package com.demo.controller;

import com.demo.entity.GioHang;
import com.demo.entity.KhachHang;
import com.demo.service.GioHangService;
import com.demo.service.KhachHangService;
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
import java.util.UUID;

@Controller
public class GioHangController {

    @Autowired
    KhachHangService khachHangService;

    @Autowired
    GioHangService gioHangService;

    @GetMapping("/gio-hang/hien-thi")
    public String hienThi(@ModelAttribute("gioHang") GioHang gioHang,
                          @RequestParam(defaultValue = "0") Integer page, Model model) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<GioHang> listGH = gioHangService.getAll(pageable);
        List<KhachHang> listKH = khachHangService.getAll();
        model.addAttribute("listGH", listGH);
        model.addAttribute("listKH", listKH);
        return "index";
    }

    @GetMapping("/gio-hang/delete/{maGioHang}")
    public String delete(@ModelAttribute("gioHang") GioHang gioHang,
                         @RequestParam(defaultValue = "0") Integer page, Model model,
                         @PathVariable("maGioHang") UUID maGioHang) {
        gioHangService.delete(maGioHang);
        Pageable pageable = PageRequest.of(page, 5);
        Page<GioHang> listGH = gioHangService.getAll(pageable);
        List<KhachHang> listKH = khachHangService.getAll();
        model.addAttribute("listGH", listGH);
        model.addAttribute("listKH", listKH);
        model.addAttribute("mess", "Xóa thành công");
        return "index";
    }

    @GetMapping("/gio-hang/detail/{maGioHang}")
    public String detail(@ModelAttribute("gioHang") GioHang gioHang,
                         @RequestParam(defaultValue = "0") Integer page, Model model,
                         @PathVariable("maGioHang") UUID maGioHang) {
        GioHang gh = gioHangService.getOne(maGioHang);
        Pageable pageable = PageRequest.of(page, 5);
        Page<GioHang> listGH = gioHangService.getAll(pageable);
        List<KhachHang> listKH = khachHangService.getAll();
        model.addAttribute("listGH", listGH);
        model.addAttribute("listKH", listKH);
        model.addAttribute("gioHang", gh);
        return "index";
    }


    @PostMapping("/gio-hang/add")
    public String add(@Valid @ModelAttribute("gioHang") GioHang gioHang, BindingResult result,
                      @RequestParam(defaultValue = "0") Integer page, Model model) {
        boolean error = result.hasErrors();
        if (gioHang.getKhachHang() == null) {
            model.addAttribute("error", "Mời bạn chọn mục khách hàng");
            error = true;
        }
        if (error) {
            Pageable pageable = PageRequest.of(page, 5);
            Page<GioHang> listGH = gioHangService.getAll(pageable);
            List<KhachHang> listKH = khachHangService.getAll();
            model.addAttribute("listGH", listGH);
            model.addAttribute("listKH", listKH);
            return "index";
        }
        gioHangService.save(gioHang);
        Pageable pageable = PageRequest.of(page, 5);
        Page<GioHang> listGH = gioHangService.getAll(pageable);
        List<KhachHang> listKH = khachHangService.getAll();
        model.addAttribute("listGH", listGH);
        model.addAttribute("listKH", listKH);
        model.addAttribute("mess", "Thêm thành công");
        return "index";
    }
}
