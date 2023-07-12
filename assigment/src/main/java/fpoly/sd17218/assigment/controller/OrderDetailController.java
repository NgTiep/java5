package fpoly.sd17218.assigment.controller;

import fpoly.sd17218.assigment.entity.OrderDetails;
import fpoly.sd17218.assigment.repository.OrderDetailRepository;
import fpoly.sd17218.assigment.service.OrderDetailService;
import fpoly.sd17218.assigment.service.OrderService;
import fpoly.sd17218.assigment.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class OrderDetailController {

    @Autowired
    ProductService productService;

    @Autowired
    OrderService  orderService;

    @Autowired
    OrderDetailService orderDetailService;

    @Autowired
    OrderDetailRepository repo;

    private  Pageable pageable;

    @GetMapping("/hien-thi")
    public String hienThi(@RequestParam(defaultValue = "0") Integer number, Model model) {
        Pageable pageable = PageRequest.of(number, 2);
        List<OrderDetails> list = repo.findAll();
        //model.addAttribute("list", list);
        return "order_detail/index";
    }

//
//    @GetMapping("/orderDetail/delete/{id}")
//    public String delete(@PathVariable("id") Long id, Model model) {
//        orderDetailService.delete(id);
//        Pageable pageable = PageRequest.of(0, 2);
//        Page<OrderDetail> listOrderDetail = orderDetailService.getAll(pageable);
//        model.addAttribute("listOrderDetail", listOrderDetail);
//        return "orderDetail/index";
//    }
//
//
//    @GetMapping("/orderDetail/view-update/{id}")
//    public String viewUpdate(@ModelAttribute("orderDetail") OrderDetail orderDetail, @PathVariable("id") Long id, Model model) {
//        OrderDetail od = orderDetailService.getOne(id);
//        model.addAttribute("orderDetail", od);
//        pageable = PageRequest.of(0, 2);
//        Page<Product> listProduct = productService.getAll(pageable);
//        Page<Order> listOrder = orderService.getAll(pageable);
//        model.addAttribute("listProduct", listProduct);
//        model.addAttribute("listOrder", listOrder);
//        return "orderDetail/update";
//    }
//
//    @GetMapping("/orderDetail/view-add")
//    public String viewAdd(@ModelAttribute("orderDetail") OrderDetail orderDetail, Model model) {
//        Pageable pageable = PageRequest.of(0, 2);
//        Page<Product> listProduct = productService.getAll(pageable);
//        Page<Order> listOrder = orderService.getAll(pageable);
//        model.addAttribute("listProduct", listProduct);
//        model.addAttribute("listOrder", listOrder);
//        return "orderDetail/add";
//    }
}


