package com.demo.controller;

import com.demo.entity.HoaDon;
import com.demo.entity.PhieuGiaoHang;
import com.demo.service.HoaDonService;
import com.demo.service.PhieuGiaoHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
public class PhieuGiaoHangController {

    @Autowired
    HoaDonService hoaDonService;

    @Autowired
    PhieuGiaoHangService phieuGiaoHangService;

    @GetMapping("/phieu-giao-hang/hien-thi")
    public String hienThi(@ModelAttribute("phieuGiaoHang") PhieuGiaoHang phieuGiaoHang,
                          @RequestParam(defaultValue = "0") Integer page, Model model) {
        Pageable pageable = PageRequest.of(page, 3);
        Page<PhieuGiaoHang> listPGH = phieuGiaoHangService.getAll(pageable);
        List<HoaDon> listHD = hoaDonService.getAll();
        model.addAttribute("listPGH", listPGH);
        model.addAttribute("listHD", listHD);
        return "index";
    }

    @GetMapping("/phieu-giao-hang/delete/{maphieugiao}")
    public String delete(@ModelAttribute("phieuGiaoHang") PhieuGiaoHang phieuGiaoHang,
                         @RequestParam(defaultValue = "0") Integer page, Model model,
                         @PathVariable("maphieugiao") UUID maphieugiao) {
        phieuGiaoHangService.delete(maphieugiao);
        Pageable pageable = PageRequest.of(page, 3);
        Page<PhieuGiaoHang> listPGH = phieuGiaoHangService.getAll(pageable);
        List<HoaDon> listHD = hoaDonService.getAll();
        model.addAttribute("listPGH", listPGH);
        model.addAttribute("listHD", listHD);
        model.addAttribute("mess", "Xóa thành công");
        return "index";
    }

    @GetMapping("/phieu-giao-hang/detail/{maphieugiao}")
    public String detail(@ModelAttribute("phieuGiaoHang") PhieuGiaoHang phieuGiaoHang,
                         @RequestParam(defaultValue = "0") Integer page, Model model,
                         @PathVariable("maphieugiao") UUID maphieugiao) {
        PhieuGiaoHang pgh = phieuGiaoHangService.getOne(maphieugiao);
        Pageable pageable = PageRequest.of(page, 3);
        Page<PhieuGiaoHang> listPGH = phieuGiaoHangService.getAll(pageable);
        List<HoaDon> listHD = hoaDonService.getAll();
        model.addAttribute("listPGH", listPGH);
        model.addAttribute("listHD", listHD);
        model.addAttribute("phieuGiaoHang", pgh);
        return "index";
    }


    @PostMapping("/phieu-giao-hang/add")
    public String add(@ModelAttribute("phieuGiaoHang") PhieuGiaoHang phieuGiaoHang,
                      @RequestParam(defaultValue = "0") Integer page, Model model) {
        phieuGiaoHangService.save(phieuGiaoHang);
        Pageable pageable = PageRequest.of(page, 3);
        Page<PhieuGiaoHang> listPGH = phieuGiaoHangService.getAll(pageable);
        List<HoaDon> listHD = hoaDonService.getAll();
        model.addAttribute("listPGH", listPGH);
        model.addAttribute("listHD", listHD);
        model.addAttribute("mess","Thêm thành công");
        return "index";
    }

    @GetMapping("/phieu-giao-hang/view-update/{maphieugiao}")
    public String viewUpdate(@ModelAttribute("phieuGiaoHang") PhieuGiaoHang phieuGiaoHang,
                         @RequestParam(defaultValue = "0") Integer page, Model model,
                         @PathVariable("maphieugiao") UUID maphieugiao) {
        PhieuGiaoHang pgh = phieuGiaoHangService.getOne(maphieugiao);
        Pageable pageable = PageRequest.of(page, 3);
        Page<PhieuGiaoHang> listPGH = phieuGiaoHangService.getAll(pageable);
        List<HoaDon> listHD = hoaDonService.getAll();
        model.addAttribute("listPGH", listPGH);
        model.addAttribute("listHD", listHD);
        model.addAttribute("phieuGiaoHang", pgh);
        return "update";
    }

    @PostMapping("/phieu-giao-hang/update/{maphieugiao}")
    public String update(@ModelAttribute("phieuGiaoHang") PhieuGiaoHang phieuGiaoHang,
                      @RequestParam(defaultValue = "0") Integer page, Model model,
                      @PathVariable("maphieugiao") UUID maphieugiao) {
        phieuGiaoHangService.save(phieuGiaoHang);
        Pageable pageable = PageRequest.of(page, 3);
        Page<PhieuGiaoHang> listPGH = phieuGiaoHangService.getAll(pageable);
        List<HoaDon> listHD = hoaDonService.getAll();
        model.addAttribute("listPGH", listPGH);
        model.addAttribute("listHD", listHD);
        model.addAttribute("mess","Sửa thành công");
        return "index";
    }
}
