package com.SWEII.Services.UsersServices;

import com.SWEII.Models.UsersModels.StoreOwner;
import com.SWEII.Repositories.UsersRepositories.IStoreOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreOwnerServices implements IStoreOwnerServices {

    @Autowired
    IStoreOwnerRepository storeOwnerRepository;


    @Override
    public List<StoreOwner> listAllStoreOwners() {
        List<StoreOwner> storeOwners = new ArrayList<>();
        Iterable<StoreOwner> iterable = storeOwnerRepository.findAllStoreOwners();
        for (StoreOwner user : iterable)
            storeOwners.add(user);
        return storeOwners;
    }
}
