package com.example.WeatherTestTask.service;

import com.example.WeatherTestTask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    //check user login is existing in database
    public boolean loginExist(String login) {
        return userRepository.findByLoginOpt(login).isPresent();
    }
}
