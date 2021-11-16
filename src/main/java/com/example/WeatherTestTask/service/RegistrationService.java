package com.example.WeatherTestTask.service;

import com.example.WeatherTestTask.exeption.RegistrationException;
import com.example.WeatherTestTask.model.DTO.UserDTO;
import com.example.WeatherTestTask.model.User;
import com.example.WeatherTestTask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RegistrationService {

    @Autowired
    PasswordService passwordService;
    UserRepository userRepository;
    UserService userService;


    public RegistrationService(PasswordService passwordService, UserRepository userRepository, UserService userService) {
        this.passwordService = passwordService;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    public String registration(UserDTO userDTO) throws RegistrationException {

        //checking login user is existing in database
        String login = userDTO.getLogin();
        if (userService.loginExist(login)) {
            throw new RegistrationException("User with login = " + login + " already exist");
        }

        User user = new User();

        user.setLogin(login);
        //checking user password is valid
        String password = userDTO.getPassword();
        if (!passwordService.isValidPassword(password)) {
            throw new RegistrationException("Password is not valid");
        }

        //encode password
        user.setPassword(passwordService.encodePassword(userDTO.getPassword()));

        user.setName(userDTO.getName());

        userRepository.save(user);
        return "User created";
    }

}
