package com.example.tasktracker.DTO;

import java.util.Set;

public class TeamDto {
    private Long id;
    private String name;
    private String description;
    private Long teamLeaderId; // ID руководителя команды
    private Long teamCreatorId; // ID создателя команды
    private Set<Long> memberIds; // Набор ID участников команды

    public TeamDto() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getTeamLeaderId() {
        return teamLeaderId;
    }

    public void setTeamLeaderId(Long teamLeaderId) {
        this.teamLeaderId = teamLeaderId;
    }

    public Long getTeamCreatorId() {
        return teamCreatorId;
    }

    public void setTeamCreatorId(Long teamCreatorId) {
        this.teamCreatorId = teamCreatorId;
    }

    public Set<Long> getMemberIds() {
        return memberIds;
    }

    public void setMemberIds(Set<Long> memberIds) {
        this.memberIds = memberIds;
    }
    // Constructors, Getters, and Setters
    // ...
}
