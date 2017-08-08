package ua.home.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.home.entity.Color;
import ua.home.service.ColorService;

@Controller
public class ColorController {

    @Autowired
    ColorService colorService;

    @GetMapping("toColorPage")
    public String toColorPage(Model model){
        model.addAttribute("color",new Color());
        model.addAttribute("colors",colorService.findAll());
        return "admin/color";
    }

    @PostMapping("addColor")
    public String addColor(@ModelAttribute("color")Color color){
        colorService.add(color);
        return "redirect:/toColorPage";
    }

    @PostMapping("deleteColor")
    public String deleteColor(@RequestParam("id") String id){
        colorService.delete(Integer.parseInt(id));
        return "redirect:/toColorPage";
    }
}
