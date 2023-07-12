package com.demo.controller;

import com.demo.model.Account;
import com.demo.model.Category;
import com.demo.model.Order;
import com.demo.model.OrderDetail;
import com.demo.model.Product;
import com.demo.service.AccountService;
import com.demo.service.CategoryService;
import com.demo.service.OrderDetailService;
import com.demo.service.OrderService;
import com.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    AccountService accountService;

    @Autowired
    ProductService productService;

    @Autowired
    OrderService orderService;

    @Autowired
    OrderDetailService orderDetailService;

    //Category
    @RequestMapping("/admin/category/index")
    public String listCategory(Model model) {
        Category item = new Category();
        model.addAttribute("item", item);
        List<Category> items = categoryService.getAll();
        model.addAttribute("items", items);
        return "admin/category/index";
    }

    @RequestMapping("/admin/category/create")
    public String createCategory(Category category) {
        categoryService.add(category);
        return "redirect:/admin/category/index";
    }

    @RequestMapping("/admin/category/edit/{id}")
    public String editCategory(@PathVariable("id") String id, Model model) {
        Category item = categoryService.getOne(id);
        model.addAttribute("item", item);
        List<Category> items = categoryService.getAll();
        model.addAttribute("items", items);
        return "admin/category/index";
    }

    @RequestMapping("/admin/category/update")
    public String update(Category item) {
        categoryService.update(item);
        return "redirect:/admin/category/edit/" + item.getId();
    }


    @RequestMapping("/admin/category/delete/{id}")
    public String delete(@PathVariable("id") String id) {

        categoryService.delete(id);
        return "redirect:/admin/category/index";
    }

    //  Product
    @RequestMapping("/admin/product/index")
    public String listProduct(Model model) {
        Product item = new Product();
        model.addAttribute("item", item);
        List<Product> items = productService.getAll();
        model.addAttribute("items", items);
        List<Category> listCategory = categoryService.getAll();
        model.addAttribute("listCategory", listCategory);
        return "admin/product/index";
    }

    @RequestMapping("/admin/product/create")
    public String createProduct(Product product) {
        productService.add(product);
        return "redirect:/admin/product/index";
    }

    @RequestMapping("/admin/product/edit/{id}")
    public String editProduct(@PathVariable("id") Integer id, Model model) {
        Product item = productService.getOne(id);
        model.addAttribute("item", item);
        List<Product> items = productService.getAll();
        model.addAttribute("items", items);
        List<Category> listCategory = categoryService.getAll();
        model.addAttribute("listCategory", listCategory);
        return "admin/product/index";
    }

    @RequestMapping("/admin/product/update")
    public String updateProduct(Product product) {
        productService.update(product);
        return "redirect:/admin/product/edit/" + product.getId();
    }


    @RequestMapping("/admin/product/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id) {
        productService.delete(id);
        return "redirect:/admin/product/index";
    }


    //  Account
    @RequestMapping("/admin/account/index")
    public String listAccount(Model model) {
        Account item = new Account();
        model.addAttribute("item", item);
        List<Account> items = accountService.getAll();
        model.addAttribute("items", items);
        return "admin/account/index";
    }

    @RequestMapping("/admin/account/create")
    public String creatAccount(Account account) {
        accountService.add(account);
        return "redirect:/admin/account/index";
    }

    @RequestMapping("/admin/account/edit/{username}")
    public String editAccount(@PathVariable("username") String username, Model model) {
        Account item = accountService.getOne(username);
        model.addAttribute("item", item);
        List<Account> items = accountService.getAll();
        model.addAttribute("items", items);
        return "admin/account/index";
    }

    @RequestMapping("/admin/account/update")
    public String update(Account account) {
        accountService.update(account);
        return "redirect:/admin/account/edit/" + account.getUsername();
    }


    @RequestMapping("/admin/account/delete/{username}")
    public String deleteAccount(@PathVariable("username") String username, Model model) {

        try {

            accountService.delete(username);
            model.addAttribute("message", "Xoa order truoc");
        } catch (Exception e) {
            System.out.println("hehehe:" + e);
        }

        return "redirect:/admin/account/index";
    }


    //  Order
    @RequestMapping("/admin/order/index")
    public String listOrder(Model model) {
        Order item = new Order();
        model.addAttribute("item", item);
        List<Order> items = orderService.getAll();
        model.addAttribute("items", items);

        List<Account> listAccount = accountService.getAll();
        model.addAttribute("listAccount", listAccount);
        return "admin/order/index";
    }

    @RequestMapping("/admin/order/create")
    public String creatOrder(Order order) {

        orderService.add(order);
        return "redirect:/admin/order/index";
    }

    @RequestMapping("/admin/order/edit/{id}")
    public String editOrder(@PathVariable("id") Long id, Model model) {
        Order item = orderService.getOne(id);
        model.addAttribute("item", item);
        List<Order> items = orderService.getAll();
        model.addAttribute("items", items);
        List<Account> listAccount = accountService.getAll();
        model.addAttribute("listAccount", listAccount);
        return "admin/order/index";
    }

    @RequestMapping("/admin/order/update")
    public String updateOrder(Order order) {
        orderService.update(order);
        return "redirect:/admin/order/edit/" + order.getId();
    }


    @RequestMapping("/admin/order/delete/{id}")
    public String deleteOrder(@PathVariable("id") Long id) {
        orderService.delete(id);
        return "redirect:/admin/order/index";
    }


    //  OrderDetails
    @RequestMapping("/admin/orderdetails/index")
    public String listOrderDetails(Model model) {
        List<OrderDetail> listOrderDetail = orderDetailService.getAll();
        model.addAttribute("listOrderDetail",listOrderDetail);
        return "admin/orderdetails/index";
    }

    @RequestMapping("/admin/orderdetails/delete/{id}")
    public String deleteOrderDetails(@PathVariable("id") Long id) {
        orderDetailService.delete(id);
        return "redirect:/admin/orderdetails/index";
    }
}

