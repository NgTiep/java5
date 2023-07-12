package fpoly.sd17318.tiepnmph25816.controller;

import fpoly.sd17318.tiepnmph25816.entity.SanPham;
import fpoly.sd17318.tiepnmph25816.service.SanPhamService;
import fpoly.sd17318.tiepnmph25816.service.impl.SanPhamServiceImpl;
import jakarta.validation.Valid;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SanPhamController {

    private List<SanPham> listSanPham = new ArrayList<>();
    private SanPhamService sanPhamService = new SanPhamServiceImpl();

    @GetMapping("/san-pham/hien-thi")
    public String hienThi(Model model, @ModelAttribute("sp") SanPham sanPham) {
        listSanPham = sanPhamService.getAll();
        model.addAttribute("listSanPham", listSanPham);
        model.addAttribute("sp", new SanPham());
        return "san-pham";
    }

    @PostMapping("/san-pham/add")
    public String add(@Valid @ModelAttribute("sp") SanPham sanPham, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("listSanPham", listSanPham);
            return "san-pham";
        } else {
            sanPhamService.add(sanPham);
            return "redirect:/san-pham/hien-thi";
        }
    }

    @GetMapping("/san-pham/detail/{id}")
    public String detail(@ModelAttribute("sp") SanPham sanPham, Model model, @PathVariable("id") int id) {
        SanPham sp = sanPhamService.detail(id);
        model.addAttribute("sp", sp);
        model.addAttribute("listSanPham", listSanPham);
        return "san-pham";
    }

    @GetMapping("/san-pham/delete/{id}")
    public String delete(@ModelAttribute("sp") SanPham sanPham, Model model, @PathVariable("id") int id) {
        sanPhamService.delete(id);
        model.addAttribute("listSanPham", listSanPham);
        return "san-pham";
    }

    @GetMapping("/san-pham/search")
    public String search(@ModelAttribute("sp") SanPham sanPham, Model model,
                         @RequestParam("ten") String ten) {
        listSanPham = sanPhamService.searchTen(listSanPham,ten);
        model.addAttribute("listSanPham", listSanPham);
        return "san-pham";
    }

    @GetMapping("/san-pham/nam")
    public String sanPhamNam(@ModelAttribute("sp") SanPham sanPham, Model model) {
       listSanPham= sanPhamService.nam(listSanPham,true);
        model.addAttribute("listSanPham", listSanPham);
        return "san-pham";
    }

    @GetMapping("/san-pham/sap-xep")
    public String sapXep(@ModelAttribute("sp") SanPham sanPham, Model model) {
        sanPhamService.sapXep(listSanPham);
        model.addAttribute("listSanPham", listSanPham);
        return "san-pham";
    }

    @GetMapping("/san-pham/view-update/{id}")
    public String viewUpdate(@ModelAttribute("sp") SanPham sanPham, Model model, @PathVariable("id") int id) {
        SanPham sp = sanPhamService.detail(id);
        model.addAttribute("sp", sp);
        return "update";
    }

    @PostMapping("/san-pham/update/{id}")
    public String update(@Valid @ModelAttribute("sp") SanPham sanPham, BindingResult result, Model model, @PathVariable("id") int id) {
        if (result.hasErrors()) {
            model.addAttribute("listSanPham", listSanPham);
            return "update";
        } else {
            int viTri = sanPhamService.viTri(listSanPham,id);
            listSanPham.set(viTri,sanPham);
            return "redirect:/san-pham/hien-thi";
        }
    }
}
