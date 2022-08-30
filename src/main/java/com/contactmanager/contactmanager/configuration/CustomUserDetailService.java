package com.contactmanager.contactmanager.configuration;

import com.contactmanager.contactmanager.entities.User;
import com.contactmanager.contactmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.getUserByUserName(username);
        if(user==null)
        {
            throw new UsernameNotFoundException("Could Not Found User");
        }
        CustomUserDetail customUserDetail= new CustomUserDetail(user);
        return customUserDetail;
    }
}
