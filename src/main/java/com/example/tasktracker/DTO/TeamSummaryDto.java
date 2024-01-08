package com.example.tasktracker.DTO;

public class TeamSummaryDto {
    private Long id;
    private String name;

    // Constructors, Getters, and Setters
    public TeamSummaryDto() {}

    public TeamSummaryDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
