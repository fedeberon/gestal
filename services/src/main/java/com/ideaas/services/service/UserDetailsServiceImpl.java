package com.ideaas.services.service;

import com.ideaas.services.dao.MyUserDetails;
import com.ideaas.services.dao.UserRepository;
import com.ideaas.services.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository dao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = dao.getUserByUsername(username);

        if (user == null){
            throw new UsernameNotFoundException("No se pudo encontrar usuario");
        }

        return new MyUserDetails(user);
    }
}
