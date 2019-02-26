package com.tornikeshelia.springboot.recipeapp.repository;

import com.tornikeshelia.springboot.recipeapp.entity.Role;
import com.tornikeshelia.springboot.recipeapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {

    User findRoleByName(String name);

}
