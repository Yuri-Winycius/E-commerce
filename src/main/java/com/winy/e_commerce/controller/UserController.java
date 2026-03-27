package com.winy.e_commerce.controller;

import com.winy.e_commerce.infrastructure.entities.UserEntity;
import com.winy.e_commerce.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody UserEntity user) {
        userService.createUser(user);

        return ResponseEntity.accepted().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(userService.findUserById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable(name = "id") Long id) {
        userService.deleteUserById(id);

        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> changeUserBy(@RequestParam(name = "id") Long id,
                                             @RequestBody UserEntity user) {
        userService.changeUserById(id, user);

        return ResponseEntity.ok().build();
    }

}
