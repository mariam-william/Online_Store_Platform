package com.SWEII.Services.UsersServices;

import com.SWEII.Models.UsersModels.User;
import com.SWEII.Repositories.UsersRepositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServices implements IUserServices {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    IAdministratorServices administratorServices;

    @Autowired
    INormalUserServices normalUserServices;

    @Autowired
    IStoreOwnerServices storeOwnerServices;


    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public boolean saveUser(User user) {
        if (userRepository.save(user) != null)
            return true;
        return false;
    }

    @Override
    public List<User> listAllUsers() {
        List<User> users = new ArrayList<>();
        users.addAll(administratorServices.listAllAdministrators());
        users.addAll(normalUserServices.listAllNormalUsers());
        users.addAll(storeOwnerServices.listAllStoreOwners());
        return users;
    }
}

