package com.example.gestion_article.Modes;

import jakarta.persistence.*;

@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public  String Nom_Art;
    public  int qte;
    public  float prix;

    @ManyToOne
    @JoinColumn(name = "category_id") // Use the name of the foreign key column in the Article table
     Category Category;


    public Article() {
    }

    public Article(int id, String nom_Art, int qte, float prix,Category category) {
        this.id = id;
        Nom_Art = nom_Art;
        this.qte = qte;
        this.prix = prix;
        Category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_Art() {
        return Nom_Art;
    }

    public void setNom_Art(String nom_Art) {
        Nom_Art = nom_Art;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public com.example.gestion_article.Modes.Category getCategory() {
        return Category;
    }

    public void setCategory(com.example.gestion_article.Modes.Category category) {
        Category = category;
    }
}
