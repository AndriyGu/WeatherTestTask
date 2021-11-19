package com.example.WeatherTestTask.model.DTO;


public class UserDTO {

    private String login;
    private String password;
    private String name;

    public UserDTO(String login, String password, String name) {
        this.login = login;
        this.password = password;
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}
