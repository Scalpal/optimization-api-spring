package com.exo1.exo1.service.impl;

import com.exo1.exo1.dto.UserDto;
import com.exo1.exo1.entity.User;
import com.exo1.exo1.mapper.UserMapper;
import com.exo1.exo1.repository.UserRepository;
import com.exo1.exo1.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    @Cacheable(value = "users", key = "#id")
    public UserDto getUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Task not found"));

        return userMapper.toDto(user);
    }

    @Override
    @Cacheable(value = "users", key = "#pageable.pageNumber")
    public Page<UserDto> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable).map(userMapper::toDto);
    }

    @Override
    public String createUser(UserDto userDto) {
        User newUser = userMapper.toEntity(userDto);

        userRepository.save(newUser);

        return "User successfully created";
    }

    @Override
    @CachePut(value = "users", key = "#id")
    public String updateUser(Long id, UserDto userDto) {
        if(!userRepository.existsById(id)) {
            throw new IllegalArgumentException("User does not exists");
        }

        User newUser = userMapper.toEntity(userDto);
        newUser.setId(id);

        userRepository.save(newUser);

        return "User successfully updated";
    }

    @Override
    @CacheEvict(value = "users", allEntries = true)
    public String deleteUser(Long id) {
        if(userRepository.existsById(id)) {
            throw new IllegalArgumentException("User does not exists");
        }

        userRepository.deleteById(id);

        return "User successfully created";
    }
}
