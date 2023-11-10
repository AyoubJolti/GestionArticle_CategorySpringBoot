package com.example.gestion_article.Services;

import com.example.gestion_article.Modes.Article;
import com.example.gestion_article.Modes.Category;
import com.example.gestion_article.Repostory.ArticleReposotry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleSerivce {
    @Autowired
    private ArticleReposotry articleReposotry;
    public List<Article> lstArticleByCategorie(int id)
    {
        return  this.articleReposotry.findAllByCategoryId(id);
    }
    public void saveArticle(Article ar)
    {
        articleReposotry.save(ar);
    }
    public void delete(int id){
        this.articleReposotry.deleteById(id);
    }
    public  Article getOne(int id){
       return this.articleReposotry.findById(id).get();
    }
    public void updateArticle(int id,Article ar){
        Optional<Article> articleOptional = articleReposotry.findById(id);
        if (articleOptional.isPresent()) {
            Article articleToUpdate = articleOptional.get();

            // Keep the existing category value
            ar.setCategory(articleToUpdate.getCategory());

            // Update other properties
            articleToUpdate.setNom_Art(ar.getNom_Art());
            articleToUpdate.setQte(ar.getQte());
            articleToUpdate.setPrix(ar.getPrix());

            // Save the updated article
            articleReposotry.save(articleToUpdate);
        }

        articleReposotry.save(ar);

    }
}
