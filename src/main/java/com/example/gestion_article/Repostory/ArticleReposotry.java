package com.example.gestion_article.Repostory;

import com.example.gestion_article.Modes.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticleReposotry  extends JpaRepository<Article,Integer> {
    @Query("SELECT a FROM Article a WHERE a.Category.id = :categoryId")
    List<Article> findAllByCategoryId(@Param("categoryId") int categoryId);

}
