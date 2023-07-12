package fpoly.sd17318.tiepnmph25816.controller;

import fpoly.sd17318.tiepnmph25816.entity.LopHoc;
import fpoly.sd17318.tiepnmph25816.service.LopHocService;
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

@Controller
public class LopHocController {

    @Autowired
    LopHocService lopHocService;
    private Page<LopHoc> pageLopHoc;


    @GetMapping("/")
    public String index(@ModelAttribute("lopHoc") LopHoc lopHoc, Model model){
        return "hien-thi";
    }

    @GetMapping("/lop-hoc/hien-thi")
    public String hienThi(@ModelAttribute("lopHoc") LopHoc lopHoc, Model model, @RequestParam(defaultValue = "0") int phanTu) {
        Pageable pageable = PageRequest.of(phanTu, 5);
        pageLopHoc = lopHocService.getAll(pageable);
        model.addAttribute("pageLopHoc", pageLopHoc);
        return "hien-thi";
    }

    @GetMapping("/lop-hoc/detail/{id}")
    public String detail(Model model, @PathVariable("id") Long id) {
        LopHoc lh = lopHocService.detail(id);
        model.addAttribute("lopHoc", lh);
        model.addAttribute("pageLopHoc", pageLopHoc);
        return "hien-thi";
    }

    @GetMapping("/lop-hoc/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        lopHocService.delete(id);
        return "redirect:/lop-hoc/hien-thi";
    }

    @PostMapping("/lop-hoc/add")
    public String add(@ModelAttribute("lopHoc") LopHoc lopHoc) {
        lopHocService.add(lopHoc);
        return "redirect:/lop-hoc/hien-thi";
    }

    @GetMapping("/lop-hoc/view-update/{id}")
    public String viewUpdate(Model model, @PathVariable("id") Long id) {
        LopHoc lh = lopHocService.detail(id);
        model.addAttribute("lh", lh);
        return "update";
    }

    @PostMapping("/lop-hoc/update/{id}")
    public String update(@ModelAttribute("lopHoc") LopHoc lopHoc, @PathVariable("id") Long id) {
        lopHocService.update(lopHoc);
        return "redirect:/lop-hoc/hien-thi";
    }


    @GetMapping("/lop-hoc/search")
    public String delete(@RequestParam("name") String name, Model model) {
        List<LopHoc> search = lopHocService.search(name);
        model.addAttribute("pageLopHoc", search);
        return "redirect:/lop-hoc/hien-thi";
    }

}
