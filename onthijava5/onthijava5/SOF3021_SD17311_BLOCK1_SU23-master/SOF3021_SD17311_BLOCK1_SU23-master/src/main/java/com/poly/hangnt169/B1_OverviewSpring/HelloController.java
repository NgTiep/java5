package com.poly.hangnt169.B1_OverviewSpring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
// Tat ca cac class trong com => Deu la bean duoc Spring quan ly.
// Khi danh dau la @Controller => Class nay (Tang nay ) => La tang controller
// Dung de trao doi giua client & server
public class HelloController {
    // Client & Server giao tiếp thông qua phương thức HTTP
    // Co 4 loai HTTP co ban:
    // GET      <=>  READ
    // POST     <=> CREATE
    // PUT      <=> UPDATE
    // DELETE   <=> DELETE
    // Với Java 4, 5 dùng 2 loại : GET , POST
    // GET: Hiển thị / Lấy dữ liệu
    // POST: Xử lý

    // Khi dung @Controller  => Mô hình trong project
    // MVC(MODEL - VIEW - CONTROLLER)
    // => Tất cả request trong controller luôn luôn trả về 1 VIEW
    // <=> RETURN STRING
    // C1: @GetMapping
//    @GetMapping("/demo")
    // C2: @RequestMapping
    @RequestMapping(value = "/demo",method = RequestMethod.POST)
    public String hienThiHelloworld(Model model){
        // Truyen gia tri tu phia controller sang view
        // J4: request.setAttribute("ten Bien day sang JSP",
        // gia tri muon truyen sang: 1 list, 1 doi tuong...)
        // J5: Model
        model.addAttribute("name","aaa");
        return "buoi1";
    }
}
