package ua.home.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.home.entity.Size;
import ua.home.service.SizeService;

@Controller
public class SizeController {

    @Autowired
    SizeService sizeService;

    @GetMapping("toSizePage")
    public String toSizePage(Model model){
        model.addAttribute("size",new Size());
        model.addAttribute("sizes",sizeService.findAll());
        return "admin/size";
    }

    @PostMapping("addSize")
    public String addSize(@ModelAttribute("size") Size size){
        sizeService.add(size);
        return "redirect:/toSizePage";
    }

    @PostMapping("deleteSize")
    public String deleteSize(@RequestParam("id") String id){
        sizeService.delete(Integer.parseInt(id));
        return "redirect:/toSizePage";
    }
}
