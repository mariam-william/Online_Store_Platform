package com.SWEII.Models.UsersModels;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "NormalUser")
public class NormalUser extends User {

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "phoneNumber", nullable = false, unique = true)
    private String phoneNumber;

    public NormalUser() {
    }

    public NormalUser(User user, String address, String phoneNumber) {
        super(user.getFirstName(), user.getLastName(), user.getEmail(), user.getUsername(), user.getPassword(), user.getType());
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
