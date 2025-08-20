package com.dio.spring_tests.welcome_controller.model;

import java.util.UUID;

public class User {

    private static Integer idGenerator = 0;

    private Integer id;
    private String login;
    private String password;

    public User() { }

    public User(String login, String password) {
        this.id = idGenerator++;
        this.login = login;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
