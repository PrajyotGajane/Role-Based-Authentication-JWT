package com.prajyot.JWTDemo.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //Todo logic to get the user from the database
        System.out.println("Hereeeree");
        List<GrantedAuthority> authorities
                = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority("USER_ADMIN"));
        authorities.add(new SimpleGrantedAuthority("NORMAL_USER"));

        return new User("admin", "password", authorities);
    }
}
