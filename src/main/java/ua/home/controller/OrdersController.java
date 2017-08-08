package ua.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ua.home.entity.Orders;
import ua.home.entity.Product;
import ua.home.entity.Status;
import ua.home.entity.User;
import ua.home.service.*;

import java.security.Principal;
import java.util.List;

@Controller
@Transactional
@EnableTransactionManagement
public class OrdersController {

    @Autowired
    OrdersService ordersService;

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @Autowired
    BrandService brandService;

    @Autowired
    SizeService sizeService;

    // getting the curt page
    @GetMapping("toCurt")
    public String toCurt(Principal principal, Model model){
        List<Orders> orders = ordersService.findOrdersByUser(userService.findByUsername(principal.getName()));
        Orders order = ordersService.findOrderInCurt(orders);

        model.addAttribute("brandName",brandService.findAll());
        model.addAttribute("sizeNum",sizeService.findAll());
        model.addAttribute("products",order.getProductList());
        model.addAttribute("order",order);
        return "curt";
    }
    // adding product to curt
    @GetMapping("addToCurt/{product}")
    public String addToCurt(@PathVariable("product")Integer product, Model model, Principal principal){
        User user = userService.findByUsername(principal.getName());
        List<Orders> orders = ordersService.findOrdersByUser(user);
        Orders order = ordersService.findOrderInCurt(orders);

        Product someProduct = productService.findOne(product);
        List<Product> products = order.getProductList();
        products.add(someProduct);
        int price = ordersService.calculatePrice(products);
        order.setPrice(""+price);
        model.addAttribute("order", order);
        ordersService.add(order);
        return "redirect:/toCurt";
    }

    // deleting product from curt
    @GetMapping("deleteFromCurt/{product}")
    public String deleteFromCurt(@PathVariable("product")String product,Principal principal){
        List<Orders> ordersList = ordersService.findOrdersByUser(userService.findByUsername(principal.getName()));
        Orders order = ordersService.findOrderInCurt(ordersList);
        List<Product> products = order.getProductList();
        products.remove(productService.findByModel(product));
        int price = ordersService.calculatePrice(products);
        order.setPrice(""+price);
        ordersService.edit(order);
        return "redirect:/toCurt";
    }

    // making a order , updating status of the order , creating new blank order
    @GetMapping("checkOut")
    public String checkOut(Principal principal){
        User user = userService.findByUsername(principal.getName());
        List<Orders> ordersList = ordersService.findOrdersByUser(user);
        Orders order = ordersService.findOrderInCurt(ordersList);
        order.setStatus(Status.PROCESSING);
        Orders neworder = new Orders(user);
        ordersList.add(neworder);
        ordersService.add(neworder);
        ordersService.edit(order);
        return "managerCall";
    }


}
