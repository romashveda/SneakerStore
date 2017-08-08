package ua.home.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.home.entity.BrandModel;
import ua.home.service.BrandModelService;
import ua.home.service.BrandService;

@Controller
public class BrandModelController {

    @Autowired
    BrandService brandService;

    @Autowired
    BrandModelService brandModelService;

    @GetMapping("toBrandModelPage")
    public String toBrandModelPage(Model model){
        model.addAttribute("brandModel",new BrandModel());
        model.addAttribute("brands",brandService.findAll());
        model.addAttribute("brandModels",brandModelService.findAll());
        return "admin/brandModel";
    }

    @PostMapping("addBrandModel")
    public String addBrandModel(@ModelAttribute("brandModel") BrandModel brandModel, @RequestParam("brand") Integer id){
        brandModelService.add(brandModel,id);
        return "redirect:/toBrandModelPage";
    }

    @PostMapping("deleteBrandModel")
    public String deleteBrandModel(@RequestParam("id") String id){
        brandModelService.delete(Integer.parseInt(id));
        return "redirect:/toBrandModelPage";
    }



}
