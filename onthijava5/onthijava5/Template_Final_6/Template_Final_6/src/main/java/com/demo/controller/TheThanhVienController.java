package com.demo.controller;

import com.demo.entity.KhachHang;
import com.demo.entity.TheThanhVien;
import com.demo.service.KhachHangService;
import com.demo.service.TheThanhVienService;
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
public class TheThanhVienController {

    @Autowired
    KhachHangService khachHangService;

    @Autowired
    TheThanhVienService theThanhVienService;

    @GetMapping("the-thanh-vien/hien-thi")
    public String hienThi(@ModelAttribute("theThanhVien") TheThanhVien theThanhVien,
                          @RequestParam(defaultValue = "0") Integer page, Model model) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<TheThanhVien> listTTV = theThanhVienService.getAll(pageable);
        List<KhachHang> listKH = khachHangService.getAll();
        model.addAttribute("listTTV", listTTV);
        model.addAttribute("listKH", listKH);
        return "index";
    }

    @GetMapping("the-thanh-vien/delete/{maThe}")
    public String delete(@ModelAttribute("theThanhVien") TheThanhVien theThanhVien,
                         @RequestParam(defaultValue = "0") Integer page, Model model,
                         @PathVariable("maThe") String maThe) {
        theThanhVienService.delete(maThe);
        Pageable pageable = PageRequest.of(page, 5);
        Page<TheThanhVien> listTTV = theThanhVienService.getAll(pageable);
        List<KhachHang> listKH = khachHangService.getAll();
        model.addAttribute("listTTV", listTTV);
        model.addAttribute("listKH", listKH);
        model.addAttribute("mess", "Xóa thành công");
        return "index";
    }


    @GetMapping("the-thanh-vien/detail/{maThe}")
    public String detail(@ModelAttribute("theThanhVien") TheThanhVien theThanhVien,
                         @RequestParam(defaultValue = "0") Integer page, Model model,
                         @PathVariable("maThe") String maThe) {
        TheThanhVien ttv = theThanhVienService.getOne(maThe);
        Pageable pageable = PageRequest.of(page, 5);
        Page<TheThanhVien> listTTV = theThanhVienService.getAll(pageable);
        List<KhachHang> listKH = khachHangService.getAll();
        model.addAttribute("listTTV", listTTV);
        model.addAttribute("listKH", listKH);
        model.addAttribute("theThanhVien", ttv);
        return "index";
    }


    @PostMapping("the-thanh-vien/add")
    public String add(@Valid @ModelAttribute("theThanhVien") TheThanhVien theThanhVien, BindingResult result,
                      @RequestParam(defaultValue = "0") Integer page, Model model) {
        if (result.hasErrors()) {
            Pageable pageable = PageRequest.of(page, 5);
            Page<TheThanhVien> listTTV = theThanhVienService.getAll(pageable);
            List<KhachHang> listKH = khachHangService.getAll();
            model.addAttribute("listTTV", listTTV);
            model.addAttribute("listKH", listKH);
            return "index";
        }
        theThanhVienService.save(theThanhVien);
        Pageable pageable = PageRequest.of(page, 5);
        Page<TheThanhVien> listTTV = theThanhVienService.getAll(pageable);
        List<KhachHang> listKH = khachHangService.getAll();
        model.addAttribute("listTTV", listTTV);
        model.addAttribute("listKH", listKH);
        model.addAttribute("mess", "Thêm thành công");
        return "index";
    }

    @GetMapping("the-thanh-vien/view-update/{maThe}")
    public String viewUpdate(@ModelAttribute("theThanhVien") TheThanhVien theThanhVien,
                             @RequestParam(defaultValue = "0") Integer page, Model model,
                             @PathVariable("maThe") String maThe) {
        TheThanhVien ttv = theThanhVienService.getOne(maThe);
        Pageable pageable = PageRequest.of(page, 5);
        Page<TheThanhVien> listTTV = theThanhVienService.getAll(pageable);
        List<KhachHang> listKH = khachHangService.getAll();
        model.addAttribute("listTTV", listTTV);
        model.addAttribute("listKH", listKH);
        model.addAttribute("theThanhVien", ttv);
        return "update";
    }

    @PostMapping("the-thanh-vien/update/{maThe}")
    public String update(@Valid @ModelAttribute("theThanhVien") TheThanhVien theThanhVien, BindingResult result,
                         @RequestParam(defaultValue = "0") Integer page, Model model,
                         @PathVariable("maThe") String maThe) {
        if (result.hasErrors()) {
            Pageable pageable = PageRequest.of(page, 5);
            Page<TheThanhVien> listTTV = theThanhVienService.getAll(pageable);
            List<KhachHang> listKH = khachHangService.getAll();
            model.addAttribute("listTTV", listTTV);
            model.addAttribute("listKH", listKH);
            return "update";
        }
        theThanhVienService.save(theThanhVien);
        Pageable pageable = PageRequest.of(page, 5);
        Page<TheThanhVien> listTTV = theThanhVienService.getAll(pageable);
        List<KhachHang> listKH = khachHangService.getAll();
        model.addAttribute("listTTV", listTTV);
        model.addAttribute("listKH", listKH);
        model.addAttribute("mess", "Sửa thành công");
        return "index";
    }

    @GetMapping("the-thanh-vien/search")
    public String search(@ModelAttribute("theThanhVien") TheThanhVien theThanhVien,
                         @RequestParam(defaultValue = "0") Integer page, Model model,
                         @RequestParam("ngayPhatHanh") String ngayPhatHanh, @RequestParam("ngayHuy") String ngayHuy,
                         @RequestParam("khachHang") KhachHang khachHang) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<TheThanhVien> listTTV = theThanhVienService.search(ngayPhatHanh, ngayHuy, khachHang, pageable);
        List<KhachHang> listKH = khachHangService.getAll();
        model.addAttribute("listTTV", listTTV);
        model.addAttribute("listKH", listKH);
        return "index";
    }
}
