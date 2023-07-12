package fpoly.sd17318.lab4.controller;


import fpoly.sd17318.lab4.entity.SanPham;
import fpoly.sd17318.lab4.service.SanPhamService;
import fpoly.sd17318.lab4.service.impl.SanPhamServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Bai45Controller {

    private List<SanPham> listSanPham = new ArrayList<>();
    private SanPhamService sanPhamService = new SanPhamServiceImpl();

    @GetMapping("/san-pham/hien-thi")
    public String hienThi(Model model){
        listSanPham = sanPhamService.getAll();
        model.addAttribute("listSanPham",listSanPham);
        return"/bai4-5/hien-thi";
    }

    @GetMapping("/san-pham/detail/{id}")
    public String detail(@ModelAttribute("sp") SanPham sanPham, @PathVariable("id") int id, Model model){
        SanPham sp = sanPhamService.detail(id);
        model.addAttribute("sp",sp);
        return"/bai4-5/detail";
    }

    @GetMapping("/san-pham/clear")
    public String clear(@ModelAttribute("sp") SanPham sanPham, Model model){
        sanPhamService.clear();
        return"/bai4-5/hien-thi";
    }

    @GetMapping("/san-pham/delete/{id}")
    public String delete(@ModelAttribute("sp") SanPham sanPham, @PathVariable("id") int id, Model model){
        sanPhamService.delete(id);
        model.addAttribute("listSanPham",listSanPham);
        return"/bai4-5/hien-thi";
    }

    @GetMapping("/san-pham/view-add")
    public String viewAdd(@ModelAttribute("sp") SanPham sanPham, Model model){
        model.addAttribute("sp",new SanPham());
        return"/bai4-5/add";
    }

    @PostMapping("/san-pham/add")
    public String add(@ModelAttribute("sp") SanPham sanPham, Model model){
        sanPhamService.add(sanPham);
        return"redirect:/san-pham/hien-thi";
    }

    @GetMapping("/san-pham/view-update/{id}")
    public String viewUpdate(@ModelAttribute("sp") SanPham sanPham, @PathVariable("id") int id, Model model){
        SanPham sp = sanPhamService.detail(id);
        model.addAttribute("sp",sp);
        return"/bai4-5/update";
    }

    @PostMapping("/san-pham/update/{id}")
    public String update(@ModelAttribute("sp") SanPham sanPham, @PathVariable("id") int id, Model model){
        int viTri = sanPhamService.viTri(listSanPham,id);
        listSanPham.set(viTri,sanPham);
        return"redirect:/san-pham/hien-thi";

    }

}
