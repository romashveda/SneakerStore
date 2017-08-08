package ua.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.home.service.ProductService;


@Controller
@Transactional
@EnableTransactionManagement
public class SearchController {

    @Autowired
    ProductService productService;

    //method for searching products in search field
    @PostMapping("/search")
    public String search(@RequestParam("string")String string, Model model){
        try {
            model.addAttribute("products",productService.searchProducts(string));
        }catch (NullPointerException e){
            return "index";
        }
        return "products/productList";
    }
}
