package com.tornikeshelia.springboot.recipeapp.repository;

import com.tornikeshelia.springboot.recipeapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {

    User findByUserName(String userName);

}
