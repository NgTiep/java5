package com.poly.hangnt169.B3_CRUDListFixCung.controller;

import com.poly.hangnt169.B3_CRUDListFixCung.entity.SinhVien;
import com.poly.hangnt169.B3_CRUDListFixCung.service.SinhVienService;
import com.poly.hangnt169.B3_CRUDListFixCung.service.impl.SinhVienServiceImpl;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SinhVienController {
    // Khi dung Controller
    // MVC(MODEL - VIEW - CONTROLLER)
    // Khi dung @Controller => Tat ca cac request/ham o trong Controller
    // => LUON LUON TRA VE 1 VIEW (RETURN 1 STRING)

    private SinhVienService sinhVienService = new SinhVienServiceImpl();
    // Interface = new Class
    private List<SinhVien> sinhViens = new ArrayList<>();

    @GetMapping("/sinh-vien/hien-thi")
    public String hienThiSinhVien(Model model) {
        sinhViens = sinhVienService.getAll();
        model.addAttribute("lists", sinhViens);
        return "/buoi3/sinhviens";
    }

    // C1: From HTML
//    @GetMapping("/sinh-vien/view-add")
//    public String viewAddSV() {
//        return "buoi3/add-sinh-vien";
//    }
//
//    @PostMapping("/sinh-vien/add")
//    public String addSinhVien(@RequestParam("mssv") String ma, @RequestParam("ten") String ten,
//                              @RequestParam("tuoi") String tuoi, @RequestParam("diaChi") String diaChi,
//                              @RequestParam("gioiTinh") String gt, Model model) {
//        // B1: Khoi tao 1 Object
//        // C1: Su dung contructor
////        SinhVien sinhVien = new SinhVien(ma, ten, Integer.valueOf(tuoi), diaChi, Boolean.valueOf(gt));
//        // C2: Su dung builder
//        SinhVien sv = SinhVien.builder()
//                .diaChi(diaChi)
//                .gioiTinh(Boolean.valueOf(gt))
//                .mssv(ma)
//                .ten(ten)
//                .tuoi(Integer.valueOf(tuoi))
//                .build(); // <=> contrutor khong tham so
//        // B2: Goi add trong service
//        sinhVienService.addSinhVien(sv);
//        //B3: Quay lai trang chu
//        // C1: Return JSP
////        sinhViens = sinhVienService.getAll();
////        model.addAttribute("lists", sinhViens);
////        return "/buoi3/sinhviens";
//        // C2: redirect
//        return "redirect:/sinh-vien/hien-thi";
//    }

    // C2: Spring From
    @GetMapping("/sinh-vien/view-add")
    public String viewAdd(Model model) {
        model.addAttribute("sv", new SinhVien());
        return "/buoi5/add-sinh-vien";
    }

    @PostMapping("/sinh-vien/add")
    public String addSinhVien(@Valid @ModelAttribute("sv") SinhVien sinhVien, BindingResult result) {
       if(result.hasErrors()){
           return "/buoi5/add-sinh-vien";
       }
        sinhVienService.addSinhVien(sinhVien);
        return "redirect:/sinh-vien/hien-thi";
    }

    @GetMapping("/sinh-vien/detail/{ma}")
    public String detailSinhVien(@PathVariable("ma") String msv, Model model) {
        SinhVien sv = sinhVienService.detailSinhVien(msv);
        model.addAttribute("sv", sv);
        return "/buoi3/detail-sinh-vien";
    }

    @GetMapping("view-update/{maSV}")
    public String viewUpdate(@PathVariable("maSV") String ma, Model model) {
        SinhVien sv = sinhVienService.detailSinhVien(ma);
        model.addAttribute("sv", sv);
        return "/buoi3/update-sinh-vien";
    }

    @GetMapping("delete/{ma}")
    public String deleteSinhVien(@PathVariable("ma") String ma) {
        sinhVienService.deleteSinhVien(ma);
        return "redirect:/sinh-vien/hien-thi";
    }
//    @GetMapping("/aaaaaaa")
//    @ResponseBody
//    // => API => Tra ve kieu du lieu mong muon
//    public List<SinhVien> test() {
//        List<SinhVien> listSinhVien = new ArrayList<>();
//        listSinhVien.add(new SinhVien("HE130461", "Nguyen Thuy Hang", 10, "Ha Noi", false));
//        listSinhVien.add(new SinhVien("HE130462", "Nguyen Hoang Tien", 11, "Ha Noi1", true));
//        listSinhVien.add(new SinhVien("HE130463", "Nguyen Anh Dung", 15, "Ha Noi3", true));
//        listSinhVien.add(new SinhVien("HE130464", "Vu Van Nguyen", 14, "Ha Noi6", true));
//        listSinhVien.add(new SinhVien("HE130465", "Tran Tuan Phong", 20, "Ha Noi7", true));
//        return listSinhVien;
//    }
}
