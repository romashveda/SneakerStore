package ua.home.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ua.home.entity.Product;
import ua.home.service.*;

import java.io.File;
import java.io.IOException;

@Controller
@Transactional
@EnableTransactionManagement
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    BrandService brandService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    SexService sexService;

    @Autowired
    SizeService sizeService;

    @Autowired
    ColorService colorService;

    @Autowired
    BrandModelService brandModelService;

    // page for adding new products
    @GetMapping("toProductPage")
    public String toProductPage(Model model){
        model.addAttribute("product",new Product());
        model.addAttribute("products",productService.findAll());
        model.addAttribute("brands",brandService.findAll());
        model.addAttribute("categories",categoryService.findAll());
        model.addAttribute("sexAll",sexService.findAll());
        model.addAttribute("sizes",sizeService.findAll());
        model.addAttribute("colors",colorService.findAll());
        model.addAttribute("brandModels",brandModelService.findAll());
        return "admin/product";
    }

    @PostMapping("addProduct")
    public String addProduct(@RequestParam("model")String model,
                             @RequestParam("price") String price,
                             @RequestParam("onSale")String onSale,
                             @RequestParam("brand")Integer brand,
                             @RequestParam("category")Integer category,
                             @RequestParam("sex")Integer sex,
                             @RequestParam("size")Integer size,
                             @RequestParam("color")Integer color,
                             @RequestParam("brandModel")Integer brandModel,
                             @RequestParam("avatar")MultipartFile multipartFile){
        String realPath = System.getProperty("user.home") + File.separator + "images\\";
        try {
            multipartFile.transferTo(new File(realPath + multipartFile.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Product product = new Product();
        product.setModel(model);
        product.setPrice(price);
        product.setOnSale(Boolean.parseBoolean(onSale));
        product.setAvatar("\\avatar\\" + multipartFile.getOriginalFilename());
        productService.add(product,brand,category,sex,size,color,brandModel);
        return "redirect:/toProductPage";
    }

    // single product page
    @GetMapping("product{id}")
    public String singleProduct(@PathVariable("id")String id, Model model){
        model.addAttribute("product",productService.findOne(Integer.parseInt(id)));
        model.addAttribute("brand",brandService.findAll());
        model.addAttribute("category",categoryService.findAll());
        model.addAttribute("sex",sexService.findAll());
        model.addAttribute("size",sizeService.findAll());
        model.addAttribute("color",colorService.findAll());
        model.addAttribute("brandModel",brandModelService.findAll());
        return "singleProduct";
    }
}
