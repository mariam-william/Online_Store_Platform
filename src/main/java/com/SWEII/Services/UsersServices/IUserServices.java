package com.SWEII.Services.UsersServices;

import com.SWEII.Models.UsersModels.User;

import java.util.List;


public interface IUserServices {

    User findByUsername(String username);
    User findByEmail(String email);
    boolean saveUser(User user);
    List<User> listAllUsers();
}
