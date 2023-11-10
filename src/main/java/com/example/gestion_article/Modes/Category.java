package com.example.gestion_article.Modes;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public  String nom_category;


    public Category(int id, String nom_category) {
        this.id = id;
        this.nom_category = nom_category;
    }

    public Category() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_category() {
        return nom_category;
    }

    public void setNom_category(String nom_category) {
        this.nom_category = nom_category;
    }
}
