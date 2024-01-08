package com.example.tasktracker.service;

import com.example.tasktracker.DTO.UserDto;
import com.example.tasktracker.DTO.UserSummaryDto;
import com.example.tasktracker.entity.User;
import com.example.tasktracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDto createUser(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        // Хеширование пароля должно производиться здесь
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());
        return convertToDto(userRepository.save(user));
    }

    public Optional<UserDto> getUser(Long id) {
        return userRepository.findById(id).map(this::convertToDto);
    }

    public Optional<UserDto> updateUser(Long id, UserDto userDto) {
        return userRepository.findById(id).map(user -> {
            user.setUsername(userDto.getUsername());
            user.setEmail(userDto.getEmail());
            // Обновление пароля, если необходимо
            user.setPassword(userDto.getPassword());
            return convertToDto(userRepository.save(user));
        });
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    private UserDto convertToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setRole(user.getRole());
        userDto.setPassword(user.getPassword());
        return userDto;
    }
    public List<UserSummaryDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> new UserSummaryDto(user.getId(), user.getUsername()))
                .collect(Collectors.toList());
    }

    public Optional<UserDto> getUserByUsername(String username) {
        return userRepository.findByUsername(username).map(this::convertToDto);
    }
}
