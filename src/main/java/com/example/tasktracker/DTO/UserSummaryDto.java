package com.example.tasktracker.DTO;

public class UserSummaryDto {
    private Long id;
    private String username;

    // Constructors, Getters, and Setters
    public UserSummaryDto() {}

    public UserSummaryDto(Long id, String username) {
        this.id = id;
        this.username = username;
    }

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
}
