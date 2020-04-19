package com.SWEII.Models.UserDetails;

import com.SWEII.Models.UsersModels.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUserDetails implements UserDetails {

    public String ROLE_PREFIX = "ROLE_";
    protected String username;
    protected String password;
    protected String email;
    protected String type;

    private List<GrantedAuthority> authorities;

    public MyUserDetails() {}

    public MyUserDetails(User user){
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.type = user.getType();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
        list.add(new SimpleGrantedAuthority(ROLE_PREFIX + (this.type).toUpperCase()));
        return list;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
