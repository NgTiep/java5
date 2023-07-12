package fpoly.sd17218.assigment.controller;

import fpoly.sd17218.assigment.entity.Accounts;
import fpoly.sd17218.assigment.service.AccountService;
import jakarta.validation.Valid;
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

import java.util.List;

@Controller
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/account/hien-thi")
    public String hienThi(@RequestParam(defaultValue = "0") Integer number, Model model) {
        Pageable pageable = PageRequest.of(number,2);
        Page<Accounts> listAccount = accountService.getAll(pageable);
        model.addAttribute("listAccount", listAccount);
        return "account/index";
    }

    @GetMapping("/account/delete/{username}")
    public String delete(@PathVariable("username") String username, Model model) {
        accountService.delete(username);
        Pageable pageable = PageRequest.of(0,2);
        Page<Accounts> listAccount = accountService.getAll(pageable);
        model.addAttribute("listAccount", listAccount);
        return "account/index";
    }

    @GetMapping("/account/view-update/{username}")
    public String viewUpdate(@ModelAttribute("account") Accounts account, @PathVariable("username") String username, Model model) {
        Accounts accounts = accountService.getOne(username);
        model.addAttribute("account", accounts);
        return "account/update";
    }


    @PostMapping("/account/update/{username}")
    public String update(@Valid @ModelAttribute("account") Accounts account, BindingResult result, @PathVariable("username") String username, Model model) {
        if(result.hasErrors()){
            return "account/add";
        }
        accountService.update(account);
        Pageable pageable = PageRequest.of(0,2);
        Page<Accounts> listAccount = accountService.getAll(pageable);
        model.addAttribute("listAccount", listAccount);
        return "account/index";
    }


    @GetMapping("/account/view-add")
    public String viewAdd(@ModelAttribute("account") Accounts account, Model model){
        return "account/add";
    }


    @PostMapping("/account/add")
    public String add(@Valid @ModelAttribute("account") Accounts account, BindingResult result, Model model) {
        if(result.hasErrors()){
            return "account/add";
        }
        accountService.add(account);
        Pageable pageable = PageRequest.of(0,2);
        Page<Accounts> listAccount = accountService.getAll(pageable);
        model.addAttribute("listAccount", listAccount);
        return "account/index";
    }
}
