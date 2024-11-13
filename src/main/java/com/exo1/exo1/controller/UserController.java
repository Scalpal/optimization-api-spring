package com.exo1.exo1.controller;

import com.exo1.exo1.dto.UserDto;
import com.exo1.exo1.entity.User;
import com.exo1.exo1.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserDto userDto) {
        String response = userService.createUser(userDto);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable Long userId) {
        User response = userService.getUser(userId);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PatchMapping("/{userId}")
    public ResponseEntity<String> updateUser(
            @PathVariable Long userId,
            @RequestBody UserDto userDto) {
        String response = userService.updateUser(userId, userDto);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> updateUser(@PathVariable Long userId) {
        String response = userService.deleteUser(userId);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
