package com.exo1.exo1.service;

import com.exo1.exo1.dto.UserDto;
import com.exo1.exo1.entity.User;

public interface UserService {
    String createUser(UserDto userDto);

    User getUser(Long id);

    String updateUser(Long id, UserDto userDto);

    String deleteUser(Long id);
}
