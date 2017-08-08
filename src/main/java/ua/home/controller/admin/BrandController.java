package ua.home.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.home.entity.Brand;
import ua.home.service.BrandService;

@Controller
public class BrandController {

    @Autowired
    BrandService brandService;

    //getting to brand page, adding and deleting brands

    @GetMapping("toBrandPage")
    public String toBrandPage(Model model){
        model.addAttribute("brand",new Brand());
        model.addAttribute("brands",brandService.findAll());// For all brands
        return "admin/brand";
    }

    @PostMapping("addBrand")
    public String addBrand(@ModelAttribute("brand")Brand brand){
        brandService.add(brand);
        return "redirect:/toBrandPage";
    }

    @PostMapping("deleteBrand")
    public String deleteBrand(@RequestParam("id") String id){
        brandService.delete(Integer.parseInt(id));
        return "redirect:/toBrandPage";
    }









}
