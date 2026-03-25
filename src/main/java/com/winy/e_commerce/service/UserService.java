package com.winy.e_commerce.service;

import com.winy.e_commerce.infrastructure.entities.UserEntity;
import com.winy.e_commerce.infrastructure.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void createUser(UserEntity user) {
        userRepository.save(user);
    }

    public UserEntity findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new NullPointerException("User not find by id " + id));
    }

    @Transactional
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public void changeUser(Long id, UserEntity user) {
        UserEntity newUser = findUserById(id);
        user.setId(newUser.getId());

        userRepository.save(user);
    }

}
