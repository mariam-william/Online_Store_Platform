package com.SWEII.Services.UsersServices;

import com.SWEII.Models.UsersModels.NormalUser;
import com.SWEII.Repositories.UsersRepositories.INormalUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NormalUserServices implements  INormalUserServices{

    @Autowired
    INormalUserRepository normalUserRepository;


    @Override
    public List<NormalUser> listAllNormalUsers() {
        List<NormalUser> normalUsers = new ArrayList<>();
        Iterable<NormalUser> iterable = normalUserRepository.findAllNormalUsers();
        for (NormalUser user : iterable)
            normalUsers.add(user);
        return normalUsers;
    }
}
