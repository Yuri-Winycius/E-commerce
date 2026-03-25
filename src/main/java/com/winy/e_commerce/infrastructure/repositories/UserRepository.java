package com.winy.e_commerce.infrastructure.repositories;

import com.winy.e_commerce.infrastructure.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
