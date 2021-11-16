package com.example.WeatherTestTask.security.jwt;

import com.example.WeatherTestTask.model.User;
import com.example.WeatherTestTask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getAllUsers().stream().filter(
                a -> a.getLogin().equals(username)
        ).findFirst().orElse(null);
        return CustomUserDetails.fromUserEntityToCustomUserDetails(user);
    }


}