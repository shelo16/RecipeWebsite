package com.tornikeshelia.springboot.recipeapp.repository;

import com.tornikeshelia.springboot.recipeapp.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comments,Integer> {
}
