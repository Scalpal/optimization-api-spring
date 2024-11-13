package com.exo1.exo1.service.impl;

import com.exo1.exo1.dto.UserCreateDto;
import com.exo1.exo1.dto.UserDto;
import com.exo1.exo1.entity.Task;
import com.exo1.exo1.entity.User;
import com.exo1.exo1.mapper.UserMapper;
import com.exo1.exo1.repository.UserRepository;
import com.exo1.exo1.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public String createUser(UserDto userDto) {
        User newUser = userMapper.toEntity(userDto);

        userRepository.save(newUser);

        return "User successfully created";
    }

    @Override
    public User getUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Task not found"));

        return user;
    }

    @Override
    public String updateUser(Long id, UserDto userDto) {
        if(!userRepository.existsById(id)) {
            throw new IllegalArgumentException("User does not exists");
        }

        User newUser = userMapper.toEntity(userDto);

        userRepository.save(newUser);

        return "User successfully updated";
    }

    @Override
    public String deleteUser(Long id) {
        if(userRepository.existsById(id)) {
            throw new IllegalArgumentException("User does not exists");
        }

        userRepository.deleteById(id);

        return "User successfully created";
    }
}
