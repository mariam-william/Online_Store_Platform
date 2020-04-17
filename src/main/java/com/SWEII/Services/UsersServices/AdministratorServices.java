package com.SWEII.Services.UsersServices;

import com.SWEII.Models.UsersModels.Administrator;
import com.SWEII.Repositories.UsersRepositories.IAdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdministratorServices implements IAdministratorServices {

    @Autowired
    IAdministratorRepository administratorRepository;


    @Override
    public List<Administrator> listAllAdministrators() {
        List<Administrator> administrators = new ArrayList<>();
        Iterable<Administrator> iterable = administratorRepository.findAllAdministrators();
        for (Administrator user : iterable)
            administrators.add(user);
        return administrators;
    }
}
