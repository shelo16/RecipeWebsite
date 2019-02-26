package com.tornikeshelia.springboot.recipeapp.service;

import com.tornikeshelia.springboot.recipeapp.entity.User;
import com.tornikeshelia.springboot.recipeapp.securityModel.CrmUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    void save(CrmUser crmUser);
    User findByUserName(String userName);
}
