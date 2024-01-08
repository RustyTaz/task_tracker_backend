package com.example.tasktracker.DTO;

import com.example.tasktracker.enums.UserRole;

public class UserDto {
    private Long id;
    private String username;
    private String email;
    private UserRole role;
    // Для запросов на создание и обновление может потребоваться пароль
    private String password;

    // Constructors, Getters, and Setters
    public UserDto() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
