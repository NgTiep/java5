package fpoly.sd17218.btvn.controller;

import fpoly.sd17218.btvn.entity.ChucVu;
import fpoly.sd17218.btvn.entity.CuaHang;
import fpoly.sd17218.btvn.entity.NhanVien;
import fpoly.sd17218.btvn.service.ChucVuService;
import fpoly.sd17218.btvn.service.CuaHangService;
import fpoly.sd17218.btvn.service.NhanVienService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
public class NhanVienController {

    @Autowired
    NhanVienService nhanVienService;

    @Autowired
    ChucVuService chucVuService;

    @Autowired
    CuaHangService cuaHangService;


    @GetMapping("/nhan-vien/hien-thi")
    public String hienThi(@RequestParam(defaultValue = "0", name = "page") Integer number, Model model) {
        Pageable pageable = PageRequest.of(number, 2);
        Page<NhanVien> listNhanVien = nhanVienService.getAll(pageable);
        model.addAttribute("listNhanVien", listNhanVien);
        return "hien-thi";
    }

    @GetMapping("/nhan-vien/detail/{id}")
    public String detail(@PathVariable("id") UUID id, Model model) {
        NhanVien nv = nhanVienService.getOne(id);
        model.addAttribute("nv", nv);
        return "detail";
    }


    @GetMapping("/nhan-vien/delete/{id}")
    public String delete(@PathVariable("id") UUID id, Model model) {
        nhanVienService.delete(id);
        Pageable pageable = PageRequest.of(0, 2);
        Page<NhanVien> listNhanVien = nhanVienService.getAll(pageable);
        model.addAttribute("listNhanVien", listNhanVien);
        model.addAttribute("mess", "delete thanh cong");
        return "hien-thi";
    }


    @GetMapping("/nhan-vien/view-add")
    public String viewAdd(@ModelAttribute("nhanVien") NhanVien nhanVien, Model model) {
        List<CuaHang> listCuaHang = cuaHangService.getAll();
        List<ChucVu> listChucVu = chucVuService.getAll();
        model.addAttribute("listCuaHang", listCuaHang);
        model.addAttribute("listChucVu", listChucVu);
        return "add";
    }


    @PostMapping("/nhan-vien/add")
    public String add(@Valid @ModelAttribute("nhanVien") NhanVien nhanVien, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<CuaHang> listCuaHang = cuaHangService.getAll();
            List<ChucVu> listChucVu = chucVuService.getAll();
            model.addAttribute("listCuaHang", listCuaHang);
            model.addAttribute("listChucVu", listChucVu);
            return "add";
        }
        nhanVienService.add(nhanVien);
        Pageable pageable = PageRequest.of(0, 2);
        Page<NhanVien> listNhanVien = nhanVienService.getAll(pageable);
        model.addAttribute("listNhanVien", listNhanVien);
        model.addAttribute("mess", "add thanh cong");
        return "hien-thi";
    }


    @GetMapping("/nhan-vien/view-update/{id}")
    public String viewUpdate(@ModelAttribute("nhanVien") NhanVien nhanVien, @PathVariable("id") UUID id, Model model) {
        NhanVien nv = nhanVienService.getOne(id);
        List<CuaHang> listCuaHang = cuaHangService.getAll();
        List<ChucVu> listChucVu = chucVuService.getAll();
        model.addAttribute("listCuaHang", listCuaHang);
        model.addAttribute("listChucVu", listChucVu);
        model.addAttribute("nhanVien", nv);
        return "update";
    }

    @PostMapping("/nhan-vien/update/{id}")
    public String update(@Valid @ModelAttribute("nhanVien") NhanVien nhanVien, BindingResult result, @PathVariable("id") UUID id, Model model) {
        if (result.hasErrors()) {
            List<CuaHang> listCuaHang = cuaHangService.getAll();
            List<ChucVu> listChucVu = chucVuService.getAll();
            model.addAttribute("listCuaHang", listCuaHang);
            model.addAttribute("listChucVu", listChucVu);
            return "update";
        }
        CuaHang cuaHang = cuaHangService.getOne(nhanVien.getCuaHang().getId());
        ChucVu chucVu = chucVuService.getOne(nhanVien.getChucVu().getId());
        nhanVien.setChucVu(chucVu);
        nhanVien.setCuaHang(cuaHang);
        nhanVienService.update(nhanVien);
        Pageable pageable = PageRequest.of(0, 2);
        Page<NhanVien> listNhanVien = nhanVienService.getAll(pageable);
        model.addAttribute("listNhanVien", listNhanVien);
        model.addAttribute("mess", "update thanh cong");
        return "hien-thi";
    }


    @GetMapping("/nhan-vien/search")
    public String search(@RequestParam(defaultValue = "0", name = "page") Integer number, @RequestParam("ten") String ten, Model model) {
//        Sort sort = Sort.by(Sort.Direction.ASC, "ten");
        Pageable pageable = PageRequest.of(number, 5);
        Page<NhanVien> listNhanVien = nhanVienService.search(ten, pageable);
        model.addAttribute("listNhanVien", listNhanVien);
        return "hien-thi";
    }

    @GetMapping("/nhan-vien/sap-xep")
    public String sapXep(@RequestParam(defaultValue = "0", name = "page") Integer number, Model model) {
//        Sort sort = Sort.by(Sort.Direction.ASC, "ten");
        Pageable pageable = PageRequest.of(number, 2);
        Page<NhanVien> listNhanVien = nhanVienService.sort(pageable);
        model.addAttribute("listNhanVien", listNhanVien);
        return "hien-thi";
    }
}
