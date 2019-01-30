package com.tornikeshelia.springboot.recipeapp.entity;

import javax.persistence.*;

@Entity
@Table(name = "ingredients")
public class Ingredients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ingredient")
    private String ingredientName;

    @Column(name = "description")
    private String ingredientDescription;


    // Constructors
    public Ingredients() {
    }

    public Ingredients(String ingredientName, String ingredientDescription) {
        this.ingredientName = ingredientName;
        this.ingredientDescription = ingredientDescription;
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public String getIngredientDescription() {
        return ingredientDescription;
    }

    public void setIngredientDescription(String ingredientDescription) {
        this.ingredientDescription = ingredientDescription;
    }

    // ToString

    @Override
    public String toString() {
        return "Ingredients{" +
                "id=" + id +
                ", ingredientName='" + ingredientName + '\'' +
                ", ingredientDescription='" + ingredientDescription + '\'' +
                '}';
    }
}
