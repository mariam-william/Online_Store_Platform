package com.SWEII.Models.UsersModels;

import javax.persistence.Entity;

@Entity(name = "Administrator")
public class Administrator extends User {

    public Administrator(){}

    public Administrator(User user) {
        super(user.getFirstName(), user.getLastName(), user.getEmail(), user.getUsername(), user.getPassword(),user.getType());
    }

}
