package com.example.sd17306.controller;

import com.example.sd17306.viewmodel.QLCuaHang;
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
public class CuaHangController {

    private List<QLCuaHang> list = new ArrayList<>();
    private String viTriUpdate;

    @GetMapping ( "index" )
    public String index ( Model model ) {
        if (list.isEmpty()) {
            listFixCung();
        }
        model.addAttribute("listCuaHang" , list);
        return "index";
    }

    @GetMapping ( "create" )
    public String create ( Model model ) {
        QLCuaHang qlCuaHang = new QLCuaHang();
        qlCuaHang.setMa("CH05");
        qlCuaHang.setTen("Gà Rán KFC");
        qlCuaHang.setDiaChi("Thai Bình Nam Bắc");
        qlCuaHang.setThanhPho("Đà Nẵng Thứ 2");
        qlCuaHang.setQuocGia("Việt Nam");
        model.addAttribute("cuaHang" , qlCuaHang);
        return "create";
    }

    @GetMapping ( "edit/{ma}" )
    public String edit ( @PathVariable ( value = "ma" ) String ma , Model model ) {
        viTriUpdate = ma;
        for (QLCuaHang qlCuaHang : list) {
            if (qlCuaHang.getMa().equals(ma)) {
                model.addAttribute("editCuaHang" , qlCuaHang);
            }
        }
        return "edit";
    }

    @GetMapping ( "delete/{ma}" )
    public String delete ( @PathVariable ( value = "ma" ) String ma, Model model) {
        QLCuaHang qlCuaHang = null;
        for (QLCuaHang x : list) {
            if (x.getMa().equals(ma)) {
                qlCuaHang = x;
            }
        }
        list.remove(qlCuaHang);
        return "redirect:/index";
    }

    @PostMapping ( "store" )
    public String store (
            //BindingResult phải nằm sau cái javabean
            @Valid @ModelAttribute ( "cuaHang" ) QLCuaHang qlCuaHang , BindingResult result , Model model
    ) {
        if (result.hasErrors()) {
            model.addAttribute("mess" , "Something not right");
            return "create";
        } else {
            model.addAttribute("mess" , "All are working properly");
            list.add(qlCuaHang);
            return "redirect:/index";
        }
//        qlCuaHang.setTen(qlCuaHang.getTen().toUpperCase(Locale.ROOT));

//        return "redirect:index";
    }

    @PostMapping ( "update" )
    public String update ( @Valid @ModelAttribute ( "editCuaHang" ) QLCuaHang qlCuaHang , BindingResult result , Model model ) {
//        int viTri = - 1;
//        for (QLCuaHang x : list) {
//            viTri++;
//            if (x.getMa().equals(viTriUpdate)) {
//                list.set(viTri , qlCuaHang);
//            }
//        }
        if (result.hasErrors()) {
            model.addAttribute("mess" , "Something not right");
            return "edit";
        } else {
            model.addAttribute("mess" , "Everything okay!");
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getMa().equals(viTriUpdate)) {
                    list.set(i , qlCuaHang);
                }
            }
            return "redirect:/index";
        }
    }

    private void listFixCung () {
        list.add(new QLCuaHang("CH01" , "Ga Xoi Mo" , "Thanh Cong 12" , "Ha Noi" , "Viet Nam"));
        list.add(new QLCuaHang("CH02" , "Pho bo" , "Lang Thuong" , "Da Nang" , "Viet Nam"));
        list.add(new QLCuaHang("CH03" , "Bun bo Hue" , "Giap Bat" , "Can Tho" , "Viet Nam"));
    }

}
