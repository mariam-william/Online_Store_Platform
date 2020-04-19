package com.SWEII.Services.UserDetailsServices;

import com.SWEII.Models.UserDetails.MyUserDetails;
import com.SWEII.Models.UsersModels.User;
import com.SWEII.Repositories.UsersRepositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServices implements UserDetailsService {

    @Autowired
    IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       if(username == null || username.isEmpty())
           throw new UsernameNotFoundException("Username is Empty");
       User user;
       if (username.contains("@"))
             user = userRepository.findByEmail(username);
       else
           user = userRepository.findByUsername(username);
       if(user != null){
            return new MyUserDetails(user);
       }
       throw new UsernameNotFoundException(username + " isn't Found");
    }
}
