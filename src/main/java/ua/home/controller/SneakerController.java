package ua.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ua.home.entity.Product;
import ua.home.service.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@Transactional
@EnableTransactionManagement
public class SneakerController {

    @Autowired
    ProductService productService;

    @Autowired
    BrandService brandService;

    @Autowired
    BrandModelService brandModelService;

    @Autowired
    SizeService sizeService;

    @Autowired
    ColorService colorService;

    //Searching items by sex and category
    @GetMapping("category/{sex}/{category}")
    public String byCatogory(@PathVariable("sex")String sex,@PathVariable("category")String category, Model model){
        model.addAttribute("products", productService.findByCategory(sex,category));
        model.addAttribute("brand",brandService.findAll());
        model.addAttribute("brandModel",brandModelService.findAll());
        return "products/productList";
    }

    //Searching items by sex
    @GetMapping("sex/{sex}")
    public String bySex(@PathVariable("sex")String sex, Model model){
        model.addAttribute("products", productService.findBySex(sex));
        model.addAttribute("brand",brandService.findAll());
        model.addAttribute("brandModel",brandModelService.findAll());
        return "products/productList";
    }

    //Searching items by brand
    @GetMapping("brand/{brand}")
    public String byBrand(@PathVariable("brand")String brand,Model model){
        model.addAttribute("products",productService.findByBrand(brand));
        model.addAttribute("brand",brandService.findAll());
        model.addAttribute("brandModel",brandModelService.findAll());
        return "/products/productList";
    }

    //Getting Sale page. Showing items with onSale=true.
    @GetMapping("toSaleSneaker")
    public String toSaleSneaker(Model model){
        model.addAttribute("products",productService.findSaleSneaker());
        model.addAttribute("brand",brandService.findAll());
        model.addAttribute("brandModel",brandModelService.findAll());
        return "products/productList";
    }

    //Getting New Arrivals page. Showing latest added 10 items.
    @GetMapping("toNewArrivals")
    public String toNewArrivals(Model model){
        List<Product> newArrivals = new ArrayList<Product>();
        List<Product> products = productService.findAll();
        if (products.size()>10) {
            for (int i = products.size() - 1; i > products.size() - 11; i--) {
                newArrivals.add(products.get(i));
            }
            model.addAttribute("products",newArrivals);
        }else{
            model.addAttribute("products",products);
        }
        model.addAttribute("brand",brandService.findAll());
        model.addAttribute("brandModel",brandModelService.findAll());
        return "products/productList";
    }

    // Getting page with single item and details.
    @GetMapping("product/{model}")
    public String singleprod(@PathVariable("model")String modell, Model model){
        model.addAttribute("product", productService.findByModel(modell));
        model.addAttribute("brand",brandService.findAll());
        model.addAttribute("size",sizeService.findAll());
        model.addAttribute("color",colorService.findAll());
        model.addAttribute("brandModel",brandModelService.findAll());
        return "products/productPage";
    }




}
