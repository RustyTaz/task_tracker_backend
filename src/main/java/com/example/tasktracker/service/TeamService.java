package com.example.tasktracker.service;

import com.example.tasktracker.DTO.TeamDto;
import com.example.tasktracker.DTO.TeamSummaryDto;
import com.example.tasktracker.entity.Team;
import com.example.tasktracker.entity.User;
import com.example.tasktracker.repository.TeamRepository;
import com.example.tasktracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private UserRepository userRepository;

    public TeamDto createTeam(TeamDto teamDto) {
        Team team = new Team();
        team.setName(teamDto.getName());
        team.setDescription(teamDto.getDescription());
        team.setTeamLeader(teamDto.getTeamLeaderId());
        team.setTeamCreator(teamDto.getTeamCreatorId());
        Set<User> members = teamDto.getMemberIds().stream()
                .map(id -> userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found")))
                .collect(Collectors.toSet());
        team.setMembers(members);
        return convertToDto(teamRepository.save(team));
    }

    public List<TeamSummaryDto> getAllTeams() {
        return teamRepository.findAll().stream()
                .map(team -> new TeamSummaryDto(team.getId(), team.getName()))
                .collect(Collectors.toList());
    }

    public Optional<TeamDto> getTeam(Long id) {
        return teamRepository.findById(id).map(this::convertToDto);
    }

    public Optional<TeamDto> getTeamByName(String name) {
        return teamRepository.findByName(name).map(this::convertToDto);
    }

    public Optional<TeamDto> updateTeam(Long id, TeamDto teamDto) {
        return teamRepository.findById(id).map(team -> {
            team.setName(teamDto.getName());
            team.setDescription(teamDto.getDescription());
            team.setTeamLeader(teamDto.getTeamLeaderId());
            team.setTeamCreator(teamDto.getTeamCreatorId());
            Set<User> members = teamDto.getMemberIds().stream()
                    .map(memberId -> userRepository.findById(memberId).orElseThrow(() -> new RuntimeException("User not found")))
                    .collect(Collectors.toSet());
            team.setMembers(members);
            return convertToDto(teamRepository.save(team));
        });
    }

    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }

    private TeamDto convertToDto(Team team) {
        TeamDto teamDto = new TeamDto();
        teamDto.setId(team.getId());
        teamDto.setName(team.getName());
        teamDto.setDescription(team.getDescription());
        teamDto.setTeamLeaderId(team.getTeamLeader() );
        teamDto.setTeamCreatorId(team.getTeamCreator());
        Set<Long> memberIds = team.getMembers().stream()
                .map(User::getId)
                .collect(Collectors.toSet());
        teamDto.setMemberIds(memberIds);
        return teamDto;
    }
}
