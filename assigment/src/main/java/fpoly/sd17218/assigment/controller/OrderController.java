package fpoly.sd17218.assigment.controller;

import fpoly.sd17218.assigment.entity.Accounts;
import fpoly.sd17218.assigment.entity.Category;
import fpoly.sd17218.assigment.entity.Order;
import fpoly.sd17218.assigment.service.AccountService;
import fpoly.sd17218.assigment.service.CategoryService;
import fpoly.sd17218.assigment.service.OrderService;
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
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    AccountService accountService;

    @GetMapping("/order/hien-thi")
    public String hienThi(@RequestParam(defaultValue = "0") Integer number, Model model) {
        Pageable pageable = PageRequest.of(number, 2);
        Page<Order> listOrder = orderService.getAll(pageable);
        model.addAttribute("listOrder", listOrder);
        return "order/index";
    }

    @GetMapping("/order/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        orderService.delete(id);
        Pageable pageable = PageRequest.of(0, 2);
        Page<Order> listOrder = orderService.getAll(pageable);
        model.addAttribute("listOrder", listOrder);
        return "order/index";
    }

    @GetMapping("/order/view-update/{id}")
    public String viewUpdate(@ModelAttribute("order") Order order, @PathVariable("id") Long id, Model model) {
        Order od = orderService.getOne(id);
        model.addAttribute("order", od);
        List<Accounts> listAccount = accountService.findAll();
        model.addAttribute("listAccount", listAccount);
        return "order/update";
    }


    @PostMapping("/order/update/{id}")
    public String update(@Valid @ModelAttribute("order") Order order, BindingResult result, @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            List<Accounts> listAccount = accountService.findAll();
            model.addAttribute("listAccount", listAccount);
            return "order/update";
        }
        Accounts accounts = accountService.getOne(order.getAccount().getUsername());
        order.setAccount(accounts);
        orderService.update(order);
        Pageable pageable = PageRequest.of(0, 2);
        Page<Order> listOrder = orderService.getAll(pageable);
        model.addAttribute("listOrder", listOrder);
        return "order/index";
    }


    @GetMapping("/order/view-add")
    public String viewAdd(@ModelAttribute("order") Order order, Model model) {
        List<Accounts> listAccount = accountService.findAll();
        model.addAttribute("listAccount", listAccount);
        return "order/add";
    }


    @PostMapping("/order/add")
    public String add(@Valid @ModelAttribute("order") Order order, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<Accounts> listAccount = accountService.findAll();
            model.addAttribute("listAccount", listAccount);
            return "order/add";
        }
        orderService.add(order);
        Pageable pageable = PageRequest.of(0, 2);
        Page<Order> listOrder = orderService.getAll(pageable);
        model.addAttribute("listOrder", listOrder);
        return "order/index";
    }
}
