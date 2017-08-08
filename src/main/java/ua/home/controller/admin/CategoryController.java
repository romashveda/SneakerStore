package ua.home.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.home.entity.Category;
import ua.home.service.CategoryService;

@Controller
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("toCategoryPage")
    public String toCategoryPage(Model model){
        model.addAttribute("category",new Category());
        model.addAttribute("categories",categoryService.findAll());
        return "admin/category";
    }

    @PostMapping("addCategory")
    public String addCategory(@ModelAttribute("category") Category category){
        categoryService.add(category);
        return "redirect:/toCategoryPage";
    }

    @PostMapping("deleteCategory")
    public String deleteCategory(@RequestParam("id") String id){
        categoryService.delete(Integer.parseInt(id));
        return "redirect:/toCategoryPage";
    }


}
