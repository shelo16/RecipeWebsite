package com.tornikeshelia.springboot.recipeapp.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "name")
    private String name;

      // Mapping To second table
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "menu_ingredient",
            joinColumns = @JoinColumn(name = "menu_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    private List<Ingredients> ingredient = new ArrayList<>();

    // Constructors
    public Menu() {
    }

    public Menu(String name) {
        this.name = name;
    }

    // Getters And Setters

    public List<Ingredients> getIngredient() {
        return ingredient;
    }

    public void setIngredient(List<Ingredients> ingredient) {
        this.ingredient = ingredient;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // ToString

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
