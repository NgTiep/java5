package com.demo.controller;

import com.demo.entity.DanhSachYeuThich;
import com.demo.entity.KhachHang;
import com.demo.service.DanhSachYeuThichService;
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
public class DanhSachYeuThichController {

    @Autowired
    KhachHangService khachHangService;

    @Autowired
    DanhSachYeuThichService danhSachYeuThichService;

    @GetMapping("/danh-sach/hien-thi")
    public String hienThi(@ModelAttribute("danhSach") DanhSachYeuThich danhSach,
                          @RequestParam(defaultValue = "0") Integer page, Model model) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<DanhSachYeuThich> listDSYT = danhSachYeuThichService.getAll(pageable);
        List<KhachHang> listKH = khachHangService.getAll();
        model.addAttribute("listDSYT", listDSYT);
        model.addAttribute("listKH", listKH);
        return "index";
    }


    @GetMapping("/danh-sach/detail/{maDanhSach}")
    public String detail(@ModelAttribute("danhSach") DanhSachYeuThich danhSach,
                         @RequestParam(defaultValue = "0") Integer page, Model model,
                         @PathVariable("maDanhSach") UUID maDanhSach) {
        DanhSachYeuThich dsyt = danhSachYeuThichService.getOne(maDanhSach);
        Pageable pageable = PageRequest.of(page, 5);
        Page<DanhSachYeuThich> listDSYT = danhSachYeuThichService.getAll(pageable);
        List<KhachHang> listKH = khachHangService.getAll();
        model.addAttribute("listDSYT", listDSYT);
        model.addAttribute("listKH", listKH);
        model.addAttribute("danhSach", dsyt);
        return "index";
    }

    @GetMapping("/danh-sach/delete/{maDanhSach}")
    public String delete(@ModelAttribute("danhSach") DanhSachYeuThich danhSach,
                         @RequestParam(defaultValue = "0") Integer page, Model model,
                         @PathVariable("maDanhSach") UUID maDanhSach) {
        danhSachYeuThichService.delete(maDanhSach);
        Pageable pageable = PageRequest.of(page, 5);
        Page<DanhSachYeuThich> listDSYT = danhSachYeuThichService.getAll(pageable);
        List<KhachHang> listKH = khachHangService.getAll();
        model.addAttribute("listDSYT", listDSYT);
        model.addAttribute("listKH", listKH);
        model.addAttribute("mess", "Xóa thành công");

        return "index";
    }

    @PostMapping("/danh-sach/add")
    public String add(@Valid @ModelAttribute("danhSach") DanhSachYeuThich danhSach, BindingResult result,
                      @RequestParam(defaultValue = "0") Integer page, Model model) {
        if (result.hasErrors()) {
            Pageable pageable = PageRequest.of(page, 5);
            Page<DanhSachYeuThich> listDSYT = danhSachYeuThichService.getAll(pageable);
            List<KhachHang> listKH = khachHangService.getAll();
            model.addAttribute("listDSYT", listDSYT);
            model.addAttribute("listKH", listKH);
            return "index";
        }
        danhSachYeuThichService.save(danhSach);
        Pageable pageable = PageRequest.of(page, 5);
        Page<DanhSachYeuThich> listDSYT = danhSachYeuThichService.getAll(pageable);
        List<KhachHang> listKH = khachHangService.getAll();
        model.addAttribute("listDSYT", listDSYT);
        model.addAttribute("listKH", listKH);
        model.addAttribute("mess", "Thêm thành công");
        return "index";
    }


    @GetMapping("/danh-sach/view-update/{maDanhSach}")
    public String viewUpdate(@ModelAttribute("danhSach") DanhSachYeuThich danhSach,
                             @RequestParam(defaultValue = "0") Integer page, Model model,
                             @PathVariable("maDanhSach") UUID maDanhSach) {
        DanhSachYeuThich dsyt = danhSachYeuThichService.getOne(maDanhSach);
        Pageable pageable = PageRequest.of(page, 5);
        Page<DanhSachYeuThich> listDSYT = danhSachYeuThichService.getAll(pageable);
        List<KhachHang> listKH = khachHangService.getAll();
        model.addAttribute("listDSYT", listDSYT);
        model.addAttribute("listKH", listKH);
        model.addAttribute("danhSach", dsyt);
        return "update";
    }

    @PostMapping("/danh-sach/update/{maDanhSach}")
    public String update(@Valid @ModelAttribute("danhSach") DanhSachYeuThich danhSach, BindingResult result,
                         @RequestParam(defaultValue = "0") Integer page, Model model,
                         @PathVariable("maDanhSach") UUID maDanhSach) {
        if (result.hasErrors()) {
            Pageable pageable = PageRequest.of(page, 5);
            Page<DanhSachYeuThich> listDSYT = danhSachYeuThichService.getAll(pageable);
            List<KhachHang> listKH = khachHangService.getAll();
            model.addAttribute("listDSYT", listDSYT);
            model.addAttribute("listKH", listKH);
            return "update";
        }
        danhSachYeuThichService.save(danhSach);
        Pageable pageable = PageRequest.of(page, 5);
        Page<DanhSachYeuThich> listDSYT = danhSachYeuThichService.getAll(pageable);
        List<KhachHang> listKH = khachHangService.getAll();
        model.addAttribute("listDSYT", listDSYT);
        model.addAttribute("listKH", listKH);
        model.addAttribute("mess", "Sửa thành công");
        return "index";
    }

    @GetMapping("/danh-sach/search")
    public String search(@ModelAttribute("danhSach") DanhSachYeuThich danhSach,
                         @RequestParam(defaultValue = "0") Integer page, Model model,
                         @RequestParam("ngayTao") String ngayTao, @RequestParam("ngayCapNhap") String ngayCapNhap,
                         @RequestParam("khachHang") KhachHang khachHang) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<DanhSachYeuThich> listDSYT = danhSachYeuThichService.search(ngayTao, ngayCapNhap, khachHang, pageable);
        List<KhachHang> listKH = khachHangService.getAll();
        model.addAttribute("listDSYT", listDSYT);
        model.addAttribute("listKH", listKH);
        return "index";
    }
}
