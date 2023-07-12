package fpoly.sd17318.tiepnmph25816.controller;

import fpoly.sd17318.tiepnmph25816.entity.GiangVien;
import fpoly.sd17318.tiepnmph25816.service.GiangVienService;
import fpoly.sd17318.tiepnmph25816.service.impl.GiangVienServiceImpl;
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
public class GiangVienController {

    private List<GiangVien> listGiangVien = new ArrayList<>();
    private GiangVienService giangVienService = new GiangVienServiceImpl();

    @GetMapping("/giang-vien/hien-thi")
    public String hienThi(Model model){
        listGiangVien = giangVienService.getAll();
        model.addAttribute("listGiangVien",listGiangVien);
        model.addAttribute("gv", new GiangVien());
        return "hien-thi";
    }

    @GetMapping("/giang-vien/view-add")
    public String viewAdd(Model model) {
        model.addAttribute("gv", new GiangVien());
        return "add";
    }

    @PostMapping("/giang-vien/add")
    public String add(@Valid @ModelAttribute("gv") GiangVien giangVien, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("listGiangVien",listGiangVien);
            return "add";
        }else{
            model.addAttribute("mess","Add thanh cong");
            giangVienService.add(giangVien);
            return "redirect:/giang-vien/hien-thi";
        }
    }

    @GetMapping("/giang-vien/detail/{ma}")
    public String detail(Model model, @PathVariable("ma") String ma){
        GiangVien gv = giangVienService.detail(ma);
        model.addAttribute("gv",gv);
        return "detail";
    }

    @GetMapping("/giang-vien/delete/{ma}")
    public String delete( @PathVariable("ma") String ma, Model model){
        giangVienService.delete(ma);
        model.addAttribute("listGiangVien",listGiangVien);
        return "hien-thi";
    }

    @GetMapping("/giang-vien/view-update/{ma}")
    public String viewUpdate(Model model, @PathVariable("ma") String ma) {
        GiangVien gv = giangVienService.detail(ma);
        model.addAttribute("gv",gv);
        return "update";
    }

    @PostMapping("/giang-vien/update/{ma}")
    public String update(@ModelAttribute("gv") GiangVien giangVien, @PathVariable("ma") String ma, BindingResult result){
        if(result.hasErrors()){
            return "update";
        }else{
            GiangVien gv = giangVienService.detail(ma);
            listGiangVien.set(giangVienService.viTri(listGiangVien, ma),giangVien);
            return "redirect:/giang-vien/hien-thi";
        }
    }
}
