package fpoly.sd17318.tiepnmph25816.controller;


import com.oracle.wls.shaded.org.apache.xpath.operations.Mod;
import fpoly.sd17318.tiepnmph25816.entity.SinhVien;
import fpoly.sd17318.tiepnmph25816.service.SinhVienService;
import fpoly.sd17318.tiepnmph25816.service.impl.SinhVienServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SinhVienController {

    private SinhVienService sinhVienService = new SinhVienServiceImpl();
    private List<SinhVien> listSinhVien = new ArrayList<>();

    @GetMapping("/sinh-vien/hien-thi")
    public String hienThi(Model model) {
        listSinhVien = sinhVienService.getAll();
        model.addAttribute("listSinhVien", listSinhVien);
        return "sinh-vien";
    }

    @GetMapping("/sinh-vien/detail/{id}")
    public String detail(Model model, @PathVariable("id") int id) {
        SinhVien sv = sinhVienService.detail(listSinhVien, id);
        model.addAttribute("listSinhVien", listSinhVien);
        model.addAttribute("sv", sv);
        return "sinh-vien";
    }

    @GetMapping("/sinh-vien/delete/{id}")
    public String hienThi(Model model, @PathVariable("id") int id) {
        sinhVienService.delete(listSinhVien, id);
        model.addAttribute("listSinhVien", listSinhVien);
        model.addAttribute("mess", "delete thanh cong");
        return "sinh-vien";
    }

    @PostMapping("/sinh-vien/add")
    public String add(@RequestParam("id") int id,
                      @RequestParam("ten") String ten,
                      @RequestParam("tuoi") int tuoi,
                      @RequestParam("diaChi") String diaChi,
                      @RequestParam("gioiTinh") boolean gioiTinh,
                      Model model) {
        SinhVien sinhVien = SinhVien.builder()
                .id(id)
                .ten(ten)
                .tuoi(tuoi)
                .diaChi(diaChi)
                .gioiTinh(gioiTinh)
                .build();
        sinhVienService.add(sinhVien);
        model.addAttribute("listSinhVien", listSinhVien);
        return "sinh-vien";
    }

    @GetMapping("/sinh-vien/search")
    public String search(Model model, @RequestParam("ten") String ten) {
        listSinhVien = sinhVienService.searchTen(listSinhVien, ten);
        model.addAttribute("listSinhVien", listSinhVien);
        return "sinh-vien";
    }

    @GetMapping("/sinh-vien/sinh-vien-nu")
    public String sinhVienNu(Model model) {
        listSinhVien = sinhVienService.sinhVienNu(listSinhVien, false);
        model.addAttribute("listSinhVien", listSinhVien);
        return "sinh-vien";
    }

    @GetMapping("/sinh-vien/sap-xep")
    public String search(Model model) {
        sinhVienService.sapXep(listSinhVien);
        model.addAttribute("listSinhVien", listSinhVien);
        return "sinh-vien";
    }

    @GetMapping("/sinh-vien/view-update/{id}")
    public String viewUpdate(Model model, @PathVariable("id") int id) {
        SinhVien sv = sinhVienService.detail(listSinhVien, id);
        model.addAttribute("listSinhVien", listSinhVien);
        model.addAttribute("sv", sv);
        return "update";
    }

    @PostMapping("/sinh-vien/update")
    public String update(@RequestParam("id") int id,
                         @RequestParam("ten") String ten,
                         @RequestParam("tuoi") int tuoi,
                         @RequestParam("diaChi") String diaChi,
                         @RequestParam("gioiTinh") boolean gioiTinh,
                         Model model) {
        SinhVien sinhVien = sinhVienService.update(listSinhVien, id);
        sinhVien.setTen(ten);
        sinhVien.setTuoi(tuoi);
        sinhVien.setDiaChi(diaChi);
        sinhVien.setGioiTinh(gioiTinh);
        listSinhVien.set(sinhVienService.viTri(listSinhVien, sinhVien.getId()), sinhVien);
        //model.addAttribute("listSinhVien", listSinhVien);
        return "redirect:/sinh-vien/hien-thi";
    }

}
