package com.tornikeshelia.springboot.recipeapp.repository;

import com.tornikeshelia.springboot.recipeapp.entity.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredients,Integer> {
}
