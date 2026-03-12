package com.winy.e_commerce.service;

import com.winy.e_commerce.entity.User;
import com.winy.e_commerce.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {

        user.setDataCriacao(LocalDateTime.now());

        return userRepository.save(user);
    }

    public List<User> listUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findId(Long id) {
        return userRepository.findById(id);
    }
}
