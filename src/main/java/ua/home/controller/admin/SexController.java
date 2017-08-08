package ua.home.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.home.entity.Sex;
import ua.home.service.SexService;

@Controller
public class SexController {

    @Autowired
    SexService sexService;

    @GetMapping("toSexPage")
    public String toSexPage(Model model){
        model.addAttribute("sex",new Sex());
        model.addAttribute("sexAll",sexService.findAll());
        return "admin/sex";
    }

    @PostMapping("addSex")
    public String addSex(@ModelAttribute("sexName") Sex sexName){
        sexService.add(sexName);
        return "redirect:/toSexPage";
    }

    @PostMapping("deleteSex")
    public String deleteSex(@RequestParam("id") String id){
        sexService.delete(Integer.parseInt(id));
        return "redirect:/toSexPage";
    }
}
