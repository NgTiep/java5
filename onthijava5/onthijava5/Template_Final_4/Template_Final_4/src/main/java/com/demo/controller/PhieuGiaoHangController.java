package com.demo.controller;

import com.demo.entity.DiaChi;
import com.demo.entity.PhieuGiaoHang;
import com.demo.service.DiaChiService;
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
    DiaChiService diaChiService;

    @Autowired
    PhieuGiaoHangService phieuGiaoHangService;

    @GetMapping("/phieu-giao-hang/hien-thi")
    public String hienThi(@ModelAttribute("phieuGiaoHang") PhieuGiaoHang phieuGiaoHang,
                          @RequestParam(defaultValue = "0") Integer page, Model model) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<PhieuGiaoHang> listPGH = phieuGiaoHangService.getAll(pageable);
        List<DiaChi> listDC = diaChiService.getAll();
        model.addAttribute("listPGH", listPGH);
        model.addAttribute("listDC", listDC);
        return "index";
    }

    @GetMapping("/phieu-giao-hang/delete/{maPhieuGiao}")
    public String delete(@ModelAttribute("phieuGiaoHang") PhieuGiaoHang phieuGiaoHang,
                         @RequestParam(defaultValue = "0") Integer page, Model model,
                         @PathVariable("maPhieuGiao") UUID maPhieuGiao) {
        phieuGiaoHangService.delete(maPhieuGiao);
        Pageable pageable = PageRequest.of(page, 5);
        Page<PhieuGiaoHang> listPGH = phieuGiaoHangService.getAll(pageable);
        List<DiaChi> listDC = diaChiService.getAll();
        model.addAttribute("listPGH", listPGH);
        model.addAttribute("listDC", listDC);
        model.addAttribute("mess", "Xóa thành công");
        return "index";
    }

    @GetMapping("/phieu-giao-hang/detail/{maPhieuGiao}")
    public String detail(@ModelAttribute("phieuGiaoHang") PhieuGiaoHang phieuGiaoHang,
                         @RequestParam(defaultValue = "0") Integer page, Model model,
                         @PathVariable("maPhieuGiao") UUID maPhieuGiao) {
        PhieuGiaoHang pgh = phieuGiaoHangService.getOne(maPhieuGiao);
        Pageable pageable = PageRequest.of(page, 5);
        Page<PhieuGiaoHang> listPGH = phieuGiaoHangService.getAll(pageable);
        List<DiaChi> listDC = diaChiService.getAll();
        model.addAttribute("listPGH", listPGH);
        model.addAttribute("listDC", listDC);
        model.addAttribute("phieuGiaoHang", pgh);
        return "index";
    }


    @PostMapping("/phieu-giao-hang/add")
    public String add(@Valid @ModelAttribute("phieuGiaoHang") PhieuGiaoHang phieuGiaoHang, BindingResult result,
                      @RequestParam(defaultValue = "0") Integer page, Model model) {
        if (result.hasErrors()) {
            Pageable pageable = PageRequest.of(page, 5);
            Page<PhieuGiaoHang> listPGH = phieuGiaoHangService.getAll(pageable);
            List<DiaChi> listDC = diaChiService.getAll();
            model.addAttribute("listPGH", listPGH);
            model.addAttribute("listDC", listDC);
            return "index";
        }
        phieuGiaoHangService.save(phieuGiaoHang);
        Pageable pageable = PageRequest.of(page, 5);
        Page<PhieuGiaoHang> listPGH = phieuGiaoHangService.getAll(pageable);
        List<DiaChi> listDC = diaChiService.getAll();
        model.addAttribute("listPGH", listPGH);
        model.addAttribute("listDC", listDC);
        model.addAttribute("mess", "Thêm thành công");
        return "index";
    }


    @GetMapping("/phieu-giao-hang/view-update/{maPhieuGiao}")
    public String viewUpdate(@ModelAttribute("phieuGiaoHang") PhieuGiaoHang phieuGiaoHang,
                             @RequestParam(defaultValue = "0") Integer page, Model model,
                             @PathVariable("maPhieuGiao") UUID maPhieuGiao) {
        PhieuGiaoHang pgh = phieuGiaoHangService.getOne(maPhieuGiao);
        Pageable pageable = PageRequest.of(page, 5);
        Page<PhieuGiaoHang> listPGH = phieuGiaoHangService.getAll(pageable);
        List<DiaChi> listDC = diaChiService.getAll();
        model.addAttribute("listPGH", listPGH);
        model.addAttribute("listDC", listDC);
        model.addAttribute("phieuGiaoHang", pgh);
        return "update";
    }


    @PostMapping("/phieu-giao-hang/update/{maPhieuGiao}")
    public String update(@Valid @ModelAttribute("phieuGiaoHang") PhieuGiaoHang phieuGiaoHang, BindingResult result,
                         @RequestParam(defaultValue = "0") Integer page, Model model) {
        if (result.hasErrors()) {
            Pageable pageable = PageRequest.of(page, 5);
            Page<PhieuGiaoHang> listPGH = phieuGiaoHangService.getAll(pageable);
            List<DiaChi> listDC = diaChiService.getAll();
            model.addAttribute("listPGH", listPGH);
            model.addAttribute("listDC", listDC);
            return "update";
        }
        phieuGiaoHangService.save(phieuGiaoHang);
        Pageable pageable = PageRequest.of(page, 5);
        Page<PhieuGiaoHang> listPGH = phieuGiaoHangService.getAll(pageable);
        List<DiaChi> listDC = diaChiService.getAll();
        model.addAttribute("listPGH", listPGH);
        model.addAttribute("listDC", listDC);
        model.addAttribute("mess", "Sửa thành công");
        return "index";
    }

    @GetMapping("/phieu-giao-hang/search")
    public String search(@ModelAttribute("phieuGiaoHang") PhieuGiaoHang phieuGiaoHang,
                         @RequestParam(defaultValue = "0") Integer page, Model model,
                         @RequestParam("nhapGiaTri") String nhapGiaTri, @RequestParam("diaChi") DiaChi diaChi) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<PhieuGiaoHang> listPGH = phieuGiaoHangService.search(nhapGiaTri, diaChi, pageable);
        List<DiaChi> listDC = diaChiService.getAll();
        model.addAttribute("listPGH", listPGH);
        model.addAttribute("listDC", listDC);
        return "index";
    }
}
