package com.tornikeshelia.springboot.recipeapp.service;

import com.tornikeshelia.springboot.recipeapp.entity.Role;
import com.tornikeshelia.springboot.recipeapp.entity.User;
import com.tornikeshelia.springboot.recipeapp.repository.RoleRepository;
import com.tornikeshelia.springboot.recipeapp.repository.UserRepository;
import com.tornikeshelia.springboot.recipeapp.securityModel.CrmUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    @Transactional
    public void save(CrmUser crmUser) {

        User user = new User();

        // assign user details to the user object
        user.setUserName(crmUser.getUserName());
        user.setPassword(bCryptPasswordEncoder.encode(crmUser.getPassword()));
        user.setFirstName(crmUser.getFirstName());
        user.setLastName(crmUser.getLastName());
        user.setEmail(crmUser.getEmail());

        // give user default role of "employee"
        user.setRole(new Role("USER"));

        userRepository.save(user);

    }



    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> authority = new ArrayList<>();
        authority.add(new SimpleGrantedAuthority("ROLE_USER"));
        User user = userRepository.findByUserName(username);
        if (user==null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),authority);
    }
}
