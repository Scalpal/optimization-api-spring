package com.exo1.exo1.service;

import com.exo1.exo1.dto.UserDto;
import com.exo1.exo1.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    UserDto getUser(Long id);

    Page<UserDto> getAllUsers(Pageable pageable);

    String createUser(UserDto userDto);

    String updateUser(Long id, UserDto userDto);

    String deleteUser(Long id);
}
