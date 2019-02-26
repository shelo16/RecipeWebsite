package com.tornikeshelia.springboot.recipeapp.repository;

import com.tornikeshelia.springboot.recipeapp.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu,String> {
}
