package com.example.gestion_article.Services;

import com.example.gestion_article.Modes.Category;
import com.example.gestion_article.Repostory.CategoryReposotry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryReposotry categoryReposotry;

    public List<Category> ListAll(){
        return  categoryReposotry.findAll();
    }
    public  void Save(Category c){
        categoryReposotry.save(c);
    }
    public  void update(int id,Category c){
        Optional<Category> existingCategory = categoryReposotry.findById(id);
        if(existingCategory.isPresent()){
            Category categoryToUpdate = existingCategory.get();
            categoryToUpdate.setNom_category(c.getNom_category());

        }

        categoryReposotry.save(c);
    }
    public  Category getCategory(int id){
       return categoryReposotry.findById(id).get();
    }
    public void  delete(int id){
        categoryReposotry.deleteById(id);
    }

}
