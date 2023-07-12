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
public class PhieuGiaoHangController {

    @Autowired
    HoaDonService hoaDonService;

    @Autowired
    PhieuGiaoHangService phieuGiaoHangService;

    @GetMapping("/phieugiaohang/hien-thi")
    public String hienThi(@ModelAttribute("phieuGiaoHang") PhieuGiaoHang phieuGiaoHang,
                          @RequestParam(defaultValue = "0") Integer page, Model model) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<PhieuGiaoHang> listPGH = phieuGiaoHangService.getAll(pageable);
        List<HoaDon> listHD = hoaDonService.getAll();
        model.addAttribute("listPGH", listPGH);
        model.addAttribute("listHD", listHD);
        return "index";
    }

    @GetMapping("/phieugiaohang/delete/{maPhieuGiao}")
    public String delete(@ModelAttribute("phieuGiaoHang") PhieuGiaoHang phieuGiaoHang,
                         @RequestParam(defaultValue = "0") Integer page, Model model,
                         @PathVariable("maPhieuGiao") UUID maPhieuGiao) {
        phieuGiaoHangService.delete(maPhieuGiao);
        Pageable pageable = PageRequest.of(page, 5);
        Page<PhieuGiaoHang> listPGH = phieuGiaoHangService.getAll(pageable);
        List<HoaDon> listHD = hoaDonService.getAll();
        model.addAttribute("listPGH", listPGH);
        model.addAttribute("listHD", listHD);
        model.addAttribute("mess", "Xóa thành công");
        return "index";
    }

    @GetMapping("/phieugiaohang/detail/{maPhieuGiao}")
    public String detail(@ModelAttribute("phieuGiaoHang") PhieuGiaoHang phieuGiaoHang,
                         @RequestParam(defaultValue = "0") Integer page, Model model,
                         @PathVariable("maPhieuGiao") UUID maPhieuGiao) {
        PhieuGiaoHang pgh = phieuGiaoHangService.getOne(maPhieuGiao);
        Pageable pageable = PageRequest.of(page, 5);
        Page<PhieuGiaoHang> listPGH = phieuGiaoHangService.getAll(pageable);
        List<HoaDon> listHD = hoaDonService.getAll();
        model.addAttribute("listPGH", listPGH);
        model.addAttribute("listHD", listHD);
        model.addAttribute("phieuGiaoHang", pgh);
        return "index";
    }

    @PostMapping("/phieugiaohang/add")
    public String add(@Valid @ModelAttribute("phieuGiaoHang") PhieuGiaoHang phieuGiaoHang, BindingResult result,
                      @RequestParam(defaultValue = "0") Integer page, Model model) {
        boolean error = result.hasErrors();
        if (phieuGiaoHang.getHoaDon() == null) {
            model.addAttribute("error", "Mời bạn chọn mục hóa đơn");
            error = true;
        }
        if (error) {
            Pageable pageable = PageRequest.of(page, 5);
            Page<PhieuGiaoHang> listPGH = phieuGiaoHangService.getAll(pageable);
            List<HoaDon> listHD = hoaDonService.getAll();
            model.addAttribute("listPGH", listPGH);
            model.addAttribute("listHD", listHD);
            return "index";
        }
        phieuGiaoHangService.save(phieuGiaoHang);
        Pageable pageable = PageRequest.of(page, 5);
        Page<PhieuGiaoHang> listPGH = phieuGiaoHangService.getAll(pageable);
        List<HoaDon> listHD = hoaDonService.getAll();
        model.addAttribute("listPGH", listPGH);
        model.addAttribute("listHD", listHD);
        model.addAttribute("mess", "Thêm thành công");
        return "index";
    }


    @GetMapping("/phieugiaohang/view-update/{maPhieuGiao}")
    public String viewUpdate(@ModelAttribute("phieuGiaoHang") PhieuGiaoHang phieuGiaoHang,
                             @RequestParam(defaultValue = "0") Integer page, Model model,
                             @PathVariable("maPhieuGiao") UUID maPhieuGiao) {
        PhieuGiaoHang pgh = phieuGiaoHangService.getOne(maPhieuGiao);
        Pageable pageable = PageRequest.of(page, 5);
        Page<PhieuGiaoHang> listPGH = phieuGiaoHangService.getAll(pageable);
        List<HoaDon> listHD = hoaDonService.getAll();
        model.addAttribute("listPGH", listPGH);
        model.addAttribute("listHD", listHD);
        model.addAttribute("phieuGiaoHang", pgh);
        return "update";
    }

    @PostMapping("/phieugiaohang/update/{maPhieuGiao}")
    public String update(@Valid @ModelAttribute("phieuGiaoHang") PhieuGiaoHang phieuGiaoHang, BindingResult result,
                         @RequestParam(defaultValue = "0") Integer page, Model model) {
        boolean error = result.hasErrors();
        if (phieuGiaoHang.getHoaDon() == null) {
            model.addAttribute("error", "Mời bạn chọn mục hóa đơn");
            error = true;
        }
        if (error) {
            Pageable pageable = PageRequest.of(page, 5);
            Page<PhieuGiaoHang> listPGH = phieuGiaoHangService.getAll(pageable);
            List<HoaDon> listHD = hoaDonService.getAll();
            model.addAttribute("listPGH", listPGH);
            model.addAttribute("listHD", listHD);
            return "update";
        }
        phieuGiaoHangService.save(phieuGiaoHang);
        Pageable pageable = PageRequest.of(page, 5);
        Page<PhieuGiaoHang> listPGH = phieuGiaoHangService.getAll(pageable);
        List<HoaDon> listHD = hoaDonService.getAll();
        model.addAttribute("listPGH", listPGH);
        model.addAttribute("listHD", listHD);
        model.addAttribute("mess", "Sửa thành công");
        return "index";
    }


    @GetMapping("/phieugiaohang/search")
    public String search(@ModelAttribute("phieuGiaoHang") PhieuGiaoHang phieuGiaoHang,
                         @RequestParam(defaultValue = "0") Integer page, Model model,
                         @RequestParam("ngayGiao") String ngayGiao, @RequestParam("ngayNhan") String ngayNhan,
                         @RequestParam("hoaDon") HoaDon hoaDon) {
        if (ngayGiao.isEmpty() || ngayNhan.isEmpty()) {
            Pageable pageable = PageRequest.of(page, 5);
            Page<PhieuGiaoHang> listPGH = phieuGiaoHangService.searchCBB(hoaDon, pageable);
            List<HoaDon> listHD = hoaDonService.getAll();
            model.addAttribute("listPGH", listPGH);
            model.addAttribute("listHD", listHD);
            return "index";
        }
        Pageable pageable = PageRequest.of(page, 5);
        Page<PhieuGiaoHang> listPGH = phieuGiaoHangService.searchAll(ngayGiao, ngayNhan, hoaDon, pageable);
        List<HoaDon> listHD = hoaDonService.getAll();
        model.addAttribute("listPGH", listPGH);
        model.addAttribute("listHD", listHD);
        return "index";
    }
}
