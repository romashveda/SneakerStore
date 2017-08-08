package ua.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.home.entity.User;

@Controller
public class MainController {

    @RequestMapping("/")
    public String toIndex(){
        return "index";
    }

    //redirect when logination failure
    @GetMapping("/login")
    public String loginFalure(@RequestParam(value = "error", required = false) boolean error,Model model){
        return "login";
    }
}
