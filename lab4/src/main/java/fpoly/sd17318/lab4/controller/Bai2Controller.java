package fpoly.sd17318.lab4.controller;

import fpoly.sd17318.lab4.service.CookieService;
import fpoly.sd17318.lab4.service.ParamService;
import fpoly.sd17318.lab4.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Bai2Controller {
    @Autowired
    CookieService cookieService;

    @Autowired
    ParamService paramService;

    @Autowired
    SessionService sessionService;

    @GetMapping("/account/login")
    public String login1() {
        return "/account/login";
    }

    @PostMapping("/account/login")
    public String login2(Model model) {
        String un = paramService.getString("username", "");
        String pw = paramService.getString("password", "");
        boolean rm = paramService.getBoolean("remember", false);
        // TODO
        System.out.println(un+":"+pw+":"+rm);
        if (un.equals("poly") && pw.equals("123")) {
            if (rm) {
                cookieService.add("user", un, 10);
            } else {
                cookieService.remove("user");
            }
            model.addAttribute("mess", "Login thành công");
            return "/account/login";
        } else {
            model.addAttribute("mess", "Login thất bai");
            return "/account/login";
        }
    }

}
