package com.example.gestion_article.Controllers;

import com.example.gestion_article.Modes.Article;
import com.example.gestion_article.Modes.Category;
import com.example.gestion_article.Services.ArticleSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ArticleController
{
    @Autowired
    private ArticleSerivce articleSerivce;


    @GetMapping("/ArticleOfCategorie/{id}")

    public String ListArticle (Model model,@PathVariable(name="id") int id){

        List<Article> lst=articleSerivce.lstArticleByCategorie(id);
        model.addAttribute("lstArt",lst);
        model.addAttribute("ide",id);


        return  "ListArticleOfCategory";
    }
    @GetMapping("/AddArticle/{id}")

    public String AddArticle (Model model,@PathVariable(name="id") int id){
       Article a=new Article();
       model.addAttribute("Article",a);
       model.addAttribute("ide",id);

        return  "AddArticleForm";
    }
    @PostMapping("/saveArticle/{id}")

    public String saveArticle (Model model,@PathVariable(name="id") int id,@ModelAttribute("Article") Article Article){
        Category C=new Category(id,"");
        articleSerivce.saveArticle(new Article(0,Article.getNom_Art(),Article.getQte(),Article.getPrix(),C));

        return  "redirect:/ArticleOfCategorie/"+id;
    }
    @RequestMapping(value = "/deleteArticle/{id}/{ide}",method=RequestMethod.GET)
    public String deleteArticle(@PathVariable(name="id") int id,Model model,@PathVariable(name="ide") int ide)
    {
        articleSerivce.delete(id);
        return  "redirect:/ArticleOfCategorie/"+ide;
    }
    @RequestMapping(value = "/EditArticle/{id}/{ide}",method=RequestMethod.GET)
    public String EditArticle(@PathVariable(name="id") int id,Model model,@PathVariable(name="ide") int ide)
    {
        Article a=articleSerivce.getOne(id);
        model.addAttribute("Article",a);
        model.addAttribute("ide",ide);

        return  "EditArticleForm";
    }
    @RequestMapping(value = "/updateArticle/{id}/{ide}",method=RequestMethod.POST)
    public String updateArticle(@ModelAttribute("Article") Article Article,@PathVariable(name="id") int id,Model model,@PathVariable(name="ide") int ide)
    {
        System.out.println(Article.getPrix()+" nom "+Article.getNom_Art() );
        articleSerivce.updateArticle(id,Article);

        return  "redirect:/ArticleOfCategorie/"+ide;
    }




}
