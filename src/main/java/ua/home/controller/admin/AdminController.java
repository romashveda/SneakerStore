package ua.home.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("toAdminPage")
    public String toAdminPage(){
        return "admin/admin";
    }


}
