package com.tornikeshelia.springboot.recipeapp;

import com.tornikeshelia.springboot.recipeapp.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RecipeappApplication{

	@Autowired
    MenuRepository menuRepository;

	public static void main(String[] args) {
		SpringApplication.run(RecipeappApplication.class, args);

	}
}

