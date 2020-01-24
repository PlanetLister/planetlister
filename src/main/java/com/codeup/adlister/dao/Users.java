package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

import java.util.List;

public interface Users {
    User findByUsername(String username);
    User findByEmail(String email);
    Long insert(User user);
    User findUserById(long id);
    User findPlanetsOwnerById(long id);
    int updateUser(User user);

}
