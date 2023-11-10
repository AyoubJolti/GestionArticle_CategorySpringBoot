package com.example.gestion_article.Controllers;

import com.example.gestion_article.Modes.Category;
import com.example.gestion_article.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CategoryController
{
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
        public String viewHomePage(Model model)
        {
            List<Category> lst=categoryService.ListAll();
            model.addAttribute("lstCat",lst);

            return  "index";
        }
    @GetMapping("new")
    public String addNew(Model model)
    {

        Category c=new Category();
        model.addAttribute("Category",c);
        return  "AddCategory";
    }

    @PostMapping("save")
    public String save(@ModelAttribute("personnel") Category Category)
    {
        categoryService.Save(Category);
        return  "redirect:/";
    }
    @RequestMapping(value = "/deleteCat/{id}",method=RequestMethod.GET)
    public String deleteCat(@PathVariable(name="id") int id)
    {
        categoryService.delete(id);
        return  "redirect:/";
    }

    @RequestMapping(value = "/edit/{id}",method=RequestMethod.GET)
    public ModelAndView editCat(@PathVariable(name="id") int id)
    {
        ModelAndView mav=new ModelAndView("editForm");
        Category c=categoryService.getCategory(id);
        mav.addObject("Category",c);
        return  mav;
    }
    @PostMapping(value = "/update/{id}")
    public String update(@PathVariable(name="id") int id,@ModelAttribute("personnel") Category Category)
    {
        categoryService.update(id,Category);
        return  "redirect:/";
    }


}
