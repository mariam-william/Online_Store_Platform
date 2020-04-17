package com.SWEII.Models.UsersModels;

import javax.persistence.Entity;

@Entity(name = "StoreOwner")
public class StoreOwner extends User {

    public StoreOwner(){}

    public StoreOwner(User user) {
        super(user.getFirstName(), user.getLastName(), user.getEmail(), user.getUsername(), user.getPassword(), user.getType());
    }

}
