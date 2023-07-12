package com.demo.controller;

import com.demo.entity.HangKhachHang;
import com.demo.entity.KhachHang;
import com.demo.service.HangKhachHangService;
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

@Controller
public class KhachHangController {

    @Autowired
    KhachHangService khachHangService;

    @Autowired
    HangKhachHangService hangKhachHangService;

    @GetMapping("/khach-hang/hien-thi")
    public String hienThi(@ModelAttribute("khachHang") KhachHang khachHang,
                          @RequestParam(defaultValue = "0") Integer page, Model model) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<KhachHang> listKH = khachHangService.getAll(pageable);
        List<HangKhachHang> listHKH = hangKhachHangService.getAll();
        model.addAttribute("listKH", listKH);
        model.addAttribute("listHKH", listHKH);
        return "index";
    }

    @GetMapping("/khach-hang/delete/{maKhachHang}")
    public String delete(@ModelAttribute("khachHang") KhachHang khachHang,
                         @RequestParam(defaultValue = "0") Integer page, Model model,
                         @PathVariable("maKhachHang") long maKhachHang) {
        khachHangService.delete(maKhachHang);
        Pageable pageable = PageRequest.of(page, 5);
        Page<KhachHang> listKH = khachHangService.getAll(pageable);
        List<HangKhachHang> listHKH = hangKhachHangService.getAll();
        model.addAttribute("listKH", listKH);
        model.addAttribute("listHKH", listHKH);
        model.addAttribute("mess", "Xóa thành công");
        return "index";
    }

    @GetMapping("/khach-hang/detail/{maKhachHang}")
    public String detail(@ModelAttribute("khachHang") KhachHang khachHang,
                         @RequestParam(defaultValue = "0") Integer page, Model model,
                         @PathVariable("maKhachHang") long maKhachHang) {
        KhachHang kh = khachHangService.getOne(maKhachHang);
        Pageable pageable = PageRequest.of(page, 5);
        Page<KhachHang> listKH = khachHangService.getAll(pageable);
        List<HangKhachHang> listHKH = hangKhachHangService.getAll();
        model.addAttribute("listKH", listKH);
        model.addAttribute("listHKH", listHKH);
        model.addAttribute("khachHang", kh);
        return "index";
    }


    @PostMapping("/khach-hang/add")
    public String add(@Valid @ModelAttribute("khachHang") KhachHang khachHang, BindingResult result,
                      @RequestParam(defaultValue = "0") Integer page, Model model) {
        boolean error = result.hasErrors();
        if (khachHang.getHangKhachHang() == null) {
            model.addAttribute("error", "Mời bạn chọn khách hàng");
            error = true;
        }
        if (error) {
            Pageable pageable = PageRequest.of(page, 5);
            Page<KhachHang> listKH = khachHangService.getAll(pageable);
            List<HangKhachHang> listHKH = hangKhachHangService.getAll();
            model.addAttribute("listKH", listKH);
            model.addAttribute("listHKH", listHKH);
            return "index";
        }
        khachHangService.save(khachHang);
        Pageable pageable = PageRequest.of(page, 5);
        Page<KhachHang> listKH = khachHangService.getAll(pageable);
        List<HangKhachHang> listHKH = hangKhachHangService.getAll();
        model.addAttribute("listKH", listKH);
        model.addAttribute("listHKH", listHKH);
        model.addAttribute("mess", "Thêm thành công");
        return "index";
    }

    @GetMapping("/khach-hang/view-update/{maKhachHang}")
    public String viewUpdate(@ModelAttribute("khachHang") KhachHang khachHang,
                             @RequestParam(defaultValue = "0") Integer page, Model model,
                             @PathVariable("maKhachHang") long maKhachHang) {
        KhachHang kh = khachHangService.getOne(maKhachHang);
        Pageable pageable = PageRequest.of(page, 5);
        Page<KhachHang> listKH = khachHangService.getAll(pageable);
        List<HangKhachHang> listHKH = hangKhachHangService.getAll();
        model.addAttribute("listKH", listKH);
        model.addAttribute("listHKH", listHKH);
        model.addAttribute("khachHang", kh);
        return "update";
    }


    @PostMapping("/khach-hang/update/{maKhachHang}")
    public String update(@Valid @ModelAttribute("khachHang") KhachHang khachHang, BindingResult result,
                         @RequestParam(defaultValue = "0") Integer page, Model model,
                         @PathVariable("maKhachHang") long maKhachHang) {
        boolean error = result.hasErrors();
        if (khachHang.getHangKhachHang() == null) {
            model.addAttribute("error", "Mời bạn chọn khách hàng");
            error = true;
        }
        if (error) {
            Pageable pageable = PageRequest.of(page, 5);
            Page<KhachHang> listKH = khachHangService.getAll(pageable);
            List<HangKhachHang> listHKH = hangKhachHangService.getAll();
            model.addAttribute("listKH", listKH);
            model.addAttribute("listHKH", listHKH);
            return "update";
        }
        khachHangService.save(khachHang);
        Pageable pageable = PageRequest.of(page, 5);
        Page<KhachHang> listKH = khachHangService.getAll(pageable);
        List<HangKhachHang> listHKH = hangKhachHangService.getAll();
        model.addAttribute("listKH", listKH);
        model.addAttribute("listHKH", listHKH);
        model.addAttribute("mess", "Sửa thành công");
        return "index";
    }


    @GetMapping("/khach-hang/search")
    public String search(@ModelAttribute("khachHang") KhachHang khachHang,
                         @RequestParam(defaultValue = "0") Integer page, Model model,
                         @RequestParam("giaTri") String giaTri,
                         @RequestParam("hangKhachHang") HangKhachHang hangKhachHang) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<KhachHang> listKH = khachHangService.search(giaTri, hangKhachHang, pageable);
        List<HangKhachHang> listHKH = hangKhachHangService.getAll();
        model.addAttribute("listKH", listKH);
        model.addAttribute("listHKH", listHKH);
        return "index";
    }

}
