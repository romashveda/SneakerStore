package ua.home.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ua.home.entity.Orders;
import ua.home.entity.Product;
import ua.home.entity.User;
import ua.home.service.BrandService;
import ua.home.service.MailService;
import ua.home.service.UserService;
import ua.home.validator.UserValidator;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@Transactional
@EnableTransactionManagement
public class UserController {

    @Autowired
    MailService mailService;

    @Autowired
    UserService userService;

    @Autowired
    BrandService brandService;

    //Getting the page with register form.
    @GetMapping("registration")
    public String toRegistration(Model model){
        model.addAttribute("user",new User());
        return "registration";
    }

    //adding new user with validation
    @PostMapping("addUser")
    public String addUser(@ModelAttribute("user") @Valid User user,BindingResult result){
        if (result.hasErrors()){
            return "registration";
        }
        userService.add(user);
//        mailService.send(user);
        return "redirect:/";
    }

    @GetMapping("toLogin")
    public String toLogin(){
        return "login";
    }

    // Admins page, getting all users
    @GetMapping("toUserPage")
    public String toUserPage(Model model){
        model.addAttribute("users",userService.findAll());
        return "admin/user";
    }

    // page for editing user, ban, etc.
    @GetMapping("edituser/{id}")
    public String editUser(@PathVariable String id, Model model){
        model.addAttribute("user",userService.findOne(Integer.parseInt(id)));
        return "admin/userEdit";
    }

    //editing
    @PostMapping("editUser")
    public String editUser(@ModelAttribute("user")User user, BindingResult bindingResult){
        System.out.println(user.getId());
        if (bindingResult.hasErrors()){

        }
        userService.edit(user);
        return "redirect:/toUserPage";
    }

    //Get all orders of selected user
    @GetMapping("orders/{username}")
    public String userOrders(@PathVariable("username")String username,Model model){
        User user = userService.findByUsername(username);
        List<Orders> ordersList = user.getOrdersList();
        List<Product> products = new ArrayList<Product>();
        for (Orders o: ordersList) {
            for (Product p: o.getProductList()) {
                products.add(p);
            }
        }
        model.addAttribute("ordersList",ordersList);
        model.addAttribute("brand",brandService.findAll());
        model.addAttribute("productList",products);
        return "/admin/ordersList";
    }

    @Autowired
    UserValidator userValidator;

    @InitBinder
    public void bind(WebDataBinder binder){
        binder.addValidators(userValidator);
    }
}
