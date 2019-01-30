package com.tornikeshelia.springboot.recipeapp.controller;

import com.tornikeshelia.springboot.recipeapp.entity.Ingredients;
import com.tornikeshelia.springboot.recipeapp.entity.Menu;
import com.tornikeshelia.springboot.recipeapp.repository.IngredientRepository;
import com.tornikeshelia.springboot.recipeapp.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class MyController{

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    IngredientRepository ingredientRepository;

    @GetMapping("/")
    private String hello(){
        return "hello-page";
    }

    @GetMapping("/recipeList")
    public String listPage(Model model){
        model.addAttribute("menuList",menuRepository.findAll());
        return "list-page";
    }

    @GetMapping("/addNew")
    public String addRecipe(Model model){
        Menu menu = new Menu();
        model.addAttribute("menu", menu);
        return "add-recipe";
    }

    @PostMapping("/postAddNew")
    public String postAddRecipe(@ModelAttribute("menu")Menu menu,
                                @RequestParam String ingName,
                                @RequestParam String ingDesc){

        String[] ingNameSplit = ingName.split(",");
        String[] ingDescSplit = ingDesc.split(",");

        for(int a = 0, b = 0; a<ingNameSplit.length; b++, a++){
            menu.getIngredient().add(new Ingredients(ingNameSplit[a], ingDescSplit[b]));
        }

        List<Menu> menuItems = menuRepository.findAll();

        menuRepository.save(menu);
        System.out.println(menuItems);
        //ingredientRepository.save(ingredient);

        return "redirect:/recipeList";
    }

    @GetMapping("/foodDescription/{id}")
    public String foodDescriptionPage(Model model, @PathVariable(name = "id") String id){
        menuRepository.findById(id).ifPresent(o -> model.addAttribute("menu", o));

        return "food-description";
    }

    @GetMapping("/delete/{id}")
    public String deleteFood(@PathVariable(name = "id")String id){
        menuRepository.deleteById(id);

        return "redirect:/recipeList";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id")String id, Model model){
        Optional<Menu> menu = menuRepository.findById(id);

        List<Ingredients> ingredients = menu.get().getIngredient();
        model.addAttribute("ingredients", ingredients);
        model.addAttribute("newMenu",menu);


        return "edit-page";
    }

    @PostMapping("/postEditMenu")
    public String postEdit(@ModelAttribute("newMenu")Menu menu,
                           @RequestParam String ingName,
                           @RequestParam String ingDesc){

        String[] ingNameSplit = ingName.split(",");
        String[] ingDescSplit = ingDesc.split(",");

        Menu menuToUpdate = menuRepository.getOne(menu.getId());


        List<Ingredients> newIngredientList = menuToUpdate.getIngredient();
        newIngredientList.clear();

        for(int a = 0, b = 0; a<ingNameSplit.length; b++, a++){
            newIngredientList.add(new Ingredients(ingNameSplit[a], ingDescSplit[b]));
        }
        menuToUpdate.setIngredient(newIngredientList);

        menuRepository.save(menuToUpdate);

        return "redirect:/recipeList";
    }

}
